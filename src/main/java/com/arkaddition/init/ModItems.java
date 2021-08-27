package com.arkaddition.init;


import com.arkaddition.creativetab.ArkItemGroups;
import com.arkaddition.items.EffectDrinkBase;
import com.arkaddition.items.FoodBase;
import com.arkaddition.items.ItemBase;
import com.arkaddition.items.tool.axe.AxeBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;


public class ModItems {
    @Nonnull
    public static final List<Item> ITEMS = new LinkedList<>();
    /**
     * ToolMaterial
     * //static final ToolMaterial MATERIAL_OBSIDIAN =EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
     * static final ToolMaterial MATERIAL_OBSIDIAN =EnumHelper.addToolMaterial("material_tool", 4, 2670, 15.0F, 3.0F, 40);
     */
    static final Item.ToolMaterial MATERIAL_DI = EnumHelper.addToolMaterial ("different_iron",5,2160,15f,10,40);

    //Materials
    public static final Item ALCOHOL_REVERSE = materials(new ItemBase("alcohol_reverse"));
    public static final Item ALCOHOL_WHITE_HORSE = materials(new ItemBase("alcohol_white_horse"));
    public static final Item BIPOLAR_NANOSHEET = materials(new ItemBase("bipolar_nanosheet"));
    public static final Item CRYSTAL_CIRCUIT = materials(new ItemBase("crystal_circuit"));
    public static final Item CRYSTAL_ELECTRONIC_UNIT = materials(new ItemBase("crystal_electronic_unit"));
    public static final Item CRYSTAL_ELEMENT = materials(new ItemBase("crystal_element"));
    public static final Item DEVICE = materials(new ItemBase("device"));
    public static final Item DEVICE_BROKEN = materials(new ItemBase("device_broken"));
    public static final Item DEVICE_CHANGE = materials(new ItemBase("device_change"));
    public static final Item DEVICE_NEW = materials(new ItemBase("device_new"));
    public static final Item GEL = materials(new ItemBase("gel"));
    public static final Item GEL_POLYMER = materials(new ItemBase("gel_polymer"));
    public static final Item GRINDING_STONE = materials(new ItemBase("grinding_stone"));
    public static final Item GRINDING_STONE_5WATER = materials(new ItemBase("grinding_stone_5water"));
    public static final Item HETEROIRON_BLOCK = materials(new ItemBase("heteroiron_block"));
    public static final Item HETEROIRON_FRAGMENTS = materials(new ItemBase("heteroiron_fragments"));
    public static final Item HETEROIRON_GROUP = materials(new ItemBase("heteroiron_group"));
    public static final Item HETEROIRON_IRON = materials(new ItemBase("heteroiron_iron"));
    public static final Item INCANDESCENT_ALLOY = materials(new ItemBase("incandescent_alloy"));
    public static final Item INCANDESCENT_ALLOY_BLOCK = materials(new ItemBase("incandescent_alloy_block"));
    public static final Item KETONE_AGGLUTINATION_GROUP = materials(new ItemBase("ketone_agglutination_group"));
    public static final Item KETONE_AGGLUTINATION = materials(new ItemBase("ketone_agglutination"));
    public static final Item KETONE_ARRAY = materials(new ItemBase("ketone_array"));
    public static final Item KETONE_DUAL = materials(new ItemBase("ketone_dual"));
    public static final Item MANGANESE_ORE = materials(new ItemBase("manganese_ore"));
    public static final Item MANGANESE_ORE_LIGHT = materials(new ItemBase("manganese_ore_light"));
    public static final Item POLYESTER = materials(new ItemBase("polyester"));
    public static final Item POLYESTER_BLOCK = materials(new ItemBase("polyester_block"));
    public static final Item POLYESTER_GROUP = materials(new ItemBase("polyester_group"));
    public static final Item POLYMERIZING_AGENT = materials(new ItemBase("polymerizing_agent"));
    public static final Item POLYSTER_MATERIAL = materials(new ItemBase("polyster_material"));
    public static final Item RMA70_24 = materials(new ItemBase("rma70_24"));
    public static final Item RMA70_12 = materials(new ItemBase("rma70_12"));
    public static final Item SOURCE_ROCK = materials(new ItemBase("source_rock "));
    public static final Item SOURCE_ROCK_PURE = materials(new ItemBase("source_rock_pure"));
    public static final Item SOURCE_ROCK_SOLID = materials(new ItemBase("source_rock_solid"));
    public static final Item SOURCE_ROCK_SOLID_GROUP = materials(new ItemBase("source_rock_solid_group"));
    public static final Item STEEL_D32 = materials(new ItemBase("steel_d32"));
    public static final Item SUGAR_AGGLOMERATES = materials(new ItemBase("sugar_agglomerates"));
    public static final Item SUGAR_ARK = materials(new ItemBase("sugar_ark"));
    public static final Item SUGAR_GROUP = materials(new ItemBase("sugar_group"));
    public static final Item SUGAR_SUBSTITUTE = materials(new ItemBase("sugar_substitute"));
    public static final Item PETERHEIM_HONEY_BISCUITS = materials(new FoodBase("peterheim_honey_biscuits", 3, 4, false));
    public static final Item BAKLAVA = materials(new FoodBase("baklava", 5, 2, false));
    public static final Item DEHYDRATED_CACTUS = materials(new FoodBase("dehydrated_cactus", 4, 6, false));

