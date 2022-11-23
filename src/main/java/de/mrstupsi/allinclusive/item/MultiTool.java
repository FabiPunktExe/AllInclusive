package de.mrstupsi.allinclusive.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class MultiTool extends TieredItem {
    private float speed;
    private float attackDamageBaseline;
    private Multimap<Attribute, AttributeModifier> defaultModifiers;

    public MultiTool(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, properties);
        this.speed = tier.getSpeed();
        this.attackDamageBaseline = attackDamage + tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", attackDamageBaseline, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
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
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
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