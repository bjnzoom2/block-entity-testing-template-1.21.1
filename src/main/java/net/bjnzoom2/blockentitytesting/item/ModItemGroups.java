package net.bjnzoom2.blockentitytesting.item;

import net.bjnzoom2.blockentitytesting.BlockEntityTesting;
import net.bjnzoom2.blockentitytesting.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup CUSTOM_BLOCK_ENTITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BlockEntityTesting.MOD_ID, "custom_block_entities"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PEDESTAL))
                    .displayName(Text.translatable("itemgroup.blockentitytesting.custom_block_entities"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PEDESTAL);
                        entries.add(ModBlocks.GROWTH_CHAMBER);
                        entries.add(ModBlocks.COMBINER);
                    }).build());

    public static final ItemGroup CUSTOM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BlockEntityTesting.MOD_ID, "custom_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.blockentitytesting.custom_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                    }).build());

    public static void registerItemGroups() {BlockEntityTesting.LOGGER.info("Registering Item Groups for " + BlockEntityTesting.MOD_ID);
    }
}

