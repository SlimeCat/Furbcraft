package com.slimecat23.furbcraft.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * sb_furby_model - SlimeCat23
 * Created using Tabula 6.0.0
 */
public class ModelFurbySkinless extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Beak;
    public ModelRenderer Rear;
    public ModelRenderer Lear;

    public ModelFurbySkinless() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Beak = new ModelRenderer(this, 0, 0);
        this.Beak.setRotationPoint(-1.0F, 19.0F, -3.0F);
        this.Beak.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-3.0F, 15.0F, -2.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6, 10, 7, 0.0F);
        this.Lear = new ModelRenderer(this, 30, 0);
        this.Lear.setRotationPoint(1.6F, 18.2F, 0.0F);
        this.Lear.addBox(-4.5F, -7.2F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(Lear, 0.0F, 0.0F, -0.2617993877991494F);
        this.Rear = new ModelRenderer(this, 26, 0);
        this.Rear.setRotationPoint(1.8F, 19.0F, 0.0F);
        this.Rear.addBox(0.0F, -7.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(Rear, 0.0F, 0.0F, 0.2617993877991494F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Beak.render(f5);
        this.Body.render(f5);
        this.Lear.render(f5);
        this.Rear.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
