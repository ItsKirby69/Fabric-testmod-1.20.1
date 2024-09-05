package kirby.testmod.item;

import kirby.testmod.TestMod;
import kirby.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DUNGEON_KEYS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "dungeon_key"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dungeon_keys"))
                    .icon(() -> new ItemStack(ModItems.DUNGEON_KEY)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.DUNGEON_KEY);
                        entries.add(ModItems.WOODSTONE_KEY);
                        entries.add(ModItems.FINGER);

                        entries.add(ModBlocks.TEST_BLOCK);
                        entries.add(ModBlocks.RAW_TEST_BLOCK);
                        entries.add(ModBlocks.GILDED_LODESTONE);

                        entries.add(ModBlocks.HALLOWED_BLOCK);
                        entries.add(ModBlocks.CHISELED_HALLOWED_BRICKS);

                        entries.add(ModItems.HALLOW_GOLD_INGOT);
                        entries.add(ModItems.IGNUS_INGOT);
                        entries.add(ModItems.AMYTHYLL_INGOT);
                        entries.add(ModItems.MAGNUS_INGOT);
                        entries.add(ModItems.GILDED_MAGNUS_INGOT);
                        entries.add(ModItems.CRYONITE_INGOT);

                        entries.add(ModItems.AMETHYST_BOTTLE);
                        //entries.add(ModItems.AMETHYST_DRAGON_BREATH);

                        entries.add(ModBlocks.SCARLET_ROSE);

                    })).build());
    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering ModItemGroups for " + TestMod.MOD_ID);
    }
}
