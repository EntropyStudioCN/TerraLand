package com.arkaddition.blocks;

import com.arkaddition.creativetab.TabArkAddition3Block0;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sun.java2d.pipe.AAShapePipe;

import javax.annotation.Nonnull;
import java.util.Random;

public class OreCu extends BlockBase {
    public OreCu(String name, Material material,SoundType sound,float hard,int level,String Tool) {
        super(name,material,sound,hard,Tool,level);

        setResistance(15.0f);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab (TabArkAddition3Block0.TABARKADDITION3BLOCK0);

    }


    @Nonnull
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this);
    }

}