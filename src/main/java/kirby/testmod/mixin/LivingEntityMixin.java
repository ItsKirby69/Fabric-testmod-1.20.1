package kirby.testmod.mixin;

import kirby.testmod.effect.CustomEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.isIn(DamageTypeTags.IS_FREEZING) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.HOLY)) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.isOf(DamageTypes.WITHER) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.HOLY)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
