package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class ItemSlotPacketStructure implements PacketStructure {
	
	private FixedLengthField position;
	private ItemPartPacketStructure itemPart;
	private OptionPartPacketStructure optionPart;
	
	public ItemSlotPacketStructure(byte[] value) {
		position = new FixedLengthField(1, value[0]);
		itemPart = new ItemPartPacketStructure(Arrays.copyOfRange(value, 1, 8));
		optionPart = new OptionPartPacketStructure(Arrays.copyOfRange(value, 8, value.length));
	}
}
