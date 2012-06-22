package trix.packet;

import trix.packet.reflective.ReflectivePacketService;
import trix.service.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(ReflectivePacketService.class)
public interface PacketService extends Service, PacketBuilder, PacketParser {

	public boolean registerBuilder(Class<? extends PacketBuilder> builder);
	public boolean registerParser(Class<? extends PacketParser> parser);

}