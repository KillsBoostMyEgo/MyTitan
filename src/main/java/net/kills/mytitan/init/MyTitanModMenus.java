
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.kills.mytitan.world.inventory.TitanSelectionMenu;
import net.kills.mytitan.MyTitanMod;

public class MyTitanModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MyTitanMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<TitanSelectionMenu>> TITAN_SELECTION = REGISTRY.register("titan_selection", () -> IMenuTypeExtension.create(TitanSelectionMenu::new));
}
