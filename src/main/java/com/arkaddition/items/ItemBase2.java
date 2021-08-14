package com.arkaddition.items;

import com.arkaddition.Main;
import com.arkaddition.creativetab.TabArkAddition2;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase2 extends Item implements IHasModel{
    public ItemBase2(String name, CreativeTabs tab) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TabArkAddition2.TABARKADDITION2); //������������Ʒ���������//TABARKADDITION

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }


}
