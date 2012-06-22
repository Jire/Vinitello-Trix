package trix.network;

import java.nio.ByteBuffer;

import trix.packet.Packet;

public interface NetworkProtocolDecoder {

	public Packet decode(ByteBuffer buffer);

}