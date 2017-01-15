package creeperchicks.registry;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import creeperchicks.Main;
import creeperchicks.mobs.Creeper_Chicken;
import creeperchicks.projectiles.Thrown_creep_Egg;

public class Entity_Registry {
	
	
	public static void register_entities(){
	reg(Creeper_Chicken.class, "CreeperChick", 1, 80, 0x14D21E, 0x58595C); 
    
    reg(Thrown_creep_Egg.class, "Entity_creep_Egg", 2, 350);
    
	}
	
	
	public static void reg(Class<? extends Entity> entityClass, String entityName, int ID, int dist, int egg, int egg2) {
	        EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID, entityName), entityClass, entityName, ID, Main.instance, dist, 3, true, egg, egg2);
	}
	public static void reg(Class<? extends Entity> entityClass, String entityName, int ID, int dist) {
	        EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID, entityName), entityClass, entityName, ID, Main.instance, dist, 3, true);
	}
}
