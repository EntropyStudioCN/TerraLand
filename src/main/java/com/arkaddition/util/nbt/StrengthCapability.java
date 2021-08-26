package com.arkaddition.util.nbt;

import com.google.gson.Gson;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class StrengthCapability implements Capability.IStorage<StrengthContainer> {
    public static StrengthCapability INSTANCE;
    public StrengthCapability(){
        INSTANCE = this;
    }
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<StrengthContainer> capability, StrengthContainer instance, EnumFacing side) {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setInteger("MAX_STRENGTH", instance.getMaxStrength());
        nbtTagCompound.setInteger("STRENGTH", instance.getStrength());
        return nbtTagCompound;
    }

    @Override
    public void readNBT(Capability<StrengthContainer> capability, StrengthContainer instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagCompound){
            instance.setMaxStrength(((NBTTagCompound) nbt).getInteger("MAX_STRENGTH"));
            instance.setStrength(((NBTTagCompound) nbt).getInteger("STRENGTH"));
        }
    }
}
