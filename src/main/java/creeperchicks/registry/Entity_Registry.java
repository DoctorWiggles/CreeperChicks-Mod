package creeperchicks.registry;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;
import creeperchicks.Main;
import creeperchicks.mobs.Creeper_Chicken;
import creeperchicks.projectiles.Thrown_creep_Egg;

public class Entity_Registry {
	
	
	public static void register_entities(){
	EntityRegistry.registerModEntity(Creeper_Chicken.class, "Creeper Chick", 1, Main.instance, 80, 3, true);
    EntityList.addMapping(Creeper_Chicken.class, "Creeper Chick", 3500, 0x14D21E, 0x58595C);
    
    EntityRegistry.registerModEntity(Thrown_creep_Egg.class, "Entity_creep_Egg", 2, Main.instance, 350, 30, true);
	}
}
