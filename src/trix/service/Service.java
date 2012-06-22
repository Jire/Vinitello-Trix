package trix.service;

public interface Service {

	public boolean isRunning();

	public void start(ServiceManager manager);
	public void stop(ServiceManager manager);

}