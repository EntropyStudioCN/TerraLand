package com.arkaddition.blocks;

import com.arkaddition.Main;
import com.arkaddition.creativetab.TabArkAddition3Block0;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class transparentBase extends Block implements IHasModel {
    public transparentBase(String name, Material material, SoundType sound, float hard, String Tool, int Level)
    {
        super(material);

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TabArkAddition3Block0.TABARKADDITION3BLOCK0);
        setLightOpacity(0);
        setSoundType(sound);
        setHardness(hard);
        setHarvestLevel (Tool,Level);



        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock (this).setRegistryName(this.getRegistryName()));
    }

    @SideOnly (Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
