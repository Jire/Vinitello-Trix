package trix.event.reflective;

import trix.event.EventService;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ReflectiveEventModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EventService.class).to(ReflectiveEventService.class).in(Scopes.SINGLETON);
	}

}