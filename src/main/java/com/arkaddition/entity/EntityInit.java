package com.arkaddition.entity;

import com.arkaddition.Main;
import com.arkaddition.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities(){

        registerEntity("source_stone_bug", SourceStoneBugEntity.class, 114514, 20, 14833957, 0);

    }   


    public static void registerEntity(String name, Class<? extends Entity> entity, int id, int range,int color1,int color2) {

        EntityRegistry.registerModEntity(new ResourceLocation(Reference.Mod_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);

    }

}
