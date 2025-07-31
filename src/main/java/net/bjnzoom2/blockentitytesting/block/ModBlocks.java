package net.bjnzoom2.blockentitytesting.block;

import net.bjnzoom2.blockentitytesting.BlockEntityTesting;
import net.bjnzoom2.blockentitytesting.block.custom.GrowthChamberBlock;
import net.bjnzoom2.blockentitytesting.block.custom.PedestalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PEDESTAL = registerBlock("pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().nonOpaque()));
    public static final Block GROWTH_CHAMBER = registerBlock("growth_chamber",
            new GrowthChamberBlock(AbstractBlock.Settings.create()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BlockEntityTesting.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BlockEntityTesting.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BlockEntityTesting.LOGGER.info("Registering Mod Blocks for " + BlockEntityTesting.MOD_ID);
    }
}

