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
        //HOLY IMMUNITY
        if (source.isIn(DamageTypeTags.IS_FREEZING) || (source.isOf(DamageTypes.WITHER) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.HOLY))) {
            cir.setReturnValue(false);
        } else if (source.isIn(DamageTypeTags.IS_FIRE) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.SCARLET_ROT)) {
            cir.setReturnValue(false);
        }
    }
}
