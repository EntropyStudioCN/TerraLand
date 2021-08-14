package com.arkaddition.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Mod.EventBusSubscriber
public class S_stone {
    static BlockPos point;
    static BlockPos circle;
    static BlockPos point1;
    static BlockPos circle1;
    static BlockPos point2;
    static BlockPos circle2;
    static BlockPos point3;
    static BlockPos circle3;
    static BlockPos point4;
    static BlockPos circle4;
    static BlockPos point5;
    static BlockPos circle5;
    static BlockPos point6;
    static BlockPos circle6;
    static BlockPos point7;
    static BlockPos circle7;
    static BlockPos point8;
    static BlockPos circle8;
    static BlockPos point9;
    static BlockPos circle9;
    static EntityPlayer pl;
    static List<BlockPos> round = new ArrayList<>();
    static List<BlockPos> inner = new ArrayList<>();
    static List<BlockPos> round1 = new ArrayList<>();
    static List<BlockPos> inner1 = new ArrayList<>();
    static List<BlockPos> round2 = new ArrayList<>();
    static List<BlockPos> inner2 = new ArrayList<>();
    static List<BlockPos> round3 = new ArrayList<>();
    static List<BlockPos> inner3 = new ArrayList<>();
    static List<BlockPos> round4= new ArrayList<>();
    static List<BlockPos> inner4 = new ArrayList<>();
    static List<BlockPos> round5 = new ArrayList<>();
    static List<BlockPos> inner5 = new ArrayList<>();
    static List<BlockPos> round6 = new ArrayList<>();
    static List<BlockPos> inner6 = new ArrayList<>();
    static List<BlockPos> round7 = new ArrayList<>();
    static List<BlockPos> inner7 = new ArrayList<>();
    static List<BlockPos> round8 = new ArrayList<>();
    static List<BlockPos> inner8 = new ArrayList<>();
    static List<BlockPos> round9 = new ArrayList<>();
    static List<BlockPos> inner9 = new ArrayList<>();

    @SubscribeEvent
    public static void onright(PlayerInteractEvent.RightClickItem event) {if (round.size() > 0){
            for (int o = 0; o < round.size(); o++) {
                Methods.line(point, round.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point1, round1.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point2, round2.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point3, round3.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point4, round4.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point5, round5.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point6, round6.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point7, round7.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point8, round8.get(o), Blocks.GLASS, event.getWorld());
                Methods.line(point9, round9.get(o), Blocks.GLASS, event.getWorld());
                System.out.println(point.getY());
                System.out.println(point1.getY());
                System.out.println(point2.getY());
                System.out.println(point3.getY());
                System.out.println(point4.getY());
                System.out.println(point5.getY());
                System.out.println(point6.getY());
                System.out.println(point7.getY());
                System.out.println(point8.getY());
                System.out.println(point9.getY());
            }
        Methods.line(point, circle, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point1, circle1, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point2, circle2, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point3, circle3, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point4, circle4, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point5, circle5, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point6, circle6, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point7, circle7, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point8, circle8, Blocks.MAGMA, event.getEntity().world);
        Methods.line(point9, circle9, Blocks.MAGMA, event.getEntity().world);
    }
    }

   // @SubscribeEvent
    public static void onleft(BlockEvent.BreakEvent event) {
        round.clear();
        inner.clear();
        round1.clear();
        inner1.clear();
        round2.clear();
        inner2.clear();
        round3.clear();
        inner3.clear();
        round4.clear();
        inner4.clear();
        round5.clear();
        inner5.clear();
        round6.clear();
        inner6.clear();
        round7.clear();
        inner7.clear();
        round8.clear();
        inner8.clear();
        round9.clear();
        inner9.clear();
        circle = event.getPos();
        circle1 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle2 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle3 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle4 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle5 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle6 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle7 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle8 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        circle9 = circle.add(new Random().nextInt(20) - 10, 0, new Random().nextInt(20) - 10);
        point = circle.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point1 = circle1.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point2 = circle2.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point3 = circle3.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point4 = circle4.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point5 = circle5.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point6 = circle6.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point7 = circle7.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point8 = circle8.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        point9 = circle9.add(new Random().nextInt(120) - 60, new Random().nextInt(50) + 20, new Random().nextInt(120) - 60);
        for (double i = -20; i < 20; i += 1) {
                for (double j = -20; j < 20; j += 1) {
                    if (Math.abs((i * i + j * j)) < 256) {
                        event.getPlayer().world.setBlockState(circle.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                        round.add(circle.add(i, 0, j));
                    }
                }
            }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle1.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round1.add(circle1.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle2.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round2.add(circle2.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle3.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round3.add(circle3.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle4.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round4.add(circle4.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle5.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round5.add(circle5.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle6.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round6.add(circle6.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle7.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round7.add(circle7.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle8.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round8.add(circle8.add(i, 0, j));
                }
            }
        }
        for (double i = -20; i < 20; i += 1) {
            for (double j = -20; j < 20; j += 1) {
                if (Math.abs((i * i + j * j)) < 256) {
                    event.getPlayer().world.setBlockState(circle9.add(i, 0, j), Blocks.MAGMA.getDefaultState());
                    round9.add(circle9.add(i, 0, j));
                }
            }
        }
    }
}
