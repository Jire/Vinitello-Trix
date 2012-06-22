package trix.network;

import java.nio.ByteBuffer;

import trix.packet.Packet;

public class NetworkDecodeEvent extends NetworkCodecEvent {

	protected NetworkDecodeEvent(Packet packet, ByteBuffer buffer) {
		super(packet, buffer);
	}

}