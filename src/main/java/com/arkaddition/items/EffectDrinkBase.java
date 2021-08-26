package com.arkaddition.items;

import com.arkaddition.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class EffectDrinkBase extends DrinkerBase implements IHasModel {
    private final PotionEffect[] allEffects;

    public EffectDrinkBase(String name, int amount, float saturation, boolean isWolfFood, PotionEffect... effects) {
        super(name, amount, saturation, isWolfFood);
        if (effects.length > 5) {
            this.allEffects = Arrays.copyOf(effects, 5);
        } else {
            this.allEffects = effects;
        }
        //setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(@Nonnull ItemStack stack, World worldIn, @Nonnull EntityPlayer player) {
        if (!worldIn.isRemote) {
            for (PotionEffect effect : allEffects) {
                player.addPotionEffect(
                        new PotionEffect(
                                effect.getPotion(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()
                        ));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(@Nonnull ItemStack stack) {
        return true;
    }
}
