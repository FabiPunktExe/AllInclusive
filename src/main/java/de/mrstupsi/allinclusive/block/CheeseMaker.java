package de.mrstupsi.allinclusive.block;

import de.mrstupsi.allinclusive.AllInclusive;
import de.mrstupsi.allinclusive.item.Cheese;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class CheeseMaker extends Block {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 4);
    public static final CheeseMaker INSTANCE = new CheeseMaker();
    public static final BlockItem ITEM = new BlockItem(INSTANCE, new Item.Properties().tab(AllInclusive.TAB));

    public CheeseMaker() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().randomTicks().strength(3.5F).sound(SoundType.STONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(STAGE) >= 1 && state.getValue(STAGE) < 4 &&
            random.nextInt(4) == 0) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, state.getValue(STAGE) + 1));
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        state = world.getBlockState(pos);
        ItemStack item = player.getItemInHand(hand);
        if (state.getValue(STAGE) == 0 && item.getItem() == Items.MILK_BUCKET) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, 1));
            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
            return InteractionResult.SUCCESS;
        } else if (state.getValue(STAGE) >= 1 &&
                   state.getValue(STAGE) < 4 && item.getItem() == Items.BUCKET) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, 0));
            item.shrink(1);
            player.setItemInHand(hand, item);
            player.addItem(new ItemStack(Items.MILK_BUCKET));
            return InteractionResult.SUCCESS;
        } else if (state.getValue(STAGE) == 4) {
            world.setBlockAndUpdate(pos, state.setValue(STAGE, 0));
            for (int i = 0; i < 1 + world.random.nextInt(3); i++) {
                world.addFreshEntity(
                        new ItemEntity(
                                world,
                                pos.getX() + 0.5F,
                                pos.getY() + 1.0F,
                                pos.getZ() + 0.5F,
                                new ItemStack(Cheese.INSTANCE)
                        )
                );
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }
}