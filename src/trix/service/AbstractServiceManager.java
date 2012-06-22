package trix.service;

import java.util.ArrayList;
import java.util.List;

import trix.event.EventService;

public abstract class AbstractServiceManager implements ServiceManager {

	private static final int DEFAULT_SERVICE_CAPACITY = 16;

	private final List<Service> services;
	private final EventService eventService;

	protected AbstractServiceManager(int initialServiceCapacity, EventService eventService) {
		this.services = new ArrayList<>(initialServiceCapacity);
		this.eventService = eventService;
	}

	protected AbstractServiceManager(EventService eventService) {
		this(DEFAULT_SERVICE_CAPACITY, eventService);
	}

	protected List<Service> getServices() {
		return services;
	}

	protected EventService getEventService() {
		return eventService;
	}

	@Override
	public boolean register(Service service) {
		if (getServices().contains(service)) {
			return false;
		}
		getEventService().dispatchEvent(new ServiceRegistrationEvent(service, this));
		return getServices().add(service);
	}

	@Override
	public void start(Service service) {
		service.start(this);
	}

	@Override
	public void stop(Service service) {
		service.stop(this);
	}

	@Override
	public void startAll() {
		for (Service service : getServices()) {
			if (!service.isRunning())
				start(service);
		}
	}

	@Override
	public void stopAll() {
		for (Service service : getServices()) {
			if (service.isRunning())
				stop(service);
		}
	}

}