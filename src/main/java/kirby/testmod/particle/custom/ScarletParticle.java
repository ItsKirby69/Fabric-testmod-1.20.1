package kirby.testmod.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

public class ScarletParticle extends AscendingParticle {

    protected ScarletParticle(ClientWorld level, double x, double y, double z, double xd, double yd, double zd, float scaleMultiplier, SpriteProvider spriteSet) {
        super(level, x, y, z, 0.1f, 0.1f, 0.1f, xd, yd, zd, scaleMultiplier, spriteSet, 0.0f, 8, -0.25f, true);

        this.velocityMultiplier = 0.6f;
        this.setPos(x,y,z);
        this.velocityX = xd + (random.nextDouble() * 0.06 - 0.01);
        this.velocityY = yd + (random.nextDouble() * 0.06 - 0.1);
        this.velocityZ = zd + (random.nextDouble() * 0.06 - 0.01);
        //this.scale *= 0.75F;
        this.maxAge = 20 + this.random.nextInt(12);
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.setBoundingBox(this.getBoundingBox().offset(dx, dy, dz));
        this.repositionFromBoundingBox();
    }

    @Override
    public float getSize(float tickDelta) {
        float f = ((float)this.age + tickDelta) / (float)this.maxAge;
        return this.scale * (1.0F - f * f * 0.1f);
    }

    @Override
    public int getBrightness(float tint) {
        float f = ((float)this.age + tint) / (float)this.maxAge;
        f = MathHelper.clamp(f, 0.0F, 0.8F);
        int i = super.getBrightness(tint);
        int j = i & 0xFF;
        int k = i >> 16 & 0xFF;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }
        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new ScarletParticle(level, x, y, z, velocityX, velocityY, velocityZ, 1.2f, this.sprites);
        }
    }
}
