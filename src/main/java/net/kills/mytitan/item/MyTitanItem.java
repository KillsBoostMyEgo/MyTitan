
package net.kills.mytitan.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MyTitanItem extends Item {
	public MyTitanItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}
}
