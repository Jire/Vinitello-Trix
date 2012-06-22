package trix.event;

public class EventListenerRegistrationEvent implements Event {

	private final EventListener listener;

	public EventListenerRegistrationEvent(EventListener listener) {
		this.listener = listener;
	}

	public EventListener getListener() {
		return listener;
	}

}