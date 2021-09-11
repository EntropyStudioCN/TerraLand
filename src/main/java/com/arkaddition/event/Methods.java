package com.arkaddition.event;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
@Deprecated
@Mod.EventBusSubscriber
public class Methods {
   public static void line1 (BlockPos pos1, BlockPos pos2, Block blc, World world) {
       double xmi = Math.min(pos1.getX(), pos2.getX());
       double xma = Math.max(pos1.getX(), pos2.getX());
       double ymi = Math.min(pos1.getY(), pos2.getY());
       double yma = Math.max(pos1.getY(), pos2.getY());
       double zmi = Math.min(pos1.getZ(), pos2.getZ());
       double zma = Math.max(pos1.getZ(), pos2.getZ());
       for (double i = xmi; i < xma; i++) {
           for (double j = ymi; j < yma; j++) {
               for (double k = zmi; k < zma; k++) {
                   if (Math.abs((i - xmi) / (xma - xmi)
                           - ((k - zmi) / (zma - zmi))) < 0.05) {

                       if (Math.abs((i - xmi) / (xma - xmi)
                               - ((j - ymi) / (yma - ymi))) < 0.05) {
                           if (Math.abs((j - ymi) / (yma - ymi)
                                   - ((k - zmi) / (zma - zmi))) < 0.05) {
                               world.setBlockState(new BlockPos(i, j, k), blc.getDefaultState());
                           }
                       }
                   }

               }
           }
       }
   }
   public static void line(BlockPos pos1, BlockPos pos2, Block block, World world){
       double dx = pos2.getX() - pos1.getX();
       double dy = pos2.getY() - pos1.getY();
       double dz = pos2.getZ() - pos1.getZ();
       double absdx = Math.abs(dx);
       double absdy = Math.abs(dy);
       double absdz = Math.abs(dz);
       if(absdx >= absdy && absdx >= absdz){
           int delta = pos2.getX() > pos1.getX() ? 1 : -1;
           for(int x = pos1.getX(); x != pos2.getX(); x += delta){
               world.setBlockState(new BlockPos(x, (((double) x) - pos1.getX()) / dx * dy + pos1.getY(), (((double) x) - pos1.getX()) / dx * dz + pos1.getZ()), block.getDefaultState());
           }
       } else if(absdy >= absdx && absdy >= absdz){
           int delta = pos2.getY() > pos1.getY() ? 1 : -1;
           for(int y = pos1.getY(); y != pos2.getY(); y += delta){
               world.setBlockState(new BlockPos((((double) y) - pos1.getY()) / dy * dx + pos1.getX(), y, (((double) y) - pos1.getY()) / dy * dz + pos1.getZ()), block.getDefaultState());
           }
       } else {
           int delta = pos2.getZ() > pos1.getZ() ? 1 : -1;
           for(int z = pos1.getZ(); z != pos2.getZ(); z+= delta){
               world.setBlockState(new BlockPos((((double) z) - pos1.getZ()) / dz * dx + pos1.getX(), (((double) z) - pos1.getZ()) / dz * dy + pos1.getY(), z), block.getDefaultState());
           }
       }


   }
   public static boolean same (BlockPos pos1, BlockPos pos2) {
       if (((pos1.getX() - pos2.getX()) ^ 2 + (pos1.getY() - pos2.getY()) ^ 2 + (pos1.getZ() - pos2.getZ()) ^ 2) < 1) {
           return true;
       } else {
           return false;
       }
   }
}
