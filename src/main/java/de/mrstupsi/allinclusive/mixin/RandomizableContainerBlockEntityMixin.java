package de.mrstupsi.allinclusive.mixin;

import de.mrstupsi.allinclusive.item.Cursor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RandomizableContainerBlockEntity.class)
public abstract class RandomizableContainerBlockEntityMixin extends BaseContainerBlockEntityMixin {
    @Inject(at = @At("RETURN"), method = "stillValid", cancellable = true)
    public void stillValid(Player p, CallbackInfoReturnable<Boolean> cir) {
        if (Cursor.INTERACTED_POSITIONS.containsKey(p)) {
            BlockPos pos = Cursor.INTERACTED_POSITIONS.get(p);
            if (pos.getX() == getBlockPos().getX() &&
                pos.getY() == getBlockPos().getY() &&
                pos.getZ() == getBlockPos().getZ()) {
                cir.setReturnValue(true);
            }
        }
    }
}