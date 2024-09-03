package kirby.testmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ScarletRotEffect extends StatusEffect {
    protected ScarletRotEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == CustomEffects.SCARLET_ROT) {
            entity.damage(entity.getDamageSources().magic(), 1.0F);
            if (entity.handSwinging == true) {
                entity.disablesShield();
            }
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == CustomEffects.SCARLET_ROT) {
            int i = 25 >> amplifier;
            return i > 0 ? duration % i == 0 : true;
        }
        return false;
    }
}
