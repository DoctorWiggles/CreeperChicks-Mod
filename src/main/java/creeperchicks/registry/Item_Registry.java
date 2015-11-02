package creeperchicks.registry;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import creeperchicks.Configs;
import creeperchicks.Main;
import creeperchicks.items.Creeper_treat;
import creeperchicks.items.Egg_item;

public class Item_Registry extends Configs{
	
	public static Item egg_item;
	public static Item creeper_treat;
	public static Item flail_item;
	
	public static void createItems() {
		Main.logger.info("Registering items");
		egg_item = new Egg_item();     
		GameRegistry.registerItem(egg_item, "egg_item");  
		
		creeper_treat = new Creeper_treat( 12, 6f, true);
		GameRegistry.registerItem(creeper_treat, "creeper_treat");
		
		
		
	
	}

}
