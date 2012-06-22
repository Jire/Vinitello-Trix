package trix.service;

public class ServiceStopEvent extends ServiceEvent {

	protected ServiceStopEvent(Service service, ServiceManager manager) {
		super(service, manager);
	}

}