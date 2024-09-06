package kirby.testmod.datagen;

import kirby.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TEST_BLOCK);
        addDrop(ModBlocks.RAW_TEST_BLOCK);
        addDrop(ModBlocks.CHISELED_HALLOWED_BRICKS);
        addDrop(ModBlocks.CHECKERED_HALLOWED_BRICKS);
        addDrop(ModBlocks.HALLOWED_BLOCK);

        addDrop(ModBlocks.SCARLET_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_SCARLET_ROSE);


        addDrop(ModBlocks.GILDED_LODESTONE, copperLikeOreDrops(ModBlocks.GILDED_LODESTONE, Items.LODESTONE, 5.0f, 10.0f));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, Float min, Float max) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
