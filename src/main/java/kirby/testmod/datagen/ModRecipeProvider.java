package kirby.testmod.datagen;

import kirby.testmod.block.ModBlocks;
import kirby.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> TEST_BURNABLE = List.of(ModBlocks.TEST_BLOCK, ModBlocks.RAW_TEST_BLOCK);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, TEST_BURNABLE, RecipeCategory.MISC, ModItems.FINGER,
                0.7f, 200, "dungeon_keys");
        offerBlasting(exporter, TEST_BURNABLE, RecipeCategory.MISC, ModItems.FINGER,
                0.7f, 100, "dungeon_keys");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.HALLOW_GOLD_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.HALLOWED_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DUNGEON_KEY, 1)
                .pattern(" C ")
                .pattern("C#C")
                .pattern(" S ")
                .input('C', Items.COBBLESTONE)
                .input('S', Items.OAK_PLANKS)
                .input('#', Items.CHISELED_STONE_BRICKS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DUNGEON_KEY)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WOODSTONE_KEY, 1)
                .pattern(" # ")
                .pattern("CSC")
                .pattern(" S ")
                .input('C', Items.COBBLESTONE)
                .input('S', Items.STICK)
                .input('#', Items.STONE_BRICKS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WOODSTONE_KEY)));
    }
}
