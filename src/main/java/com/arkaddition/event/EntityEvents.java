package com.arkaddition.event;

import com.arkaddition.util.ARKNBTDef.ARKNBTDef;
import com.arkaddition.util.ARKNBTDef.ARKNBTUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class EntityEvents {
    @SubscribeEvent
    public void EntityJoinEvent(EntityJoinWorldEvent event){
        if (event.getWorld().isRemote){
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
        }
    }
}
