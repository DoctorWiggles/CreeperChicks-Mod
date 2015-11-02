package creeperchicks.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import creeperchicks.Main;

public class RecipeFactory extends Item_Registry{
	
	public static void ShapelessRecipe(ItemStack output, Object... recipe){	
		GameRegistry.addRecipe(new ShapelessOreRecipe(output,recipe));
		
	}
	static ItemStack skull = new ItemStack(Items.skull, 0, 4);
	
	public static void RegisterRecipes(){
		Main.logger.info("Loading Recipes");
		
		ShapelessRecipe(new ItemStack(Items.gunpowder, 1 , 0), new Object[]{
			egg_item});
		
		if(BlazePowderSmelting){
			GameRegistry.addSmelting(egg_item, new ItemStack(Items.blaze_powder), 0f);}
	
		
		ShapelessRecipe(new ItemStack(creeper_treat, 2, 0), new Object[]{
			skull, Items.wheat_seeds, Items.wheat_seeds});
	}

}
