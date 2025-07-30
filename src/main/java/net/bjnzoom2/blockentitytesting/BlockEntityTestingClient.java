package net.bjnzoom2.blockentitytesting;

import net.bjnzoom2.blockentitytesting.block.ModBlocks;
import net.bjnzoom2.blockentitytesting.block.entity.ModBlockEntities;
import net.bjnzoom2.blockentitytesting.block.entity.renderer.PedestalBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BlockEntityTestingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
    }
}
