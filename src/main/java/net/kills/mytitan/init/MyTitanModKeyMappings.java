
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.kills.mytitan.network.UseODMGearMessage;
import net.kills.mytitan.network.TitanTransformationMessage;
import net.kills.mytitan.network.MoveODMRightMessage;
import net.kills.mytitan.network.MoveODMLeftMessage;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MyTitanModKeyMappings {
	public static final KeyMapping TITAN_TRANSFORMATION = new KeyMapping("key.my_titan.titan_transformation", GLFW.GLFW_KEY_X, "key.categories.titan") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new TitanTransformationMessage(0, 0));
				TitanTransformationMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TITAN_TRANSFORMATION_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TITAN_TRANSFORMATION_LASTPRESS);
				PacketDistributor.SERVER.noArg().send(new TitanTransformationMessage(1, dt));
				TitanTransformationMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ODM_GEAR = new KeyMapping("key.my_titan.use_odm_gear", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new UseODMGearMessage(0, 0));
				UseODMGearMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ODM_GEAR_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ODM_GEAR_LASTPRESS);
				PacketDistributor.SERVER.noArg().send(new UseODMGearMessage(1, dt));
				UseODMGearMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOVE_ODM_LEFT = new KeyMapping("key.my_titan.move_odm_left", GLFW.GLFW_KEY_A, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new MoveODMLeftMessage(0, 0));
				MoveODMLeftMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MOVE_ODM_LEFT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MOVE_ODM_LEFT_LASTPRESS);
				PacketDistributor.SERVER.noArg().send(new MoveODMLeftMessage(1, dt));
				MoveODMLeftMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MOVE_ODM_RIGHT = new KeyMapping("key.my_titan.move_odm_right", GLFW.GLFW_KEY_D, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new MoveODMRightMessage(0, 0));
				MoveODMRightMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MOVE_ODM_RIGHT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MOVE_ODM_RIGHT_LASTPRESS);
				PacketDistributor.SERVER.noArg().send(new MoveODMRightMessage(1, dt));
				MoveODMRightMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long TITAN_TRANSFORMATION_LASTPRESS = 0;
	private static long USE_ODM_GEAR_LASTPRESS = 0;
	private static long MOVE_ODM_LEFT_LASTPRESS = 0;
	private static long MOVE_ODM_RIGHT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TITAN_TRANSFORMATION);
		event.register(USE_ODM_GEAR);
		event.register(MOVE_ODM_LEFT);
		event.register(MOVE_ODM_RIGHT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				TITAN_TRANSFORMATION.consumeClick();
				USE_ODM_GEAR.consumeClick();
				MOVE_ODM_LEFT.consumeClick();
				MOVE_ODM_RIGHT.consumeClick();
			}
		}
	}
}
