package trix.network;

import java.nio.ByteBuffer;

import trix.packet.Packet;

public abstract class AbstractNetworkProtocol implements NetworkProtocol {

	private final NetworkProtocolEncoder encoder;
	private final NetworkProtocolDecoder decoder;

	protected AbstractNetworkProtocol(NetworkProtocolEncoder encoder, NetworkProtocolDecoder decoder) {
		this.encoder = encoder;
		this.decoder = decoder;
	}

	@Override
	public ByteBuffer encode(Packet packet) {
		return getEncoder().encode(packet);
	}

	@Override
	public Packet decode(ByteBuffer buffer) {
		return getDecoder().decode(buffer);
	}

	@Override
	public NetworkProtocolEncoder getEncoder() {
		return encoder;
	}

	@Override
	public NetworkProtocolDecoder getDecoder() {
		return decoder;
	}

}