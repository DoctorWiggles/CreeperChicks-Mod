package creeperchicks.projectiles;

import java.util.Stack;




import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Thrown_creep_Egg extends EntityThrowable{

   public Thrown_creep_Egg(World par1World) {
       super(par1World);
   }

   public Thrown_creep_Egg(World par2World, EntityPlayer par3EntityPlayer) {
       super(par2World,par3EntityPlayer);
   }
   
   @Override
   protected void entityInit() {

	   //if enabled spawns particle effects
   }
   public void onUpdate()
   {
	   int i;
       super.onUpdate();
       for (i = 0; i < 2; ++i)
       {
           //this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)i / 4.0D, this.posY + this.motionY * (double)i / 4.0D, this.posZ + this.motionZ * (double)i / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
       }   
   }
   
  
   @Override
   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {

   }
      

   @Override
   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {

   }
   //Called upon when the entity touches an object, being an entity or block
   @Override
  protected void onImpact(MovingObjectPosition mop) {
      
	   
	   if(!this.worldObj.isRemote){
      
      
      this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)1, true);
      this.setDead();
	   }
   }

  
}