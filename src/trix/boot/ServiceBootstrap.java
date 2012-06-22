package trix.boot;

import trix.event.EventService;
import trix.service.ServiceManager;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class ServiceBootstrap extends GuiceBootstrap {

	private final ServiceManager serviceManager;
	private final EventService eventService;

	@Inject
	protected ServiceBootstrap(Injector injector, ServiceManager serviceManager, EventService eventService) {
		super(injector);
		this.serviceManager = serviceManager;
		this.eventService = eventService;
	}

	protected ServiceManager getServiceManager() {
		return serviceManager;
	}

	protected EventService getEventService() {
		return eventService;
	}

	@Override
	public void boot() {
		// go ahead and start all services
		getServiceManager().startAll();

		// dispatch completion notification to event service
		getEventService().dispatchEvent(new BootCompletedEvent(this));
	}

}