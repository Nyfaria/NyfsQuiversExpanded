package com.nyfaria.nyfsquiversexpanded.datagen;

import com.google.common.base.Preconditions;
import com.nyfaria.nyfsquiver.NyfsQuiver;
import com.nyfaria.nyfsquiversexpanded.NyfsQuiversExpanded;
import com.nyfaria.nyfsquiversexpanded.init.NQEItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class NQEItemModelProvider extends ItemModelProvider {
    public NQEItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NyfsQuiversExpanded.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        Stream.of(
                        NQEItemInit.SILVER_QUIVER,
                        NQEItemInit.IRON_NETHERITE_QUIVER,
                        NQEItemInit.EMERALD_NETHERITE_QUIVER,
                        NQEItemInit.DIAMOND_NETHERITE_QUIVER,
                        NQEItemInit.GOLD_NETHERITE_QUIVER,
                        NQEItemInit.NEPTUNIUM_QUIVER
                )
                .map(Supplier::get)
                .forEach(this::simpleItemModel);

    }


    protected ItemModelBuilder simpleItemModel(Item item) {
        return simpleModel(item, mcLoc("item/generated"));
    }


    protected ItemModelBuilder simpleModel(Item item, ResourceLocation parent) {
        String name = getName(item);
        return singleTexture(name, parent, "layer0", modLoc("item/" + name));
    }




    protected String getName(Item item) {
        return item.getRegistryName().getPath();
    }

    @Override
    public ItemModelBuilder getBuilder(String path) {
        //Preconditions.checkNotNull(path, "Path must not be null");
        ResourceLocation outputLoc = extendWithFolder(path.contains(":") ? new ResourceLocation(path) : new ResourceLocation(modid, path));
        this.existingFileHelper.trackGenerated(outputLoc, MODEL);
        return generatedModels.computeIfAbsent(outputLoc, loc -> new NQEItemModelBuilder(loc, existingFileHelper));
    }

    private ResourceLocation extendWithFolder(ResourceLocation rl) {
        if (rl.getPath().contains("/")) {
            return rl;
        }
        return new ResourceLocation(rl.getNamespace(), folder + "/" + rl.getPath());
    }
}
