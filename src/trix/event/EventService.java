package trix.event;

import trix.event.reflective.ReflectiveEventService;
import trix.service.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(ReflectiveEventService.class)
public interface EventService extends Service {
	public void dispatchEvent(Event event);
	public void registerListener(EventListener listener);
}