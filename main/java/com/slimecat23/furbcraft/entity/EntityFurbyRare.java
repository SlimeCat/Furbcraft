package com.slimecat23.furbcraft.entity;

import com.slimecat23.furbcraft.entity.render.RenderFurby;

import net.minecraft.init.Biomes;
import net.minecraft.world.World;

public class EntityFurbyRare extends EntityFurby
	{public EntityFurbyRare(World _world) 
		{super(_world);
		spawn_biome= Biomes.ROOFED_FOREST;
		skin= RenderFurby.KC;
		saveData();
		loadData();
		} 
	}
