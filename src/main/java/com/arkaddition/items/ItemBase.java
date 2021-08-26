package com.arkaddition.items;


import com.arkaddition.Main;
import com.arkaddition.creativetab.ArkItemGroups;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author Liplum
 */
public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ArkItemGroups.Materials);
    }
    public ItemBase(String name, CreativeTabs creativeTabs){
        setTranslationKey(name);
        setRegistryName(name);
        if (creativeTabs == null){
            setCreativeTab(ArkItemGroups.Materials);
        }else {
            setCreativeTab(creativeTabs);
        }
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
