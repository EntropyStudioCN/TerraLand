package com.arkaddition.init;

import com.arkaddition.entity.SourceStoneBugEntity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ModSpawn {
    /** Register Mobs based on Biome sub Types */
    public static void registerSpawnList()
    {
        Map<Type, Set<Biome>> biomeMap = buildBiomeListByType() ;
        addNormalSpawn(biomeMap);
        addHumidSpawn(biomeMap);
        addOpenGroundSpawn(biomeMap);
    }

    //Mob 添加生物生成信息
    public static void add(Biome biome, int weight, Class<? extends EntityLiving> entityclassIn, int groupCountMin, int groupCountMax) {
        if (weight > 0){
            biome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(entityclassIn, weight, groupCountMin, groupCountMax));
        }
    }

    //构建模组中生物生成的信息表
    private static Map<Type,Set<Biome>> buildBiomeListByType() {
        Map<Type,Set<Biome>> biomesAndTypes = new HashMap<>();

        for (Biome biome: Biome.REGISTRY) {
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);

            for (BiomeDictionary.Type type : types) {
                if (!biomesAndTypes.containsKey(type)) {
                    biomesAndTypes.put(type,new HashSet<>());
                }

                biomesAndTypes.get(type).add(biome);
            }
        }
        return biomesAndTypes;
    }

    //添加生物生成信息(最经常用)
    private static void addNormalSpawn(Map<Type, Set<Biome>> biomeMap) {
        for (Biome biome:Biome.REGISTRY) {
            //Example Spawn
            // add (biome,ModConfig. SPAWN_CONF.SPAWN_TAINTER,EntityMoroonTainter. class，1，4);
            //生物在什么地形上生成,生成相关配置(生成率，数值越大越好),生物.class文件, 一次生成最少数量,  最大数量
            add(biome, 8, SourceStoneBugEntity.class, 1, 4);
            //weight实际值调在(1~10)即可
        }
    }

    //在开放地块生成生物
    private static void addOpenGroundSpawn (Map<Type, Set<Biome>> biomeMap){
        for(Biome biome : Biome.REGISTRY) {
            //if (!BiomeDictionary.hasType(biome,Type. DENSE))
            //add (biome, ModConfig.SPAWN_CONF.SPAWN_SKELETON_TOWER,EntitySpawnTower.class,1，1);
        }
    }

    //在潮湿地块生成(一般不用)
    private static void addHumidSpawn (Map<Type,Set<Biome>>biomeMap) {
        for (Biome biome : Biome.REGISTRY){
            if(BiomeDictionary.hasType(biome, Type.WET) || (BiomeDictionary. hasType(biome, Type.WATER))) {
                //add (biome,ModConfig.SPAWN_CONF. SPAWN_TIDE_MAKER,EntityMoroonTideMaker.class,1，1);
            }
        }
    }

    public static void add(int weight, Class<? extends EntityLiving> entityclassIn, int groupCountMin, int groupCountMax, Biome biome) {
        if (weight > 0){
            biome.getSpawnableList(EnumCreatureType.MONSTER).add(new Biome.SpawnListEntry(entityclassIn, weight, groupCountMin, groupCountMax));
        }
    }

}
