package creeperchicks.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import creeperchicks.Main;


public class Config {

	
	
	public static Configuration config;
	
	//==========================================================================//


	public static void configOptions(FMLPreInitializationEvent event) {
		Main.logger.info("Syncing Config");
		config = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig();
	}	
	
	public static final String Settings = "Settings";
	public static boolean BlazePowderSmelting;
	public static boolean CreeperCrushing;
	public static boolean TransformationExplosion;

	//=============================================================================//
	public static void syncConfig (){

		BlazePowderSmelting = config.get(Settings, "Blaze Powder Smelting", true,"Allows Creeper Chick Eggs to be smelted into Blaze Powder").getBoolean();
		CreeperCrushing = config.get(Settings, "Creeper Crushing", true, "Allows Creepers to be instantly crushed and give bonus loot including heads").getBoolean(true);
		TransformationExplosion = config.get(Settings, "Transformation Explosion", true, "Allows or disables transformation creating explosions").getBoolean(true);
		
		if(config.hasChanged())
			config.save();

	}
	
	

}
