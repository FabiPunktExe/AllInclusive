package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class SteelLeggings extends ArmorItem {
    public static final SteelLeggings INSTANCE = new SteelLeggings();

    public SteelLeggings() {
        super(SteelArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}