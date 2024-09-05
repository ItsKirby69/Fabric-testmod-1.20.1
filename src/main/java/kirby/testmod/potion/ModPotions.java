package kirby.testmod.potion;

import kirby.testmod.TestMod;
import kirby.testmod.effect.CustomEffects;
import kirby.testmod.item.ModItems;
import kirby.testmod.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModPotions {
    //public static RegistryKey<Potion> EMPTY_KEY = RegistryKey.of(RegistryKeys.POTION, new Identifier("empty"));
    //public static Potion AMETHYST_EMPTY;
    public static Potion AMETHYST_WATER_POTION;

    public static Potion HOLY_POTION;
    public static Potion LONG_HOLY_POTION;
    public static Potion BLEED_POTION;
    public static Potion LONG_BLEED_POTION;

    public static Potion LAVA_POTION;


    private static Potion register(String name, Potion potion){
        return Registry.register(Registries.POTION, new Identifier(TestMod.MOD_ID, name), potion);
    }
    private static Potion register(RegistryKey<Potion> key, Potion potion) {
        return Registry.register(Registries.POTION, key, potion);
    }

    public static void registerPotions(){
        //AMETHYST_EMPTY = register(ModPotions.EMPTY_KEY, new Potion());
        //AMETHYST_WATER_POTION = register("water", new Potion());
        //instants
        //TODO only register the drink lava pot
        LAVA_POTION = register("lava_potion", new Potion(new StatusEffectInstance(CustomEffects.LAVA_SPICED, 1)));

        //timed
        HOLY_POTION = register("holy_potion", new Potion(new StatusEffectInstance(CustomEffects.HOLY, 3600)));
        LONG_HOLY_POTION = register("long_holy_potion", new Potion("holy_potion", new StatusEffectInstance(CustomEffects.HOLY, 9600)));

        BLEED_POTION = register("bleed_potion", new Potion(new StatusEffectInstance(CustomEffects.BLEED, 3600)));
        LONG_BLEED_POTION = register("long_bleed_potion", new Potion("bleed_potion", new StatusEffectInstance(CustomEffects.BLEED, 9600)));

        registerPotionRecipes();
    }

    //TODO registerPotionRecipes first parameter from potion to item? potentially make a lava potion for the molten blaze potion just a food item instead of a potion?
    private static void registerPotionRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ModItems.FINGER, ModPotions.HOLY_POTION);
        //BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.LAVA_POTION, Items.BLAZE_POWDER, ModPotions.BLEED_POTION);
    }
}
