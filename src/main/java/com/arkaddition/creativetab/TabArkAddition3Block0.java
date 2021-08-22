package com.arkaddition.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arkaddition.init.ModItems;
import com.arkaddition.init.ModBlocks;

public class TabArkAddition3Block0 {
    public static final CreativeTabs TABARKADDITION3BLOCK0 = new CreativeTabs(CreativeTabs.getNextID(), "tabarkaddition3block0")
    {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.OREDIFFERENTIRON);
        }

        //@SideOnly(Side.CLIENT)
        //public ItemStack getTabIconItem()
        //{
        //    return new ItemStack(ModItems.INCANDESCENT_ALLOY_BLOCK);//Originiums
        //}
    };
}