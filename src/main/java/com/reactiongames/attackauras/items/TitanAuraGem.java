package com.reactiongames.attackauras.items;

import com.reactiongames.attackauras.AttackAuras;
import com.reactiongames.attackauras.util.CapabilityHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TitanAuraGem extends Item {
    public TitanAuraGem() {
        super(new Item.Properties().group(AttackAuras.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.getCapability(CapabilityHandler.AURA_CAPABILITY).ifPresent(aura -> {
            aura.setAuraType(1);
        });
        return ActionResult.resultConsume(playerIn.getHeldItem(handIn));
    }
}