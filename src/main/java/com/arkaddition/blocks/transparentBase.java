package com.arkaddition.blocks;

import com.arkaddition.Main;
import com.arkaddition.creativetab.TabArkAddition3Block0;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class transparentBase extends Block implements IHasModel {
    public transparentBase(String name, Material material, SoundType sound, float hard, String Tool, int Level)
    {
        super(material);

        setTranslationKey(name);
        setRegistryName(name);
        setLightOpacity(1);
        setCreativeTab(TabArkAddition3Block0.TABARKADDITION3BLOCK0);
        setSoundType(sound);
        setHardness(hard);
        setHarvestLevel (Tool,Level);



        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock (this).setRegistryName(this.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }


//see to del -by IAX
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (blockState != iblockstate)
        {
            return true;
        }

        if (block == this)
        {
            return false;
        }

        return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
//until here



    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
