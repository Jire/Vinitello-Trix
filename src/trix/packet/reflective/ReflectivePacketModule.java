package trix.packet.reflective;

import trix.packet.PacketService;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ReflectivePacketModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PacketService.class).to(ReflectivePacketService.class).in(Scopes.SINGLETON);
	}

}