package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

public class DiamondMultiTool extends MultiTool {
    public static final DiamondMultiTool INSTANCE = new DiamondMultiTool();

    public DiamondMultiTool() {
        super(Tiers.DIAMOND, 7, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(Items.DIAMOND));
    }
}