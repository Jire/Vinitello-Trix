package trix.service;

import trix.service.reflective.ReflectiveServiceManager;

import com.google.inject.ImplementedBy;

@ImplementedBy(ReflectiveServiceManager.class)
public interface ServiceManager {

	public boolean register(Service service);

	public void start(Service service);
	public void stop(Service service);

	public void startAll();
	public void stopAll();

}