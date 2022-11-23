package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.AxeItem;

public class SteelMultiTool extends MultiTool {
    public static final SteelMultiTool INSTANCE = new SteelMultiTool();

    public SteelMultiTool() {
        super(SteelTier.INSTANCE, 7, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}