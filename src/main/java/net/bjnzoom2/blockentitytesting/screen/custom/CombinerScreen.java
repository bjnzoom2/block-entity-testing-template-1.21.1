package net.bjnzoom2.blockentitytesting.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.bjnzoom2.blockentitytesting.BlockEntityTesting;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CombinerScreen extends HandledScreen<CombinerScreenHandler> {
    private static final Identifier GUI_TEXTURE =
            Identifier.of(BlockEntityTesting.MOD_ID, "textures/gui/combiner/combiner_gui.png");
    private static final Identifier DUAL_ARROW_TEXTURE =
            Identifier.of(BlockEntityTesting.MOD_ID, "textures/gui/dual_arrow_progress.png");

    public CombinerScreen(CombinerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(DUAL_ARROW_TEXTURE, x + 73, y + 26, 0, 0,
                    handler.getScaledArrowProgress(), 36, 26, 36);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
