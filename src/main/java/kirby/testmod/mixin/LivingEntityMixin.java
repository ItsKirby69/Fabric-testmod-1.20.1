package kirby.testmod.mixin;

import kirby.testmod.effect.CustomEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    //TODO revaluate how/what gives immunity and such | cannot put all types in one if statement cuz it breaks
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        //HOLY IMMUNITY
        if ((source.isIn(DamageTypeTags.IS_FREEZING) || source.isOf(DamageTypes.WITHER)) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.HOLY)) {
            cir.setReturnValue(false);
        }
        if (source.isOf(DamageTypes.ON_FIRE) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.SCARLET_ROT)) {
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 30, 3));
            cir.setReturnValue(false);
        } else if (source.isOf(DamageTypes.IN_FIRE) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.SCARLET_ROT)){
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 3));
            cir.setReturnValue(false);
        } else if (source.isOf(DamageTypes.LAVA) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.SCARLET_ROT)){
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 7));
            cir.setReturnValue(false);
        } else if (source.isIn(DamageTypeTags.IS_FIRE) && ((LivingEntity)(Object)this).hasStatusEffect(CustomEffects.SCARLET_ROT)){
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 3));
            cir.setReturnValue(false);
        }
    }
}
