package net.kills.mytitan.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ODMGearMovementProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double lookX = 0;
		double lookY = 0;
		double lookZ = 0;
		double vX = 0;
		double vY = 0;
		double vZ = 0;
		lookX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		lookY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		lookZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		if (!world.isEmptyBlock(BlockPos.containing(lookX, lookY, lookZ))) {
			vX = (lookX - entity.getX()) / 10;
			vY = (lookY - entity.getY()) / 10;
			vZ = (lookZ - entity.getZ()) / 10;
			entity.setDeltaMovement(new Vec3(vX, vY, vZ));
		}
	}
}
