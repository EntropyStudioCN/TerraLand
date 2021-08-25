package com.arkaddition.init;

import com.arkaddition.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();


    public static final Block TORNADOO_SANDSTORM = new BlockBase("tornadoo_sandstrom", Material.GLASS,SoundType.SAND,-1f,"pickaxe",-1);
    public static final Block TORNADOO = new BlockBase("tornadoo", Material.GLASS,SoundType.SAND,-1f,"pickaxe",-1);
//ores
    public static final Block TIN_ORE = new OreCu ("tin_ore",Material.IRON,SoundType.STONE,4.0F,2,"pickaxe");
    public static final Block SILVER_ORE = new OreCu ("silver_ore",Material.IRON,SoundType.STONE,4.0F,2,"pickaxe");

    public static final Block LEAD_ORE = new OreCu ("lead_ore",Material.IRON,SoundType.STONE,3.0F,2,"pickaxe");
    public static final Block MANGANESE_ORE = new OreCu ("manganese_ore",Material.IRON,SoundType.STONE,8.0F,3,"pickaxe");


    public static final Block ORECU = new OreCu ("orecu",Material.IRON,SoundType.STONE,5.0f,2,"pickaxe");
    public static final Block OREDIFFERENTIRON = new OreDifferentIRON("oredifferentiron",Material.IRON,SoundType.STONE,15.0f,3,"pickaxe");
//structure
    public static final Block SOURCESTONECORE = new SourceStoneCore();
    public static final Block SOURCESTONEOUT = new transparentBase ("soucestoneout",Material.GLASS,SoundType.STONE,80.0f,"pickaxe",1);

    public static final Block ORIROCK = new BlockBase ("orirock",Material.IRON,SoundType.STONE,3.0f,"pickaxe",1);


}


