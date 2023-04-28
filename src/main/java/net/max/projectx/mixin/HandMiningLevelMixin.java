package net.max.projectx.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class HandMiningLevelMixin {
    @Inject(method = "canHarvest", at = @At("HEAD"), cancellable = true)
    public void restrictWoodenBlockBreakingByHand(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        // Check if the player is trying to break a wooden block
        if (state.isIn(BlockTags.LOGS)
                || state.isIn(BlockTags.PLANKS)
                || state.isIn(BlockTags.WOODEN_DOORS)
                || state.isIn(BlockTags.WOODEN_FENCES)
                || state.isIn(BlockTags.FENCE_GATES)
                || state.isIn(BlockTags.WOODEN_SLABS)
                || state.isIn(BlockTags.WOODEN_STAIRS)
                || state.isIn(BlockTags.WOODEN_TRAPDOORS))
        {
            // Check if the player is holding an axe item in their main hand
            ItemStack mainHandStack = ((PlayerEntity) (Object) this).getMainHandStack();
            if (mainHandStack.isEmpty() || !(mainHandStack.getItem() instanceof AxeItem)) {
                cir.setReturnValue(false);
            }
        }
    }
}
