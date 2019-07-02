package com.slimecat23.furbcraft.entity.render.layers;

import com.slimecat23.furbcraft.entity.EntityFurby;
import com.slimecat23.furbcraft.entity.render.RenderFurby;
import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class LayerFurbyEye implements LayerRenderer<EntityFurby>
	{
    private static final ResourceLocation WOLF_COLLAR= new ResourceLocation(Reference.MOD_ID + ":textures/entity/furby_eye.png");
    private final RenderFurby furby_render;

    public LayerFurbyEye(RenderFurby _render)
    	{this.furby_render= _render;
    	}

    public void doRenderLayer(EntityFurby entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    	{if (entitylivingbaseIn.isTamed() && !entitylivingbaseIn.isInvisible())
        	{this.furby_render.bindTexture(WOLF_COLLAR);
            float[] afloat= entitylivingbaseIn.getEyeColor().getColorComponentValues();
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            this.furby_render.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        	}
    	}

    public boolean shouldCombineTextures()
    	{return true;
    	}
}
