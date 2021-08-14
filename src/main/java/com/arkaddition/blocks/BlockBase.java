package com.arkaddition.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


import com.arkaddition.Main;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;











public class BlockBase extends Block implements IHasModel{
	public BlockBase(String name, Material material) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);//将你的方块放在哪个物品栏，这里我们选择的是草方块(建筑方块)那一类

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
