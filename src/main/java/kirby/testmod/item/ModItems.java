package kirby.testmod.item;

import kirby.testmod.TestMod;
import kirby.testmod.item.custom.DungeonKeyItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DUNGEON_KEY = registerItem("dungeon_key", new Item(new FabricItemSettings()));
    public static final Item WOODSTONE_KEY = registerItem("woodstone_key", new Item(new FabricItemSettings()));

    public static final Item FINGER = registerItem("finger", new DungeonKeyItem(new FabricItemSettings()));

    //Add items to the ingredients group tab
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        //entries.add(DUNGEON_KEY);
        //entries.add(WOODSTONE_KEY);

        //entries.add(FINGER);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TestMod.LOGGER.info("Registering ModItems for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
