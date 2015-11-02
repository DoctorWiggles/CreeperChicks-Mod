package creeperchicks.items;

import creeperchicks.CreepTab;
import creeperchicks.projectiles.Thrown_creep_Egg;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Egg_item extends Item
{
    private static final String __OBFID = "CL_00000023";

    public Egg_item()
    {
        this.maxStackSize = 16;
        this.setCreativeTab(CreepTab.creeperchicks);
        this.setUnlocalizedName("egg_item");
        //setTextureName("creeperchicks:egg_item");
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (!p_77659_3_.capabilities.isCreativeMode)
        {
            --p_77659_1_.stackSize;
        }

        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.spawnEntityInWorld(new Thrown_creep_Egg(p_77659_2_, p_77659_3_));
        }

        return p_77659_1_;
    }
}