package kirby.testmod;

import kirby.testmod.block.ModBlocks;
import kirby.testmod.particle.ModParticles;
import kirby.testmod.particle.custom.ScarletParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SCARLET_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_SCARLET_ROSE, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(ModParticles.SCARLET_PARTICLE, ScarletParticle.Factory::new);
    }
}
