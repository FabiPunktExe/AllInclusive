package de.mrstupsi.allinclusive.mixin;

import de.mrstupsi.allinclusive.item.MultiTool;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.UntouchingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(UntouchingEnchantment.class)
public class UntouchingEnchantmentMixin extends Enchantment {
    protected UntouchingEnchantmentMixin(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public boolean canEnchant(ItemStack is) {
        return super.canEnchant(is) || is.getItem() instanceof MultiTool;
    }
}