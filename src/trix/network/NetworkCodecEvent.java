package trix.network;

import java.nio.ByteBuffer;

import trix.event.Event;
import trix.packet.Packet;

public abstract class NetworkCodecEvent implements Event {

	private final Packet packet;
	private final ByteBuffer buffer;

	protected NetworkCodecEvent(Packet packet, ByteBuffer buffer) {
		this.packet = packet;
		this.buffer = buffer;
	}

	public Packet getPacket() {
		return packet;
	}

	public ByteBuffer getBuffer() {
		return buffer;
	}

}