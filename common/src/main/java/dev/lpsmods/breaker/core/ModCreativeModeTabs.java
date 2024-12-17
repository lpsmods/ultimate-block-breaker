package dev.lpsmods.breaker.core;

import dev.lpsmods.breaker.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab MAIN;

    private static CreativeModeTab registerTab(String name, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), tab);
    }

    public static void init() {}

    static {
        MAIN = registerTab("breaker", CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("itemGroup."+Constants.MOD_ID)).icon(() -> {
            return new ItemStack(ModItems.DIAMOND_BREAKER_BLOCK);
        }).displayItems((CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output out) -> {
            out.accept(ModItems.ULTIMATE_BLOCK_BREAKER);
            out.accept(ModItems.WOOD_BREAKER_BLOCK);
            out.accept(ModItems.STONE_BREAKER_BLOCK);
            out.accept(ModItems.IRON_BREAKER_BLOCK);
            out.accept(ModItems.GOLD_BREAKER_BLOCK);
            out.accept(ModItems.DIAMOND_BREAKER_BLOCK);
            out.accept(ModItems.NETHERITE_BREAKER_BLOCK);
        }).build());
    }
}
