
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.kills.mytitan.MyTitanMod;

public class MyTitanModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MyTitanMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> TITANELECTRICITY = REGISTRY.register("titanelectricity", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("my_titan", "titanelectricity")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TITANTRANSFORM = REGISTRY.register("titantransform", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("my_titan", "titantransform")));
}
