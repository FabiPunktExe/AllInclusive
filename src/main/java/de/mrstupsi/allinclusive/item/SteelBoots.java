package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class SteelBoots extends ArmorItem {
    public static final SteelBoots INSTANCE = new SteelBoots();

    public SteelBoots() {
        super(SteelArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}