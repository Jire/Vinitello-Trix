package trix.event.reflective;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import trix.event.AbstractEventService;
import trix.event.Event;
import trix.event.EventListener;
import trix.event.EventListenerRegistrationEvent;
import trix.reflect.ReflectiveAssistant;
import trix.reflect.RegisterAutomatically;
import trix.service.ServiceManager;
import trix.service.reflective.StartOnRegistration;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
@RegisterAutomatically
@StartOnRegistration
public class ReflectiveEventService extends AbstractEventService {

	private final ReflectiveAssistant reflectiveAssistant;
	private final Injector injector;

	@Inject
	protected ReflectiveEventService(ReflectiveAssistant reflectiveAssistant, Injector injector) {
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
	public void start(ServiceManager manager) {
		super.start(manager);

		for (Class<?> eventListener : getReflectiveAssistant().getClasses(EventListener.class)) {
			RegisterAutomatically registerAutomatically = eventListener.getAnnotation(RegisterAutomatically.class);
			if (registerAutomatically != null && registerAutomatically.value()) {
				registerListener((EventListener) injector.getInstance(eventListener));
			}
		}
	}

	@Override
	public void dispatchEvent(Event event) {
		try {
			for (Entry<EventListener, Map<Class<? extends Event>, Method>> entry : getRegistry().entrySet()) {
				for (Entry<Class<? extends Event>, Method> secondaryEntry : entry.getValue().entrySet()) {
					if (event.getClass().equals(secondaryEntry.getKey()))
						secondaryEntry.getValue().invoke(entry.getKey(), event);
				}
			}
		} catch (InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void registerListener(EventListener listener) {
		Map<Class<? extends Event>, Method> events = new HashMap<>();

		for (Method method : listener.getClass().getMethods()) {
			if (method.isAnnotationPresent(HandlesEvent.class)) {
				HandlesEvent annotation = method.getAnnotation(HandlesEvent.class);
				if (annotation.value()) {
					Class<?>[] parameters = method.getParameterTypes();
					if (parameters.length == 1) {
						events.put((Class<? extends Event>) parameters[0], method);
					}
				}
			}
		}

		getRegistry().put(listener, events);

		dispatchEvent(new EventListenerRegistrationEvent(listener));
	}

}