package kirby.testmod.effect;

import kirby.testmod.TestMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomEffects {
    //holy, scarlet rot, fire immunity (+ gives speed on heated blocks), bleed.
    public static StatusEffect HOLY;
    public static StatusEffect SCARLET_ROT;

    public static StatusEffect registerHolyEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestMod.MOD_ID, name),
                new HolyEffect(StatusEffectCategory.BENEFICIAL, 9520880));
    }

    public static StatusEffect registerScarletRotEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestMod.MOD_ID, name),
                new ScarletRotEffect(StatusEffectCategory.HARMFUL, 8889187));
    }

    public static void registerEffects(){
        HOLY = registerHolyEffect("holy");
        SCARLET_ROT = registerScarletRotEffect("scarlet_rot");
    }
}
