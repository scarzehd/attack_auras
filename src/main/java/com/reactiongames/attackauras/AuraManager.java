package com.reactiongames.attackauras;

import com.reactiongames.attackauras.capabilities.IAura;
import com.reactiongames.attackauras.util.CapabilityHandler;
import com.reactiongames.attackauras.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AttackAuras.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AuraManager {
    @SubscribeEvent
    public static void entityJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity =event.getEntityLiving();
        LazyOptional<IAura> capability = entity.getCapability(CapabilityHandler.AURA_CAPABILITY);
        if (capability.isPresent()) {
            World world = entity.getEntityWorld();
            world.setBlockState(entity.getPosition().add(0, 2, 0), RegistryHandler.DEV_BLOCK.get().getDefaultState());
        }
    }
}
