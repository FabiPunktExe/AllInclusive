package de.mrstupsi.allinclusive.block;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.material.Material;

public class DeepslateRandomite extends DropExperienceBlock {
    public static final DeepslateRandomite INSTANCE = new DeepslateRandomite();
    public static final BlockItem ITEM = new BlockItem(INSTANCE, new Item.Properties().tab(AllInclusive.TAB));

    public DeepslateRandomite() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 5));
    }
}