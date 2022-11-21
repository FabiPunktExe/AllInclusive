package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.HoeItem;

public class SteelHoe extends HoeItem {
    public static final SteelHoe INSTANCE = new SteelHoe();

    public SteelHoe() {
        super(SteelTier.INSTANCE, -2, -1.0F, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}