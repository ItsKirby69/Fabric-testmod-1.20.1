package kirby.testmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HolyEffect extends StatusEffect {
    protected HolyEffect(StatusEffectCategory category, int color) {
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
            int i = 25 >> amplifier;
            return i > 0 ? duration % i == 0 : true;
        }
        return false;
    }
}
