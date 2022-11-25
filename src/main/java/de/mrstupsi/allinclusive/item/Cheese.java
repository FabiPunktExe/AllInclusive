package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Cheese extends Item {
    public static final Cheese INSTANCE = new Cheese();

    public Cheese() {
        super(new Properties().tab(AllInclusive.TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.2F).build()));
    }
}