import { StartupEvent, system } from "@minecraft/server";
import { registerBlockComponents, registerItemComponents } from "./registry";
import { AddonUtils } from "@lpsmods/mc-utils";
import { PROJECT_ID } from "./constants";

AddonUtils.addonId = PROJECT_ID;

function startup(event: StartupEvent): void {
  registerBlockComponents(event.blockComponentRegistry);
  registerItemComponents(event.itemComponentRegistry);
}

system.beforeEvents.startup.subscribe(startup);
