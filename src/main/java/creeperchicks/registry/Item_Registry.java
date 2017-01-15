package creeperchicks.registry;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import creeperchicks.Main;
import creeperchicks.config.Config;
import creeperchicks.items.Creeper_treat;
import creeperchicks.items.Egg_item;

public class Item_Registry extends Config{
	
	public static Item egg_item;
	public static Item creeper_treat;
	public static Item flail_item;
	
	public static void createItems() {
		Main.logger.info("Registering items");
		
		reg(egg_item = new Egg_item("egg_item"));				
		reg(creeper_treat = new Creeper_treat("creeper_treat", 12, 6f, true));
		
	
	}
	
	public static void reg(Item item){
		
		item.setRegistryName(item.getUnlocalizedName().substring(5));
		GameRegistry.register(item);
	}

}
