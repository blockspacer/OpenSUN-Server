package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.packet.structures.ChannelUnitStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.AUTH, operation = PacketOPCode.AUTH_ANS_SRV_STATE)
public class S2CAnsSrvStatePacket implements Packet {

    private final FixedLengthField channelsCount;
    private final List<ChannelUnitStructure> channelsList;

    public S2CAnsSrvStatePacket(final List<ChannelUnitStructure> channelsList) {
        this.channelsCount = new FixedLengthField(1, channelsList.size());
        this.channelsList = channelsList;
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(channelsCount, channelsList);
    }
}
