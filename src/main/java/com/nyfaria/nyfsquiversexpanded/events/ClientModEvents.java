package com.nyfaria.nyfsquiversexpanded.events;

import com.nyfaria.nyfsquiversexpanded.NyfsQuiversExpanded;
import com.nyfaria.nyfsquiversexpanded.init.NQEItemInit;
import com.nyfaria.nyfsquiversexpanded.renderer.NQEModels;
import com.nyfaria.nyfsquiversexpanded.renderer.NQERenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = NyfsQuiversExpanded.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent e){

        CuriosRendererRegistry.register(NQEItemInit.SILVER_QUIVER.get(), NQERenderer::new);
        CuriosRendererRegistry.register(NQEItemInit.NEPTUNIUM_QUIVER.get(), NQERenderer::new);
        CuriosRendererRegistry.register(NQEItemInit.IRON_NETHERITE_QUIVER.get(), NQERenderer::new);
        CuriosRendererRegistry.register(NQEItemInit.GOLD_NETHERITE_QUIVER.get(), NQERenderer::new);
        CuriosRendererRegistry.register(NQEItemInit.EMERALD_NETHERITE_QUIVER.get(), NQERenderer::new);
        CuriosRendererRegistry.register(NQEItemInit.DIAMOND_NETHERITE_QUIVER.get(), NQERenderer::new);
    }
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        ForgeModelBakery.addSpecialModel(NQEModels.SILVER_QUIVER);
        ForgeModelBakery.addSpecialModel(NQEModels.SILVER_QUIVER_NOARROWS);
        ForgeModelBakery.addSpecialModel(NQEModels.NEPTUNIUM_QUIVER);
        ForgeModelBakery.addSpecialModel(NQEModels.NEPTUNIUM_QUIVER_NOARROWS);
        ForgeModelBakery.addSpecialModel(NQEModels.IRON_NETHERITE_QUIVER);
        ForgeModelBakery.addSpecialModel(NQEModels.IRON_NETHERITE_QUIVER_NOARROWS);
        ForgeModelBakery.addSpecialModel(NQEModels.GOLD_NETHERITE_QUIVER);
        ForgeModelBakery.addSpecialModel(NQEModels.GOLD_NETHERITE_QUIVER_NOARROWS);
        ForgeModelBakery.addSpecialModel(NQEModels.EMERALD_NETHERITE_QUIVER);
        ForgeModelBakery.addSpecialModel(NQEModels.EMERALD_NETHERITE_QUIVER_NOARROWS);
        ForgeModelBakery.addSpecialModel(NQEModels.DIAMOND_NETHERITE_QUIVER);
        ForgeModelBakery.addSpecialModel(NQEModels.DIAMOND_NETHERITE_QUIVER_NOARROWS);
    }
}
