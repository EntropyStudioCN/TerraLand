package com.arkaddition.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arkaddition.init.ModItems;

public class TabArkAddition1 {
	public static final CreativeTabs TABARKADDITION1 = new CreativeTabs(CreativeTabs.getNextID(), "tabarkaddition1")
	{
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BAKLAVA);//Originiums
        }

        //@SideOnly(Side.CLIENT)
        //public ItemStack getTabIconItem()
        //{
        //    return new ItemStack(ModItems.BAKLAVA);//Originiums
        //}
    };
}
