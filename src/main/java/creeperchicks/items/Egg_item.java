package creeperchicks.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import creeperchicks.CreepTab;
import creeperchicks.projectiles.Thrown_creep_Egg;
import creeperchicks.util.ModUtil;

public class Egg_item extends Item{

    public Egg_item(String unlocal)
    {
        this.maxStackSize = 16;
        this.setCreativeTab(CreepTab.creeperchicks);
        this.setUnlocalizedName(unlocal);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4){

    	par3List.add(TextFormatting.ITALIC + "Something is rumbling inside");
    }

    @Override	  
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){

    	ItemStack stack = player.getHeldItem(hand);
    	if (!player.capabilities.isCreativeMode){stack.shrink(1);}

    	ModUtil.sound(player, SoundEvents.ENTITY_ARROW_SHOOT, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F) );

    	if (!world.isRemote)
    	{	Thrown_creep_Egg eggy = new Thrown_creep_Egg(world, player);
    		eggy.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0F, 1F, 1F);
    		world.spawnEntity(eggy);
    	}

    	return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}