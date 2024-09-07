package kirby.testmod.effect.custom;

import kirby.testmod.TestMod;
import kirby.testmod.effect.CustomEffects;
import kirby.testmod.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class BleedEffect extends StatusEffect {
    public BleedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();

        if (world.isClient()) {
            for (int i = 0; i < 10; i++) {
                double x = entity.getX() + (world.random.nextDouble() * -world.random.nextDouble()) * 1.0;
                double y = entity.getY() + world.random.nextDouble() * entity.getHeight();
                double z = entity.getZ() + (world.random.nextDouble() * -world.random.nextDouble()) * 1.0;

                world.addParticle(ModParticles.SCARLET_PARTICLE, x, y, z, 0.0, 0.0, 0.0); // Replace with custom particle if desired
            }
        } else {
            float damageAmountFinal = 3.0F;
            if (this == CustomEffects.BLEED) {
                if (entity.getArmor() >= 15F) {
                    damageAmountFinal -= 2F;
                } else if (entity.getArmor() < 15F) {
                    damageAmountFinal -= 0.5F;
                }
                //TODO remove after debug done
                TestMod.LOGGER.info("Armor amount when ticked: " + entity.getArmor());
                TestMod.LOGGER.info("Damage total: " + damageAmountFinal);
                entity.damage(entity.getDamageSources().magic(), damageAmountFinal);
            }
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
