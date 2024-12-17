package dev.lpsmods.breaker.core;


import dev.lpsmods.breaker.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModItems {
    public static final Item ULTIMATE_BLOCK_BREAKER;
    public static final Item WOOD_BREAKER_BLOCK;
    public static final Item STONE_BREAKER_BLOCK;
    public static final Item IRON_BREAKER_BLOCK;
    public static final Item GOLD_BREAKER_BLOCK;
    public static final Item DIAMOND_BREAKER_BLOCK;
    public static final Item NETHERITE_BREAKER_BLOCK;
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), item);
    }
    
    private static Item registerBlock(String name, Block block) {
        return registerItem(name, new BlockItem(block, new Item.Properties()));
    }

    public static void init() {}

    static {
        ULTIMATE_BLOCK_BREAKER = registerBlock("ultimate_block_breaker", ModBlocks.ULTIMATE_BLOCK_BREAKER);
        WOOD_BREAKER_BLOCK = registerBlock("wood_breaker_block", ModBlocks.WOOD_BREAKER_BLOCK);
        STONE_BREAKER_BLOCK = registerBlock("stone_breaker_block", ModBlocks.STONE_BREAKER_BLOCK);
        IRON_BREAKER_BLOCK = registerBlock("iron_breaker_block", ModBlocks.IRON_BREAKER_BLOCK);
        GOLD_BREAKER_BLOCK = registerBlock("gold_breaker_block", ModBlocks.GOLD_BREAKER_BLOCK);
        DIAMOND_BREAKER_BLOCK = registerBlock("diamond_breaker_block", ModBlocks.DIAMOND_BREAKER_BLOCK);
        NETHERITE_BREAKER_BLOCK = registerBlock("netherite_breaker_block", ModBlocks.NETHERITE_BREAKER_BLOCK);
    }
}
