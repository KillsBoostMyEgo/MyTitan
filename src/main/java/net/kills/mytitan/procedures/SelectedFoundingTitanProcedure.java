package net.kills.mytitan.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.kills.mytitan.network.MyTitanModVariables;

public class SelectedFoundingTitanProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerownFoundingTitan == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Selected Founding Titan"), true);
			{
				MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
				_vars.SelectedTitan = 5;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
