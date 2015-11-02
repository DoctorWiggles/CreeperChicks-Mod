package creeperchicks.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import creeperchicks.registry.Item_Registry;

public class Fuel_Handler implements IFuelHandler {
	/**
	 * credit The_Fireplace
	 */

	@Override
	public int getBurnTime(ItemStack fuel) {
		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();
		
		 if(itemFuel == Item_Registry.egg_item)
			 return 2000;
		 else		
			 return 0;
		 
	}

}
