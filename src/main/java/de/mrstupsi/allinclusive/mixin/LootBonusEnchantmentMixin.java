package de.mrstupsi.allinclusive.mixin;

import de.mrstupsi.allinclusive.item.MultiTool;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.LootBonusEnchantment;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootBonusEnchantment.class)
public class LootBonusEnchantmentMixin extends Enchantment {
    protected LootBonusEnchantmentMixin(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public boolean canEnchant(ItemStack is) {
        return super.canEnchant(is) || is.getItem() instanceof MultiTool;
    }
}