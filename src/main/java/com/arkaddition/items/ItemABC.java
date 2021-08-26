package com.arkaddition.items;


import com.arkaddition.Main;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.item.Item;

/**
 * @author Liplum
 */
public class ItemABC extends Item implements IHasModel {
    public ItemABC() {
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
