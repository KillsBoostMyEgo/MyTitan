package net.kills.mytitan.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.kills.mytitan.network.MyTitanModVariables;
import net.kills.mytitan.MyTitanMod;

public class TitanTransformationCompleteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MyTitanMod.queueServerWork(10, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "clear");
			for (int index0 = 0; index0 < 10; index0++) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("my_titan:titantransform")), SoundSource.PLAYERS, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("my_titan:titantransform")), SoundSource.PLAYERS, 5, 1, false);
					}
				}
			}
			if (5 >= entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
				if (1 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
				} else {
					if (2 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
					} else {
						if (3 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
						} else {
							if (4 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
							}
						}
					}
				}
			} else {
				if (5 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
				} else {
					if (6 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
					} else {
						if (7 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
						} else {
							if (8 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
							} else {
								if (9 == entity.getData(MyTitanModVariables.PLAYER_VARIABLES).SelectedTitan) {
								}
							}
						}
					}
				}
			}
			{
				MyTitanModVariables.PlayerVariables _vars = entity.getData(MyTitanModVariables.PLAYER_VARIABLES);
				_vars.IsPlayerTransformed = true;
				_vars.syncPlayerVariables(entity);
			}
		});
	}
}
