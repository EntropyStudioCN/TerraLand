package com.arkaddition.items;

import com.arkaddition.Main;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

import com.arkaddition.creativetab.TabArkAddition;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
    public ItemBase(String name, CreativeTabs tab) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TabArkAddition.TABARKADDITION); //������������Ʒ���������//TABARKADDITION

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
