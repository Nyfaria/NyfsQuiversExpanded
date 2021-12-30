package com.nyfaria.nyfsquiversexpanded.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(PiglinAi.class)
public class PiglinGoldMixin {
    @Unique
    private static boolean found = false;

    @Inject(method = "isWearingGold", at = @At("HEAD"), cancellable = true)
    private static void curiosPiglinNeutrality(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
        found = false;
        CuriosApi.getCuriosHelper().getEquippedCurios(livingEntity).ifPresent(e -> {
            for (int i = 0; i < e.getSlots(); i++) {
                ItemStack itemStack = e.getStackInSlot(i);
                if (itemStack.getItem().makesPiglinsNeutral(itemStack, livingEntity)) {
                    found = true;
                }
            }
        });
        if(found){
            cir.setReturnValue(true);
        }
    }
}
