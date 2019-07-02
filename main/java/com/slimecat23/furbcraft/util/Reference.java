package com.slimecat23.furbcraft.util;

import java.util.Random;

import com.slimecat23.furbcraft.creativeTabs.FurbyTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Reference 
	{public static final String MOD_ID = "scfc";
	public static final String NAME = "Furbcraft";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "com.slimecat23.furbcraft.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.slimecat23.furbcraft.proxy.CommonProxy";
	
	public static final CreativeTabs FURBCRAFT= new FurbyTab();
	
	public static final int ENTITY_FURBY = 120;
	public static final int ENTITY_FURBY_RARE = 121;
	public static final Item[] PLANTS= new Item[] {Items.APPLE, Items.BEETROOT, Items.CARROT, Items.CHORUS_FRUIT, Items.MELON, Items.POTATO, Items.WHEAT};
	public static final Item[] SWEETS= new Item[] {Items.SUGAR, Items.CAKE, Items.COOKIE, Items.PUMPKIN_PIE};
	
	public static Random random= new Random();
	}
