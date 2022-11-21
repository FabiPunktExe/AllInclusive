package de.mrstupsi.allinclusive.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class SteelArmorMaterial implements ArmorMaterial {
    public static final SteelArmorMaterial INSTANCE = new SteelArmorMaterial();
    private static final int[] HEALTH_PER_SLOT = new int[] {13, 15, 16, 11};
    private final int[] slotProtections = new int[] {3, 5, 7, 3};

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return HEALTH_PER_SLOT[slot.getIndex()] * 22;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return slotProtections[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(SteelIngot.INSTANCE);
    }

    @Override
    public String getName() {
        return "allinclusive:steel";
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}