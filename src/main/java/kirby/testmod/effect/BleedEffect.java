package kirby.testmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedEffect extends StatusEffect {
    protected BleedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == CustomEffects.BLEED) {
            if (entity.getArmor() > 15F) {
                entity.damage(entity.getDamageSources().magic(), 1.0F);
            } else if (entity.getArmor() <= 15F){
                entity.damage(entity.getDamageSources().magic(), 2.0F);
            }
            entity.damage(entity.getDamageSources().magic(), 1.0F);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == CustomEffects.BLEED) {
            int i = 70 >> amplifier;
            return i > 0 ? duration % i == 0 : true;
        }
        return false;
    }
}
