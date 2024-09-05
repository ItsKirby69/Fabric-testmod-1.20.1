package kirby.testmod.mixin;

import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;

//TODO cauldron rising and decreasing per amethyst bottle | WORKING, JUST NEED CUSTOM LAVA POTION TEXTURE
@Mixin(CauldronBehavior.class)
public class CauldronBehaviorMixin {
//    WATER_CAULDRON_BEHAVIOR.put(Items.GLASS_BOTTLE, (CauldronBehavior)(state, world, pos, player, hand, stack) -> {
//        if (!world.isClient) {
//            Item item = stack.getItem();
//            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
//            player.incrementStat(Stats.USE_CAULDRON);
//            player.incrementStat(Stats.USED.getOrCreateStat(item));
//            LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
//            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
//        }
//
//        return ActionResult.success(world.isClient);
//    });
}
