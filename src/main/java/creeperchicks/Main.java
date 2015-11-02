package creeperchicks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.java.games.input.Keyboard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler; // used in 1.6.2
//import net.minecraftforge.fml.common.Mod.PreInit;    // used in 1.5.2
//import net.minecraftforge.fml.common.Mod.Init;       // used in 1.5.2
//import net.minecraftforge.fml.common.Mod.PostInit;   // used in 1.5.2
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.fml.common.network.NetworkMod; // not used in 1.7
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import creeperchicks.util.ForgeEventHandler;


@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main 
{	

	// The instance of your mod that Forge uses.
	@Instance(value = "CreeperChicks")
	public static Main instance; 
	
	public static final String MODID = "CreeperChicks";
	public static final String MODNAME = "CreeperChicks";
	public static final String VERSION = "v2.a";
	
	
	public static final Logger logger = LogManager.getLogger("CreeperChicks");
	public static ForgeEventHandler eventHandler = new ForgeEventHandler();
	public static Configuration config;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="creeperchicks.ClientProxy", serverSide="creeperchicks.CommonProxy")
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