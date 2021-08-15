package com.arkaddition.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimatableModel;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.shadowed.eliotlash.mclib.utils.Interpolations;

import java.awt.*;
import java.util.Collections;

/**
 * EntityRender by EntropyStudioCN
 * @param <T> Class extends EntityCreature & IAnimatable
 */
public class ArkEntityRenderEngine<T extends EntityCreature & IAnimatable> extends GeoEntityRenderer<T> {
    private Scale scale = null;
    protected ArkEntityRenderEngine(RenderManager renderManager, AnimatedGeoModel modelProvider) {
        super(renderManager, modelProvider);
    }

    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks){
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);

        // TODO: entity.isPassenger() looks redundant here
        boolean shouldSit = /* entity.isPassenger() && */ (entity.getRidingEntity() != null && entity.getRidingEntity().shouldRiderSit());
        EntityModelData entityModelData = new EntityModelData();
        entityModelData.isSitting = shouldSit;
        entityModelData.isChild = entity.isChild();

        float f = Interpolations.lerpYaw(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
        float f1 = Interpolations.lerpYaw(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
        float netHeadYaw = f1 - f;
        if (shouldSit && entity.getRidingEntity() instanceof EntityLivingBase)
        {
            EntityLivingBase livingentity = (EntityLivingBase) entity.getRidingEntity();
            f = Interpolations.lerpYaw(livingentity.prevRenderYawOffset, livingentity.renderYawOffset, partialTicks);
            netHeadYaw = f1 - f;
            float f3 = MathHelper.wrapDegrees(netHeadYaw);
            if (f3 < -85.0F)
            {
                f3 = -85.0F;
            }

            if (f3 >= 85.0F)
            {
                f3 = 85.0F;
            }

            f = f1 - f3;
            if (f3 * f3 > 2500.0F)
            {
                f += f3 * 0.2F;
            }

            netHeadYaw = f1 - f;
        }

        float headPitch = Interpolations.lerp(entity.prevRotationPitch, entity.rotationPitch, partialTicks);
		/* TODO: vanilla mobs can't sleep in beds in 1.12.2 and below
		if (entity.getPose() == Pose.SLEEPING)
		{
			Direction direction = entity.getBedDirection();
			if (direction != null)
			{
				float f4 = entity.getEyeHeight(Pose.STANDING) - 0.1F;
				stack.translate((double) ((float) (-direction.getXOffset()) * f4), 0.0D, (double) ((float) (-direction.getZOffset()) * f4));
			}
		} */
        float f7 = this.handleRotationFloat(entity, partialTicks);
        this.applyRotations(entity, f7, f, partialTicks);
        float f4 = prepareScale(entity,partialTicks);
        float limbSwingAmount = 0.0F;
        float limbSwing = 0.0F;
        if (!shouldSit && entity.isEntityAlive())
        {
            limbSwingAmount = Interpolations.lerp(entity.prevLimbSwingAmount, entity.limbSwingAmount, partialTicks);
            limbSwing = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);
            if (entity.isChild())
            {
                limbSwing *= 3.0F;
            }

            if (limbSwingAmount > 1.0F)
            {
                limbSwingAmount = 1.0F;
            }
        }
        entityModelData.headPitch = -headPitch;
        entityModelData.netHeadYaw = -netHeadYaw;

        AnimationEvent predicate = new AnimationEvent(entity, limbSwing, limbSwingAmount, partialTicks, !(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F), Collections.singletonList(entityModelData));
        GeoModelProvider modelProvider = getGeoModelProvider();
        GeoModel model = modelProvider.getModel(modelProvider.getModelLocation(entity));
        if (modelProvider instanceof IAnimatableModel)
        {
            ((IAnimatableModel<T>) modelProvider).setLivingAnimations(entity, this.getUniqueID(entity), predicate);
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(0, 0.01f, 0);
        Minecraft.getMinecraft().renderEngine.bindTexture(getEntityTexture(entity));
        Color renderColor = getRenderColor(entity, partialTicks);
        render(model, entity, partialTicks, (float) renderColor.getRed() / 255f, (float) renderColor.getBlue() / 255f, (float) renderColor.getGreen() / 255f, (float) renderColor.getAlpha() / 255);

        //if (entity instanceof EntityPlayer && !((EntityPlayer) entity).isSpectator()) {
        //    for (GeoLayerRenderer layerRenderer : this.layerRenderers) {
        //        layerRenderer.doRenderLayer(entity, limbSwing, limbSwingAmount, partialTicks, f7, netHeadYaw, headPitch, 1 / 16F);
        //    }
        //}
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }
    public float prepareScale(T p_188322_1_, float p_188322_2_) {
        GlStateManager.enableRescaleNormal();
        //GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        this.preRenderCallback(p_188322_1_, p_188322_2_);
        if (scale != null){
            scale.apply();
        }
        float f = 0.0625F;
        //GlStateManager.translate(0.0F, -1.501F, 0.0F);
        return 0.0625F;
    }
    public void preRenderCallback(T entitylivingbaseIn, float partialTickTime) {
    }
    public void addScale(float x,float y,float z){
        scale = new Scale(x,y,z);
    }
    private static class Scale {
        private float x;
        private float y;
        private float z;
        public Scale(float x,float y,float z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        public void apply(){
            GL11.glScalef(x,y,z);
        }
    }
}
