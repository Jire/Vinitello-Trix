package trix.boot;

import com.google.inject.Injector;

public abstract class GuiceBootstrap implements Bootstrap {

	private final Injector injector;

	protected GuiceBootstrap(Injector injector) {
		this.injector = injector;
	}

	protected Injector getInjector() {
		return injector;
	}

	protected <T> T getInstance(Class<T> type) {
		return getInjector().getInstance(type);
	}

}