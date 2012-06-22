package trix.network;

import java.nio.ByteBuffer;

import trix.packet.Packet;

public class NetworkEncodeEvent extends NetworkCodecEvent {

	protected NetworkEncodeEvent(Packet packet, ByteBuffer buffer) {
		super(packet, buffer);
	}

}