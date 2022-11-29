package de.mrstupsi.allinclusive.block;

import de.mrstupsi.allinclusive.AllInclusive;
import de.mrstupsi.allinclusive.item.Cheese;
import de.mrstupsi.allinclusive.item.GravityBoots;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Graviator extends Block implements EntityBlock {
    public static final Graviator INSTANCE = new Graviator();
    public static final BlockItem ITEM = new BlockItem(INSTANCE, new Item.Properties().tab(AllInclusive.TAB));

    public Graviator() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().randomTicks().strength(3.5F).sound(SoundType.STONE));
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GraviatorBlockEntity.TYPE.create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return (world2, pos2, state2, t) -> {
            if (t instanceof GraviatorBlockEntity) {
                ((GraviatorBlockEntity) t).tick(world2, pos2);
            }
        };
    }

    public static class GraviatorBlockEntity extends BlockEntity {
        public static final BlockEntityType<GraviatorBlockEntity> TYPE = BlockEntityType.Builder.of(GraviatorBlockEntity::new, INSTANCE).build(null);
        public GraviatorBlockEntity(BlockPos pos, BlockState state) {
            super(TYPE, pos, state);
        }

        public void tick(Level world, BlockPos pos) {
            Vec3 posVec = new Vec3(
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5
            );
            for (Entity e : world.getEntitiesOfClass(
                    Entity.class,
                    new AABB(
                            pos.offset(-7.5, -7.5, -7.5),
                            pos.offset(8.5, 8.5, 8.5)
                    ),
                    e -> e.position().distanceTo(posVec) <= 10.0
            )) {
                if (e instanceof Player) {
                    ItemStack boots = ((Player) e).getItemBySlot(EquipmentSlot.FEET);
                    if (boots != null && boots.getItem() == GravityBoots.INSTANCE) {
                        continue;
                    }
                }
                double strength = 0.2 / 10.0 * (10.0 - e.position().distanceTo(posVec));
                e.setDeltaMovement(e.getDeltaMovement().add(0, strength, 0));
            }
        }
    }
}