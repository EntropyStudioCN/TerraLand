package com.arkaddition.init;


import java.util.ArrayList;
import java.util.List;

import com.arkaddition.items.*;


import com.arkaddition.Main;

import com.arkaddition.creativetab.TabArkAddition1;

import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;


public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	
	
	
	
	

//auto Tab1
	public static final Item ALCOHOL_REVERSE = new ItemBase("alcohol_reverse", null);
	public static final Item ALCOHOL_WHITE_HORSE = new ItemBase("alcohol_white_horse", null);
	public static final Item BIPOLAR_NANOSHEET = new ItemBase("bipolar_nanosheet", null);
	public static final Item CRYSTAL_CIRCUIT = new ItemBase("crystal_circuit", null);
	public static final Item CRYSTAL_ELECTRONIC_UNIT = new ItemBase("crystal_electronic_unit", null);
	public static final Item CRYSTAL_ELEMENT = new ItemBase("crystal_element", null);
	public static final Item DEVICE = new ItemBase("device", null);
	public static final Item DEVICE_BROKEN = new ItemBase("device_broken", null);
	public static final Item DEVICE_CHANGE = new ItemBase("device_change", null);
	public static final Item DEVICE_NEW = new ItemBase("device_new", null);
	public static final Item GEL = new ItemBase("gel", null);
	public static final Item GEL_POLYMER = new ItemBase("gel_polymer", null);
	public static final Item GRINDING_STONE = new ItemBase("grinding_stone", null);
	public static final Item GRINDING_STONE_5WATER = new ItemBase("grinding_stone_5water", null);
	public static final Item HETEROIRON_BLOCK = new ItemBase("heteroiron_block", null);
	public static final Item HETEROIRON_FRAGMENTS = new ItemBase("heteroiron_fragments", null);
	public static final Item HETEROIRON_GROUP = new ItemBase("heteroiron_group", null);
	public static final Item HETEROIRON_IRON = new ItemBase("heteroiron_iron", null);
	public static final Item INCANDESCENT_ALLOY = new ItemBase("incandescent_alloy", null);
	public static final Item INCANDESCENT_ALLOY_BLOCK = new ItemBase("incandescent_alloy_block", null);
	public static final Item KETONE_AGGLUTINATION_GROUP = new ItemBase("ketone_agglutination_group", null);
	public static final Item KETONE_AGGLUTINATION = new ItemBase("ketone_agglutination", null);
	public static final Item KETONE_ARRAY = new ItemBase("ketone_array", null);
	public static final Item KETONE_DUAL = new ItemBase("ketone_dual", null);
	public static final Item MANGANESE_ORE = new ItemBase("manganese_ore", null);
	public static final Item MANGANESE_ORE_LIGHT = new ItemBase("manganese_ore_light", null);
	public static final Item POLYESTER = new ItemBase("polyester", null);
	public static final Item POLYESTER_BLOCK = new ItemBase("polyester_block", null);
	public static final Item POLYESTER_GROUP = new ItemBase("polyester_group", null);
	public static final Item POLYMERIZING_AGENT = new ItemBase("polymerizing_agent", null);
	public static final Item POLYSTER_MATERIAL = new ItemBase("polyster_material", null);
	public static final Item RMA70_24 = new ItemBase("rma70_24", null);
	public static final Item RMA70_12 = new ItemBase("rma70_12", null);
	public static final Item SOURCE_ROCK  = new ItemBase("source_rock ", null);
	public static final Item SOURCE_ROCK_PURE = new ItemBase("source_rock_pure", null);
	public static final Item SOURCE_ROCK_SOLID = new ItemBase("source_rock_solid", null);
	public static final Item SOURCE_ROCK_SOLID_GROUP = new ItemBase("source_rock_solid_group", null);
	public static final Item STEEL_D32 = new ItemBase("steel_d32", null);
	public static final Item SUGAR_AGGLOMERATES = new ItemBase("sugar_agglomerates", null);
	public static final Item SUGAR_ARK = new ItemBase("sugar_ark", null);
	public static final Item SUGAR_GROUP = new ItemBase("sugar_group", null);
	public static final Item SUGAR_SUBSTITUTE = new ItemBase("sugar_substitute", null);        
//auto Tab2
    public static final Item FURNITURE_PARTS = new ItemBase2("furniture_parts", null);
    public static final Item LOONG_DOOR_COIN = new ItemBase2("loong_door_coin", null);
    public static final Item PURE_GOLD = new ItemBase2("pure_gold", null);
    public static final Item SOURCE_JADE = new ItemBase2("source_jade", null);
    public static final Item SOURCE_JADE_FRAGMENT = new ItemBase2("source_jade_fragment", null);
    public static final Item SYNTHETIC_JADE = new ItemBase2("synthetic_jade", null);
//auto Tab1(3)
	// amount, saturation, iswolfFood
    public static final Item BAKLAVA = new FoodBase0("baklava", 5, 2,false,TabArkAddition1.TABARKADDITION1);
    public static final Item BEAUTIFUL_MUSHROOM = new ItemBase3("beautiful_mushroom", null);
    public static final Item DEHYDRATED_CACTUS = new FoodBase0("dehydrated_cactus", 4,6,false,TabArkAddition1.TABARKADDITION1);

    public static final ItemFood GAINT_HOOF_ENERGY_DRINK = new EffectDrinkBase("gaint_hoof_energy_drink", 0, 4, false, TabArkAddition1.TABARKADDITION1,
            new PotionEffect(MobEffects.NIGHT_VISION, 90 * 20, 0, false, true),
            new PotionEffect(MobEffects.SPEED, 90 * 20, 2, false, true),
            new PotionEffect(MobEffects.STRENGTH, 90 * 20, 2, false, true),
            new PotionEffect(null,0,0,false,false),
            new PotionEffect(null,0,0,false,false));





    public static final Item KETTLE = new ItemBase3("kettle", null);
    public static final Item MOTHERS_CHILL = new ItemBase3("mothers_chill", null);
    public static final Item PETERHEIM_HONEY_BISCUITS = new FoodBase0("peterheim_honey_biscuits", 3,4,false,TabArkAddition1.TABARKADDITION1);
    public static final Item QUANTUM_FIREWORKS = new ItemBase3("quantum_fireworks", null);
    public static final Item SALTED_EGG_YOLK_CHOCOLATE = new FoodBase0("salted_egg_yolk_chocolate", 3, 4,false,TabArkAddition1.TABARKADDITION1);
    public static final Item TWO_BURGER_SET = new FoodBase0("two_burger_set", 22,10,false,TabArkAddition1.TABARKADDITION1);

    
}

