package trix.service.reflective;

import trix.event.EventService;
import trix.reflect.ReflectiveAssistant;
import trix.reflect.RegisterAutomatically;
import trix.service.AbstractServiceManager;
import trix.service.Service;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class ReflectiveServiceManager extends AbstractServiceManager {

	private final ReflectiveAssistant reflectiveAssistant;
	private final Injector injector;

	@Inject
	protected ReflectiveServiceManager(EventService eventService, ReflectiveAssistant reflectiveAssistant, Injector injector) {
		super(eventService);
		this.reflectiveAssistant = reflectiveAssistant;
		this.injector = injector;
	}

	protected ReflectiveAssistant getReflectiveAssistant() {
		return reflectiveAssistant;
	}

	protected Injector getInjector() {
		return injector;
	}

	@Override
	public boolean register(Service service) {
		StartOnRegistration startWhenRegistered = service.getClass().getAnnotation(StartOnRegistration.class);
		if (startWhenRegistered != null && startWhenRegistered.value()) {
			start(service);
		}
		return super.register(service);
	}

	@Override
	public void startAll() {
		for (Class<?> service : reflectiveAssistant.getClasses(Service.class)) {
			RegisterAutomatically registerAutomatically = service.getAnnotation(RegisterAutomatically.class);
			if (registerAutomatically != null && registerAutomatically.value()) {
				register((Service) getInjector().getInstance(service));
			}
		}
		super.startAll();
	}

}