package com.arkaddition.blocks;

import com.arkaddition.blocks.TileEnity.SSCTileEnity;
import com.arkaddition.creativetab.TabArkAddition3Block0;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class SourceStoneCore extends Block implements IHasModel {
    public static DataParameter<Float> RADIATION = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.FLOAT);
    public SourceStoneCore() {
        super(Material.IRON);
        setTranslationKey("com.ark.soucestonecore");
        setRegistryName("soucestonecore");
        setCreativeTab(TabArkAddition3Block0.TABARKADDITION3BLOCK0);
        setLightLevel(15F);
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

    }
    @Override
    public void updateTick(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_){
        //WARN: Maybe it will make lag
        System.out.println("Tick");
        for (Entity entity : p_180650_1_.getLoadedEntityList()) {
            if (entity instanceof EntityPlayer){
                float distance = (float) entity.getDistance(p_180650_2_.getX(),p_180650_2_.getY(),p_180650_2_.getZ());
                if (distance <= 7 && !(distance < 0)){
                    float radiation = 7 - distance;
                    if (entity.getDataManager().get(RADIATION) < radiation)
                    entity.getDataManager().set(RADIATION,radiation);
                }else {
                    if (entity.getDataManager().get(RADIATION) != 0F){
                        entity.getDataManager().set(RADIATION,0F);
                    }
                }
            }
        }
    }
}
