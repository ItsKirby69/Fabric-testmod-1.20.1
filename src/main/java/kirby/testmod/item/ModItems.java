package kirby.testmod.item;

import kirby.testmod.TestMod;
import kirby.testmod.item.custom.DungeonKeyItem;
import kirby.testmod.item.custom.HallowedGoldIngotItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.EnchantedGoldenAppleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DUNGEON_KEY = registerItem("dungeon_key", new Item(new FabricItemSettings()));
    public static final Item WOODSTONE_KEY = registerItem("woodstone_key", new Item(new FabricItemSettings()));

    public static final Item FINGER = registerItem("finger", new DungeonKeyItem(new FabricItemSettings()));

    public static final Item HALLOW_GOLD_INGOT = registerItem("hallow_gold_ingot", new HallowedGoldIngotItem(new FabricItemSettings()));
    public static final Item IGNUS_INGOT = registerItem("ignus_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item AMYTHYLL_INGOT = registerItem("amythyll_ingot", new Item(new FabricItemSettings()));
    public static final Item MAGNUS_INGOT = registerItem("magnus_ingot", new Item(new FabricItemSettings()));
    public static final Item GILDED_MAGNUS_INGOT = registerItem("gilded_magnus_ingot", new Item(new FabricItemSettings()));
    public static final Item CRYONITE_INGOT = registerItem("cryonite_ingot", new Item(new FabricItemSettings()));


    //Add items to the ingredients group tab for some reason?
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        //entries.add(DUNGEON_KEY);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TestMod.LOGGER.info("Registering ModItems for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
