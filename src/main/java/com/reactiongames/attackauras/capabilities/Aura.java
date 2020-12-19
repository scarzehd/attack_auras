package com.reactiongames.attackauras.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class Aura implements IAura {
    private int auraType;

    private LivingEntity entity;

    public Aura(LivingEntity entity) {
        auraType = 0;
        this.entity = entity;
    }

    @Override
    public void setAuraType(int auraType) {
        this.auraType = auraType;
    }

    @Override
    public int getAuraType() {
        return this.auraType;
    }

    @Override
    public void sync() {

    }
}
