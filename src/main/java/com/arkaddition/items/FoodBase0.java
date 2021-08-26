package com.arkaddition.items;

import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;

@Deprecated
public class FoodBase0 extends FoodBase implements IHasModel {
    public FoodBase0(String name, int amount, float saturation, boolean isWolfFood, CreativeTabs tab) {
        super(name, amount, saturation, isWolfFood);
        super.setCreativeTab(tab);
        ModItems.ITEMS.add(this);
    }
}
