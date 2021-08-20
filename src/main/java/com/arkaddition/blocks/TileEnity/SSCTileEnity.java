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
    //private int progress;
   // private int fuel;

    // 注意，虽然 TileEntity 本身是抽象类，但它并没有任何抽象方法。
    // 有鉴于 Minecraft 反序列化 TileEntity 的方式，TileEntity 必须要有 public 的
    // 零参构造器。这里我们省略构造器不写，即使用隐式声明的默认构造器。

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        // 从 NBT 标签中读数据，以反序列化 TileEntity
        // 一定要调用 super.readFromNBT
        super.readFromNBT(tag);
        //this.progress = tag.getInteger("Progress");
        //this.fuel = tag.getInteger("Fuel");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        // 向 NBT 标签中写数据，以序列化 TileEntity
        // 在返回前务必写入必须的数据
        // 一定要调用 super.writeToNBT(tag)
        //tag.setInteger("Progress", this.progress);
        //tag.setInteger("Fuel", this.fuel);
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
