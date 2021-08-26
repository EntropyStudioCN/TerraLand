package com.arkaddition.blocks.TileEnity;

import com.arkaddition.blocks.SourceStoneCore;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

import java.util.Random;


public final class SSCTileEnity extends TileEntity implements ITickable {

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        return super.writeToNBT(tag);
    }


    @Override
    public void update() {
        //GameTick = 0.05s
        if (world.isRemote) {
            BlockPos bp = this.pos;
            for (Entity entity : this.world.getLoadedEntityList()) {
                if (entity instanceof EntityPlayer) {
                    float distance = (float) entity.getDistance(bp.getX(), bp.getY(), bp.getZ());
                    if (distance <= 7){
                        if(new Random().nextInt(100)<=15){
                            entity.getDataManager().set(SourceStoneCore.RADIATION,entity.getDataManager().get(SourceStoneCore.RADIATION)+0.001f);
                        }
                    }
                }
            }
        }
    }
}
