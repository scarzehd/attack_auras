package com.reactiongames.attackauras.capabilities;

public interface IAura {
    void setAuraType(int auraType);
    int getAuraType();

    void applyEffects();

    void sync();
}
