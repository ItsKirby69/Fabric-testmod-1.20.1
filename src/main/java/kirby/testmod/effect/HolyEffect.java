package kirby.testmod.effect;

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
    protected HolyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == CustomEffects.HOLY) {
            if (entity.getHealth() < entity.getMaxHealth()) {
                entity.heal(0.5F);
            }
            //TODO make this more reliable because this relys on potion effect ticks. Look into pure immunity like fireImmunity. Look into deeper and darker's armor set immunity | WORKING WITH NEW MIXIN
//            if (entity.hasStatusEffect(StatusEffects.WITHER)) {
//                entity.removeStatusEffect(StatusEffects.WITHER);
//                entity.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, 1F, 1F);
//            } else if (entity.hasStatusEffect(StatusEffects.WEAKNESS)) {
//                entity.removeStatusEffect(StatusEffects.WEAKNESS);
//                entity.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, 1F, 1F);
//            } else if (entity.getRecentDamageSource().isIn(DamageTypeTags.IS_FIRE)) {
//                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED), null);
//            }
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == CustomEffects.HOLY) {
            int i = 25 >> amplifier;
            return i > 0 ? duration % i == 0 : true;
        }
        return false;
    }
}
