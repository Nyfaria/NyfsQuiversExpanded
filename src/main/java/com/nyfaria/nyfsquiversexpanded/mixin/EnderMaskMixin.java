package com.nyfaria.nyfsquiversexpanded.mixin;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.common.CuriosHelper;

@Mixin(EnderMan.class)
public class EnderMaskMixin {

    boolean found = false;

    @Inject(method = "isLookingAtMe", at = @At("HEAD"), cancellable = true)
    public void curioEnderMask(Player player, CallbackInfoReturnable<Boolean> cir) {
        found = false;
        CuriosApi.getCuriosHelper().getEquippedCurios(player).ifPresent(e -> {
            for (int i = 0; i < e.getSlots(); i++) {
                ItemStack itemStack = e.getStackInSlot(i);
                if (itemStack.getItem().isEnderMask(itemStack, player, (EnderMan) (Object) this)) {
                    found = true;
                }
            }
        });
        if (found) {
            cir.setReturnValue(false);
        }
    }
}
