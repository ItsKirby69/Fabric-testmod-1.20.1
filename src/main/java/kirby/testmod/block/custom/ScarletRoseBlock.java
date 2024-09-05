package kirby.testmod.block.custom;

import kirby.testmod.effect.CustomEffects;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class ScarletRoseBlock extends FlowerBlock {
    public ScarletRoseBlock(StatusEffect effect, AbstractBlock.Settings settings) {
        super(effect, 8, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || floor.isOf(Blocks.MAGMA_BLOCK) || floor.isOf(Blocks.BEE_NEST) || floor.isOf(Blocks.CARVED_PUMPKIN) || floor.isOf(Blocks.JACK_O_LANTERN) || floor.isOf(Blocks.SCULK) || floor.isOf(Blocks.SCULK_CATALYST);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = (double)pos.getX() + vec3d.x;
        double e = (double)pos.getZ() + vec3d.z;

        for (int i = 0; i < 3; i++) {
            if (random.nextBoolean()) {
                world.addParticle(
                        ParticleTypes.ENCHANT, d + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0
                );
            }
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity livingEntity && !livingEntity.isInvulnerableTo(world.getDamageSources().wither())) {
                livingEntity.addStatusEffect(new StatusEffectInstance(CustomEffects.SCARLET_ROT, 60));
            }
        }
    }
}
