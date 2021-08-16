package com.arkaddition.event;

import com.arkaddition.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class ArkEventHandler {

    public static int timerDis = 0;
    public static int timerDisWait = 0;
    public static int tickerDis = 0;
    public static BlockPos posMin;
    public static EntityPlayer player;
    public static BlockPos meteoCore;
    public static int metetoMove[] = new int[3];
    public static boolean stonegrow = false;
    public  static BlockPos stone ;
    public static int stoneMove[] = new int[3];
    public static int stoneSize = 3;
    public static int stoneLeng = 0;
    public  static BlockPos earthquake;
    public static int eatrthMove[] = {1, -3};
    public  static int earthMoved = 1;

    public static BlockPos wind;

    public static boolean sand =  false;
    public static BlockPos sandstate;

    public static BlockPos water;

    public static double sandTowx;
    public static double sandTowz;

        @SubscribeEvent
        public static void onTicker(TickEvent.ClientTickEvent event) {}
        @SubscribeEvent
        public static void onTick(ServerTickEvent event) {
    try {
        tickerDis++;
        if (timerDis <= 0) {
            if (new Random().nextInt(1919810) == 2 && player != null) {
                player.sendMessage(new TextComponentTranslation("message.arkitems.disaster.wait"));
                timerDisWait = 6000 + new Random().nextInt(6000);
                timerDis = new Random().nextInt(12000) + 6000;//天灾开启
                posMin = new BlockPos(player.posX - 50, 0, player.posZ - 50);
            }
        } else {//天灾时
            if (timerDisWait > 0) {
                timerDisWait--;
            } else {
                timerDis--;
                /*if (meteoCore == null) {//````````````````````````陨石
                    if (new Random().nextInt(200) == 0) {
                        meteoCore = posMin.add(new Random().nextInt(100), 250, new Random().nextInt(100));
                        EntityMeteo ball = new EntityMeteo(player.world, player);
                        ball.shoot(player, player.rotationPitch, player.prevRotationYaw, 0.0F, 0.0F, 0.0F);
                        player.world.spawnEntity(ball);
                        ball.setPosition(meteoCore.getX(), meteoCore.getY(), meteoCore.getZ());
                    }
                }*/
                //地裂
                if (earthquake != null && new Random().nextInt(20) == 6) {
                    earthquake = earthquake.add(new Random().nextInt(3) + earthMoved, 0,
                            new Random().nextInt(3) + earthMoved);
                    int size = new Random().nextInt(3) + 1;
                    for (int i = -size; i < size; i++) {
                        for (int j = -size; j < size; j++) {
                            for (int k = 2; k < 255; k++) {
                                Block bl = player.world.getBlockState(earthquake.add(i, k, j)).getBlock();
                                if (i + j <= 1) {
                                    player.world.setBlockState(earthquake.add(i, k, j), Blocks.AIR.getDefaultState());
                                } else if (i + j > 1 && new Random().nextInt(i + j) == 0) {
                                    player.world.setBlockState(earthquake.add(i, k, j), Blocks.AIR.getDefaultState());
                                }
                                if (bl != Blocks.AIR && !stonegrow) {
                                    if (new Random().nextInt(500) == 8) {
                                        player.world.createExplosion(null, earthquake.add(i, k, j).getX(), earthquake.add(i, k, j).getY(),
                                                earthquake.add(i, k, j).getZ(), new Random().nextInt(10) + 1, true);
                                        player.world.setBlockState(earthquake.add(i, k, j), Blocks.COAL_BLOCK.getDefaultState());
                                        if (new Random().nextInt(20) == 9) {
                                            player.world.setBlockState(earthquake.add(i, k, j), Blocks.DIAMOND_BLOCK.getDefaultState());
                                        }
                                        stonegrow = true;
                                        stone = earthquake.add(i, k, j);
                                        stoneSize = 3;
                                        stoneLeng = 0;
                                        stoneMove[0] = new Random().nextInt(2);
                                        stoneMove[1] = new Random().nextInt(2);
                                        stoneMove[2] = new Random().nextInt(2);
                                    }
                                }
                            }
                        }
                    }
                    if (new Random().nextInt(100) == 8) {
                        earthquake = null;
                    }
                } else {
                    if (new Random().nextInt(600) == 1) {
                        earthquake = posMin.add(new Random().nextInt(100), 2, new Random().nextInt(100));
                        earthMoved = eatrthMove[new Random().nextInt(2)];
                    }
                }

                //源石(并在陨石和地裂里罢)

                if (stonegrow && (stone != null)) {
                    player.world.setBlockState(stone, ModBlocks.TORNADOO.getDefaultState());
                    stoneLeng++;
                    stoneSize -= new Random().nextInt(2);
                    if (stoneSize <= 0) {
                        stonegrow = false;
                        stoneSize = 1;
                    }
                    for (int i = -stoneSize; i < stoneSize; i++) {
                        for (int j = -stoneSize; j < stoneSize; j++) {
                            int k = i * j;
                            if (new Random().nextInt(2) == 0) {
                                player.world.setBlockState(stone.add(i + stoneMove[0] * k, stoneLeng, j + stoneMove[2] * k), ModBlocks.TORNADOO.getDefaultState());
                                player.world.setBlockState(stone.add(stoneLeng, i + stoneMove[1] * k, j + stoneMove[2] * k), ModBlocks.TORNADOO.getDefaultState());
                                player.world.setBlockState(stone.add(-stoneLeng, i + stoneMove[1] * k, j + stoneMove[2] * k), ModBlocks.TORNADOO.getDefaultState());
                                player.world.setBlockState(stone.add(i + stoneMove[0] * k, j + stoneMove[1] * k, stoneLeng), ModBlocks.TORNADOO.getDefaultState());
                                player.world.setBlockState(stone.add(i + stoneMove[0] * k, j + stoneMove[1] * k, stoneLeng), ModBlocks.TORNADOO.getDefaultState());
                            }
                        }
                    }
                }
                //生物(并在出生事件以及风里)
                //闪电
                int y = new Random().nextInt(255);
                BlockPos lig = new BlockPos(posMin.getX() + new Random().nextInt(100), y, posMin.getZ() + new Random().nextInt(100));
                Block blc = player.world.getBlockState(lig.up()).getBlock();
                Block blc1 = player.world.getBlockState(lig.west()).getBlock();
                Block blc2 = player.world.getBlockState(lig.east()).getBlock();
                Block blc3 = player.world.getBlockState(lig.north()).getBlock();
                Block blc4 = player.world.getBlockState(lig.south()).getBlock();
                if (player.world.getBlockState(lig).getBlock() != Blocks.AIR && (blc == Blocks.AIR || blc1 == Blocks.AIR
                        || blc2 == Blocks.AIR || blc3 == Blocks.AIR || blc4 == Blocks.AIR) && new Random().nextInt(5) == 0) {
                    EntityLightningBolt light = new EntityLightningBolt(player.world, lig.getX(), lig.getY(), lig.getZ(), false);
                    player.world.addWeatherEffect(light);
                    if (new Random().nextInt(10) == 0) {
                        stonegrow = true;
                        stone = lig;
                        stoneSize = 3;
                        stoneLeng = 0;
                        stoneMove[0] = new Random().nextInt(2);
                        stoneMove[1] = new Random().nextInt(2);
                        stoneMove[2] = new Random().nextInt(2);
                    }
                }
                //风:沙尘暴、龙卷

                //沙尘暴
                if (sand) {
                    BlockPos pos1 = posMin.add(0, 0, 0);
                    BlockPos pos2 = posMin.add(100, 250, 100);
                    List<Entity> tar = player.getEntityWorld().getEntitiesWithinAABBExcludingEntity(player,
                            new AxisAlignedBB(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(),
                                    pos2.getZ()));
                    for (int i = 0; i < tar.size(); i++) {
                        tar.get(i).attackEntityFrom(new DamageSource("generic"), 0.01f);
                        tar.get(i).addVelocity(sandTowx, 0, sandTowz);
                    }
                    if (timerDis == 100) {
                        sand = false;
                    }
                    if (new Random().nextInt(600) == 29) {
                        sandstate = posMin.add(new Random().nextInt(100),  0, new Random().nextInt(100));
                        for (int i = 0; i < 250; i ++) {
                            if (player.world.getBlockState(sandstate.add(0, i, 0)).getBlock() != Blocks.AIR) {
                                sandstate = sandstate.add(0, i, 0);
                                break;
                            }
                        }
                    }
                }
                if (!sand && timerDis > 200) {
                    sand = true;
                    sandTowx = (double) (new Random().nextInt(6) - 3) / 100;
                    sandTowz = (double) (new Random().nextInt(6) - 3) / 100;
                }
                if (sandstate != null) {
                    player.world.setBlockState(sandstate, Blocks.SAND.getDefaultState());
                    player.world.setBlockState(sandstate.up(), Blocks.SAND.getDefaultState());
                    player.world.setBlockState(sandstate.west(), Blocks.SAND.getDefaultState());
                    player.world.setBlockState(sandstate.east(), Blocks.SAND.getDefaultState());
                    player.world.setBlockState(sandstate.north(), Blocks.SAND.getDefaultState());
                    player.world.setBlockState(sandstate.south(), Blocks.SAND.getDefaultState());
                }
                //水,雨
            }
        }
    } catch (Exception e) {
        System.out.println(000);
    }

}
    @SubscribeEvent
    public static void onLeft2(BreakEvent event) {
        player = event.getPlayer();
        if (player.world.getBlockState(event.getPos()).getBlock() == Blocks.OBSIDIAN) {
            //if (player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Items.ARROW)) {
                timerDis = 12000;
                timerDisWait = 0;
                posMin = new BlockPos(player.posX - 50, 0, player.posZ - 50);
            //}
        }
    }


    @SubscribeEvent
    public void onr(TickEvent.PlayerTickEvent event) {
            if (sand) {
                EntityPlayer pl = event.player;
                pl.addVelocity(sandTowx, 0, sandTowz);
                for (int i = 0; i < 10; i ++) {
                    pl.world.spawnParticle(EnumParticleTypes.WATER_DROP, pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getX(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getY(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getZ(), sandTowx * 100, 0, sandTowz * 100);
                    pl.world.spawnParticle(EnumParticleTypes.CLOUD, pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getX(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getY(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getZ(), sandTowx * 100, 0, sandTowz * 100);
                    pl.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getX(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getY(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getZ(), sandTowx * 100, 0, sandTowz * 100);
                    pl.world.spawnParticle(EnumParticleTypes.WATER_WAKE, pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getX(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getY(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getZ(), sandTowx * 100, 0, sandTowz * 100);
                    pl.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getX(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getY(), pl.getPosition().add(new Random().nextInt(20) - 10, new Random().nextInt(20) - 10, new Random().nextInt(20) - 10).getZ(), sandTowx * 100, 0, sandTowz * 100);
                }
            }
    }


}
