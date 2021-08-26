package com.arkaddition.items;

import com.arkaddition.Main;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements IHasModel {
    public FoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setTranslationKey(name);
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}