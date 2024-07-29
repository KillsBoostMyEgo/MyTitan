
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.kills.mytitan.MyTitanMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MyTitanModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyTitanMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MY_TITAN_TAB = REGISTRY.register("my_titan_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.my_titan.my_titan_tab")).icon(() -> new ItemStack(MyTitanModItems.MY_TITAN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MyTitanModItems.ODM_LEGGINGS.get());
				tabData.accept(MyTitanModItems.EMPTY_SYRINGE.get());
				tabData.accept(MyTitanModItems.ATTACK_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.FEMALE_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.COLOSSAL_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.ARMORED_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.JAW_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.CART_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.BEAST_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.WAR_HAMMER_TITAN_SYRINGE.get());
				tabData.accept(MyTitanModItems.FOUNDING_TITAN_SYRINGE.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(MyTitanModItems.ODM_GEAR_LEGGINGS.get());
		}
	}
}
