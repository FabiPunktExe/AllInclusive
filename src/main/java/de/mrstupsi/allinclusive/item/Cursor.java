package de.mrstupsi.allinclusive.item;

import de.mrstupsi.allinclusive.AllInclusive;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashMap;
import java.util.List;

public class Cursor extends Item {
    public static final Cursor INSTANCE = new Cursor();
    public static final HashMap<Player, BlockPos> INTERACTED_POSITIONS = new HashMap<>();

    public Cursor() {
        super(new Properties().tab(AllInclusive.TAB).craftRemainder(Items.WHITE_WOOL));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player p, InteractionHand hand) {
        ItemStack is = p.getItemInHand(hand);
        if (p.level.isClientSide) return InteractionResultHolder.pass(is);
        if (p.isCrouching()) {
            return InteractionResultHolder.pass(is);
        } else {
            CompoundTag tag = is.getOrCreateTag();
            if (tag.contains("cursor")) {
                CompoundTag cursor = tag.getCompound("cursor");
                BlockPos pos = new BlockPos(
                        cursor.getInt("x"),
                        cursor.getInt("y"),
                        cursor.getInt("z")
                );
                String dim = cursor.getString("dim");
                if (p.level.dimension().location().getPath().equals(dim)) {
                    Direction face = Direction.byName(cursor.getString("face"));
                    BlockState state = p.level.getBlockState(pos);
                    INTERACTED_POSITIONS.put(p, pos);
                    state.use(
                            p.level,
                            p,
                            hand,
                            new BlockHitResult(
                                    new Vec3(pos.getX(), pos.getY(), pos.getX()),
                                    face,
                                    pos,
                                    false
                            )
                    );
                    return InteractionResultHolder.success(is);
                } else {
                    return InteractionResultHolder.fail(is);
                }
            } else {
                return InteractionResultHolder.fail(is);
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player p = context.getPlayer();
        ItemStack is = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        if (p.level.isClientSide) return InteractionResult.PASS;
        if (p.isCrouching() && pos != null) {
            CompoundTag tag = is.getOrCreateTag();
            CompoundTag cursor = new CompoundTag();
            cursor.putInt("x", pos.getX());
            cursor.putInt("y", pos.getY());
            cursor.putInt("z", pos.getZ());
            cursor.putString("dim", p.level.dimension().location().getPath());
            cursor.putString("face", context.getClickedFace().toString());
            tag.put("cursor", cursor);
            is.setTag(tag);
            p.setItemInHand(context.getHand(), is);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void appendHoverText(ItemStack is, Level world, List<Component> tooltip, TooltipFlag flag) {
        CompoundTag tag = is.getOrCreateTag();
        if (tag.contains("cursor")) {
            CompoundTag cursor = tag.getCompound("cursor");
            int x = cursor.getInt("x");
            int y = cursor.getInt("y");
            int z = cursor.getInt("z");
            String dim = cursor.getString("dim");
            tooltip.add(Component.literal("§7Block: [" + x + ", " + y + ", " + z + ", " + dim + "]"));
        } else {
            tooltip.add(Component.literal("§7Block: [-, -, -, -]"));
        }
    }
}