package com.arkaddition.blocks;

import javafx.scene.effect.Light;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


import com.arkaddition.Main;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

public class BlockBase extends Block implements IHasModel{
	public BlockBase(String name, Material material, CreativeTabs tab, float lightlevel, int Opacity, float hard, SoundType sound,float Resistance)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setLightLevel(lightlevel);
        setLightOpacity(Opacity);
        setHardness(hard);
        setSoundType(sound);
        setResistance(Resistance);


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
