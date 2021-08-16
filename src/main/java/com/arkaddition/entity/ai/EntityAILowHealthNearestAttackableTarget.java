package com.arkaddition.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAILowHealthNearestAttackableTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {
    private double thresholdValue;
    public EntityAILowHealthNearestAttackableTarget(EntityCreature p_i45878_1_, Class<T> p_i45878_2_, boolean p_i45878_3_,float thresholdValue) {
        super(p_i45878_1_, p_i45878_2_, p_i45878_3_);
        this.thresholdValue = thresholdValue;
    }
    @Override
    public boolean shouldExecute() {
        if (taskOwner.getHealth() <= thresholdValue){
            return super.shouldExecute();
        }
        return false;
    }
}
