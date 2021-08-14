package com.arkaddition.items;

import com.arkaddition.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EffectDrinkBase extends DrinkerBase implements IHasModel {
    //我们这个食物定义5种效果，你可以继续加效果进来……
    PotionEffect effect1,effect2,effect3,effect4,effect5;
    public EffectDrinkBase(String name, int amount, float saturation, boolean iswolfFood, CreativeTabs tab, PotionEffect effect1, PotionEffect effect2, PotionEffect effect3
            , PotionEffect effect4, PotionEffect effect5) {
        super(name, amount, saturation, iswolfFood, tab);

        //setAlwaysEdible();
        this.effect1=effect1;
        this.effect2=effect2;
        this.effect3=effect3;
        this.effect4=effect4;
        this.effect5=effect5;
    }
    @Override
    protected void onFoodEaten(ItemStack stack,World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote)
        {
            if (effect1.getPotion()!=null) {
                player.addPotionEffect(new PotionEffect(effect1.getPotion(), effect1.getDuration(), effect1.getAmplifier(), effect1.getIsAmbient(), effect1.doesShowParticles()));
            }
            if (effect2.getPotion()!=null) {
                player.addPotionEffect(new PotionEffect(effect2.getPotion(), effect2.getDuration(), effect2.getAmplifier(), effect2.getIsAmbient(), effect2.doesShowParticles()));
            }
            if (effect3.getPotion()!=null) {
                player.addPotionEffect(new PotionEffect(effect3.getPotion(), effect3.getDuration(), effect3.getAmplifier(), effect3.getIsAmbient(), effect3.doesShowParticles()));
            }
            if (effect4.getPotion()!=null) {
                player.addPotionEffect(new PotionEffect(effect4.getPotion(), effect4.getDuration(), effect4.getAmplifier(), effect4.getIsAmbient(), effect4.doesShowParticles()));
            }
            if (effect5.getPotion()!=null) {
                player.addPotionEffect(new PotionEffect(effect5.getPotion(), effect5.getDuration(), effect5.getAmplifier(), effect5.getIsAmbient(), effect5.doesShowParticles()));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect( ItemStack stack)
    {
        return true;
    }
}
