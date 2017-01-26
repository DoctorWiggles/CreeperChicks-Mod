package creeperchicks.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModUtil {
	
		
	public static void sound(EntityPlayer player, SoundEvent event, float volume, float pitch){
		
		player.world.playSound(player, player.getPosition(), event,
        		SoundCategory.PLAYERS, volume, pitch);
	}
	
	public static void sound(World world, BlockPos pos, SoundEvent event, float volume, float pitch){
		
		world.playSound(null, pos, event,
        		SoundCategory.PLAYERS, volume, pitch);
	}

}
