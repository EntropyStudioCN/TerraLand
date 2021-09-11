package com.arkaddition.event;

import javafx.util.Pair;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.collection.concurrent.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class S_stone {
    public static void genThorns(BlockPos pos, World world){
        BlockPos center = pos;
        List<Pair<BlockPos, BlockPos>> thorns = new ArrayList<>();
        for(int i = 0; i < 10; i++){ //先。。。生成十根？可以修改
            double dxBottom = new Random().nextInt(20) - 10;
            double dzBottom = new Random().nextInt(20) - 10;
            double k = dzBottom / dxBottom;
            double l = Math.sqrt(dxBottom * dxBottom + dzBottom * dzBottom);
            double cos = dxBottom / l;
            double sin = dzBottom / l;
            int side = k > 0 ? 1 : -1;
            BlockPos coreBottom = center.add(dxBottom, 0, dzBottom);
            double len = new Random().nextInt(20) + 65;
            double dyTop = new Random().nextInt((int) len - 25) + 25;
            double l2 = Math.sqrt(len * len - dyTop * dyTop);
            double dxTop = l2 * cos;
            double dzTop = l2 * sin;
            BlockPos coreTop = coreBottom.add(dxTop, dyTop, dzTop);
            // 尝试先生成源石刺的中心，然后让刺的生成方向尽可能远离底部中心；同时保证刺的长度不会太怪
            // 至于如何让倾斜度过大的刺不会太扁平，这需要计算锥截面的方程，当然也可以搞近似
            List<BlockPos> bottom = genBottom(coreBottom, world); //在该函数修改底面方程
            for(BlockPos pos1 : bottom) {
                Methods.line(pos1, coreTop, Blocks.GLASS, world); //从底面每个点拉一条直线去顶点，AG妙啊
            }
            coreTop.add(-2, -2 * dyTop / dxTop, -2 * k); //生成源石核心，这里的计划是拉一条锥体中轴线，并且不到顶上因为可能会突出去（由方块大小为1导致）
            thorns.add(new Pair<>(coreBottom, coreTop));          //而且由于后面生成的非核心可能会覆盖先生成的核心，所以保存核心的路径，之后再循环外生成
            Debug.log("Gen success");
        }
        for(Pair<BlockPos, BlockPos> thorn : thorns){
            Methods.line(thorn.getKey(), thorn.getValue(), Blocks.MAGMA, world);
            Debug.log("Gen Core");
        }
    }

    static List<BlockPos> genBottom(BlockPos point, World world){ //生成底部，参数数量和意义根据实际情况改
        List<BlockPos> bottom = new ArrayList<>();
        for (double i = -10; i < 10; i += 1) {
            for (double j = -10; j < 10; j += 1) {
                if (Math.abs((i * i + j * j)) < 100) {
                    world.setBlockState(point.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    bottom.add(point.add(i, 0, j));
                }
            }
        }
        return bottom;
    }
}
