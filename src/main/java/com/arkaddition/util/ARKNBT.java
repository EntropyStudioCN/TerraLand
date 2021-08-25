package com.arkaddition.util;
import com.arkaddition.util.ARKNBTDef.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class ARKNBT {
    public String ArkJob;


    private final NBTTagCompound basic;

    public ARKNBT()
    {
        ArkJob  = "Empty";
        basic = new NBTTagCompound();
    }

    public ARKNBT(NBTTagCompound srcNBT)
    {
        readFromBasic(srcNBT);
        basic = srcNBT;
    }

    public void readFromBasic(NBTTagCompound tag)
    {
        if (tag != null)
        {
            ArkJob  = tag.getString (ARKNBTDef.ARK_JOB.getName());
        }
    }

    public void writeToBasic(NBTTagCompound tag)
    {
        if (tag == null)
        {
            tag = new NBTTagCompound();
        }

        tag.setString (ARKNBTDef.ARK_JOB.getName(), ArkJob);
    }

    public NBTTagCompound getBasic()
    {
        NBTTagCompound tag = basic.copy();
        writeToBasic(tag);

        return tag;
    }

    public void save()
    {
        writeToBasic(basic);
    }
////////////////////////////////////////////////////////////////////////////////////////////////

    public static NBTTagCompound getTagSafe(NBTTagCompound tag, String key) {
        if(tag == null) {
            return new NBTTagCompound();
        }

        return tag.getCompoundTag(key);
    }

    public static NBTTagCompound getPlyrIdlTagSafe(EntityPlayer player) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound Ark_data = getTagSafe(data,"ARKADDITOIN");

        return Ark_data;
    }


    public static String getPlayerIdeallandStrSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getString(key);
    }
////////////////////////////////////////////////////////////////////////////////////////////////
    public static void setPlayerArkJob(EntityPlayer player, String key, String value) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound Ark_data = getPlyrIdlTagSafe(player);

        Ark_data.setString (key, value);

        data.setTag("ARKADDITION", Ark_data);
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
    }
}
