package com.reactiongames.attackauras.util;

import com.reactiongames.attackauras.AttackAuras;
import com.reactiongames.attackauras.blocks.BlockItemBase;
import com.reactiongames.attackauras.blocks.DevBlock;
import com.reactiongames.attackauras.items.ItemBase;
import com.reactiongames.attackauras.items.TitanAuraGem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AttackAuras.MOD_ID);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AttackAuras.MOD_ID);

    public static void Init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> AURA_GEM = ITEMS.register("aura_gem", ItemBase::new);
    public static final RegistryObject<Item> TITAN_AURA = ITEMS.register("titan_aura", ItemBase::new);
    public static final RegistryObject<Item> TITAN_AURA_GEM = ITEMS.register("titan_aura_gem", TitanAuraGem::new);

    //Blocks
    public static final RegistryObject<Block> DEV_BLOCK = BLOCKS.register("dev_block", DevBlock::new);

    //BlockItems
    public static final RegistryObject<Item> DEV_BLOCK_ITEM = ITEMS.register("dev_block", () -> new BlockItemBase(DEV_BLOCK.get()));
}
