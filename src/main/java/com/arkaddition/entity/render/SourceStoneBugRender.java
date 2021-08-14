package com.arkaddition.entity.render;

import com.arkaddition.entity.SourceStoneBugEntity;
import com.arkaddition.entity.models.SourceStoneBugModel;
import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SourceStoneBugRender extends GeoEntityRenderer<SourceStoneBugEntity> {
    protected SourceStoneBugRender(RenderManager renderManager) {
        super(renderManager, new SourceStoneBugModel());
        this.shadowSize = 0.4F;
    }
}
