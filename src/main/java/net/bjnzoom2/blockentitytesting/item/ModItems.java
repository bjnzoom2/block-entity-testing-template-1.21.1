package net.bjnzoom2.blockentitytesting.item;

import net.bjnzoom2.blockentitytesting.BlockEntityTesting;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BlockEntityTesting.MOD_ID, name), item);
    }

    public static void registerItems() {
        BlockEntityTesting.LOGGER.info("Registering Custom Items for " + BlockEntityTesting.MOD_ID);
    }
}
