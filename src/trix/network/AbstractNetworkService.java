package trix.network;

import java.util.ArrayList;
import java.util.List;

import trix.service.ThreadService;

public abstract class AbstractNetworkService extends ThreadService implements NetworkService {

	private final int port;
	private final NetworkProtocol protocol;
	private final List<NetworkClient> clients;

	protected AbstractNetworkService(int port, NetworkProtocol protocol) {
		super("Network Service");
		this.port = port;
		this.protocol = protocol;
		this.clients = new ArrayList<>();
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public NetworkProtocol getProtocol() {
		return protocol;
	}

	@Override
	public List<NetworkClient> getClients() {
		return clients;
	}

}