package de.mrstupsi.allinclusive;

import de.mrstupsi.allinclusive.block.*;
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
            return new ItemStack(IceMaker.ITEM);
        }
    };

    public AllInclusive() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        BLOCKS.register("ice_maker", () -> IceMaker.INSTANCE);
        ITEMS.register("ice_maker", () -> IceMaker.ITEM);
        ITEMS.register("cheese", () -> Cheese.INSTANCE);
        BLOCKS.register("cheese_maker", () -> CheeseMaker.INSTANCE);
        ITEMS.register("cheese_maker", () -> CheeseMaker.ITEM);
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
