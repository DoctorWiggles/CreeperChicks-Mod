package creeperchicks.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import creeperchicks.CreepTab;
import creeperchicks.config.Config;
import creeperchicks.mobs.Creeper_Chicken;
import creeperchicks.util.ModUtil;

public class Creeper_treat extends ItemFood
{
	

	public Creeper_treat(String unlocal, int healAmount, float saturationModifier, boolean wolvesFavorite){
		super(healAmount, saturationModifier, wolvesFavorite);
		this.setUnlocalizedName(unlocal);
		setCreativeTab(CreepTab.creeperchicks);
		this.maxStackSize = 64;  
		this.setAlwaysEdible();

	}

	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4)
      {
      par3List.add(TextFormatting.ITALIC + "Chickens seem to be attracted to it...");
     }
	
    
    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand)
    {
    	World world = player.world;
    	double x = target.posX;
    	double y = target.posY;
    	double z = target.posZ;
    	if (target.world.isRemote)
    	{
    		return false;
    	}
    	if(target instanceof EntityChicken){
    		ItemStack heldItem = player.inventory.getCurrentItem();
    		stack.shrink(1);
    		if(Config.TransformationExplosion){
    			world.createExplosion(target, x,y,z, (float)3, true);}
    		target.setDead();
    		String name = null;
    		try{
    			name = ((EntityChicken) target).getCustomNameTag();}
    		catch(Exception exception){}   

    		Creeper_Chicken chicky = new Creeper_Chicken(world);
    		chicky.setLocationAndAngles(x,y,z, 0.0F, 0.0F);
    		world.spawnEntity(chicky);
    		if(name != null){
    			chicky.setCustomNameTag(name);
    		}				 
    	} 

    	return false;
    }

        
    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase living)
    {
    	if (!world.isRemote)
        {
   		 world.createExplosion(living, living.posX, living.posY, living.posZ, (float)3, false);
   		 world.createExplosion(living, living.posX, living.posY, living.posZ, (float).2, true);
        } 
    	stack.shrink(1);
        
        if (living instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)living;
            player.getFoodStats().addStats(this, stack);           
            ModUtil.sound((EntityPlayer)living, SoundEvents.ENTITY_PLAYER_BURP,0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, world, player);
            player.addStat(StatList.getObjectUseStats(this));
            
            if(player.capabilities.isCreativeMode){stack.grow(1);}
    	
        }

        return stack;
    }
        
     
}