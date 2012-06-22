package trix.packet;

import java.util.HashMap;
import java.util.Map;

import trix.service.ThreadService;

public abstract class AbstractPacketService extends ThreadService implements PacketService {

	private static final int DEFAULT_REGISTRY_CAPACITY = 256;

	private final Map<Class<? extends PacketRepresentation>, PacketBuilder> builders;
	private final Map<Integer, PacketParser> parsers;

	protected AbstractPacketService(int initialRegistryCapacity) {
		super("Packet Service");
		builders = new HashMap<>(initialRegistryCapacity);
		parsers = new HashMap<>(initialRegistryCapacity);
	}

	protected AbstractPacketService() {
		this(DEFAULT_REGISTRY_CAPACITY);
	}

	protected Map<Class<? extends PacketRepresentation>, PacketBuilder> getBuilders() {
		return builders;
	}

	protected Map<Integer, PacketParser> getParsers() {
		return parsers;
	}

}