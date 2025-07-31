package net.bjnzoom2.blockentitytesting.item;

import net.bjnzoom2.blockentitytesting.BlockEntityTesting;
import net.bjnzoom2.blockentitytesting.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup RUBY_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BlockEntityTesting.MOD_ID, "ruby_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PEDESTAL))
                    .displayName(Text.translatable("itemgroup.blockentitytesting.custom_block_entities"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PEDESTAL);
                        entries.add(ModBlocks.GROWTH_CHAMBER);
                    }).build());

    public static void registerItemGroups() {BlockEntityTesting.LOGGER.info("Registering Item Groups for " + BlockEntityTesting.MOD_ID);
    }
}

