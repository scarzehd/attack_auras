package com.reactiongames.attackauras.items;

import com.reactiongames.attackauras.AttackAuras;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase(Properties properties) {
        super(properties);
    }

    public ItemBase() {
        super(new Item.Properties().group(AttackAuras.TAB));
    }
}
