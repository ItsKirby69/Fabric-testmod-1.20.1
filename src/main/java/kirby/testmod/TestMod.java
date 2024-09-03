package kirby.testmod;

import kirby.testmod.block.ModBlocks;
import kirby.testmod.effect.CustomEffects;
import kirby.testmod.item.ModItemGroups;
import kirby.testmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		CustomEffects.registerEffects();
		LOGGER.info("Hello Fabric world!");
	}
}