package com.nyfaria.nyfsquiversexpanded.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class SplashPotionArrow extends Arrow {
    public SplashPotionArrow(Level p_36861_, double p_36862_, double p_36863_, double p_36864_) {
        super(p_36861_, p_36862_, p_36863_, p_36864_);
    }

    @Override
    protected void onHit(HitResult p_36755_) {
        ItemStack itemstack = this.getPickupItem();
        Potion potion = PotionUtils.getPotion(itemstack);
        makeAreaOfEffectCloud(itemstack,potion);
        super.onHit(p_36755_);
    }

    private void makeAreaOfEffectCloud(ItemStack p_37538_, Potion p_37539_) {
        AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            areaeffectcloud.setOwner((LivingEntity)entity);
        }

        areaeffectcloud.setRadius(3.0F);
        areaeffectcloud.setRadiusOnUse(-0.5F);
        areaeffectcloud.setWaitTime(10);
        areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
        areaeffectcloud.setPotion(p_37539_);

        for(MobEffectInstance mobeffectinstance : potion.getEffects()) {
            areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
        }

        //CompoundTag compoundtag = p_37538_.getTag();
        areaeffectcloud.setFixedColor(PotionUtils.getColor(potion.getEffects()));


        this.level.addFreshEntity(areaeffectcloud);
    }
}
