package kirby.testmod.item.custom;

import kirby.testmod.item.ModItems;
import kirby.testmod.potion.ModPotions;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class AmethystBottleItem extends Item {
    public AmethystBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
            BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
            if (blockHitResult.getType() == HitResult.Type.MISS) {
                return TypedActionResult.pass(itemStack);
            } else {
                if (blockHitResult.getType() == HitResult.Type.BLOCK) {
                    BlockPos blockPos = blockHitResult.getBlockPos();
                    if (!world.canPlayerModifyAt(user, blockPos)) {
                        return TypedActionResult.pass(itemStack);
                    }
                    ItemStack lavaPotion = new ItemStack(Items.POTION);
                    PotionUtil.setPotion(lavaPotion, ModPotions.LAVA_POTION);

                    //TODO Amethyst bottles need to properly get the lava potion. and also work in cauldrons | WORKING
                    if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                        world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                        return TypedActionResult.success(this.fill(itemStack, user, new ItemStack(Items.EXPERIENCE_BOTTLE)), world.isClient());
                    } else if (world.getFluidState(blockPos).isIn(FluidTags.LAVA)) {
                        world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                        world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                        return TypedActionResult.success(this.fill(itemStack, user, lavaPotion), world.isClient());
                    } else if (world.getBlockState(blockPos).isOf(Blocks.LAVA_CAULDRON)) {
                        world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        return TypedActionResult.success(this.fill(itemStack, user, lavaPotion), world.isClient());
                    }
                }

                return TypedActionResult.pass(itemStack);
            }
    }

    protected ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }
}
