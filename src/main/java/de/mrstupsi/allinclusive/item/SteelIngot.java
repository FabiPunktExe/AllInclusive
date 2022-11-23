package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import de.mrstupsi.allinclusive.block.SteelBlock;
import net.minecraft.world.item.Item;

public class SteelIngot extends Item {
    public static final SteelIngot INSTANCE = new SteelIngot();

    public SteelIngot() {
        super(new Item.Properties().tab(AllInclusive.TAB));
    }
}