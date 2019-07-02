package com.slimecat23.furbcraft.items;

import com.slimecat23.furbcraft.Main;
import com.slimecat23.furbcraft.init.ItemInit;
import com.slimecat23.furbcraft.util.IHasModel;
import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel 
	{//VARIABLES
	
	
	//CONSTRUCTOR
	public ItemBase(String name)
		{setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Reference.FURBCRAFT);
		ItemInit.ITEMS.add(this);
		}
	
	
	//METHODS
	@Override
	public void registerModels() 
		{Main.proxy.registerModel(this, 0 );
		}
	}
