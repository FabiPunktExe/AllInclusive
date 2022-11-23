package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.Tiers;

public class NetheriteMultiTool extends MultiTool {
    public static final NetheriteMultiTool INSTANCE = new NetheriteMultiTool();

    public NetheriteMultiTool() {
        super(Tiers.NETHERITE, 8, -2.4F, new Properties().tab(AllInclusive.TAB));
    }
}