package com.reactiongames.attackauras.capabilities;

public interface IAura {
    void setAuraType(int auraType);
    int getAuraType();

    void sync();
}
