package creeperchicks;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.util.EnumHelper;

public class Configs extends Main{
	
	public static boolean BlazePowderSmelting;
	public static boolean CreeperCrushing;
	public static boolean TransformationExplosion;
	
	//===============================================================================//
	
	/** Begins Registering, loading and saving configuration**/
	public static void ProcessConfiguration(FMLPreInitializationEvent event){

		////////////////////
		/** Config Core **/
		//////////////////       	        	

		config = new Configuration(event.getSuggestedConfigurationFile());
		
		String conf1 = "A. General Settings";
		Property ToolDurability = config.get(conf1, " ", " ");
		ToolDurability.comment = "Configure some things";


		//Property Interactions = config.get("Custom Interactions", "", "");
		//Interactions.comment = "Enable or disable world interactions";


		config.load();

		logger.info("Loading Configs");
		
		
		BlazePowderSmelting = config.get(conf1, "BlazePowderSmelting", false, "Allows Creeper Chick Eggs to be smelted into Blaze Powder").getBoolean(false);
		CreeperCrushing = config.get(conf1, "CreeperCrushing", true, "Allows Creepers to be instantly crushed and give bonus loot including heads").getBoolean(true);
		TransformationExplosion = config.get(conf1, "TransformationExplosion", true, "Allows or disables transformation creating explosions").getBoolean(true);
		
		

		config.save(); 
		logger.info("Configurations Saved");
		
		


	}




	

}
