package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = 0x2A)
public class S2CAnsItemsPacket implements Packet<AgentServerContext> {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x2A);
	
	private byte[] value = {
			0x00, 0x00, 0x0f, 0x00,
			0x0a, 0x00, 0x00, 0x00, //exp
			0x10, 0x00, 0x00, 0x00, //skill point
			0x10, 0x00, 0x00, 0x00, //stat point
			
			0x40, 0x42, 0x0f, 0x00, 0x00, 0x00, 0x00, 0x00, //money
			(byte) 0xf0, (byte) 0xeb, //selected style
			(byte) 0x9e, 0x08, //max hp
			0x3b, 0x01, //hp
			(byte) 0xc4, 0x03, //max mp
			(byte) 0xda, 0x00, //mp
			0x65, 0x00, //move speed
			(byte) 0x98, 0x00, //att speed
			0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, //state time
			0x00, //title id
			0x00, 0x00, //unk
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, //title time?
			0x00, //inv lock
			0x00, //unk
			0x00, 0x00,
			0x00, 0x00,
			0x01, 0x01,
			0x00, 0x00,
			0x00, 0x00,
			0x00, 0x00,
			0x00, 0x00,
			0x00,
			
			0x14, 0x00,
			0x12, 0x00,
			0x0f, 0x00,
			0x0e, 0x00,
			0x0d, 0x00,
			0x10, 0x00,
			0x10, 0x00,
			
			0x00, 0x00, 0x0b, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, (byte) 0xff,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x53, 0x00, 0x35, 0x00, 0x00, 0x00, 0x00
	};

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
	}
}
