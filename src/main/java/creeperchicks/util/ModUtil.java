package creeperchicks.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class ModUtil {
	
		
	public static void sound(EntityPlayer player, SoundEvent event, float volume, float pitch){
		
		player.world.playSound(player, player.getPosition(), event,
        		SoundCategory.PLAYERS, volume, pitch);
	}

}
