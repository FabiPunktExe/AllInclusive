package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

public class GoldenMultiTool extends MultiTool {
    public static final GoldenMultiTool INSTANCE = new GoldenMultiTool();

    public GoldenMultiTool() {
        super(Tiers.GOLD, 4, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(Items.GOLD_INGOT));
    }
}