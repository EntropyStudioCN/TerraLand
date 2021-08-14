package com.arkaddition.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arkaddition.init.ModItems;

public class TabArkAddition {
	public static final CreativeTabs TABARKADDITION = new CreativeTabs(CreativeTabs.getNextID(), "tabarkaddition")
	{
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.INCANDESCENT_ALLOY_BLOCK);
        }

        //@SideOnly(Side.CLIENT)
        //public ItemStack getTabIconItem()
        //{
        //    return new ItemStack(ModItems.INCANDESCENT_ALLOY_BLOCK);//Originiums
        //}
    };
}
