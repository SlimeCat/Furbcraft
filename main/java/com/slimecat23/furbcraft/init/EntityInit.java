package com.slimecat23.furbcraft.init;

import com.google.common.collect.Iterators;
import com.slimecat23.furbcraft.Main;
import com.slimecat23.furbcraft.entity.EntityFurby;
import com.slimecat23.furbcraft.entity.EntityFurbyRare;
import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import scala.actors.threadpool.Arrays;

public class EntityInit 
	{//VARIABLES
	//static Biome[] all_biomes= (Biome[]) ForgeRegistries.BIOMES.getValuesCollection().toArray();
	static Biome[] TERRA= new Biome[] {Biomes.BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.COLD_BEACH, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.HELL, Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS, Biomes.MESA, Biomes.MESA_ROCK, Biomes.MUSHROOM_ISLAND, Biomes.PLAINS, Biomes.REDWOOD_TAIGA, Biomes.REDWOOD_TAIGA_HILLS, Biomes.ROOFED_FOREST, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.STONE_BEACH, Biomes.TAIGA, Biomes.TAIGA_HILLS};
	
	
	//METHODS
	public static void registerEntities()
		{registerEntity("furby", EntityFurby.class, Reference.ENTITY_FURBY, 50, 0xffffff, 0x000000, TERRA, EnumCreatureType.CREATURE, 20, 2, 4);
		registerEntity("rare_furby", EntityFurbyRare.class, Reference.ENTITY_FURBY_RARE, 50, 0x7777ff, 0xffaa77, new Biome[] {Biomes.ROOFED_FOREST}, EnumCreatureType.CREATURE, 1, 1, 1);
		}
	
	private static void registerEntity(String _name, Class<? extends EntityLiving> _entity, int _id, int _range, int _color1, int _color2, Biome[] _biomes, EnumCreatureType _type, int _chance, int _min, int _max)
		{EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + _name), _entity, _name, _id, Main.instance, _range, 1, true, _color1, _color2);
		EntityRegistry.addSpawn(_entity, _chance, _min, _max, _type, _biomes);
		}
	}
