package com.arkaddition.init;

import com.arkaddition.blocks.OreDifferentIRON;
import com.arkaddition.creativetab.TabArkAddition3Block0;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

import com.arkaddition.blocks.BlockBase;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block TORNADOO_SANDSTORM = new BlockBase("tornadoo_sandstrom", Material.IRON, TabArkAddition3Block0.TABARKADDITION3BLOCK0);
    public static final Block TORNADOO = new BlockBase("tornadoo", Material.IRON, TabArkAddition3Block0.TABARKADDITION3BLOCK0 );
    public static final Block OREDIFFERENTIRON = new OreDifferentIRON("oredifferentiron",Material.IRON, TabArkAddition3Block0.TABARKADDITION3BLOCK0);
}


