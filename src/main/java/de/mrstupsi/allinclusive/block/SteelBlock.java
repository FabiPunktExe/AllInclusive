package de.mrstupsi.allinclusive.block;

import de.mrstupsi.allinclusive.AllInclusive;
import de.mrstupsi.allinclusive.item.SteelIngot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class SteelBlock extends Block {
    public static final SteelBlock INSTANCE = new SteelBlock();
    public static final BlockItem ITEM = new BlockItem(INSTANCE, new Item.Properties().tab(AllInclusive.TAB).craftRemainder(SteelIngot.INSTANCE));

    public SteelBlock() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));
    }
}