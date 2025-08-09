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

public record CombinerRecipe(Ingredient inputItem1, Ingredient inputItem2, ItemStack output) implements Recipe<CombinerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem1);
        list.add(this.inputItem2);
        return list;
    }

    @Override
    public boolean matches(CombinerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        ItemStack slot1 = input.getStackInSlot(0);
        ItemStack slot2 = input.getStackInSlot(1);

        return (inputItem1.test(slot1) && inputItem2.test(slot2)) ||
                (inputItem1.test(slot2) && inputItem2.test(slot1));
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
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient1").forGetter(CombinerRecipe::inputItem1),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient2").forGetter(CombinerRecipe::inputItem2),
                ItemStack.CODEC.fieldOf("result").forGetter(CombinerRecipe::output)
        ).apply(inst, CombinerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, CombinerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, CombinerRecipe::inputItem1,
                        Ingredient.PACKET_CODEC, CombinerRecipe::inputItem2,
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
