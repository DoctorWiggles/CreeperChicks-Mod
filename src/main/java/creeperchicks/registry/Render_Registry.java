package creeperchicks.registry;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import creeperchicks.Main;
import creeperchicks.mobs.Creeper_Chicken;
import creeperchicks.mobs.Creeper_Chicken_Model;
import creeperchicks.mobs.Creeper_Chicken_Render;
import creeperchicks.projectiles.Render_Item;
import creeperchicks.projectiles.Thrown_creep_Egg;
public final class Render_Registry {

	
	static RenderManager render = Minecraft.getMinecraft().getRenderManager();	
	static RenderItem Item = Minecraft.getMinecraft().getRenderItem();
	
	
	public static void register_entity_renderer(){
		 
		 reg(Creeper_Chicken.class, new Creeper_Chicken_Render(render, new Creeper_Chicken_Model(), 0.3F)); 
		 reg(Thrown_creep_Egg.class, new Render_Item(render, Item_Registry.egg_item, Item));
		 
	}
	
	
	public static void reg(Class<? extends Entity> entityClass, Render renderer){
		
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
	}
	
	public static void registerItems(){
		
		reg(Item_Registry.creeper_treat);
		reg(Item_Registry.egg_item);
		
		
	}

	
	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register
		(item, 0, new ModelResourceLocation(Main.PATH + item.getUnlocalizedName().substring(5), "inventory"));
		}
	
	
	
}