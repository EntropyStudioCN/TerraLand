package com.arkaddition.entity;

import com.arkaddition.Main;
import com.arkaddition.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	//��������Ϣ����ע��
    public static void registerEntities(){
                    //�������ƣ�����д�������࣬��Reference�е����ƣ�׷�ٷ�Χ�����ﵰ��ɫ1����ɫ2  
        //registerEntity("ra3", EntityRA3.class, Reference.xxx, 20, 14833957, 0);
    }   


    public static void registerEntity(String name, Class<? extends Entity> entity, int id, int range,int color1,int color2) {

        EntityRegistry.registerModEntity(new ResourceLocation(Reference.Mod_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);

    }

}
