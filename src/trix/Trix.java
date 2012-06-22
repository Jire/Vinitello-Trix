package trix;

import trix.boot.Bootstrap;
import trix.boot.BootstrapBuilder;

import com.google.inject.Module;

public final class Trix {

	public static Bootstrap buildBootstrap(Module... modules) {
		return new BootstrapBuilder().withModules(modules).build();
	}

	public static void main(String[] args) {
		buildBootstrap().boot();
	}

}