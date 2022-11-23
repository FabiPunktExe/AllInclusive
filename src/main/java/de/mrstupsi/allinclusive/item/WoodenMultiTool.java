package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

public class WoodenMultiTool extends MultiTool {
    public static final WoodenMultiTool INSTANCE = new WoodenMultiTool();

    public WoodenMultiTool() {
        super(Tiers.WOOD, 4, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(Items.OAK_PLANKS));
    }
}