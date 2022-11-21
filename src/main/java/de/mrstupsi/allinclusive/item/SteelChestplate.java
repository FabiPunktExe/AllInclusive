package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class SteelChestplate extends ArmorItem {
    public static final SteelChestplate INSTANCE = new SteelChestplate();

    public SteelChestplate() {
        super(SteelArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}