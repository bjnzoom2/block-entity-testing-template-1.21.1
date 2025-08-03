package net.bjnzoom2.blockentitytesting;

import net.bjnzoom2.blockentitytesting.block.entity.ModBlockEntities;
import net.bjnzoom2.blockentitytesting.block.entity.renderer.PedestalBlockEntityRenderer;
import net.bjnzoom2.blockentitytesting.screen.ModScreenHandlers;
import net.bjnzoom2.blockentitytesting.screen.custom.GrowthChamberScreen;
import net.bjnzoom2.blockentitytesting.screen.custom.PedestalScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BlockEntityTestingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);
        HandledScreens.register(ModScreenHandlers.GROWTH_CHAMBER_SCREEN_HANDLER, GrowthChamberScreen::new);
    }
}
