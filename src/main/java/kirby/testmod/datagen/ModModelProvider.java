package kirby.testmod.datagen;

import kirby.testmod.block.ModBlocks;
import kirby.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(ModBlocks.TEST_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.RAW_TEST_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.CHISELED_HALLOWED_BRICKS, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHECKERED_HALLOWED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HALLOWED_BLOCK);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SCARLET_ROSE, ModBlocks.POTTED_SCARLET_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DUNGEON_KEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODSTONE_KEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.FINGER, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMYTHYLL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYONITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GILDED_MAGNUS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGNUS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.IGNUS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HALLOW_GOLD_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_BOTTLE, Models.GENERATED);


        itemModelGenerator.registerArmor((ArmorItem) ModItems.HALLOWED_GOLD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HALLOWED_GOLD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HALLOWED_GOLD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HALLOWED_GOLD_BOOTS);

//        itemModelGenerator.register(ModItems.LAVA_POTION, Models.GENERATED);
//        itemModelGenerator.register(ModItems.AMETHYST_POTION, Models.GENERATED);
//        itemModelGenerator.register(ModItems.AMETHYST_DRAGON_BREATH, Models.GENERATED);

    }
}
