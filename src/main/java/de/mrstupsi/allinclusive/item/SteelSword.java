package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.SwordItem;

public class SteelSword extends SwordItem {
    public static final SteelSword INSTANCE = new SteelSword();

    public SteelSword() {
        super(SteelTier.INSTANCE, 3, -2.4F, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}