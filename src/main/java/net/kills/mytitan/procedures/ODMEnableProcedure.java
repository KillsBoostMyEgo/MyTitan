package net.kills.mytitan.procedures;

import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;

import net.kills.mytitan.network.MyTitanModVariables;

public class ODMEnableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
			_vars.ODMSelectedX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			_vars.syncPlayerVariables(entity);
		}
		{
			MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
			_vars.ODMSelectedY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			_vars.syncPlayerVariables(entity);
		}
		{
			MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
			_vars.ODMSelectedZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			_vars.syncPlayerVariables(entity);
		}
		{
			MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
			_vars.ODMEnabled = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}
