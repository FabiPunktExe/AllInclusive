package de.mrstupsi.allinclusive.block;

import de.mrstupsi.allinclusive.AllInclusive;
import de.mrstupsi.allinclusive.item.SteelIngot;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class IceMaker extends Block {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 16);
    public static final IceMaker INSTANCE = new IceMaker();
    public static final BlockItem ITEM = new BlockItem(INSTANCE, new Item.Properties().tab(AllInclusive.TAB));

    public IceMaker() {
        super(Properties.of(Material.STONE).randomTicks().strength(1.0F).sound(SoundType.METAL));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(STAGE) >= 1 && state.getValue(STAGE) < 16) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, state.getValue(STAGE) + 1));
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        state = world.getBlockState(pos);
        ItemStack item = player.getItemInHand(hand);
        if (state.getValue(STAGE) == 0 && item.getItem() == Items.WATER_BUCKET) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, 1));
            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
            return InteractionResult.SUCCESS;
        } else if (state.getValue(STAGE) >= 1 &&
                   state.getValue(STAGE) < 16 && item.getItem() == Items.BUCKET) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, 0));
            item.shrink(1);
            player.setItemInHand(hand, item);
            player.addItem(new ItemStack(Items.WATER_BUCKET));
            return InteractionResult.SUCCESS;
        } else if (state.getValue(STAGE) == 16) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, 0));
            world.addFreshEntity(
                    new ItemEntity(
                            world,
                            pos.getX() + 0.5F,
                            pos.getY() + 1.0F,
                            pos.getZ() + 0.5F,
                            new ItemStack(Items.ICE)
                    )
            );
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }
}