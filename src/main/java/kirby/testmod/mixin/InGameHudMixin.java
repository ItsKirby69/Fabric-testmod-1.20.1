package kirby.testmod.mixin;

import kirby.testmod.TestMod;
import kirby.testmod.effect.CustomEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Unique
    private static final Identifier SCARLET_HEARTS = new Identifier("testmod", "textures/gui/scarlet_hearts.png");
    @Unique
    private static final Identifier HOLY_HEARTS = new Identifier("testmod", "textures/gui/holy_hearts.png");

    @Inject(method = "drawHeart", at = @At("HEAD"), cancellable = true)
    private void testmod$drawCustomHeart(DrawContext context, InGameHud.HeartType type, int x, int y, int v, boolean blinking, boolean halfHeart, CallbackInfo ci) {
        if (!blinking && type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player && (player.hasStatusEffect(CustomEffects.SCARLET_ROT) || player.hasStatusEffect(CustomEffects.SCARLET_ROT))) {
            Identifier textureId;
            if (player.hasStatusEffect(CustomEffects.SCARLET_ROT)) {
                textureId = SCARLET_HEARTS;
            } else if (player.hasStatusEffect(CustomEffects.SCARLET_ROT)) {
                textureId = HOLY_HEARTS;
            } else {
                return;
            }
            context.drawTexture(textureId, x, y, halfHeart ? 9 : 0, v, 9, 9);
            ci.cancel();
        }
    }
}
