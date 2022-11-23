package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

public class StoneMultiTool extends MultiTool {
    public static final StoneMultiTool INSTANCE = new StoneMultiTool();

    public StoneMultiTool() {
        super(Tiers.STONE, 5, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(Items.COBBLESTONE));
    }
}