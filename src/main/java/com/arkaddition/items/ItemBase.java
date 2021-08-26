package com.arkaddition.items;


import com.arkaddition.Main;
import com.arkaddition.creativetab.ArkItemGroups;
import com.arkaddition.util.IHasModel;
import net.minecraft.item.Item;

/**
 * @author Liplum
 */
public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setTranslationKey(name);
        setRegistryName(name);
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
