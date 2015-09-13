package creeperchicks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import creeperchicks.registry.Item_Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

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
	public Item getTabIconItem() 
	{
		return Item_Registry.creeper_treat;
	}
}