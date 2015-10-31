package creeperchicks.util;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHandler {
  
	protected static Random growrand = new Random();
	
	//event when a creeper is crushed to spew bonus loot
	@SubscribeEvent
	public void CrushedLoot_Handler(LivingHurtEvent event){
				
		if (event.isCanceled() || !(event.entityLiving instanceof EntityCreeper)) { 
		      return;
		    }
		if(event.source == DamageSource.fallingBlock || event.source == DamageSource.inWall
				||event.source == DamageSource.anvil){			
		//precall business
		EntityLivingBase ent = event.entityLiving;
		double X = ent.posX;
		double Y = ent.posY;
		double Z  = ent.posZ;
		World world = ent.worldObj;
		ItemStack powder = new ItemStack(Items.gunpowder, 1);
		ItemStack skull = new ItemStack(Items.skull, 1, 4);
		int randy = growrand.nextInt(4);
		int roll = randy + 2;
		
		
		short short1 =24;
		short short2 = 16;
		for (int lp = 0; lp < short2; ++lp)
       {
           double d6 = (double)lp / ((double)short1 - 1.0D);
           float f = (this.growrand.nextFloat()*40) ;
           float f1 = (this.growrand .nextFloat()*40 );
           float f2 = (this.growrand .nextFloat()*40 );		          
           float p1 = (this.growrand .nextFloat()/3 ) ;
           float p = (this.growrand .nextFloat()-.5F )/5 ;
           float p2 = (this.growrand .nextFloat()-.5F )/5 ;
           
           world.spawnParticle("largesmoke", X+f-.5, Y+f1, Z+f2+.5, p, p1, p2);
           
       }		
		ent.attackEntityFrom(DamageSource.fall, 100);
		//ent.setDead();
		
		//Drop random loot
				for(int go = 0; go<randy; ++go){
				ent.entityDropItem(powder, 0);
				}
				ent.entityDropItem(skull, 0);
				
			//ent.setDead();
			event.setCanceled(true);
		}
		
		
		
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}