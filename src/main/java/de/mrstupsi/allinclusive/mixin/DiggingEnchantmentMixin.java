package de.mrstupsi.allinclusive.mixin;

import de.mrstupsi.allinclusive.item.MultiTool;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DiggingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DiggingEnchantment.class)
public class DiggingEnchantmentMixin {
    @Inject(at = @At(value = "RETURN"), method = "canEnchant", cancellable = true)
    public void canEnchant(ItemStack is, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || is.getItem() instanceof MultiTool);
    }
}