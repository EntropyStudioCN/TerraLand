package com.arkaddition.blocks;

import com.arkaddition.Main;
import com.arkaddition.blocks.TileEnity.SSCTileEnity;
import com.arkaddition.creativetab.ArkItemGroups;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class SourceStoneCore extends Block implements IHasModel, ITileEntityProvider {
    public static DataParameter<Float> RADIATION = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.FLOAT);
    public static DataParameter<Float> DISTANCE = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.FLOAT);
    public SourceStoneCore() {
        super(Material.IRON);
        setTranslationKey("soucestonecore");
        setRegistryName("soucestonecore");
        setCreativeTab(ArkItemGroups.Blocks);
        setLightLevel(1.0F);
        setLightOpacity(1);
        setHardness(70F);
        setSoundType(SoundType.GLASS);
        setResistance(-1.0f);
        this.setTickRandomly(true);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new SSCTileEnity ();
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public void updateTick(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
        //WARN: Maybe it will make lag
    }
    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }


    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new SSCTileEnity ();
    }
}
