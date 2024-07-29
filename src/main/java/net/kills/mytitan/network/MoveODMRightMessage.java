
package net.kills.mytitan.network;

import net.kills.mytitan.MyTitanMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record MoveODMRightMessage(int type, int pressedms) implements CustomPacketPayload {

	public static final ResourceLocation ID = new ResourceLocation(MyTitanMod.MODID, "key_move_odm_right");

	public MoveODMRightMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt());
	}

	@Override
	public void write(final FriendlyByteBuf buffer) {
		buffer.writeInt(type);
		buffer.writeInt(pressedms);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handleData(final MoveODMRightMessage message, final PlayPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.workHandler().submitAsync(() -> {
				pressAction(context.player().get(), message.type, message.pressedms);
			}).exceptionally(e -> {
				context.packetHandler().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			ODMMoveRightEnableProcedure.execute();
		}

		if (type == 1) {

			ODMMoveDisableProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MyTitanMod.addNetworkMessage(MoveODMRightMessage.ID, MoveODMRightMessage::new, MoveODMRightMessage::handleData);
	}

}
