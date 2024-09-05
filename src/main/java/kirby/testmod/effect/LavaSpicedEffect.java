package kirby.testmod.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

public class LavaSpicedEffect extends StatusEffect {
    protected LavaSpicedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (!target.isFireImmune()) {
            target.setOnFireFor(15);
            target.damage(target.getDamageSources().lava(), 15F);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public boolean isInstant() {
        return true;
    }
}
