package kirby.testmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GildedLodestoneBlock extends Block {
    public GildedLodestoneBlock(Settings settings) {
        super(settings);
        // Set the default state of the block to be deactivated.
        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            // Skip if the player isn't allowed to modify the world.
            return ActionResult.PASS;
        } else {
            // Get the current value of the "activated" property
            boolean activated = state.get(ACTIVATED);

            // Flip the value of activated and save the new blockstate.
            world.setBlockState(pos, state.with(ACTIVATED, !activated));

            // Play a click sound to emphasise the interaction.
            world.playSound(player, pos, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.SUCCESS;
        }
    }

    public static int getLuminance(BlockState currentBlockState) {
        // Get the value of the "activated" property.
        boolean activated = currentBlockState.get(GildedLodestoneBlock.ACTIVATED);

        // Return a light level if activated = true
        return activated ? 15 : 0;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }



}
