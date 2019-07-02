package com.slimecat23.furbcraft.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.slimecat23.furbcraft.block.BlockBase;
import com.slimecat23.furbcraft.block.BlockBuddy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockInit 
	{//VARIABLES
	public static final ArrayList<Block> BLOCKS= new ArrayList<Block>();
	public static final HashMap<Integer, Block> BUDDIES= new HashMap<Integer, Block>();
	
	public static final Block BLOCK_BUDDY_CM= new BlockBuddy("block_buddy_cm");
	public static final Block BLOCK_BUDDY_WC= new BlockBuddy("block_buddy_wc");
	public static final Block BLOCK_BUDDY_WF= new BlockBuddy("block_buddy_wf");
	public static final Block BLOCK_BUDDY_SK= new BlockBuddy("block_buddy_sk");
	public static final Block BLOCK_BUDDY_LP= new BlockBuddy("block_buddy_lp");
	public static final Block BLOCK_BUDDY_SB= new BlockBuddy("block_buddy_sb");
	public static final Block BLOCK_BUDDY_KC= new BlockBuddy("block_buddy_kc");
	//public static final Block BLOCK_TEST= new BlockBase("block_test", Material.IRON, CreativeTabs.BUILDING_BLOCKS);
	}
