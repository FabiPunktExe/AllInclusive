package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class SteelHelmet extends ArmorItem {
    public static final SteelHelmet INSTANCE = new SteelHelmet();

    public SteelHelmet() {
        super(SteelArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}