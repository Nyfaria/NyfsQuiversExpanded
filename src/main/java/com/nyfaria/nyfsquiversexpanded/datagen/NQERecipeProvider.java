package com.nyfaria.nyfsquiversexpanded.datagen;

import com.autovw.advancednetherite.core.ModItems;
import com.nyfaria.nyfsquiver.init.ItemInit;
import com.nyfaria.nyfsquiver.items.QuiverItem;
import com.nyfaria.nyfsquiversexpanded.init.NQEItemInit;
import com.teammetallurgy.aquaculture.init.AquaItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class NQERecipeProvider extends RecipeProvider {
    public NQERecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeSaver) {

        registerQuiverRecipe(NQEItemInit.SILVER_QUIVER.get(), ItemInit.IRON_QUIVER.get(), ItemTags.createOptional(new ResourceLocation("forge:ingots/silver")), recipeSaver);
        registerQuiverRecipe(NQEItemInit.NEPTUNIUM_QUIVER.get(), ItemInit.NETHERITE_QUIVER.get(), AquaItems.NEPTUNIUM_INGOT.get(), recipeSaver);
        upgradeQuiverRecipe(NQEItemInit.IRON_NETHERITE_QUIVER.get(), ItemInit.NETHERITE_QUIVER.get(), ModItems.NETHERITE_IRON_INGOT.get(), recipeSaver);
        upgradeQuiverRecipe(NQEItemInit.GOLD_NETHERITE_QUIVER.get(), NQEItemInit.IRON_NETHERITE_QUIVER.get(), ModItems.NETHERITE_GOLD_INGOT.get(), recipeSaver);
        upgradeQuiverRecipe(NQEItemInit.EMERALD_NETHERITE_QUIVER.get(), NQEItemInit.GOLD_NETHERITE_QUIVER.get(), ModItems.NETHERITE_EMERALD_INGOT.get(), recipeSaver);
        upgradeQuiverRecipe(NQEItemInit.DIAMOND_NETHERITE_QUIVER.get(), NQEItemInit.EMERALD_NETHERITE_QUIVER.get(), ModItems.NETHERITE_DIAMOND_INGOT.get(), recipeSaver);

    }
    public void registerQuiverRecipe(QuiverItem newQuiver, QuiverItem baseQuiver, Tag<Item> upgradeItem, Consumer<FinishedRecipe> recipeSaver){
        ShapedRecipeBuilder.shaped(newQuiver)
                .define('U',upgradeItem)
                .define('B', baseQuiver)
                .define('F', Items.FEATHER)
                .pattern("UUF")
                .pattern("UBU")
                .pattern("UUU")
                .unlockedBy("has_moss", has(upgradeItem))
                .save(recipeSaver);
    }
    public void registerQuiverRecipe(QuiverItem newQuiver, QuiverItem baseQuiver, Item upgradeItem, Consumer<FinishedRecipe> recipeSaver){
        ShapedRecipeBuilder.shaped(newQuiver)
                .define('U',upgradeItem)
                .define('B', baseQuiver)
                .define('F', Items.FEATHER)
                .pattern("UUF")
                .pattern("UBU")
                .pattern("UUU")
                .unlockedBy("has_moss", has(upgradeItem))
                .save(recipeSaver);
    }
    public void upgradeQuiverRecipe(QuiverItem newQuiver, QuiverItem baseQuiver, Tag<Item> upgradeItem, Consumer<FinishedRecipe> recipeSaver){
        UpgradeRecipeBuilder.smithing(Ingredient.of(baseQuiver), Ingredient.of(upgradeItem), newQuiver)
                .unlocks("netherite_armor", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT));
    }
    public void upgradeQuiverRecipe(QuiverItem newQuiver, QuiverItem baseQuiver, Item upgradeItem, Consumer<FinishedRecipe> recipeSaver){
        UpgradeRecipeBuilder.smithing(Ingredient.of(baseQuiver), Ingredient.of(upgradeItem), newQuiver)
                .unlocks("netherite_armor", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT)).save(recipeSaver, newQuiver.getRegistryName().getPath() + "_smithing");
    }
}
