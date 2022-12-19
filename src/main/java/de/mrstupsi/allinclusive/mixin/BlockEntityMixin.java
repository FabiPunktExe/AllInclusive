package de.mrstupsi.allinclusive.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockEntity.class)
public abstract class BlockEntityMixin {
    @Shadow public abstract BlockPos getBlockPos();

    @Shadow @Final protected BlockPos worldPosition;
}