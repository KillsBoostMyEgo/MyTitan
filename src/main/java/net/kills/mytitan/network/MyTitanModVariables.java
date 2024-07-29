package net.kills.mytitan.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.Minecraft;

import net.kills.mytitan.MyTitanMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MyTitanModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MyTitanMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MyTitanMod.addNetworkMessage(PlayerVariablesSyncMessage.ID, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handleData);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.IsPlayerTransformed = original.IsPlayerTransformed;
			clone.DoesPlayerOwnAttackTitan = original.DoesPlayerOwnAttackTitan;
			clone.DoesPlayerOwnColossalTitan = original.DoesPlayerOwnColossalTitan;
			clone.DoesPlayerOwnFemaleTitan = original.DoesPlayerOwnFemaleTitan;
			clone.DoesPlayerOwnBeastTitan = original.DoesPlayerOwnBeastTitan;
			clone.DoesPlayerownFoundingTitan = original.DoesPlayerownFoundingTitan;
			clone.DoesPlayerOwnCartTitan = original.DoesPlayerOwnCartTitan;
			clone.DoesPlayerOwnJawTitan = original.DoesPlayerOwnJawTitan;
			clone.DoesPlayerOwnArmoredTitan = original.DoesPlayerOwnArmoredTitan;
			if (!event.isWasDeath()) {
				clone.SelectedTitan = original.SelectedTitan;
				clone.ODMEnabled = original.ODMEnabled;
				clone.ODMSelectedZ = original.ODMSelectedZ;
				clone.ODMSelectedY = original.ODMSelectedY;
				clone.ODMSelectedX = original.ODMSelectedX;
				clone.ODMDirection = original.ODMDirection;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean IsPlayerTransformed = false;
		public boolean DoesPlayerOwnAttackTitan = false;
		public boolean DoesPlayerOwnColossalTitan = false;
		public boolean DoesPlayerOwnFemaleTitan = false;
		public boolean DoesPlayerOwnBeastTitan = false;
		public boolean DoesPlayerownFoundingTitan = false;
		public boolean DoesPlayerOwnCartTitan = false;
		public boolean DoesPlayerOwnJawTitan = false;
		public boolean DoesPlayerOwnArmoredTitan = false;
		public double SelectedTitan = 0;
		public boolean ODMEnabled = false;
		public double ODMSelectedZ = 0;
		public double ODMSelectedY = 0;
		public double ODMSelectedX = 0;
		public double ODMDirection = 0;

		@Override
		public CompoundTag serializeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("IsPlayerTransformed", IsPlayerTransformed);
			nbt.putBoolean("DoesPlayerOwnAttackTitan", DoesPlayerOwnAttackTitan);
			nbt.putBoolean("DoesPlayerOwnColossalTitan", DoesPlayerOwnColossalTitan);
			nbt.putBoolean("DoesPlayerOwnFemaleTitan", DoesPlayerOwnFemaleTitan);
			nbt.putBoolean("DoesPlayerOwnBeastTitan", DoesPlayerOwnBeastTitan);
			nbt.putBoolean("DoesPlayerownFoundingTitan", DoesPlayerownFoundingTitan);
			nbt.putBoolean("DoesPlayerOwnCartTitan", DoesPlayerOwnCartTitan);
			nbt.putBoolean("DoesPlayerOwnJawTitan", DoesPlayerOwnJawTitan);
			nbt.putBoolean("DoesPlayerOwnArmoredTitan", DoesPlayerOwnArmoredTitan);
			nbt.putDouble("SelectedTitan", SelectedTitan);
			nbt.putBoolean("ODMEnabled", ODMEnabled);
			nbt.putDouble("ODMSelectedZ", ODMSelectedZ);
			nbt.putDouble("ODMSelectedY", ODMSelectedY);
			nbt.putDouble("ODMSelectedX", ODMSelectedX);
			nbt.putDouble("ODMDirection", ODMDirection);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			IsPlayerTransformed = nbt.getBoolean("IsPlayerTransformed");
			DoesPlayerOwnAttackTitan = nbt.getBoolean("DoesPlayerOwnAttackTitan");
			DoesPlayerOwnColossalTitan = nbt.getBoolean("DoesPlayerOwnColossalTitan");
			DoesPlayerOwnFemaleTitan = nbt.getBoolean("DoesPlayerOwnFemaleTitan");
			DoesPlayerOwnBeastTitan = nbt.getBoolean("DoesPlayerOwnBeastTitan");
			DoesPlayerownFoundingTitan = nbt.getBoolean("DoesPlayerownFoundingTitan");
			DoesPlayerOwnCartTitan = nbt.getBoolean("DoesPlayerOwnCartTitan");
			DoesPlayerOwnJawTitan = nbt.getBoolean("DoesPlayerOwnJawTitan");
			DoesPlayerOwnArmoredTitan = nbt.getBoolean("DoesPlayerOwnArmoredTitan");
			SelectedTitan = nbt.getDouble("SelectedTitan");
			ODMEnabled = nbt.getBoolean("ODMEnabled");
			ODMSelectedZ = nbt.getDouble("ODMSelectedZ");
			ODMSelectedY = nbt.getDouble("ODMSelectedY");
			ODMSelectedX = nbt.getDouble("ODMSelectedX");
			ODMDirection = nbt.getDouble("ODMDirection");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.PLAYER.with(serverPlayer).send(new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final ResourceLocation ID = new ResourceLocation(MyTitanMod.MODID, "player_variables_sync");

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this(new PlayerVariables());
			this.data.deserializeNBT(buffer.readNbt());
		}

		@Override
		public void write(final FriendlyByteBuf buffer) {
			buffer.writeNbt(data.serializeNBT());
		}

		@Override
		public ResourceLocation id() {
			return ID;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final PlayPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.workHandler().submitAsync(() -> Minecraft.getInstance().player.getData(PLAYER_VARIABLES).deserializeNBT(message.data.serializeNBT())).exceptionally(e -> {
					context.packetHandler().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
