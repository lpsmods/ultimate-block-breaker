import { Block, BlockPermutation, CustomComponentParameters, ItemUseOnEvent } from "@minecraft/server";

export interface BreakerUpgradeComponentOptions {}

export class BreakerUpgradeComponent {
  static typeId = "lpsm_breaker:breaker_upgrade";
  private blocks = new Map<string, string>();

  constructor() {
    this.onUseOn = this.onUseOn.bind(this);
  }

  upgrade(block: Block, blockName: string): void {
    block.setPermutation(BlockPermutation.resolve(blockName, block.permutation.getAllStates()));
  }

  addBlock(oldBlockName: string, newBlockName: string): BreakerUpgradeComponent {
    this.blocks.set(oldBlockName, newBlockName);
    return this;
  }

  // EVENTS

  onUseOn(event: ItemUseOnEvent, args: CustomComponentParameters): void {
    const options = args.params as BreakerUpgradeComponentOptions;
    for (const blockName of this.blocks.keys())
      if (event.block.matches(blockName)) {
        const e = this.blocks.get(blockName);
        if (!e) continue;
        event.block.dimension.playSound("dig.metal", event.block.location);
        this.upgrade(event.block, e);
        return;
      }
  }
}
