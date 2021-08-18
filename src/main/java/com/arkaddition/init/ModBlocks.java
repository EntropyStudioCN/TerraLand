package com.arkaddition.init;

import com.arkaddition.blocks.OreDifferentIRON;
import com.arkaddition.blocks.SourceStoneCore;
import com.arkaddition.creativetab.TabArkAddition3Block0;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

import com.arkaddition.blocks.BlockBase;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block TORNADOO_SANDSTORM = new BlockBase("tornadoo_sandstrom", Material.IRON, TabArkAddition3Block0.TABARKADDITION3BLOCK0,0,1,-1.0f,SoundType.SAND,-1.0f);
    public static final Block TORNADOO = new BlockBase("tornadoo", Material.IRON, TabArkAddition3Block0.TABARKADDITION3BLOCK0 ,0,1,-1.0f,SoundType.SAND,-1.0f);

    public static final Block OREDIFFERENTIRON = new OreDifferentIRON("oredifferentiron",Material.IRON, TabArkAddition3Block0.TABARKADDITION3BLOCK0,0,0,5.0F,SoundType.STONE,300.0f);

    public static final Block SOURCESTONECORE = new SourceStoneCore();
    public static final Block SOURCESTONEOUT = new BlockBase("soucestoneout",Material.GLASS, TabArkAddition3Block0.TABARKADDITION3BLOCK0,0,0,80.0f, SoundType.STONE,-1.0f);

}


