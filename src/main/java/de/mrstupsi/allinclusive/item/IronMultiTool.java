package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

public class IronMultiTool extends MultiTool {
    public static final IronMultiTool INSTANCE = new IronMultiTool();

    public IronMultiTool() {
        super(Tiers.IRON, 6, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(Items.IRON_INGOT));
    }
}