package com.slimecat23.furbcraft.proxy;

import com.slimecat23.furbcraft.util.handlers.RegistryHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
	{//METHODS
	@Override
	public void registerModel(Item item, int metadata) 
		{ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
