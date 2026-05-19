import { BlockComponentTickEvent, CustomComponentParameters } from "@minecraft/server";
import { getNeighborUpdate } from "../utils.js";
import { BlockStateSuperset } from "@minecraft/vanilla-data";
const EXCLUDE = ["minecraft:bedrock"];

export interface BreakerBlockComponentOptions {}

export class BreakerBlockComponent {
  static typeId = "lpsm_breaker:breaker_block";
  poweredState: keyof BlockStateSuperset;

  constructor(poweredState = "breaker:powered") {
    this.poweredState = poweredState as keyof BlockStateSuperset;
    this.onTick = this.onTick.bind(this);
  }

  breakBlock(event: BlockComponentTickEvent, dir: string): void {
    var o;
    switch (dir) {
      case "up":
        o = event.block.below();
        break;
      case "down":
        o = event.block.above();
        break;
      case "north":
        o = event.block.south();
        break;
      case "south":
        o = event.block.north();
        break;
      case "east":
        o = event.block.west();
        break;
      case "west":
        o = event.block.east();
        break;
      default:
        return;
    }

    if (!o) return;
    const { x, y, z } = o.location;
    if (o.isAir || o.isLiquid || EXCLUDE.includes(o.typeId)) {
      event.dimension.runCommand(`setblock ${x} ${y} ${z} air destroy`);
    }
  }

  // EVENTS

  onTick(event: BlockComponentTickEvent, args: CustomComponentParameters): void {
    const options = args.params as BreakerBlockComponentOptions;
    const t = getNeighborUpdate(event);
    if (t) {
      const o = t.getRedstonePower();
      null != o && event.block.setPermutation(event.block.permutation.withState(this.poweredState, 0 != o));
    }
    if (!event.block.permutation.getState(this.poweredState)) return;
    const dir = event.block.permutation.getState("minecraft:facing_direction") as string;
    this.breakBlock(event, dir);
  }
}
