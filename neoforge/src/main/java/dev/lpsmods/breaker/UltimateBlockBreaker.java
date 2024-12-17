package dev.lpsmods.breaker;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class UltimateBlockBreaker {

    public UltimateBlockBreaker(IEventBus eventBus) {
        Bootstrap.init();

    }
}