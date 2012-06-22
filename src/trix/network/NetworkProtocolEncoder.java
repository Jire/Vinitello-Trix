package trix.network;

import java.nio.ByteBuffer;

import trix.packet.Packet;

public interface NetworkProtocolEncoder {

	public ByteBuffer encode(Packet packet);

}