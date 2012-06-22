package trix.network;

import java.util.List;

import trix.service.Service;

public interface NetworkService extends Service {

	public int getPort();
	public NetworkProtocol getProtocol();
	public List<NetworkClient> getClients();

}