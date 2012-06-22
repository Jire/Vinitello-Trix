package trix.service.reflective;

import trix.service.ServiceManager;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ReflectiveServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ServiceManager.class).to(ReflectiveServiceManager.class).in(Scopes.SINGLETON);
	}

}