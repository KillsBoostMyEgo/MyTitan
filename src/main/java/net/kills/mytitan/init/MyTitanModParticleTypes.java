
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.kills.mytitan.MyTitanMod;

public class MyTitanModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, MyTitanMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ELECTRICITY = REGISTRY.register("electricity", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(true));
}
