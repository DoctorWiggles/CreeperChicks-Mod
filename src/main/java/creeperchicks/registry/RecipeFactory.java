package creeperchicks.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import creeperchicks.Main;

public class RecipeFactory extends Item_Registry{
	
	public static void ShapelessRecipe(ItemStack output, Object... recipe){	
		GameRegistry.addRecipe(new ShapelessOreRecipe(output,recipe));
		
	}
	static ItemStack skull = new ItemStack(Items.SKULL, 1, 4);
	
	public static void RegisterRecipes(){
		Main.logger.info("Loading Recipes");
		
		ShapelessRecipe(new ItemStack(Items.GUNPOWDER, 1 , 0), new Object[]{
			egg_item});
		
		if(BlazePowderSmelting){
			GameRegistry.addSmelting(egg_item, new ItemStack(Items.BLAZE_POWDER), 0f);}
	
		
		ShapelessRecipe(new ItemStack(creeper_treat, 2, 0), new Object[]{
			skull, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS});
	}

}
