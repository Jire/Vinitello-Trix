package trix.boot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceBootstrapFinalizer implements BootstrapFinalizer {

	private final Module[] modules;

	protected GuiceBootstrapFinalizer(Module[] modules) {
		this.modules = modules;
	}

	protected Module[] getModules() {
		return modules.clone();
	}

	@Override
	public Bootstrap build() {
		Injector injector = Guice.createInjector(getModules());
		return injector.getInstance(Bootstrap.class);
	}

}