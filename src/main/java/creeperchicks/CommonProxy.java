package creeperchicks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import creeperchicks.config.Config;
import creeperchicks.items.Fuel_Handler;
import creeperchicks.registry.Entity_Registry;
import creeperchicks.registry.Item_Registry;
import creeperchicks.registry.RecipeFactory;
import creeperchicks.util.ForgeEventHandler;

public class CommonProxy {
	
public void preInit(FMLPreInitializationEvent e) {	
		Config.configOptions(e);  
		Item_Registry.createItems();
		GameRegistry.registerFuelHandler(new Fuel_Handler());
		
		if(Config.CreeperCrushing){
		FMLCommonHandler.instance().bus().register(Main.eventHandler);
		MinecraftForge.EVENT_BUS.register(Main.eventHandler);
		}

	}

	public void init(FMLInitializationEvent e) {
		Entity_Registry.register_entities();
		RecipeFactory.RegisterRecipes();
		
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}