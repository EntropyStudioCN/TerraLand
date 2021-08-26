package com.arkaddition.items;

import com.arkaddition.creativetab.ArkItemGroups;
import com.arkaddition.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;

@Deprecated
public class ItemBase extends ItemABC implements IHasModel {
    public ItemBase(String name, CreativeTabs tab) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ArkItemGroups.Materials); //这个决定你的物品会放在哪里//TABARKADDITION
    }
}
