package kirby.testmod.particle;

import kirby.testmod.TestMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType SCARLET_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLEED_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(TestMod.MOD_ID, "scarlet_particle"), SCARLET_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(TestMod.MOD_ID, "bleed_particle"), BLEED_PARTICLE);
    }
}
