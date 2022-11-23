package de.mrstupsi.allinclusive;

import de.mrstupsi.allinclusive.block.SteelBlock;
import de.mrstupsi.allinclusive.item.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("allinclusive")
public class AllInclusive {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "allinclusive");
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "allinclusive");
    public static final CreativeModeTab TAB = new CreativeModeTab("allinclusive") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SteelBlock.ITEM);
        }
    };

    public AllInclusive() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        BLOCKS.register("steel_block", () -> SteelBlock.INSTANCE);
        ITEMS.register("steel_block", () -> SteelBlock.ITEM);
        ITEMS.register("steel_axe", () -> SteelAxe.INSTANCE);
        ITEMS.register("steel_boots", () -> SteelBoots.INSTANCE);
        ITEMS.register("steel_chestplate", () -> SteelChestplate.INSTANCE);
        ITEMS.register("steel_helmet", () -> SteelHelmet.INSTANCE);
        ITEMS.register("steel_hoe", () -> SteelHoe.INSTANCE);
        ITEMS.register("steel_ingot", () -> SteelIngot.INSTANCE);
        ITEMS.register("steel_leggings", () -> SteelLeggings.INSTANCE);
        ITEMS.register("steel_multitool", () -> SteelMultiTool.INSTANCE);
        ITEMS.register("steel_pickaxe", () -> SteelPickaxe.INSTANCE);
        ITEMS.register("steel_shovel", () -> SteelShovel.INSTANCE);
        ITEMS.register("steel_sword", () -> SteelSword.INSTANCE);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = "allinclusive", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
