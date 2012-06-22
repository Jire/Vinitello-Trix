package trix.service;

import trix.event.Event;

public abstract class ServiceEvent implements Event {

	private final Service service;
	private final ServiceManager manager;

	protected ServiceEvent(Service service, ServiceManager manager) {
		this.service = service;
		this.manager = manager;
	}

	public Service getService() {
		return service;
	}

	public ServiceManager getManager() {
		return manager;
	}

}