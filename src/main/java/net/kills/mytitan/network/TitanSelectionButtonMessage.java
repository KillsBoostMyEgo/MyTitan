
package net.kills.mytitan.network;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.kills.mytitan.world.inventory.TitanSelectionMenu;
import net.kills.mytitan.procedures.SelectedJawTitanProcedure;
import net.kills.mytitan.procedures.SelectedFoundingTitanProcedure;
import net.kills.mytitan.procedures.SelectedFemaleTitanProcedure;
import net.kills.mytitan.procedures.SelectedColossalTitanProcedure;
import net.kills.mytitan.procedures.SelectedCartTitanProcedure;
import net.kills.mytitan.procedures.SelectedBeastTitanProcedure;
import net.kills.mytitan.procedures.SelectedAttackTitanProcedure;
import net.kills.mytitan.procedures.SelectedArmoredTitanProcedure;
import net.kills.mytitan.MyTitanMod;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record TitanSelectionButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final ResourceLocation ID = new ResourceLocation(MyTitanMod.MODID, "titan_selection_buttons");
	public TitanSelectionButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	@Override
	public void write(final FriendlyByteBuf buffer) {
		buffer.writeInt(buttonID);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handleData(final TitanSelectionButtonMessage message, final PlayPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.workHandler().submitAsync(() -> {
				Player entity = context.player().get();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.packetHandler().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = TitanSelectionMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectedAttackTitanProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SelectedColossalTitanProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SelectedJawTitanProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SelectedFemaleTitanProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SelectedCartTitanProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SelectedBeastTitanProcedure.execute(entity);
		}
		if (buttonID == 6) {

			SelectedJawTitanProcedure.execute(entity);
		}
		if (buttonID == 7) {

			SelectedArmoredTitanProcedure.execute(entity);
		}
		if (buttonID == 8) {

			SelectedFoundingTitanProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MyTitanMod.addNetworkMessage(TitanSelectionButtonMessage.ID, TitanSelectionButtonMessage::new, TitanSelectionButtonMessage::handleData);
	}
}
