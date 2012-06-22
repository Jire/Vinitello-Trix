package trix.service;

public class ServiceStartEvent extends ServiceEvent  {

	protected ServiceStartEvent(Service service, ServiceManager manager) {
		super(service, manager);
	}

}