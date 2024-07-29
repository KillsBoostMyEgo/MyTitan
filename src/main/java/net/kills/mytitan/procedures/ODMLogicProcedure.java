package net.kills.mytitan.procedures;

import net.neoforged.bus.api.Event;

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

private static void execute(
@Nullable Event event,
LevelAccessor world,
Entity entity ) {
if (
entity == null ) return ;
double vX = 0;double vY = 0;double vZ = 0;double maxV = 0;double vRatio = 0;double highestV = 0;double movementX = 0;double movementZ = 0;
if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS):ItemStack.EMPTY).getItem() == MyTitanModItems.ODM_GEAR_LEGGINGS.get()&&&&!world.isEmptyBlock(BlockPos.containing(,,))) {maxV = 1;vRatio = 1;vY = (-entity.getY())*0.1;if (!=0) {if (entity.getYRot()>=-135&&entity.getYRot()<-45) {vZ = (-entity.getZ()+*5)*0.1;}}else{vX = (-entity.getX())*0.1;vZ = (-entity.getZ())*0.1;}highestV = Math.max(Math.abs(vX),Math.max(Math.abs(vY),Math.abs(vZ)));if (highestV>1||highestV<-1) {vRatio = maxV/ highestV;}vX = entity.getDeltaMovement().x()+vX*vRatio;vY = entity.getDeltaMovement().y()+vY*vRatio;vZ = entity.getDeltaMovement().z()+vZ*vRatio;if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(("" + entity.getYRot())), false);entity.setDeltaMovement(new Vec3(vX, vY, vZ));}
}
}
