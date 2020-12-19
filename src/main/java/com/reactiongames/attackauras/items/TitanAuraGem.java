package com.reactiongames.attackauras.items;

import com.reactiongames.attackauras.AttackAuras;
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
}