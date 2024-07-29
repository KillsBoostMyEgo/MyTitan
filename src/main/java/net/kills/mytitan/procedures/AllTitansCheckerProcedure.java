package net.kills.mytitan.procedures;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.kills.mytitan.network.MyTitanModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AllTitansCheckerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnAttackTitan == true) {
			if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnColossalTitan == true) {
				if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnFemaleTitan == true) {
					if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnBeastTitan == true) {
						if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerownFoundingTitan == true) {
							if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnCartTitan == true) {
								if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnJawTitan == true) {
									if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnArmoredTitan == true) {
										if (entity.getData(MyTitanModVariables.PLAYER_VARIABLES).DoesPlayerOwnWarHammerTitan == true) {
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("my_titan:all_titans_unlocked"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
