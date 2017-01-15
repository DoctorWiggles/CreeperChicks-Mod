package creeperchicks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import creeperchicks.registry.Item_Registry;

public class CreepTab extends CreativeTabs
{
			public static CreepTab creeperchicks = new CreepTab();
	
	public CreepTab()
	{
		
		super("creeperchicks");
		
		 this.setBackgroundImageName("items.png");
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Item_Registry.creeper_treat);
	}

	@Override
	public ItemStack getTabIconItem() {
		
		return new ItemStack(Item_Registry.creeper_treat);
	}
	
}