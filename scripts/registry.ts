import { BlockComponentRegistry, ItemComponentRegistry } from "@minecraft/server";
import { BreakerBlockComponent } from "./block/breaker_block.js";
import { BreakerUpgradeComponent } from "./item/upgrade.js";
import { AddonUtils, GuideBookComponent } from "@lpsmods/mc-utils";
import { pages } from "./guide/main.js";

export function registerBlockComponents(reg: BlockComponentRegistry): void {
  reg.registerCustomComponent("breaker:breaker_block", new BreakerBlockComponent());
}

export function registerItemComponents(reg: ItemComponentRegistry): void {
  const id = AddonUtils.makeId("guide_book");
  reg.registerCustomComponent(id, new GuideBookComponent(pages));
  GuideBookComponent.setup(id);

  reg.registerCustomComponent(
    "breaker:stone_upgrade",
    new BreakerUpgradeComponent().addBlock("breaker:wooden_block_breaker", "breaker:stone_block_breaker"),
  );
  reg.registerCustomComponent(
    "breaker:iron_upgrade",
    new BreakerUpgradeComponent().addBlock("breaker:stone_block_breaker", "breaker:iron_block_breaker"),
  );
  reg.registerCustomComponent(
    "breaker:gold_upgrade",
    new BreakerUpgradeComponent().addBlock("breaker:iron_block_breaker", "breaker:gold_block_breaker"),
  );
  reg.registerCustomComponent(
    "breaker:diamond_upgrade",
    new BreakerUpgradeComponent().addBlock("breaker:gold_block_breaker", "breaker:diamond_block_breaker"),
  );
  reg.registerCustomComponent(
    "breaker:netherite_upgrade",
    new BreakerUpgradeComponent().addBlock("breaker:diamond_block_breaker", "breaker:netherite_block_breaker"),
  );
}
