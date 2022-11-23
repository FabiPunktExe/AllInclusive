package de.mrstupsi.allinclusive.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class MultiTool extends SwordItem {
    private float speed;

    public MultiTool(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
        this.speed = tier.getSpeed();
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        return speed;
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity entity, LivingEntity attacker) {
        itemStack.hurtAndBreak(2, entity, breaker -> breaker.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level world, BlockState blockState, BlockPos pos, LivingEntity entity) {
        if (!world.isClientSide && blockState.getDestroySpeed(world, pos) != 0.0F) {
            itemStack.hurtAndBreak(1, entity, breaker -> breaker.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(getTier(), state);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) ||
               ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) ||
               ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) ||
               toolAction == ToolActions.SHOVEL_DIG ||
               ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}