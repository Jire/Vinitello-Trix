package trix.network;

import java.nio.ByteBuffer;

import trix.packet.Packet;

public interface NetworkProtocol {

	public ByteBuffer encode(Packet packet);
	public Packet decode(ByteBuffer buffer);

	public NetworkProtocolEncoder getEncoder();
	public NetworkProtocolDecoder getDecoder();

}