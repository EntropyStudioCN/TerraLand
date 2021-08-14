package com.arkaddition.entity.models;

import com.arkaddition.util.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SourceStoneBugModel extends AnimatedGeoModel {
    /*@Override
    public void setLivingAnimations(Object entity, Integer uniqueID, AnimationEvent customPredicate) {

    }*/

    @Override
    public ResourceLocation getModelLocation(Object object) {
        return new ResourceLocation(Reference.Mod_ID,"geo/source_stone_bug.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object object) {
        return new ResourceLocation(Reference.Mod_ID,"textures/entities/source_stone_bug.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Object animatable) {
        return new ResourceLocation(Reference.Mod_ID,"animations/source_stone_bug.animation.json");
    }
}
