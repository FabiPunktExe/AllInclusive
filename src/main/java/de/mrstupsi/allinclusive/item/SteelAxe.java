package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.AxeItem;

public class SteelAxe extends AxeItem {
    public static final SteelAxe INSTANCE = new SteelAxe();

    public SteelAxe() {
        super(SteelTier.INSTANCE, 6, -3.1F, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}