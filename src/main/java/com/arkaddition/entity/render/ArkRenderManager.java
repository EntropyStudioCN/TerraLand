package com.arkaddition.entity.render;

import com.arkaddition.entity.SourceStoneBugEntity;
import net.minecraft.client.renderer.entity.RenderManager;

public class ArkRenderManager {
    public static void register(RenderManager renderManager){
        SourceStoneBugRender sourceStoneBugRender = new SourceStoneBugRender(renderManager);
        renderManager.entityRenderMap.put(SourceStoneBugEntity.class,sourceStoneBugRender);
    }
}
