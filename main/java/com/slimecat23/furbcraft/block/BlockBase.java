package com.slimecat23.furbcraft.block;

import com.slimecat23.furbcraft.Main;
import com.slimecat23.furbcraft.init.BlockInit;
import com.slimecat23.furbcraft.init.ItemInit;
import com.slimecat23.furbcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


public class BlockBase extends Block implements IHasModel
	{//CONSTRUCTOR
	public BlockBase(String _name, Material _material, CreativeTabs _tab) 
		{super(_material);
		setUnlocalizedName(_name);
		setRegistryName(_name);
		setCreativeTab(_tab);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(_name));
		}
	
	
	//METHODS
	@Override
	public void registerModels() 
		{Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
		}
	}