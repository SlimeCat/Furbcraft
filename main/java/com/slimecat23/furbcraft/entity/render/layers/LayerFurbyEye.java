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
	{private static final ResourceLocation FURBY_EYE= new ResourceLocation(Reference.MOD_ID + ":textures/entity/furby_eye.png");
	private static final ResourceLocation FURBY_EYE_SAD= new ResourceLocation(Reference.MOD_ID + ":textures/entity/furby_eye_sad.png");
	private static final ResourceLocation SKINLESS_EYE= new ResourceLocation(Reference.MOD_ID + ":textures/entity/skinless_eye.png");
	private static final ResourceLocation SKINLESS_EYE_SAD= new ResourceLocation(Reference.MOD_ID + ":textures/entity/skinless_eye_sad.png");
	private final RenderFurby furby_render;

    public LayerFurbyEye(RenderFurby _render)
    	{this.furby_render= _render;
    	}

    public void doRenderLayer(EntityFurby _entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    	{if (!_entity.isInvisible())
        	{if (_entity.happiness> 30)
        		{if (_entity.skin== RenderFurby.SKINLESS)
        			{this.furby_render.bindTexture(SKINLESS_EYE);
        			}
        		else
        			{this.furby_render.bindTexture(FURBY_EYE);
        			}
        		}
        	else
        		{if (_entity.skin== RenderFurby.SKINLESS)
	    			{this.furby_render.bindTexture(SKINLESS_EYE_SAD);
	    			}
	    		else
	    			{this.furby_render.bindTexture(FURBY_EYE_SAD);
	    			}
        		}
            float[] afloat= _entity.getEyeColor().getColorComponentValues();
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            this.furby_render.getMainModel().render(_entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        	}
    	}

    public boolean shouldCombineTextures()
    	{return true;
    	}
}
