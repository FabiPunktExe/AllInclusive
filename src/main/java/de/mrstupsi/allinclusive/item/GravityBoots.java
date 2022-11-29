package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;

public class GravityBoots extends ArmorItem {
    public static final GravityBoots INSTANCE = new GravityBoots();

    public GravityBoots() {
        super(GravityArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Properties().tab(AllInclusive.TAB).craftRemainder(Items.IRON_INGOT));
    }
}