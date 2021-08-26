package com.arkaddition.event;

import com.arkaddition.util.ARKNBTDef.ARKNBTDef;
import com.arkaddition.util.ARKNBTDef.ARKNBTUtil;
import com.arkaddition.util.Reference;
import com.arkaddition.util.nbt.StrengthCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.logging.Logger;

public class EntityEvents {
    @SubscribeEvent
    public void EntityJoinEvent(EntityJoinWorldEvent event){
        /*if (event.getWorld().isRemote){
            //WARN:Control entities on Server
            if (event.getEntity() instanceof EntityPlayer){
                //Add a NBT Tag
                EntityPlayer entityPlayer = (EntityPlayer) event.getEntity();
                boolean result;
                if (!ARKNBTUtil.EntityHasKey(entityPlayer,ARKNBTDef.ARK_STRENGTH_MAX.getName())){
                    result = ARKNBTUtil.SetInt(entityPlayer, ARKNBTDef.ARK_STRENGTH_MAX.getName(),100);
                }else {
                    result = true;
                }
                if (!result) LogManager.getLogger("TerraLand").error("Can't set NBT("+ARKNBTDef.ARK_STRENGTH_MAX.getName()+") to player("+entityPlayer.getName()+")");
                if (!ARKNBTUtil.EntityHasKey(entityPlayer,ARKNBTDef.ARK_STRENGTH_MAX.getName())){
                    result = ARKNBTUtil.SetInt(entityPlayer, ARKNBTDef.ARK_STRENGTH.getName(),110);
                }else {
                    result = true;
                }
                if (!result) LogManager.getLogger("TerraLand").error("Can't set NBT("+ARKNBTDef.ARK_STRENGTH.getName()+") to player("+entityPlayer.getName()+")");
            }
        }*/
    }
    @SubscribeEvent
    public void addCap(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof EntityPlayer){
            event.addCapability(new ResourceLocation(Reference.Mod_ID, "strength_nbt"), new ICapabilityProvider() {
                @Override
                public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
                    return capability == null;
                }

                @Nullable
                @Override
                public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
                    return null;
                }
            });
        }
    }
}
