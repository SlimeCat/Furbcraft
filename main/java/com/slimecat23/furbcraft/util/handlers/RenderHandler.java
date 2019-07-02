package com.slimecat23.furbcraft.util.handlers;

import com.slimecat23.furbcraft.entity.EntityFurby;
import com.slimecat23.furbcraft.entity.EntityFurbyRare;
import com.slimecat23.furbcraft.entity.render.RenderFurby;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHandler 
	{public static void registerEntityRenders()
		{RenderingRegistry.registerEntityRenderingHandler(EntityFurby.class, RenderFurby.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFurbyRare.class, RenderFurby.FACTORY);
		}
	}