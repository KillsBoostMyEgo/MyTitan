package net.kills.mytitan.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.kills.mytitan.item.ODMGearItem;

public class ODMGearModel extends GeoModel<ODMGearItem> {
	@Override
	public ResourceLocation getAnimationResource(ODMGearItem object) {
		return new ResourceLocation("my_titan", "animations/odmgear.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ODMGearItem object) {
		return new ResourceLocation("my_titan", "geo/odmgear.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ODMGearItem object) {
		return new ResourceLocation("my_titan", "textures/item/odmgeartexture.png");
	}
}
