package com.reactiongames.attackauras.capabilities;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AuraProvider implements ICapabilityProvider {
    protected final Capability<IAura> capability;

    protected final IAura instance;

    protected final LazyOptional<IAura> lazyOptional;

    public AuraProvider(final Capability<IAura> capability, final IAura instance) {
        this.capability = capability;
        this.instance = instance;
        
        if (this.instance != null) {
            lazyOptional = LazyOptional.of(() -> this.instance);
        } else {
            lazyOptional = LazyOptional.empty();
        }
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return capability.orEmpty(cap, lazyOptional);
    }

    public IAura getInstance() {
        return this.instance;
    }
}
