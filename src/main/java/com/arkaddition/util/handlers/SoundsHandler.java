package com.arkaddition.util.handlers;

import com.arkaddition.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

    //����Ҫ�������õ������¼�

	public static SoundEvent PINESHOOT;
	//ENTITY_RA3_AMBIENT,ENTITY_RA3_HURT,ENTITY_RA3_DEATH


	//ע�������¼�

	public static void registerSounds() {
		
		PINESHOOT = registerSound("guns.pineshoot");

		//ENTITY_RA3_AMBIENT = registerSound("entity.ra3.ambient");

	}


	private static SoundEvent registerSound(String name) {

		ResourceLocation location = new ResourceLocation(Reference.Mod_ID, name);

		SoundEvent event = new SoundEvent(location);

		event.setRegistryName(name);

		ForgeRegistries.SOUND_EVENTS.register(event);

		return event;

	}

}
