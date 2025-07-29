package net.bjnzoom2.blockentitytesting.block.entity;

import net.bjnzoom2.blockentitytesting.BlockEntityTesting;
import net.bjnzoom2.blockentitytesting.block.ModBlocks;
import net.bjnzoom2.blockentitytesting.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BlockEntityTesting.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build());

    public static void registerBlockEntities() {
        BlockEntityTesting.LOGGER.info("Registering Block Entities for " + BlockEntityTesting.MOD_ID);
    }
}
