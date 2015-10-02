package creeperchicks.registry;


import cpw.mods.fml.client.registry.RenderingRegistry;
import creeperchicks.Main;
import creeperchicks.mobs.Creeper_Chicken;
import creeperchicks.mobs.Creeper_Chicken_Model;
import creeperchicks.mobs.Creeper_Chicken_Render;
import creeperchicks.projectiles.Creep_Egg_Render;
import creeperchicks.projectiles.Thrown_creep_Egg;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.Item;
public final class Render_Registry {

	public static void register_entity_renderer(){
		 RenderingRegistry.registerEntityRenderingHandler((Creeper_Chicken.class),
				 new Creeper_Chicken_Render(new Creeper_Chicken_Model(), 0.3F));   
        
		 RenderingRegistry.registerEntityRenderingHandler(Thrown_creep_Egg.class, new Creep_Egg_Render(1));
		 
		 
	}

	
}