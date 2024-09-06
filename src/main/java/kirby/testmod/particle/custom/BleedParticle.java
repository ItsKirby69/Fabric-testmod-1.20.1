package kirby.testmod.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

public class BleedParticle extends SpriteBillboardParticle {
    protected BleedParticle(ClientWorld level, double x, double y, double z, SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(level, x, y, z, xd, yd, zd);

        this.velocityMultiplier = 0.6f;
        this.setPos(x,y,z);
        this.velocityX = xd;
        this.velocityY = yd - 1f;
        this.velocityZ = zd;
        this.scale *= 0.75F;
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
        return this.scale * (1.0F - f * f * 0.5F);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new BleedParticle(level, x, y, z, this.sprites, velocityX, velocityY, velocityZ);
        }

    }

}
