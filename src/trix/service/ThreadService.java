package trix.service;

public abstract class ThreadService extends AbstractService implements Runnable {

	private final Thread thread;

	protected ThreadService(String name) {
		this.thread = new Thread(this, name);
	}

	protected ThreadService() {
		this.thread = new Thread(this);
	}

	protected Thread getThread() {
		return thread;
	}

	@Override
	public void start(ServiceManager manager) {
		super.start(manager);
		getThread().start();
	}

	@Override
	public void stop(ServiceManager manager) {
		super.stop(manager);
	}

	@Override
	public void run() {
		// Intended for overload.
	}

}