package com.nyfaria.nyfsquiversexpanded.renderer;

import com.nyfaria.nyfsquiver.items.QuiverItem;
import com.nyfaria.nyfsquiver.items.QuiverModels;
import com.nyfaria.nyfsquiver.items.QuiverType;
import com.nyfaria.nyfsquiversexpanded.NyfsQuiversExpanded;
import com.nyfaria.nyfsquiversexpanded.init.EnumInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class NQEModels{
    public static ResourceLocation SILVER_QUIVER = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/silver_quiver");
    public static ResourceLocation SILVER_QUIVER_NOARROWS = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/silver_quiver_noarrows");
    public static ResourceLocation NEPTUNIUM_QUIVER = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/neptunium_quiver");
    public static ResourceLocation NEPTUNIUM_QUIVER_NOARROWS = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/neptunium_quiver_noarrows");
    public static ResourceLocation IRON_NETHERITE_QUIVER = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/iron_netherite_quiver");
    public static ResourceLocation IRON_NETHERITE_QUIVER_NOARROWS = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/iron_netherite_quiver_noarrows");
    public static ResourceLocation GOLD_NETHERITE_QUIVER = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/gold_netherite_quiver");
    public static ResourceLocation GOLD_NETHERITE_QUIVER_NOARROWS = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/gold_netherite_quiver_noarrows");
    public static ResourceLocation EMERALD_NETHERITE_QUIVER = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/emerald_netherite_quiver");
    public static ResourceLocation EMERALD_NETHERITE_QUIVER_NOARROWS = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/emerald_netherite_quiver_noarrows");
    public static ResourceLocation DIAMOND_NETHERITE_QUIVER = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/diamond_netherite_quiver");
    public static ResourceLocation DIAMOND_NETHERITE_QUIVER_NOARROWS = new ResourceLocation(NyfsQuiversExpanded.MODID, "back/diamond_netherite_quiver_noarrows");
    public static Map<QuiverType, ResourceLocation> ARROWS;
    public static Map<QuiverType, ResourceLocation> NOARROWS;
    public static void init() {

        ARROWS = Map.of(
                EnumInit.SILVER, SILVER_QUIVER,
                EnumInit.NEPTUNIUM, NEPTUNIUM_QUIVER,
                EnumInit.IRON_NETHERITE, IRON_NETHERITE_QUIVER,
                EnumInit.GOLD_NETHERITE, GOLD_NETHERITE_QUIVER,
                EnumInit.EMERALD_NETHERITE, EMERALD_NETHERITE_QUIVER,
                EnumInit.DIAMOND_NETHERITE, DIAMOND_NETHERITE_QUIVER
                );
        NOARROWS = Map.of(
                EnumInit.SILVER, SILVER_QUIVER_NOARROWS,
                EnumInit.NEPTUNIUM, NEPTUNIUM_QUIVER_NOARROWS,
                EnumInit.IRON_NETHERITE, IRON_NETHERITE_QUIVER_NOARROWS,
                EnumInit.GOLD_NETHERITE, GOLD_NETHERITE_QUIVER_NOARROWS,
                EnumInit.EMERALD_NETHERITE, EMERALD_NETHERITE_QUIVER_NOARROWS,
                EnumInit.DIAMOND_NETHERITE, DIAMOND_NETHERITE_QUIVER_NOARROWS
        );

    }
    public static ResourceLocation getQuiverModel(ItemStack itemStack, boolean hasArrows) {
        QuiverItem quiverItem = (QuiverItem)itemStack.getItem();
        return hasArrows ? ARROWS.get(quiverItem.type) : NOARROWS.get(quiverItem.type);
    }
}
