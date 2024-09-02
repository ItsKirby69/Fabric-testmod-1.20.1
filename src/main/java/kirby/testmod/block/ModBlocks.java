package kirby.testmod.block;

import kirby.testmod.TestMod;
import kirby.testmod.block.custom.GildedLodestoneBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TEST_BLOCK = registerBlock("test_block", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.STONE)));
    public static final Block RAW_TEST_BLOCK = registerBlock("raw_test_block", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block GILDED_LODESTONE = registerBlock("gilded_lodestone", new GildedLodestoneBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE)
            .sounds(BlockSoundGroup.LODESTONE)
            .luminance(GildedLodestoneBlock::getLuminance)));

    //deco blocks :U
    public static final Block HALLOWED_BLOCK = registerBlock("hallowed_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block CHISELED_HALLOWED_BRICKS = registerBlock("chiseled_hallowed_bricks", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.METAL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for " + TestMod.MOD_ID);
    }
}
