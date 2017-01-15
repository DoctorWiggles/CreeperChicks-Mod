package creeperchicks.projectiles;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Thrown_creep_Egg extends EntityThrowable{

   public Thrown_creep_Egg(World world) {
       super(world);
   }

   public Thrown_creep_Egg(World world, EntityPlayer player) {
       super(world,player);
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
   public void readEntityFromNBT(NBTTagCompound nbttagcompound) {}      

   @Override
   public void writeEntityToNBT(NBTTagCompound nbttagcompound) {}
   
   //Called upon when the entity touches an object, being an entity or block
   @Override
   protected void onImpact(RayTraceResult mop) {
      
	   
	   if(!this.world.isRemote){      
      
      this.world.createExplosion(null, this.posX, this.posY, this.posZ, (float)1, true);
      this.setDead();
	   }
   }

  
}