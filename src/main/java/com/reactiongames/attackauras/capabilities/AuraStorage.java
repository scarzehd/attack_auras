package com.reactiongames.attackauras.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class AuraStorage implements Capability.IStorage<IAura> {

    @Override
    public INBT writeNBT(Capability<IAura> capability, IAura instance, Direction side) {
        return IntNBT.valueOf(instance.getAuraType());
    }

    @Override
    public void readNBT(Capability<IAura> capability, IAura instance, Direction side, INBT nbt) {
        instance.setAuraType(((IntNBT)nbt).getInt());
    }
}
