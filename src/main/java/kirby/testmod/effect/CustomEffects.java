package kirby.testmod.effect;

import kirby.testmod.TestMod;
import kirby.testmod.effect.custom.BleedEffect;
import kirby.testmod.effect.custom.HolyEffect;
import kirby.testmod.effect.custom.LavaSpicedEffect;
import kirby.testmod.effect.custom.ScarletRotEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomEffects {
    //holy, scarlet rot, fire immunity (+ gives speed on heated blocks), bleed.
    //TODO effects with attribute modifiers might need a unique id?
    public static StatusEffect HOLY;
    public static StatusEffect SCARLET_ROT;
    public static StatusEffect BLEED;
    public static StatusEffect LAVA_SPICED;

    public static StatusEffect registerHolyEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestMod.MOD_ID, name),
                new HolyEffect(StatusEffectCategory.BENEFICIAL, 16644511)
                        .addAttributeModifier(EntityAttributes.GENERIC_LUCK, "55FCED67-E92A-486E-9800-B47F202C4386",
                        1.25F, EntityAttributeModifier.Operation.ADDITION));
    }

    public static StatusEffect registerScarletRotEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestMod.MOD_ID, name),
                new ScarletRotEffect(StatusEffectCategory.HARMFUL, 16728064)
                        .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "55FCED67-E92A-486E-9800-B47F202C4386",
                                -0.25F, EntityAttributeModifier.Operation.MULTIPLY_BASE));
    }

    public static StatusEffect registerBleedEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestMod.MOD_ID, name),
                new BleedEffect(StatusEffectCategory.HARMFUL, 10485760));
    }

    public static StatusEffect registerLavaSpicedEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestMod.MOD_ID, name),
                new LavaSpicedEffect(StatusEffectCategory.HARMFUL, 16740608));
    }

    public static void registerEffects(){
        TestMod.LOGGER.info("Registering CustomEffects for " + TestMod.MOD_ID);

        HOLY = registerHolyEffect("holy");
        SCARLET_ROT = registerScarletRotEffect("scarlet_rot");
        BLEED = registerBleedEffect("bleed");
        LAVA_SPICED = registerLavaSpicedEffect("lava_spiced");
    }
}
