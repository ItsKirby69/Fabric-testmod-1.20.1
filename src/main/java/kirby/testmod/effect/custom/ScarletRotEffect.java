package kirby.testmod.effect.custom;

import kirby.testmod.effect.CustomEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ScarletRotEffect extends StatusEffect {
    //done, might make changes for armor changes in the customEffects class
    public ScarletRotEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == CustomEffects.SCARLET_ROT) {
            entity.damage(entity.getDamageSources().magic(), 1.0F);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == CustomEffects.SCARLET_ROT) {
            int i = 40 >> amplifier;
            return i > 0 ? duration % i == 0 : true;
        }

        return false;
    }
}
