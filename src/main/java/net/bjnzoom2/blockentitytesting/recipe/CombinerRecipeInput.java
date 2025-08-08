package net.bjnzoom2.blockentitytesting.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;;

public record CombinerRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> input0;
            case 1 -> input1;
            default -> ItemStack.EMPTY;
        };
    }
    @Override
    public int getSize() {
        return 2;
    }
}
