package com.arkaddition.blocks;

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

public class OreDifferentIRON extends BlockBase {
    public OreDifferentIRON(String name, Material material, CreativeTabs tab,SoundType sound,float hard,int level,String Tool) {
        super(name,material,tab,sound,hard,Tool,level);

        setResistance(15.0f);
    }


    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return ModItems.HETEROIRON_FRAGMENTS;
    }

    @Override
    public int quantityDropped(Random random) {
        return 3;
    }
    //fortune
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
       if (fortune > 0) {
           int bonusFactor = Math.max(random.nextInt(fortune + 2) - 1, 0);
           return this.quantityDropped(random) * (bonusFactor + 1);
       } else {
           return this.quantityDropped(random);
       }
    }
    //exp
    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random random = world instanceof World ? ((World) world).rand : new Random();
       return MathHelper.getInt(random, 3, 7);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
       return new ItemStack(this);
    }

}
