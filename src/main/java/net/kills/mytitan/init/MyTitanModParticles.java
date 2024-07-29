
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kills.mytitan.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.kills.mytitan.client.particle.ElectricityParticle;
import net.kills.mytitan.client.particle.BloodParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MyTitanModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(MyTitanModParticleTypes.ELECTRICITY.get(), ElectricityParticle::provider);
		event.registerSpriteSet(MyTitanModParticleTypes.BLOOD.get(), BloodParticle::provider);
	}
}
