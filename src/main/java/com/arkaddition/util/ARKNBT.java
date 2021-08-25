package com.arkaddition.util;
import com.arkaddition.util.ARKNBTDef.ARKNBTDef;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;


public class ARKNBT {
    public int ArkStrength;
    //public boolean isEarth;
    //public boolean isSky;

    private final NBTTagCompound basic;

    public ARKNBT()
    {
        ArkStrength = 0;

        //isEarth = false;
        //isSky = false;

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
            ArkStrength = tag.getInteger(ARKNBTDef.ARK_STRENGTH.getName ());

            //isEarth = tag.getBoolean(IDLNBTDef.IS_EARTH);
            //isSky = tag.getBoolean(IDLNBTDef.IS_SKY);
        }
    }

    public void writeToBasic(NBTTagCompound tag)
    {
        if (tag == null)
        {
            tag = new NBTTagCompound();
        }

        tag.setInteger(ARKNBTDef.ARK_STRENGTH.getName (), ArkStrength);
        //tag.setBoolean(IDLNBTDef.IS_EARTH, isEarth);
        //tag.setBoolean(IDLNBTDef.IS_SKY, isSky);
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

    //PlayerData
    //--PERSISTED_NBT_TAG
    //  --ARK
    //    --KILL_COUNT,etc


    public static NBTTagCompound getTagSafe(NBTTagCompound tag, String key) {
        if(tag == null) {
            return new NBTTagCompound();
        }

        return tag.getCompoundTag(key);
    }

    public static NBTTagCompound getPlyrIdlTagSafe(EntityPlayer player) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound ark_data = getTagSafe(data, "ARK");

        return ark_data;
    }

    public static NBTTagCompound getPlayerARKTagGroupSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getCompoundTag(key);
    }

    public static int[] getPlayerARKIntArraySafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getIntArray(key);
    }

    public static int getPlayerARKIntSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getInteger(key);
    }
    public static float getPlayerARKFloatSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getFloat(key);
    }
    public static double getPlayerARKDoubleSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getDouble(key);
    }
    public static boolean getPlayerARKBoolSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getBoolean(key);
    }
    public static String getPlayerARKStrSafe(EntityPlayer player, String key) {
        return getPlyrIdlTagSafe(player).getString(key);
    }

    public static void setPlayerARKTagSafe(EntityPlayer player, String key, int value) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound ark_data = getPlyrIdlTagSafe(player);

        ark_data.setInteger(key, value);

        data.setTag("ARK", ark_data);
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
    }

    public static void setPlayerARKTagSafe(EntityPlayer player, String key, int[] value) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound ark_data = getPlyrIdlTagSafe(player);

        ark_data.setIntArray(key, value);

        data.setTag("ARK", ark_data);
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
    }

    public static void setPlayerARKTagSafe(EntityPlayer player, String key, double value) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound ark_data = getPlyrIdlTagSafe(player);

        ark_data.setDouble(key, value);

        data.setTag("ARK", ark_data);
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
    }

    public static void setPlayerARKTagSafe(EntityPlayer player, String key, boolean value) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound ark_data = getPlyrIdlTagSafe(player);

        ark_data.setBoolean(key, value);

        data.setTag("ARK", ark_data);
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
    }

    public static void setPlayerARKTagSafe(EntityPlayer player, String key, String value) {
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound ark_data = getPlyrIdlTagSafe(player);

        ark_data.setString(key, value);

        data.setTag("ARK", ark_data);
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
    }
}