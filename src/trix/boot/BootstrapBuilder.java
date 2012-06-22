package trix.boot;

import trix.event.reflective.ReflectiveEventModule;
import trix.packet.reflective.ReflectivePacketModule;
import trix.service.reflective.ReflectiveServiceModule;

import com.google.inject.Module;

public class BootstrapBuilder {

	private static final Module[] DEFAULT_MODULES = {
		new ReflectiveEventModule(),
		new ReflectiveServiceModule(),
		new ReflectivePacketModule()
	};

	public BootstrapFinalizer withModules(Module... modules) {
		return new GuiceBootstrapFinalizer(modules);
	}

	public BootstrapFinalizer withDefaultModules() {
		return withModules(DEFAULT_MODULES);
	}

}