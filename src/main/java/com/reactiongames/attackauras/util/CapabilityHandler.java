package com.reactiongames.attackauras.util;

import com.reactiongames.attackauras.AttackAuras;
import com.reactiongames.attackauras.capabilities.Aura;
import com.reactiongames.attackauras.capabilities.AuraProvider;
import com.reactiongames.attackauras.capabilities.AuraStorage;
import com.reactiongames.attackauras.capabilities.IAura;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.Callable;

public class CapabilityHandler {
    @CapabilityInject(IAura.class)
    public static Capability<IAura> AURA_CAPABILITY = null;
    public static final ResourceLocation AURA_ID = new ResourceLocation(AttackAuras.MOD_ID, "aura");

    public static void register() {
        CapabilityManager.INSTANCE.register(IAura.class, new AuraStorage(), new Callable<IAura>() {
            @Override
            public IAura call() throws Exception {
                return new Aura(null);
            }
        });
    }

    @Mod.EventBusSubscriber(modid = AttackAuras.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EventHandler {
        @SubscribeEvent
        public static void attachCapabilities(final AttachCapabilitiesEvent event) {
            if (event.getObject() instanceof LivingEntity) {
                LivingEntity object = (LivingEntity) event.getObject();
                event.addCapability(AURA_ID, new AuraProvider(AURA_CAPABILITY, new Aura((LivingEntity) object)));
            }
        }

        @SubscribeEvent
        public static void playerClone(final PlayerEvent.Clone event) {
            event.getOriginal().getCapability(AURA_CAPABILITY).ifPresent(oldAura -> {
                event.getEntityLiving().getCapability(AURA_CAPABILITY).ifPresent(newAura -> {
                    newAura.setAuraType(oldAura.getAuraType());
                });
            });
        }

        @SubscribeEvent
        public static void playerChangeDimension(final PlayerEvent.PlayerChangedDimensionEvent event) {
            event.getEntityLiving().getCapability(AURA_CAPABILITY).ifPresent(IAura::sync);
        }
    }
}
