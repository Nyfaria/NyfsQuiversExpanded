package com.nyfaria.nyfsquiversexpanded;

import com.nyfaria.nyfsquiversexpanded.datagen.NQEItemModelProvider;
import com.nyfaria.nyfsquiversexpanded.datagen.NQERecipeProvider;
import com.nyfaria.nyfsquiversexpanded.init.EnumInit;
import com.nyfaria.nyfsquiversexpanded.init.NQEItemInit;
import com.nyfaria.nyfsquiversexpanded.renderer.NQEModels;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NyfsQuiversExpanded.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsQuiversExpanded {
    public static final String MODID = "nyfsquiversexpanded";
    public static final Logger LOGGER = LogManager.getLogger();

    public NyfsQuiversExpanded() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        NQEModels.init();
        EnumInit.init();
        NQEItemInit.ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // do something when the setup is run on both client and server
        LOGGER.info("HELLO from common setup!");
    }
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            generator.addProvider(new NQERecipeProvider(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new NQEItemModelProvider(generator, existingFileHelper));
        }
    }
}
