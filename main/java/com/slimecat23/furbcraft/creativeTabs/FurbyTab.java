package com.slimecat23.furbcraft.creativeTabs;

import com.slimecat23.furbcraft.init.BlockInit;
import com.slimecat23.furbcraft.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FurbyTab extends CreativeTabs
	{//CONSTRUCTOR
	public FurbyTab() 
		{super("furbcraft");
		}
	
	
	//METHODS
	@Override
	public ItemStack getTabIconItem() 
		{return new ItemStack(ItemInit.FURBY_LOVE);
		}
	}