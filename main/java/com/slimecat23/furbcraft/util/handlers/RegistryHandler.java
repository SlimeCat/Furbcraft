package com.slimecat23.furbcraft.util.handlers;

import com.slimecat23.furbcraft.Main;
import com.slimecat23.furbcraft.init.BlockInit;
import com.slimecat23.furbcraft.init.EntityInit;
import com.slimecat23.furbcraft.init.ItemInit;
import com.slimecat23.furbcraft.init.LootInit;
import com.slimecat23.furbcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@EventBusSubscriber
public class RegistryHandler 
	{//METHODS
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
		{event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
		}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
		{event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
		{for(Item item : ItemInit.ITEMS)
			{if(item instanceof IHasModel)
				{((IHasModel)item).registerModels();
				}
			}
		
		for(Block block : BlockInit.BLOCKS)
			{if(block instanceof IHasModel)
				{((IHasModel)block).registerModels();
				}
			}
		}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
		{EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		LootInit.registerTables();
		MinecraftForge.EVENT_BUS.register(LootInit.class);
		}
	
	public static void initRegistries(FMLInitializationEvent event)
		{	
		}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
		{
		}
	
	public static void serverRegistries(FMLServerStartingEvent event)
		{
		}
}