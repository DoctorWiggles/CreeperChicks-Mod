package creeperchicks.util;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHandler {
  
	protected static Random growrand = new Random();
	
	//event when a creeper is crushed to spew bonus loot
	@SubscribeEvent
	public void CrushedLoot_Handler(LivingHurtEvent event){
				
		if (event.isCanceled() || !(event.getEntityLiving() instanceof EntityCreeper)) { 
		      return;
		    }
		if(event.getSource() == DamageSource.FALLING_BLOCK || event.getSource() == DamageSource.IN_WALL
				||event.getSource() == DamageSource.ANVIL){			
		//precall business
		EntityLivingBase ent = event.getEntityLiving();
		double X = ent.posX;
		double Y = ent.posY;
		double Z  = ent.posZ;
		World world = ent.world;
		ItemStack powder = new ItemStack(Items.GUNPOWDER, 1);
		ItemStack skull = new ItemStack(Items.SKULL, 1, 4);
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
           
           world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, X+f-.5, Y+f1, Z+f2+.5, p, p1, p2);
           
       }		
		ent.attackEntityFrom(DamageSource.FALL, 100);		
		
		//Drop random loot
				for(int go = 0; go<randy; ++go){
				ent.entityDropItem(powder, 0);
				}
				ent.entityDropItem(skull, 0);
			
			event.setCanceled(true);
		}
		
		
		
	}
	
	
	 
	 
	 
}