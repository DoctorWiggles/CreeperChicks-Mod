package creeperchicks.util;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import creeperchicks.Main;
import creeperchicks.projectiles.Thrown_creep_Egg;
import creeperchicks.registry.Item_Registry;

public class Dispenser_Handler {
	
    public static void registerVanillaDispenserBehaviors()
    {
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item_Registry.egg_item, new DispenserBehaviour());
              
    }
    

final static class DispenserBehaviour extends BehaviorDefaultDispenseItem
{
    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    public ItemStack dispenseStack(IBlockSource source, ItemStack stack)
    {
    	World world = source.getWorld(); 
    	BlockPos pos = source.getBlockPos();
    	IPosition iposition = BlockDispenser.getDispensePosition(source);
    	EnumFacing enumfacing = (EnumFacing)source.getBlockState().getValue(BlockDispenser.FACING);
    	
    	
        Thrown_creep_Egg eggy = new Thrown_creep_Egg(world); 
        eggy.setThrowableHeading(
				(double)enumfacing.getFrontOffsetX(), 
				(double)enumfacing.getFrontOffsetY() + 0.1F, 
				(double)enumfacing.getFrontOffsetZ(), 1F, 1F);
        eggy.setPosition(
        		enumfacing.getFrontOffsetX()+pos.getX()+0.5F, 
        		enumfacing.getFrontOffsetY()+pos.getY()+0.5F,
        		enumfacing.getFrontOffsetZ()+pos.getZ()+0.5F);
		world.spawnEntity(eggy);
		ModUtil.sound(world, pos, SoundEvents.ENTITY_ARROW_SHOOT, 0.5F, 0.4F / (Main.randy.nextFloat() * 0.4F + 0.8F) );
        
		stack.shrink(1);
        return stack;
    }
}


}
