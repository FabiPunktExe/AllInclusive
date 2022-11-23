package de.mrstupsi.allinclusive.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public class SteelTier implements Tier {
    public static final SteelTier INSTANCE = new SteelTier();

    @Override
    public int getUses() {
        return 700;
    }

    @Override
    public float getSpeed() {
        return 7.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 2.0F;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 16;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(SteelIngot.INSTANCE);
    }
}