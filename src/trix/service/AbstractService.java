package trix.service;

public abstract class AbstractService implements Service {

	private boolean running;

	private void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start(ServiceManager manager) {
		if (isRunning()) {
			throw new IllegalStateException("The service is already running!");
		}
		setRunning(true);
		if (manager instanceof AbstractServiceManager) {
			((AbstractServiceManager) manager).getEventService().dispatchEvent(new ServiceStartEvent(this, manager));
		}
	}

	@Override
	public void stop(ServiceManager manager) {
		if (!isRunning()) {
			throw new IllegalStateException("The service has already been stopped!");
		}
		setRunning(false);
		if (manager instanceof AbstractServiceManager) {
			((AbstractServiceManager) manager).getEventService().dispatchEvent(new ServiceStopEvent(this, manager));
		}
	}

}