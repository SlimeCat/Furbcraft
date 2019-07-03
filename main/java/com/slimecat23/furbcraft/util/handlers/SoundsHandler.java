package com.slimecat23.furbcraft.util.handlers;

import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler 
	{//VARIABLES
	public static SoundEvent ENTITY_FURBY_AMBIENT;
	public static SoundEvent ENTITY_FURBY_HURT;
	public static SoundEvent ENTITY_FURBY_DEATH;
	
	
	//METHODS
	public static void registerSounds()
		{ENTITY_FURBY_AMBIENT= registerSound("entity.furby.ambient");
		ENTITY_FURBY_DEATH= registerSound("entity.furby.death");
		ENTITY_FURBY_HURT= registerSound("entity.furby.hurt");
		}
	
	private static SoundEvent registerSound(String _name)
		{ResourceLocation location= new ResourceLocation(Reference.MOD_ID, _name);
		SoundEvent event= new SoundEvent(location);
		event.setRegistryName(_name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
		}
	}
