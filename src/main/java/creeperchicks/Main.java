package creeperchicks;

import java.util.Random;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import creeperchicks.util.ForgeEventHandler;

@Mod(modid=Main.MODID, name=Main.MODNAME, version= Main.VERSION, guiFactory = Main.GUIFactory)
public class Main 
{	
	public static final String MODID = "creeperchicks";
	public static final String PATH = MODID + ":";
	public static final String MODNAME = "Creeper Chicks";
	public static final String VERSION = "v2.1";
	public static final String GUIFactory  = "creeperchicks.config.Config_Factory";
	public static final Logger logger = LogManager.getLogger(Main.MODID);
	
	
	@Instance
	public static Main instance = new Main();
	public static Random randy = new Random();
	
	
	public static ForgeEventHandler eventHandler = new ForgeEventHandler();
	public static Configuration config;

	
	@net.minecraftforge.fml.common.SidedProxy(clientSide="creeperchicks.ClientProxy", serverSide="creeperchicks.CommonProxy")
	public static CommonProxy proxy;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.init(event);

	}

	@EventHandler 
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}