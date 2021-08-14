package com.arkaddition.items;

import com.arkaddition.Main;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;


public class FoodBase0 extends ItemFood implements IHasModel{
    public FoodBase0(String name, int amount, float saturation, boolean iswolfFood,CreativeTabs tab) {
        super( amount, saturation, iswolfFood );
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModItems.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
