package trix.packet.reflective;

import trix.packet.AbstractPacketService;
import trix.packet.Packet;
import trix.packet.PacketBuilder;
import trix.packet.PacketParser;
import trix.packet.PacketRepresentation;
import trix.reflect.RegisterAutomatically;
import trix.service.reflective.StartOnRegistration;

import com.google.inject.Singleton;

@Singleton
@RegisterAutomatically
@StartOnRegistration
public class ReflectivePacketService extends AbstractPacketService {

	@Override
	public Packet build(PacketRepresentation packetRep) {
		PacketBuilder builder = getBuilders().get(packetRep.getClass());
		if (builder != null) {
			return builder.build(packetRep);
		}
		return null;
	}

	@Override
	public PacketRepresentation parse(Packet packet) {
		PacketParser parser = getParsers().get(packet.getId());
		if (parser != null) {
			return parser.parse(packet);
		}
		return null;
	}

	@Override
	public boolean registerBuilder(Class<? extends PacketBuilder> builder) {
		Object object = null;
		try {
			object = builder.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (object != null) {
			BuildsPacket annotation = builder.getAnnotation(BuildsPacket.class);
			if (annotation != null) {
				getBuilders().put(annotation.value(), (PacketBuilder) object);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean registerParser(Class<? extends PacketParser> parser) {
		Object object = null;
		try {
			object = parser.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (object != null) {
			ParsesPacket annotation = parser.getAnnotation(ParsesPacket.class);
			if (annotation != null) {
				for (int packetId : annotation.value()) {
					getParsers().put(packetId, (PacketParser) object);
				}
				return true;
			}
		}
		return false;
	}

}