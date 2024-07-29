package net.kills.mytitan.procedures;

import net.neoforged.bus.api.Event;

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
				_level.sendParticles((SimpleParticleType) (MyTitanModParticleTypes.DELETED_MOD_ELEMENT.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.4, 1, 0.4, 0.25);
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
