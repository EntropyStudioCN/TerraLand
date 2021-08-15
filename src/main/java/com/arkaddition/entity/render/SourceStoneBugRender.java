package com.arkaddition.entity.render;

import com.arkaddition.entity.SourceStoneBugEntity;
import com.arkaddition.entity.models.SourceStoneBugModel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntitySlime;

public class SourceStoneBugRender extends ArkEntityRenderEngine<SourceStoneBugEntity> {
    protected SourceStoneBugRender(RenderManager renderManager) {
        super(renderManager, new SourceStoneBugModel());
        this.shadowSize = 0.4F;
        //addScale(2F,2F,2F);
    }
    @Override
    public void doRender(SourceStoneBugEntity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.shadowSize = 0.4F * (float)p_76986_1_.getSize();
        super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    @Override
    public void preRenderCallback(SourceStoneBugEntity entitylivingbaseIn, float partialTickTime) {
        float lvt_3_1_ = 0.999F;
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float lvt_4_1_ = (float)entitylivingbaseIn.getSize();
        float lvt_6_1_ = 1.0F / (0F + 1.0F);
        GlStateManager.scale(lvt_6_1_ * lvt_4_1_, 1.0F / lvt_6_1_ * lvt_4_1_, lvt_6_1_ * lvt_4_1_);
    }
}
