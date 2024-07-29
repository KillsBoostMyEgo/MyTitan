package net.kills.mytitan.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.kills.mytitan.item.ODMItem;

public class ODMModel extends GeoModel<ODMItem> {
	@Override
	public ResourceLocation getAnimationResource(ODMItem object) {
		return new ResourceLocation("my_titan", "animations/odmgear.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ODMItem object) {
		return new ResourceLocation("my_titan", "geo/odmgear.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ODMItem object) {
		return new ResourceLocation("my_titan", "textures/item/odmgear_texture.png");
	}
}