    public static final ItemFood GAINT_HOOF_ENERGY_DRINK = materials(new EffectDrinkBase("gaint_hoof_energy_drink", 0, 4, false,
            new PotionEffect(MobEffects.NIGHT_VISION, 90 * 20, 0, false, true),
            new PotionEffect(MobEffects.SPEED, 90 * 20, 2, false, true),
            new PotionEffect(MobEffects.STRENGTH, 90 * 20, 2, false, true)));

    public static final Item SALTED_EGG_YOLK_CHOCOLATE = materials(new FoodBase("salted_egg_yolk_chocolate", 3, 4, false));
    public static final Item TWO_BURGER_SET = materials(new FoodBase("two_burger_set", 22, 10, false));

    //Exchanges
    public static final Item FURNITURE_PARTS = exchanges(new ItemBase("furniture_parts"));
    public static final Item LOONG_DOOR_COIN = exchanges(new ItemBase("loong_door_coin"));
    public static final Item PURE_GOLD = exchanges(new ItemBase("pure_gold"));
    public static final Item SOURCE_JADE = exchanges(new ItemBase("source_jade"));
    public static final Item SOURCE_JADE_FRAGMENT = exchanges(new ItemBase("source_jade_fragment"));
    public static final Item SYNTHETIC_JADE = exchanges(new ItemBase("synthetic_jade"));

    //Others
    public static final Item BEAUTIFUL_MUSHROOM = others(new ItemBase("beautiful_mushroom"));
    public static final Item KETTLE = others(new ItemBase("kettle"));
    public static final Item MOTHERS_CHILL = others(new ItemBase("mothers_chill"));
    public static final Item QUANTUM_FIREWORKS = others(new ItemBase("quantum_fireworks"));

    //axe
    public static final Item DIFFERENT_IRON_AXE = tool(new AxeBase ("different_iron_axe",MATERIAL_DI,12f,8f));


    @Nonnull
    private static <T extends Item> T materials(@Nonnull T item) {
        return with(item, ArkItemGroups.Materials);
    }

    @Nonnull
    private static <T extends Item> T exchanges(@Nonnull T item) {
        return with(item, ArkItemGroups.Exchanges);
    }

    @Nonnull
    private static <T extends Item> T others(@Nonnull T item) {
        return with(item, ArkItemGroups.Others);
    }

    @Nonnull
    private static <T extends Item> T tool(@Nonnull T item) {
        return  with (item, ArkItemGroups.Tool);
    }

    @Nonnull
    private static <T extends Item> T with(@Nonnull T item, @Nonnull CreativeTabs creativeTabs) {
        item.setCreativeTab(creativeTabs);
        return item;
    }

    //-------------------------------------------------------------------
    //At the bottom of all codes on this page, it's an initialization of the icon of every item group.
    //And DO NOT add any code about item register after this LINE.
    static {
        ArkItemGroups.Materials.setIcon(new ItemStack(INCANDESCENT_ALLOY_BLOCK));
        ArkItemGroups.Exchanges.setIcon(new ItemStack(BAKLAVA));
        ArkItemGroups.Others.setIcon(new ItemStack(SOURCE_JADE));
        ArkItemGroups.Tool.setIcon (new ItemStack (DIFFERENT_IRON_AXE));
    }
}

