package creeperchicks;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import creeperchicks.items.Fuel_Handler;
import creeperchicks.registry.Entity_Registry;
import creeperchicks.registry.Item_Registry;
import creeperchicks.registry.RecipeFactory;

public class CommonProxy {
	
public void preInit(FMLPreInitializationEvent e) {	
		Item_Registry.createItems();
		GameRegistry.registerFuelHandler(new Fuel_Handler());

	}

	public void init(FMLInitializationEvent e) {
		Entity_Registry.register_entities();
		RecipeFactory.RegisterRecipes();
		
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}