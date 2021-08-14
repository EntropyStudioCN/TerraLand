package com.arkaddition.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

import com.arkaddition.blocks.BlockBase;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block TORNADOO_SANDSTORM = new BlockBase("tornadoo_sandstrom", Material.IRON);
    public static final Block TORNADOO = new BlockBase("tornadoo", Material.IRON);
    //此处只能大写+下划线        该方块名称(小写+下划线)  方块的材料属性为铁方块(击打的音效，挖掘等级与铁块一致，可随意修改)
}


