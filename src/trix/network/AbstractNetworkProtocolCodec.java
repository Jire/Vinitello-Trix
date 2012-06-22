package trix.network;

import trix.event.EventService;

public abstract class AbstractNetworkProtocolCodec {

	private final EventService eventService;

	protected AbstractNetworkProtocolCodec(EventService eventService) {
		this.eventService = eventService;
	}

	protected EventService getEventService() {
		return eventService;
	}

}