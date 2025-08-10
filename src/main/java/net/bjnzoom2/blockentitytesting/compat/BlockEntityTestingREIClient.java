package net.bjnzoom2.blockentitytesting.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.bjnzoom2.blockentitytesting.block.ModBlocks;
import net.bjnzoom2.blockentitytesting.recipe.CombinerRecipe;
import net.bjnzoom2.blockentitytesting.recipe.GrowthChamberRecipe;
import net.bjnzoom2.blockentitytesting.recipe.ModRecipes;
import net.bjnzoom2.blockentitytesting.screen.custom.CombinerScreen;
import net.bjnzoom2.blockentitytesting.screen.custom.GrowthChamberScreen;

public class BlockEntityTestingREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new GrowthChamberCategory());
        registry.add(new CombinerCategory());

        registry.addWorkstations(GrowthChamberCategory.GROWTH_CHAMBER, EntryStacks.of(ModBlocks.GROWTH_CHAMBER));
        registry.addWorkstations(CombinerCategory.COMBINER, EntryStacks.of(ModBlocks.COMBINER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GrowthChamberRecipe.class, ModRecipes.GROWTH_CHAMBER_TYPE,
                GrowthChamberDisplay::new);
        registry.registerRecipeFiller(CombinerRecipe.class, ModRecipes.COMBINER_TYPE,
                CombinerDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25), GrowthChamberScreen.class,
                GrowthChamberCategory.GROWTH_CHAMBER);
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 168) / 2) + 30, 20, 25), CombinerScreen.class,
                CombinerCategory.COMBINER);
    }
}
