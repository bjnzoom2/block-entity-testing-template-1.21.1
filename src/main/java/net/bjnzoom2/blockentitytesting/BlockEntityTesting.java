package net.bjnzoom2.blockentitytesting;

import net.bjnzoom2.blockentitytesting.block.ModBlocks;
import net.bjnzoom2.blockentitytesting.block.entity.ModBlockEntities;
import net.bjnzoom2.blockentitytesting.item.ModItemGroups;
import net.bjnzoom2.blockentitytesting.recipe.ModRecipes;
import net.bjnzoom2.blockentitytesting.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockEntityTesting implements ModInitializer {
	public static final String MOD_ID = "blockentitytesting";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
	}
}