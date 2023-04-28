package net.max.projectx.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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
        if (state.isIn(BlockTags.LOGS)) {
            // If the player's main hand is empty, prevent breaking the block
            if (((PlayerEntity) (Object) this).getMainHandStack().isEmpty()) {
                cir.setReturnValue(false);
            }
        }
    }
}
