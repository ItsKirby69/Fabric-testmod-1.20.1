package kirby.testmod;

import kirby.testmod.block.ModBlocks;
import kirby.testmod.effect.CustomEffects;
import kirby.testmod.item.ModItemGroups;
import kirby.testmod.item.ModItems;
import kirby.testmod.particle.ModParticles;
import kirby.testmod.potion.ModPotions;
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
		CustomEffects.registerEffects();
		ModItems.registerModItems();
		ModPotions.registerPotions();
		ModParticles.registerParticles();
		LOGGER.info("Hello Fabric world!");
	}
}