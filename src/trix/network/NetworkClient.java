package trix.network;

import java.util.UUID;

import trix.packet.Packet;

public interface NetworkClient {

	public UUID getUUID();
	public NetworkService getService();
	public void write(Packet packet);

}