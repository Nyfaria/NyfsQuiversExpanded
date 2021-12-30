package com.nyfaria.nyfsquiversexpanded.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.nyfaria.nyfsquiver.curios.QuiverRenderer;
import com.nyfaria.nyfsquiver.init.EnchantmentInit;
import com.nyfaria.nyfsquiver.items.QuiverModels;
import com.nyfaria.nyfsquiver.items.QuiverStorageManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class NQERenderer extends QuiverRenderer {
    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        if (!EnchantmentHelper.getEnchantments(stack).containsKey(EnchantmentInit.MELD_ENCHANTMENT.get()) || !slotContext.getWearer().isInvisible()) {
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
            LivingEntity living = slotContext.getWearer();
            ICurioRenderer.translateIfSneaking(matrixStack, living);
            ICurioRenderer.rotateIfSneaking(matrixStack, living);
            matrixStack.translate(-0.75D, 0.35D, -0.145D);
            matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            ItemStack arrowsE = QuiverStorageManager.getCurrentSlotStack(stack);
            BakedModel quiver = itemRenderer.getItemModelShaper().getModelManager().getModel(NQEModels.getQuiverModel(stack, !arrowsE.isEmpty()));
            MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
            itemRenderer.render(stack, ItemTransforms.TransformType.HEAD, true, matrixStack, buffer, light, light, quiver);
        }

    }
}
