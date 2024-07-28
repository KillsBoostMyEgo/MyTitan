package net.kills.mytitan.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.kills.mytitan.init.MyTitanModParticleTypes;
import net.kills.mytitan.MyTitanMod;

public class TitanTransformParticlesSounProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MyTitanMod.queueServerWork(10, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("my_titan:titanelectricity")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("my_titan:titanelectricity")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.BLOOD.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
			MyTitanMod.queueServerWork(10, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
				MyTitanMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
					MyTitanMod.queueServerWork(20, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
						MyTitanMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
							MyTitanMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
								MyTitanMod.queueServerWork(10, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
									MyTitanMod.queueServerWork(20, () -> {
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
										MyTitanMod.queueServerWork(20, () -> {
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
											MyTitanMod.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
												MyTitanMod.queueServerWork(20, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.ELECTRICITY.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"stopsound @a[distance=10] player my_titan:titanelectricity");
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}
