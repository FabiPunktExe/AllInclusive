package de.mrstupsi.allinclusive.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

public class GravityArmorMaterial implements ArmorMaterial {
    public static final GravityArmorMaterial INSTANCE = new GravityArmorMaterial();

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return ArmorMaterials.IRON.getDurabilityForSlot(slot);
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return ArmorMaterials.IRON.getDefenseForSlot(slot);
    }

    @Override
    public int getEnchantmentValue() {
        return ArmorMaterials.IRON.getEnchantmentValue();
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.IRON.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return ArmorMaterials.IRON.getRepairIngredient();
    }

    @Override
    public String getName() {
        return "allinclusive:gravity";
    }

    @Override
    public float getToughness() {
        return ArmorMaterials.IRON.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return ArmorMaterials.IRON.getKnockbackResistance();
    }
}