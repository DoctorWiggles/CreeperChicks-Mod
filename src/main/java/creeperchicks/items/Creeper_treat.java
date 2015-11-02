package creeperchicks.items;

import creeperchicks.Configs;
import creeperchicks.CreepTab;
import creeperchicks.mobs.Creeper_Chicken;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Creeper_treat extends ItemFood
{
	


	//private PotionEffect[] effects;

    public Creeper_treat(int healAmount, float saturationModifier, boolean wolvesFavorite)
    {	super(healAmount, saturationModifier, wolvesFavorite);
    this.setUnlocalizedName("creeper_treat");
    //setTextureName("Creeperchicks:creeper_treat");
    setCreativeTab(CreepTab.creeperchicks);
    this.maxStackSize = 64;  

    //this.effects = effects;
    }
    
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {

   	 if (!world.isRemote)
        {
   		 world.createExplosion(player, player.posX, player.posY, player.posZ, (float)3, false);
   		 world.createExplosion(null, player.posX, player.posY, player.posZ, (float).2, true);
        }    	
   	 //player.getFoodStats().func_151686_a(this, stack);
           world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
          // this.onFoodEaten(stack, world, player);
           return;
  
    }
    
    
   
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (player.canEat(true))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }
    	return stack;
    }
    
    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
    	World world = player.worldObj;
    	double x = entity.posX;
    	double y = entity.posY;
    	double z = entity.posZ;
        if (entity.worldObj.isRemote)
        {
            return false;
        }
        if(entity instanceof EntityChicken){
        	ItemStack heldItem = player.inventory.getCurrentItem();
			 heldItem.stackSize--;
    		 if(Configs.TransformationExplosion){
    			 world.createExplosion(entity, x,y,z, (float)3, true);}
    		 entity.setDead();
    		 String name = null;
    		 try{
    			 name = ((EntityChicken) entity).getCustomNameTag();}
    		 	catch(Exception exception){}   
    		 
    		 Creeper_Chicken chicky = new Creeper_Chicken(world);
    		 chicky.setLocationAndAngles(x,y,z, 0.0F, 0.0F);
    		 //chicky.onSpawnWithEgg((IEntityLivingData)null);
				 world.spawnEntityInWorld(chicky);
				 if(name != null){
					chicky.setCustomNameTag(name);
					//chicky.setAlwaysRenderNameTag(true);
				 }
				 
    	}       
        
        return false;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.EAT;
    }
}