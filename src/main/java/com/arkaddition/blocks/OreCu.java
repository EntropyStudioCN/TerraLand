package com.arkaddition.blocks;

import com.arkaddition.creativetab.ArkItemGroups;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class OreCu extends BlockBase {
    public OreCu(String name, Material material,SoundType sound,float hard,int level,String Tool) {
        super(name,material,sound,hard,Tool,level);

        setResistance(15.0f);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab (ArkItemGroups.Blocks);

    }


    @Nonnull
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this);
    }

}