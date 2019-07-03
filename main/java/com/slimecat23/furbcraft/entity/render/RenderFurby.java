package com.slimecat23.furbcraft.entity.render;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.slimecat23.furbcraft.entity.EntityFurby;
import com.slimecat23.furbcraft.entity.model.ModelFurbyMane;
import com.slimecat23.furbcraft.entity.model.ModelFurbySkinless;
import com.slimecat23.furbcraft.entity.model.ModelFurbyTail;
import com.slimecat23.furbcraft.entity.render.layers.LayerFurbyEye;
import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.init.Biomes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderFurby extends RenderLiving<EntityFurby>
	{//VARIABLES
	public static final FurbyFactory FACTORY= new FurbyFactory();
		//furby skins
	public static final ResourceLocation SNOWBALL= new ResourceLocation(Reference.MOD_ID + ":textures/entity/snowball.png");
	public static final ResourceLocation CHURCH_MOUSE= new ResourceLocation(Reference.MOD_ID + ":textures/entity/church_mouse.png");
	public static final ResourceLocation WITCHES_CAT= new ResourceLocation(Reference.MOD_ID + ":textures/entity/witches_cat.png");
	public static final ResourceLocation SKUNK= new ResourceLocation(Reference.MOD_ID + ":textures/entity/skunk.png");
	public static final ResourceLocation WOLF= new ResourceLocation(Reference.MOD_ID + ":textures/entity/wolf.png");
	public static final ResourceLocation LEOPARD= new ResourceLocation(Reference.MOD_ID + ":textures/entity/leopard.png");
	public static final ResourceLocation KC= new ResourceLocation(Reference.MOD_ID + ":textures/entity/kc.png");
	public static final ResourceLocation SKINLESS= new ResourceLocation(Reference.MOD_ID + ":textures/entity/skinless.png");
		//furby models
	public static final ModelFurbyTail TAIL= new ModelFurbyTail();
	public static final ModelFurbyMane MANE= new ModelFurbyMane();
	public static final ModelFurbySkinless SKIN= new ModelFurbySkinless();
		//biome based skin selector
	public static final HashMap<Biome, ArrayList<ResourceLocation>> TEXTURES= new HashMap<Biome, ArrayList<ResourceLocation>>();
	public static final HashMap<ResourceLocation, ModelBase> MODELS= new HashMap<ResourceLocation, ModelBase>();
	public static final HashMap<ResourceLocation, EnumDyeColor> EYES= new HashMap<ResourceLocation, EnumDyeColor>();
	public ResourceLocation skin;
	
	
	//CONSTRUCTOR
	public RenderFurby(RenderManager _manager)
		{super(_manager, new ModelFurbyTail(), 0.5F);
		this.addLayer(new LayerFurbyEye(this));
		//model hash filling
		MODELS.put(SNOWBALL, TAIL);
		MODELS.put(LEOPARD, TAIL);
		MODELS.put(WITCHES_CAT, TAIL);
		MODELS.put(KC, MANE);
		MODELS.put(CHURCH_MOUSE, MANE);
		MODELS.put(SKUNK, MANE);
		MODELS.put(WOLF, MANE);
		MODELS.put(SKINLESS, SKIN);
		//eye hash filling
		EYES.put(SNOWBALL, EnumDyeColor.LIGHT_BLUE);
		EYES.put(LEOPARD, EnumDyeColor.BROWN);
		EYES.put(WITCHES_CAT, EnumDyeColor.GREEN);
		EYES.put(KC, EnumDyeColor.GRAY);
		EYES.put(CHURCH_MOUSE, EnumDyeColor.LIGHT_BLUE);
		EYES.put(SKUNK, EnumDyeColor.WHITE);
		EYES.put(WOLF, EnumDyeColor.GREEN);
		EYES.put(SKINLESS, EnumDyeColor.LIME);
		//biome hash filling
		ArrayList resources= new ArrayList<ResourceLocation>();
		//plains
		resources.add(SKUNK);
		resources.add(CHURCH_MOUSE);
		resources.add(WITCHES_CAT);
		TEXTURES.put(Biomes.PLAINS, resources);
		TEXTURES.put(Biomes.MUTATED_PLAINS, resources);
		//forest
		resources= new ArrayList<ResourceLocation>();
		resources.add(CHURCH_MOUSE);
		resources.add(WITCHES_CAT);
		resources.add(WOLF);
		TEXTURES.put(Biomes.FOREST, resources);
		TEXTURES.put(Biomes.FOREST_HILLS, resources);
		TEXTURES.put(Biomes.MUTATED_FOREST, resources);
		//birch
		resources= new ArrayList<ResourceLocation>();
		resources.add(WOLF);
		TEXTURES.put(Biomes.BIRCH_FOREST, resources);
		TEXTURES.put(Biomes.BIRCH_FOREST_HILLS, resources);
		TEXTURES.put(Biomes.MUTATED_BIRCH_FOREST, resources);
		TEXTURES.put(Biomes.MUTATED_BIRCH_FOREST_HILLS, resources);
		//roofed
		resources= new ArrayList<ResourceLocation>();
		resources.add(WOLF);
		resources.add(WITCHES_CAT);
		TEXTURES.put(Biomes.ROOFED_FOREST, resources);
		TEXTURES.put(Biomes.MUTATED_ROOFED_FOREST, resources);
		//savanna
		resources= new ArrayList<ResourceLocation>();
		resources.add(WOLF);
		resources.add(WITCHES_CAT);
		resources.add(CHURCH_MOUSE);
		TEXTURES.put(Biomes.SAVANNA, resources);
		TEXTURES.put(Biomes.SAVANNA_PLATEAU, resources);
		TEXTURES.put(Biomes.MUTATED_SAVANNA, resources);
		TEXTURES.put(Biomes.MUTATED_SAVANNA_ROCK, resources);
		//taiga
		resources= new ArrayList<ResourceLocation>();
		resources.add(WITCHES_CAT);
		resources.add(SKUNK);
		resources.add(LEOPARD);
		TEXTURES.put(Biomes.TAIGA, resources);
		TEXTURES.put(Biomes.TAIGA_HILLS, resources);
		TEXTURES.put(Biomes.MUTATED_TAIGA, resources);
		//redwood
		resources= new ArrayList<ResourceLocation>();
		resources.add(LEOPARD);
		TEXTURES.put(Biomes.REDWOOD_TAIGA, resources);
		TEXTURES.put(Biomes.REDWOOD_TAIGA_HILLS, resources);
		TEXTURES.put(Biomes.MUTATED_REDWOOD_TAIGA, resources);
		TEXTURES.put(Biomes.MUTATED_REDWOOD_TAIGA_HILLS, resources);
		//mountain
		resources= new ArrayList<ResourceLocation>();
		resources.add(LEOPARD);
		TEXTURES.put(Biomes.EXTREME_HILLS, resources);
		TEXTURES.put(Biomes.EXTREME_HILLS_EDGE, resources);
		TEXTURES.put(Biomes.EXTREME_HILLS_WITH_TREES, resources);
		//swamp
		resources= new ArrayList<ResourceLocation>();
		resources.add(WITCHES_CAT);
		TEXTURES.put(Biomes.SWAMPLAND, resources);
		TEXTURES.put(Biomes.MUTATED_SWAMPLAND, resources);
		//cold
		resources= new ArrayList<ResourceLocation>();
		resources.add(SNOWBALL);
		TEXTURES.put(Biomes.FROZEN_RIVER, resources);
		TEXTURES.put(Biomes.ICE_PLAINS, resources);
		TEXTURES.put(Biomes.ICE_MOUNTAINS, resources);
		TEXTURES.put(Biomes.COLD_TAIGA, resources);
		TEXTURES.put(Biomes.COLD_TAIGA_HILLS, resources);
		TEXTURES.put(Biomes.COLD_BEACH, resources);
		TEXTURES.put(Biomes.MUTATED_TAIGA_COLD, resources);
		TEXTURES.put(Biomes.MUTATED_ICE_FLATS, resources);
		TEXTURES.put(Biomes.FROZEN_OCEAN, resources);
		//beach
		resources= new ArrayList<ResourceLocation>();
		resources.add(CHURCH_MOUSE);
		TEXTURES.put(Biomes.BEACH, resources);
		TEXTURES.put(Biomes.STONE_BEACH, resources);
		TEXTURES.put(Biomes.OCEAN, resources);
		TEXTURES.put(Biomes.DEEP_OCEAN, resources);
		TEXTURES.put(Biomes.RIVER, resources);
		//jungle
		resources= new ArrayList<ResourceLocation>();
		resources.add(LEOPARD);
		TEXTURES.put(Biomes.JUNGLE, resources);
		TEXTURES.put(Biomes.JUNGLE_EDGE, resources);
		TEXTURES.put(Biomes.JUNGLE_HILLS, resources);
		TEXTURES.put(Biomes.MUTATED_JUNGLE, resources);
		TEXTURES.put(Biomes.MUTATED_JUNGLE_EDGE, resources);
		//desert
		resources= new ArrayList<ResourceLocation>();
		resources.add(CHURCH_MOUSE);
		TEXTURES.put(Biomes.DESERT, resources);
		TEXTURES.put(Biomes.DESERT_HILLS, resources);
		TEXTURES.put(Biomes.MUTATED_DESERT, resources);
		//mesa
		resources= new ArrayList<ResourceLocation>();
		resources.add(WOLF);
		TEXTURES.put(Biomes.MESA, resources);
		TEXTURES.put(Biomes.MESA_CLEAR_ROCK, resources);
		TEXTURES.put(Biomes.MESA_ROCK, resources);
		TEXTURES.put(Biomes.MUTATED_MESA, resources);
		TEXTURES.put(Biomes.MUTATED_MESA_CLEAR_ROCK, resources);
		TEXTURES.put(Biomes.MUTATED_MESA_ROCK, resources);
		//mushroom
		resources= new ArrayList<ResourceLocation>();
		resources.add(SKINLESS);
		TEXTURES.put(Biomes.MUSHROOM_ISLAND, resources);
		TEXTURES.put(Biomes.MUSHROOM_ISLAND, resources);
		//other
		resources= new ArrayList<ResourceLocation>();
		resources.add(SKINLESS);
		TEXTURES.put(Biomes.HELL, resources);
		TEXTURES.put(Biomes.DEFAULT, resources);
		TEXTURES.put(Biomes.VOID, resources);
		TEXTURES.put(Biomes.SKY, resources);
		}
	
	
	//METHODS
	@Override
	protected ResourceLocation getEntityTexture(EntityFurby _entity)
		{if (_entity!= null)
			{return _entity.skin;
			}
		return null;
		}
	
	@Override
	public void doRender(EntityFurby _entity, double _x, double _y, double _z, float _entityYaw, float _partialTicks)
		{this.mainModel= _entity.model;
		super.doRender(_entity, _x, _y, _z, _entityYaw, _partialTicks);
		}
	
	@Override
	protected void applyRotations(EntityFurby _entityLiving, float _value, float _rotationYaw, float _partialTicks)
		{super.applyRotations(_entityLiving, _value, _rotationYaw, _partialTicks);
		}
	
	
	//SUBCLASSES
	static class FurbyFactory implements IRenderFactory<EntityFurby> 
		{@Override
        public Render<? super EntityFurby> createRenderFor(RenderManager _manager) 
			{return new RenderFurby(_manager);
			}
		}
	}
