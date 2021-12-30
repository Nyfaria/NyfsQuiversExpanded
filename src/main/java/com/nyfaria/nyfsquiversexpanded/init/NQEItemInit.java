package com.nyfaria.nyfsquiversexpanded.init;

import com.nyfaria.nyfsquiver.items.QuiverItem;
import com.nyfaria.nyfsquiver.items.QuiverType;
import com.nyfaria.nyfsquiversexpanded.NyfsQuiversExpanded;
import com.nyfaria.nyfsquiversexpanded.entity.SplashPotionArrow;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NQEItemInit {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsQuiversExpanded.MODID);

    public static RegistryObject<QuiverItem> SILVER_QUIVER = ITEMS.register("silver_quiver", () -> new QuiverItem(EnumInit.SILVER));
    public static RegistryObject<QuiverItem> IRON_NETHERITE_QUIVER = ITEMS.register("iron_netherite_quiver", () -> new QuiverItem(EnumInit.IRON_NETHERITE));
    public static RegistryObject<QuiverItem> GOLD_NETHERITE_QUIVER = ITEMS.register("gold_netherite_quiver", () -> new QuiverItem(EnumInit.GOLD_NETHERITE) {
        @Override
        public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
            return true;
        }
    });
    public static RegistryObject<QuiverItem> EMERALD_NETHERITE_QUIVER = ITEMS.register("emerald_netherite_quiver", () -> new QuiverItem(EnumInit.EMERALD_NETHERITE) {
        @Override
        public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
            return true;
        }
    });
    public static RegistryObject<QuiverItem> DIAMOND_NETHERITE_QUIVER = ITEMS.register("diamond_netherite_quiver", () -> new QuiverItem(EnumInit.DIAMOND_NETHERITE) {
        @Override
        public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
            return true;
        }
        @Override
        public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
            return true;
        }

    });
    public static RegistryObject<QuiverItem> NEPTUNIUM_QUIVER = ITEMS.register("neptunium_quiver", () -> new QuiverItem(EnumInit.NEPTUNIUM) {
        @Override
        public AbstractArrow modifyArrow(AbstractArrow abstractArrow) {
            if(abstractArrow instanceof Arrow) {
                if(((Arrow)abstractArrow).potion.getEffects().size() > 0) {
                    SplashPotionArrow splashPotionArrow = new SplashPotionArrow(abstractArrow.level, abstractArrow.getX(), abstractArrow.getY(), abstractArrow.getZ());
                    splashPotionArrow.potion = ((Arrow) abstractArrow).potion;
                    return splashPotionArrow;
                }
            }
            return abstractArrow;
        }
    });

}
