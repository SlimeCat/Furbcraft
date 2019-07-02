package com.slimecat23.furbcraft.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


/**
 * sb_furby_model - SlimeCat23
 * Created using Tabula 6.0.0
 */
public class ModelFurbyTail extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Beak;
    public ModelRenderer Hair;
    public ModelRenderer Tail;
    public ModelRenderer Rfoot;
    public ModelRenderer Lfoot;
    public ModelRenderer Rear;
    public ModelRenderer Lear;

    public ModelFurbyTail() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Rfoot = new ModelRenderer(this, 47, 0);
        this.Rfoot.setRotationPoint(-4.0F, 23.0F, -4.0F);
        this.Rfoot.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.Rear = new ModelRenderer(this, 50, 3);
        this.Rear.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.Rear.addBox(0.0F, -7.0F, 0.0F, 4, 7, 1, 0.0F);
        this.setRotateAngle(Rear, 0.0F, 0.0F, 0.2617993877991494F);
        this.Lfoot = new ModelRenderer(this, 55, 0);
        this.Lfoot.setRotationPoint(2.0F, 23.0F, -4.0F);
        this.Lfoot.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.Lear = new ModelRenderer(this, 32, 6);
        this.Lear.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.Lear.addBox(-4.0F, -7.0F, 0.0F, 4, 7, 1, 0.0F);
        this.setRotateAngle(Lear, 0.0F, 0.0F, -0.2617993877991494F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-4.0F, 15.0F, -2.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 8, 9, 8, 0.0F);
        this.Tail = new ModelRenderer(this, 36, 0);
        this.Tail.setRotationPoint(-2.0F, 21.0F, 6.0F);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
        this.Hair = new ModelRenderer(this, 24, 0);
        this.Hair.setRotationPoint(-1.0F, 13.0F, -1.0F);
        this.Hair.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
        this.Beak = new ModelRenderer(this, 0, 0);
        this.Beak.setRotationPoint(-1.0F, 19.0F, -3.0F);
        this.Beak.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Rfoot.render(f5);
        this.Rear.render(f5);
        this.Lfoot.render(f5);
        this.Lear.render(f5);
        this.Body.render(f5);
        this.Tail.render(f5);
        this.Hair.render(f5);
        this.Beak.render(f5);
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
