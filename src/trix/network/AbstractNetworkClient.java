package trix.network;

import java.util.UUID;

public abstract class AbstractNetworkClient implements NetworkClient {

	private final UUID uuid;
	private final NetworkService service;

	protected AbstractNetworkClient(UUID uuid, NetworkService service) {
		this.uuid = uuid;
		this.service = service;
	}

	protected AbstractNetworkClient(NetworkService service) {
		this(UUID.randomUUID(), service);
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public NetworkService getService() {
		return service;
	}

}