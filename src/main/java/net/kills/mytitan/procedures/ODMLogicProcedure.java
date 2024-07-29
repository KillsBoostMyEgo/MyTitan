package net.kills.mytitan.procedures;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.kills.mytitan.network.MyTitanModVariables;
import net.kills.mytitan.init.MyTitanModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ODMLogicProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double vX = 0;
		double vY = 0;
		double vZ = 0;
		double maxV = 0;
		double vRatio = 0;
		double highestV = 0;
		double movementX = 0;
		double movementZ = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == MyTitanModItems.ODM_GEAR_LEGGINGS.get() && entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMEnabled
				&& !world.isEmptyBlock(
						BlockPos.containing(entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedX, entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedY, entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedZ))) {
			maxV = 1;
			vRatio = 1;
			vY = (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedY - entity.getY()) * 0.1;
			if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMDirection != 0) {
				if (entity.getYRot() >= -135 && entity.getYRot() < -45) {
					vZ = (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedZ - entity.getZ() + entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMDirection * 5) * 0.1;
				}
			} else {
				vX = (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedX - entity.getX()) * 0.1;
				vZ = (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).ODMSelectedZ - entity.getZ()) * 0.1;
			}
			highestV = Math.max(Math.abs(vX), Math.max(Math.abs(vY), Math.abs(vZ)));
			if (highestV > 1 || highestV < -1) {
				vRatio = maxV / highestV;
			}
			vX = entity.getDeltaMovement().x() + vX * vRatio;
			vY = entity.getDeltaMovement().y() + vY * vRatio;
			vZ = entity.getDeltaMovement().z() + vZ * vRatio;
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getYRot())), false);
			entity.setDeltaMovement(new Vec3(vX, vY, vZ));
		}
	}
}
