package net.bjnzoom2.blockentitytesting.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record CombinerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CombinerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(CombinerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CombinerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.COMBINER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.COMBINER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<CombinerRecipe> {
        public static final MapCodec<CombinerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CombinerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CombinerRecipe::output)
        ).apply(inst, CombinerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, CombinerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, CombinerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, CombinerRecipe::output,
                        CombinerRecipe::new);

        @Override
        public MapCodec<CombinerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CombinerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
