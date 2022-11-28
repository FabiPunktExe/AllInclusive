package de.mrstupsi.allinclusive.block;

import com.google.common.collect.Lists;
import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class Randomite extends DropExperienceBlock {
    public static final Randomite INSTANCE = new Randomite();
    public static final BlockItem ITEM = new BlockItem(INSTANCE, new Item.Properties().tab(AllInclusive.TAB));
    public static final RegistryObject<ConfiguredFeature<?, ?>> RANDOMITE_CONFIGURED = AllInclusive.CONFIGURED_FEATURES.register(
            "randomite_configured",
            () -> new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreConfiguration(
                            List.of(
                                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, INSTANCE.defaultBlockState()),
                                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DeepslateRandomite.INSTANCE.defaultBlockState())
                            ),
                            8
                    )
            )
    );
    public static final PlacedFeature RANDOMITE_PLACED = new PlacedFeature(
            RANDOMITE_CONFIGURED.getHolder().get(),
            Lists.newArrayList(
                    CountPlacement.of(96),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()),
                    BiomeFilter.biome()
            )
    );

    public Randomite() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5));
    }
}