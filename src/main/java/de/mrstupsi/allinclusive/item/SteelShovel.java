package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

public class SteelShovel extends ShovelItem {
    public static final SteelShovel INSTANCE = new SteelShovel();

    public SteelShovel() {
        super(SteelTier.INSTANCE, 1.5F, -3.0F, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}