
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.kills.mytitan.client.gui.TitanSelectionScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MyTitanModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MyTitanModMenus.TITAN_SELECTION.get(), TitanSelectionScreen::new);
	}
}
