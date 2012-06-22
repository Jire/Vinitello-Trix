package trix.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import trix.service.ThreadService;

public abstract class AbstractEventService extends ThreadService implements EventService {

	private static final int DEFAULT_REGISTRY_CAPACITY = 16;

	private final Map<EventListener, Map<Class<? extends Event>, Method>> registry;

	protected AbstractEventService(int initialRegistryCapacity) {
		super("Event Service");
		this.registry = new HashMap<>(initialRegistryCapacity);
	}

	protected AbstractEventService() {
		this(DEFAULT_REGISTRY_CAPACITY);
	}

	protected Map<EventListener, Map<Class<? extends Event>, Method>> getRegistry() {
		return registry;
	}

}