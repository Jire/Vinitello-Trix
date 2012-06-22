package trix.boot;

import trix.event.Event;

public abstract class BootEvent implements Event {

	private final Bootstrap bootstrap;

	protected BootEvent(Bootstrap bootstrap) {
		this.bootstrap = bootstrap;
	}

	public Bootstrap getBootstrap() {
		return bootstrap;
	}

}