package kirby.testmod.effect.custom;

import kirby.testmod.effect.CustomEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.loot.function.CopyNameLootFunction;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvents;

public class HolyEffect extends StatusEffect {
    //done, might make more immunities? maybe ask for how to buff it
    public HolyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == CustomEffects.HOLY) {
            if (entity.getHealth() < entity.getMaxHealth()) {
                entity.heal(0.5F);
            }
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == CustomEffects.HOLY) {
            int i = 30 >> amplifier;
            return i > 0 ? duration % i == 0 : true;
        }
        return false;
    }
}
