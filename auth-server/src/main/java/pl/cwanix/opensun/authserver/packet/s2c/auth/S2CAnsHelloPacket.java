package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.AUTH, operation = PacketOPCode.AUTH_ANS_HELLO)
public class S2CAnsHelloPacket implements Packet {

    private final FixedLengthField serverInfo;
    private final FixedLengthField encKey;

    public S2CAnsHelloPacket(final byte[] encKey) {
        this.serverInfo = new FixedLengthField(64);
        this.encKey = new FixedLengthField(4, encKey);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(serverInfo, encKey);
    }
}
