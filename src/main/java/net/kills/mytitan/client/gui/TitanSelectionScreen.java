package net.kills.mytitan.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.kills.mytitan.world.inventory.TitanSelectionMenu;
import net.kills.mytitan.network.TitanSelectionButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TitanSelectionScreen extends AbstractContainerScreen<TitanSelectionMenu> {
	private final static HashMap<String, Object> guistate = TitanSelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_attack_titan;
	Button button_colossal_titan;
	Button button_armored_titan;
	Button button_female_titan;
	Button button_cart_titan;
	Button button_beast_titan;
	Button button_jaw_titan;
	Button button_war_hammer_titan;
	Button button_founding_titan;

	public TitanSelectionScreen(TitanSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("my_titan:textures/screens/titan_selection.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_attack_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_attack_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(0, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 41, this.topPos + 15, 87, 20).build();
		guistate.put("button:button_attack_titan", button_attack_titan);
		this.addRenderableWidget(button_attack_titan);
		button_colossal_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_colossal_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(1, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 35, 98, 20).build();
		guistate.put("button:button_colossal_titan", button_colossal_titan);
		this.addRenderableWidget(button_colossal_titan);
		button_armored_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_armored_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(2, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 44, this.topPos + 152, 93, 20).build();
		guistate.put("button:button_armored_titan", button_armored_titan);
		this.addRenderableWidget(button_armored_titan);
		button_female_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_female_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(3, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 41, this.topPos + 56, 87, 20).build();
		guistate.put("button:button_female_titan", button_female_titan);
		this.addRenderableWidget(button_female_titan);
		button_cart_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_cart_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(4, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 47, this.topPos + 113, 77, 20).build();
		guistate.put("button:button_cart_titan", button_cart_titan);
		this.addRenderableWidget(button_cart_titan);
		button_beast_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_beast_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(5, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 41, this.topPos + 75, 82, 20).build();
		guistate.put("button:button_beast_titan", button_beast_titan);
		this.addRenderableWidget(button_beast_titan);
		button_jaw_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_jaw_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(6, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 50, this.topPos + 134, 72, 20).build();
		guistate.put("button:button_jaw_titan", button_jaw_titan);
		this.addRenderableWidget(button_jaw_titan);
		button_war_hammer_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_war_hammer_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(7, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 169, 108, 20).build();
		guistate.put("button:button_war_hammer_titan", button_war_hammer_titan);
		this.addRenderableWidget(button_war_hammer_titan);
		button_founding_titan = Button.builder(Component.translatable("gui.my_titan.titan_selection.button_founding_titan"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new TitanSelectionButtonMessage(8, x, y, z));
				TitanSelectionButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 39, this.topPos + 92, 98, 20).build();
		guistate.put("button:button_founding_titan", button_founding_titan);
		this.addRenderableWidget(button_founding_titan);
	}
}
