package com.slimecat23.furbcraft;

import com.slimecat23.furbcraft.proxy.CommonProxy;
import com.slimecat23.furbcraft.util.Reference;
import com.slimecat23.furbcraft.util.handlers.RegistryHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
	{//VARIABLES
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide= Reference.CLIENT_PROXY_CLASS, serverSide= Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	//METHODS
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
		{RegistryHandler.preInitRegistries(event);
		}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
		{RegistryHandler.initRegistries(event);
		}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
		{RegistryHandler.postInitRegistries(event);
		}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
		{RegistryHandler.serverRegistries(event);
		}
	}
