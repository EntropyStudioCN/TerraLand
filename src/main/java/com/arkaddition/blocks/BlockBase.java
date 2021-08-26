package com.arkaddition.blocks;

import com.arkaddition.creativetab.ArkItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


import com.arkaddition.Main;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

public class BlockBase extends Block implements IHasModel{
	public BlockBase(String name, Material material,SoundType sound,float hard,String Tool,int Level)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(ArkItemGroups.Blocks);
        setSoundType(sound);
        setHardness(hard);
        setHarvestLevel (Tool,Level);


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
