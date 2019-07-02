package com.slimecat23.furbcraft.init;

import java.util.ArrayList;

import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class LootInit
	{public static void registerTables()
		{LootTableList.register(new ResourceLocation(Reference.MOD_ID, "chests/simple_dungeon"));
        LootTableList.register(new ResourceLocation(Reference.MOD_ID, "chests/end_city_treasure"));
		}
	
	@SubscribeEvent
    public static void onEvent(LootTableLoadEvent event) 
		{if (event.getName().toString().equals("minecraft:chests/end_city_treasure")) 
        	{System.out.println("Injecting loot: End Chest");
			addItem(event.getTable(), loadPool("chests/end_city_treasure"));
        	}
		if (event.getName().toString().equals("minecraft:chests/simple_dungeon")) 
	    	{System.out.println("Injecting loot: Dungeon");
			addItem(event.getTable(), loadPool("chests/simple_dungeon"));
	    	}
		}
	
	public static LootPool loadPool(String _location)
		{return new LootPool
			(new LootEntry[] 
				{new LootEntryTable
					(new ResourceLocation(Reference.MOD_ID, _location),
					1,
					0,
					new LootCondition[0],
					"rtapeentry"
					)
				},
			new LootCondition[0],
			new RandomValueRange(1),
			new RandomValueRange(0, 1),
			"rtapentry"
			);
		}
	
	public static void addItem(LootTable table, LootPool pool) 
		{table.addPool(pool);
		}
	}
