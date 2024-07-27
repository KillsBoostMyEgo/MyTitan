
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.kills.mytitan.item.ODMGearItem;
import net.kills.mytitan.item.MyTitanItem;
import net.kills.mytitan.MyTitanMod;

public class MyTitanModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, MyTitanMod.MODID);
	public static final DeferredHolder<Item, Item> MY_TITAN = REGISTRY.register("my_titan", () -> new MyTitanItem());
	public static final DeferredHolder<Item, Item> ODM_GEAR_LEGGINGS = REGISTRY.register("odm_gear_leggings", () -> new ODMGearItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}
}
