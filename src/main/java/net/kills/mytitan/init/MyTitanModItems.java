
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

import net.kills.mytitan.item.WarHammerTitanSyringeItem;
import net.kills.mytitan.item.ODMItem;
import net.kills.mytitan.item.ODMGearItem;
import net.kills.mytitan.item.MyTitanItem;
import net.kills.mytitan.item.JawTitanSyringeItem;
import net.kills.mytitan.item.FoundingTitanSyringeItem;
import net.kills.mytitan.item.FemaleTitanSyringeItem;
import net.kills.mytitan.item.EmptySyringeItem;
import net.kills.mytitan.item.ColossalTitanSyringeItem;
import net.kills.mytitan.item.CartTitanSyringeItem;
import net.kills.mytitan.item.BeastTitanSyringeItem;
import net.kills.mytitan.item.AttackTitanSyringeItem;
import net.kills.mytitan.item.ArmoredTitanSyringeItem;
import net.kills.mytitan.MyTitanMod;

public class MyTitanModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, MyTitanMod.MODID);
	public static final DeferredHolder<Item, Item> MY_TITAN = REGISTRY.register("my_titan", () -> new MyTitanItem());
	public static final DeferredHolder<Item, Item> ODM_GEAR_LEGGINGS = REGISTRY.register("odm_gear_leggings", () -> new ODMGearItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final DeferredHolder<Item, Item> ODM_LEGGINGS = REGISTRY.register("odm_leggings", () -> new ODMItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final DeferredHolder<Item, Item> EMPTY_SYRINGE = REGISTRY.register("empty_syringe", () -> new EmptySyringeItem());
	public static final DeferredHolder<Item, Item> ATTACK_TITAN_SYRINGE = REGISTRY.register("attack_titan_syringe", () -> new AttackTitanSyringeItem());
	public static final DeferredHolder<Item, Item> FEMALE_TITAN_SYRINGE = REGISTRY.register("female_titan_syringe", () -> new FemaleTitanSyringeItem());
	public static final DeferredHolder<Item, Item> COLOSSAL_TITAN_SYRINGE = REGISTRY.register("colossal_titan_syringe", () -> new ColossalTitanSyringeItem());
	public static final DeferredHolder<Item, Item> ARMORED_TITAN_SYRINGE = REGISTRY.register("armored_titan_syringe", () -> new ArmoredTitanSyringeItem());
	public static final DeferredHolder<Item, Item> JAW_TITAN_SYRINGE = REGISTRY.register("jaw_titan_syringe", () -> new JawTitanSyringeItem());
	public static final DeferredHolder<Item, Item> CART_TITAN_SYRINGE = REGISTRY.register("cart_titan_syringe", () -> new CartTitanSyringeItem());
	public static final DeferredHolder<Item, Item> BEAST_TITAN_SYRINGE = REGISTRY.register("beast_titan_syringe", () -> new BeastTitanSyringeItem());
	public static final DeferredHolder<Item, Item> WAR_HAMMER_TITAN_SYRINGE = REGISTRY.register("war_hammer_titan_syringe", () -> new WarHammerTitanSyringeItem());
	public static final DeferredHolder<Item, Item> FOUNDING_TITAN_SYRINGE = REGISTRY.register("founding_titan_syringe", () -> new FoundingTitanSyringeItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}
}
