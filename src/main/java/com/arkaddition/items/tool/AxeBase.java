package com.arkaddition.items.tool;

import com.arkaddition.Main;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.item.ItemAxe;

/**
 * @Author IAX
 */
public class AxeBase extends ItemAxe implements IHasModel{
    public AxeBase(String name,ToolMaterial material,float Damage,float Speed){
        super(material,Damage,Speed);
        setTranslationKey(name);
        setRegistryName(name);

        ModItems.ITEMS.add (this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }


}
