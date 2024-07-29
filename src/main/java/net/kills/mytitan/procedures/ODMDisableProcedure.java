package net.kills.mytitan.procedures;

import net.minecraft.world.entity.Entity;

import net.kills.mytitan.network.MyTitanModVariables;

public class ODMDisableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
			_vars.ODMEnabled = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
