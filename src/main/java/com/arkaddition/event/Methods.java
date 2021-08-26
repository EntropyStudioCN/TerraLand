package com.arkaddition.event;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
@Deprecated
@Mod.EventBusSubscriber
public class Methods {
   public static void line (BlockPos pos1, BlockPos pos2, Block blc, World world) {
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
   public static boolean same (BlockPos pos1, BlockPos pos2) {
       if (((pos1.getX() - pos2.getX()) ^ 2 + (pos1.getY() - pos2.getY()) ^ 2 + (pos1.getZ() - pos2.getZ()) ^ 2) < 1) {
           return true;
       } else {
           return false;
       }
   }
}
