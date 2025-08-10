package net.bjnzoom2.blockentitytesting.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.bjnzoom2.blockentitytesting.recipe.CombinerRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;


public class CombinerDisplay extends BasicDisplay {
    public CombinerDisplay(RecipeEntry<CombinerRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0)),
                EntryIngredients.ofIngredient(recipe.value().getIngredients().get(1))),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CombinerCategory.COMBINER;
    }
}
