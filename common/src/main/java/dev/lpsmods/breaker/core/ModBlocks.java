package dev.lpsmods.breaker.core;

import dev.lpsmods.breaker.Constants;
import dev.lpsmods.breaker.block.BreakerBlock;
import dev.lpsmods.breaker.block.LegacyBreakerBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Block ULTIMATE_BLOCK_BREAKER;
    public static final Block WOOD_BREAKER_BLOCK;
    public static final Block STONE_BREAKER_BLOCK;
    public static final Block IRON_BREAKER_BLOCK;
    public static final Block GOLD_BREAKER_BLOCK;
    public static final Block DIAMOND_BREAKER_BLOCK;
    public static final Block NETHERITE_BREAKER_BLOCK;

    private static Block registerBreakerBlock(String name, TagKey<Block> blockTag, int delay) {
        return registerBlock(name, new LegacyBreakerBlock(blockTag, delay, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).destroyTime(1.5f).forceSolidOn().pushReaction(PushReaction.NORMAL).randomTicks()));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), block);
    }

    public static void init() {}

    static {
        ULTIMATE_BLOCK_BREAKER = registerBlock("ultimate_block_breaker", new BreakerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).destroyTime(1.5f).forceSolidOn().pushReaction(PushReaction.NORMAL).randomTicks()));
        WOOD_BREAKER_BLOCK = registerBreakerBlock("wood_breaker_block", ModBlockTags.WOOD_BREAKER, 11);
        STONE_BREAKER_BLOCK = registerBreakerBlock("stone_breaker_block", ModBlockTags.STONE_BREAKER,9);
        IRON_BREAKER_BLOCK = registerBreakerBlock("iron_breaker_block", ModBlockTags.IRON_BREAKER,7);
        GOLD_BREAKER_BLOCK = registerBreakerBlock("gold_breaker_block", ModBlockTags.GOLD_BREAKER,5);
        DIAMOND_BREAKER_BLOCK = registerBreakerBlock("diamond_breaker_block", ModBlockTags.DIAMOND_BREAKER,3);
        NETHERITE_BREAKER_BLOCK = registerBreakerBlock("netherite_breaker_block", ModBlockTags.NETHERITE_BREAKER,1);
    }
}
