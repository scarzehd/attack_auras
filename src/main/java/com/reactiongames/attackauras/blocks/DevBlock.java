package com.reactiongames.attackauras.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DevBlock extends Block {

    public DevBlock() {
        super(AbstractBlock.Properties.create(Material.ROCK).jumpFactor(10).hardnessAndResistance(-1, -1).speedFactor(10).harvestLevel(3));
    }
}
