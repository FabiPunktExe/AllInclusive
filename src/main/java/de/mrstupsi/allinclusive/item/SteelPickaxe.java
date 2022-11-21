package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.item.PickaxeItem;

public class SteelPickaxe extends PickaxeItem {
    public static final SteelPickaxe INSTANCE = new SteelPickaxe();

    public SteelPickaxe() {
        super(SteelTier.INSTANCE, 1, -2.8F, new Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));
    }
}