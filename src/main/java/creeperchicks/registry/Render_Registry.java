package creeperchicks.registry;


import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.Item;
public final class Render_Registry extends Item_Registry{

	
	static RenderManager randy = Minecraft.getMinecraft().getRenderManager();	
	static RenderItem item = Minecraft.getMinecraft().getRenderItem();
	
	//============================ Entities ======================================================//
	public static void register_entity_renderer(){
		 RenderingRegistry.registerEntityRenderingHandler((Creeper_Chicken.class),
				 new Creeper_Chicken_Render(randy, new Creeper_Chicken_Model(), 0.3F));   
        
		 //RenderingRegistry.registerEntityRenderingHandler(Thrown_creep_Egg.class, new Creep_Egg_Render(1));
		 RenderingRegistry.registerEntityRenderingHandler(Thrown_creep_Egg.class, new Creep_Egg_Render(randy, egg_item, item));
		 
		 
	}
	//============================ Items =========================================================//
	


	public static void registerItemRenderer() {
		Main.logger.info("Registering Renders");
		//reg(ItemRegistry.chocolatemilk);
		reg(creeper_treat);
		reg(egg_item);
		
	}
	
	
	public static void registerBlockRenderer(){
		//reg(ItemRegistry.falseBedrock);
	}

	//==========================================================================//

	public static String modid = Main.MODID;

	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register
		(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		//Main.logger.info(modid + ":" + item.getUnlocalizedName().substring(5), "inventory");
	}
	
	public static void Meta_reg(Item item, int meta, String file) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register
	    (item, meta, new ModelResourceLocation(modid + ":" + file, "inventory"));
	    //Main.logger.info(modid + ":" + file, "inventory");
	}
	

	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}