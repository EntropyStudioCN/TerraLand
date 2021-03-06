package com.arkaddition.world;

import com.arkaddition.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class GenOreArks implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.getDimension() == 0)
        {
            //generateOverworld(random,chunkX,chunkZ, world,chunkGenerator,chunkProvider);

        }

    }
    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        //Write U ores
        //generateOre(ModBlocks.OREDIFFERENTIRON.getDefaultState(),world,random,chunkX*16,chunkZ*16);
       //Different IRON
        generateOre(ModBlocks.OREDIFFERENTIRON.getDefaultState(),world,random,chunkX*16,chunkZ*16,1,50,random.nextInt(4)+2,random.nextInt(10)+5);

        //cu
        generateOre(ModBlocks.ORECU.getDefaultState(),world,random,chunkX*16,chunkZ*16,1,50,random.nextInt(8)+2,random.nextInt(35)+20);
        //xi
        generateOre(ModBlocks.TIN_ORE.getDefaultState(),world,random,chunkX*16,chunkZ*16,1,40,random.nextInt(8)+2,random.nextInt(35)+20);
        //ag
        generateOre(ModBlocks.LEAD_ORE.getDefaultState(),world,random,chunkX*24,chunkZ*24,1,30,random.nextInt(10)+1,random.nextInt(25)+15);

        //mn
        generateOre (ModBlocks.MANGANESE_ORE.getDefaultState(),world,random,chunkX*32,chunkZ*32,1,30,random.nextInt(5)+1,random.nextInt(15)+10);
        //lead
        generateOre(ModBlocks.LEAD_ORE.getDefaultState(),world,random,chunkX*24,chunkZ*24,1,40,random.nextInt(8)+1,random.nextInt(20)+15);
    }
    private void generateOre(IBlockState ore,World world,Random random,int x,int z,int minY,int maxY,int size,int chances)
    {
        int deltaY = maxY - minY;


        //generateRULE
        for (int i = 0; i < chances;i++)
        {
            BlockPos pos = new BlockPos(x+random.nextInt(16),minY+random.nextInt(deltaY),z+random.nextInt(16));


            WorldGenMinable generator = new WorldGenMinable(ore,size);
            generator.generate(world,random,pos);
        }


    }
}
