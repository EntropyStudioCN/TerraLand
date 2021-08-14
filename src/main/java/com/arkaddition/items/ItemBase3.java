package com.arkaddition.items;

import com.arkaddition.Main;
import com.arkaddition.creativetab.TabArkAddition1;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase3 extends Item implements IHasModel{
    public ItemBase3(String name, CreativeTabs tab) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TabArkAddition1.TABARKADDITION1); //������������Ʒ���������//TABARKADDITION

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }


}
