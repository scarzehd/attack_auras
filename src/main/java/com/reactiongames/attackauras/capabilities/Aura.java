package com.reactiongames.attackauras.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.network.play.server.SEntityPropertiesPacket;
import net.minecraft.world.server.ServerWorld;

import java.util.Collections;
import java.util.UUID;

public class Aura implements IAura {
    private int auraType;

    private UUID knockbackModifier = UUID.randomUUID();

    private LivingEntity entity;

    public Aura(LivingEntity entity) {
        auraType = 0;
        this.entity = entity;
    }

    @Override
    public void setAuraType(int auraType) {
        this.auraType = auraType;
        this.applyEffects();
    }

    @Override
    public int getAuraType() {
        return this.auraType;
    }

    @Override
    public void applyEffects() {
        switch (auraType) {
            case 0:
                break;
            case 1:
                final ModifiableAttributeInstance entityKnockbackAttribute = entity.getAttribute(Attributes.ATTACK_KNOCKBACK);
                final AttributeModifier modifier = new AttributeModifier(knockbackModifier, "aura_knockback_modifier", 10.0D, AttributeModifier.Operation.ADDITION);

                entityKnockbackAttribute.applyNonPersistentModifier(modifier);

                sync();
                break;
        }
    }

    @Override
    public void sync() {
        if (entity != null && !entity.getEntityWorld().isRemote()) {
            final ModifiableAttributeInstance entityKockbackAttribute = entity.getAttribute(Attributes.ATTACK_KNOCKBACK);
            final SEntityPropertiesPacket packet = new SEntityPropertiesPacket(entity.getEntityId(), Collections.singleton(entityKockbackAttribute));
            ((ServerWorld) entity.getEntityWorld()).getChunkProvider().sendToTrackingAndSelf(entity, packet);
        }
    }
}
