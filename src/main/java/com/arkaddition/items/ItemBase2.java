package com.arkaddition.items;

import com.arkaddition.creativetab.ArkItemGroups;
import com.arkaddition.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;

@Deprecated
public class ItemBase2 extends ItemABC implements IHasModel {
    public ItemBase2(String name, CreativeTabs tab) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ArkItemGroups.Exchanges); //������������Ʒ���������//TABARKADDITION
    }
}
