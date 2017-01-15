package creeperchicks;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import creeperchicks.registry.Render_Registry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {		
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		Render_Registry.register_entity_renderer();
		Render_Registry.registerItems();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		
	}
}