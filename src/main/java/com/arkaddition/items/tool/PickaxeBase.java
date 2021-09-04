package com.arkaddition.items.tool;


import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.item.ItemPickaxe;

/**
 *@Author IAX
 */

public class PickaxeBase extends ItemPickaxe implements IHasModel {
    public PickaxeBase(String name,ToolMaterial material){
        super(material);
        setRegistryName (name);
        setTranslationKey (name);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

    }
}
