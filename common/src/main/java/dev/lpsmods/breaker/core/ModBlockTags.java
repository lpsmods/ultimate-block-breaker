package dev.lpsmods.breaker.core;


import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> WOOD_BREAKER = of("wood_breaker");
    public static final TagKey<Block> STONE_BREAKER = of("stone_breaker");
    public static final TagKey<Block> IRON_BREAKER = of("iron_breaker");
    public static final TagKey<Block> GOLD_BREAKER = of("gold_breaker");
    public static final TagKey<Block> DIAMOND_BREAKER = of("diamond_breaker");
    public static final TagKey<Block> NETHERITE_BREAKER = of("netherite_breaker");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(UltimateBlockBreaker.MOD_ID, id));
    }
}
