package com.arkaddition.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SourceStoneThorn {
    public void spawn(BlockPos bp, Entity commandSenderEntity, World world){
        commandSenderEntity.sendMessage(new TextComponentString("Start spawn Source Stone Thorn at "+bp.getX()+","+bp.getY()+","+bp.getZ()));
        int size = new Random().nextInt(10)+10;//Between 10-20
        commandSenderEntity.sendMessage(new TextComponentString("Source Stone Thorn Base size:"+size));
        new ThornBase(bp,size,world).spawn();
        new ThornA(bp,world).spawn();
    }
    private static class ThornA extends Thorn{
        public ThornA(BlockPos center, World world) {
            super(center, world);
        }
        @Override
        public void spawn(){
            int height = new Random().nextInt(5)+10;//Between 10 - 15
            if ((height&1) != 0){
                if (height == 15){
                    height -= 1;
                }else {
                    height +=1;
                }
            }
            int size = height;
            for(int i=1;i<=size;i++){
                //Every 2 blocks offset
                BlockPos top = new BlockPos(getCenter().getX(),getCenter().getY() + i,getCenter().getZ());
                new Circle(top,i,getWorld()).spawn(Blocks.GLASS.getDefaultState());
                new Circle(top,i - 1,getWorld()).spawn(Blocks.MAGMA.getDefaultState());
            }
        }
    }
    private static class Thorn{
        private BlockPos center;
        private World world;
        public Thorn(BlockPos center,World world){
            this.center = center;
            this.world = world;
        }
        public void spawn(){

        }

        public BlockPos getCenter() {
            return center;
        }

        public World getWorld() {
            return world;
        }
    }
    private static class ThornBase {
        private BlockPos center;
        private int size;
        private World world;
        public ThornBase(BlockPos center,int size,World world){
            this.center = center;
            this.size = size;
            this.world = world;
        }
        public void spawn(){
            new Circle(center,size,world).spawn(Blocks.MAGMA.getDefaultState());
        }
    }
    private static class Circle{
        private BlockPos center;
        private int size;
        private World world;
        public Circle(BlockPos center,int size,World world){
            this.size = size;
            this.center = center;
            this.world = world;
        }
        public void spawn(IBlockState blockState){
            List<BlockPos> poss = new ArrayList<BlockPos>();
            for(int x=-size;x<=size;x++){
                for(int z=-size;z<=size;z++){
                    poss.add(new BlockPos(x,0,z));
                }
            }
            List<BlockPos> possC = new ArrayList<BlockPos>();
            poss.forEach(P ->{
                if (P.getDistance(0,0,0)<=size + 0.5){
                    possC.add(P);
                }
            });
            possC.forEach(P ->{
                world.setBlockState(new BlockPos(
                        center.getX() + P.getX(),
                        center.getY() + P.getY(),
                        center.getZ() + P.getZ()
                ), blockState);
            });
        }
    }
}
