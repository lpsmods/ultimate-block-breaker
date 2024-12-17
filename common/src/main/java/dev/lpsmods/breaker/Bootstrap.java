package dev.lpsmods.breaker;

import dev.lpsmods.breaker.core.ModBlocks;
import dev.lpsmods.breaker.core.ModCreativeModeTabs;
import dev.lpsmods.breaker.core.ModItems;

public class Bootstrap {
    public static void init() {
        ModBlocks.init();
        ModItems.init();
        ModCreativeModeTabs.init();
    }
}