package kirby.testmod.item.custom;

import kirby.testmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.swing.*;

public class HallowedGoldIngotItem extends Item {
    public HallowedGoldIngotItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        if (!world.getBlockState(blockPos).isOf(ModBlocks.GILDED_LODESTONE)) {
            return super.useOnBlock(context);
        } else {
            world.playSound(null, blockPos, SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, 2.0F);
            PlayerEntity playerEntity = context.getPlayer();
            ItemStack itemStack = context.getStack();
            if (!playerEntity.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            ItemStack itemStack2 = new ItemStack(Items.LAPIS_BLOCK, 3);

            if (!playerEntity.getInventory().insertStack(itemStack2)) {
                playerEntity.dropItem(itemStack2, false);
            }
        }

        return ActionResult.success(world.isClient);
    }

}
