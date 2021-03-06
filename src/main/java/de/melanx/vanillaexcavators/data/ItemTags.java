package de.melanx.vanillaexcavators.data;

import de.melanx.morevanillalib.api.BigBreakMaterials;
import de.melanx.morevanillalib.data.ModTags;
import de.melanx.vanillaexcavators.items.ExcavatorItem;
import de.melanx.vanillaexcavators.items.ExcavatorRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ItemTags extends ItemTagsProvider {

    public ItemTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        for (RegistryObject<Item> registryObject : ExcavatorRegistry.ITEMS.getEntries()) {
            Item item = registryObject.get();
            BigBreakMaterials itemTier = (BigBreakMaterials) ((ExcavatorItem) item).getToolMaterial();
            switch (itemTier) {
                case WOOD:
                    getBuilder(ModTags.Items.WOOD_TOOLS).add(item);
                    break;
                case STONE:
                    getBuilder(ModTags.Items.STONE_TOOLS).add(item);
                    break;
                case IRON:
                    getBuilder(ModTags.Items.IRON_TOOLS).add(item);
                    break;
                case GOLD:
                    getBuilder(ModTags.Items.GOLD_TOOLS).add(item);
                    break;
                case DIAMOND:
                    getBuilder(ModTags.Items.DIAMOND_TOOLS).add(item);
                    break;
                case BONE:
                    getBuilder(ModTags.Items.BONE_TOOLS).add(item);
                    break;
                case COAL:
                    getBuilder(ModTags.Items.COAL_TOOLS).add(item);
                    break;
                case EMERALD:
                    getBuilder(ModTags.Items.EMERALD_TOOLS).add(item);
                    break;
                case ENDER:
                    getBuilder(ModTags.Items.ENDER_TOOLS).add(item);
                    break;
                case FIERY:
                    getBuilder(ModTags.Items.FIERY_TOOLS).add(item);
                    break;
                case GLOWSTONE:
                    getBuilder(ModTags.Items.GLOWSTONE_TOOLS).add(item);
                    break;
                case LAPIS:
                    getBuilder(ModTags.Items.LAPIS_TOOLS).add(item);
                    break;
                case NETHER:
                    getBuilder(ModTags.Items.NETHER_TOOLS).add(item);
                    break;
                case OBSIDIAN:
                    getBuilder(ModTags.Items.OBSIDIAN_TOOLS).add(item);
                    break;
                case PAPER:
                    getBuilder(ModTags.Items.PAPER_TOOLS).add(item);
                    break;
                case PRISMARINE:
                    getBuilder(ModTags.Items.PRISMARINE_TOOLS).add(item);
                    break;
                case QUARTZ:
                    getBuilder(ModTags.Items.QUARTZ_TOOLS).add(item);
                    break;
                case REDSTONE:
                    getBuilder(ModTags.Items.REDSTONE_TOOLS).add(item);
                    break;
                case SLIME:
                    getBuilder(ModTags.Items.SLIME_TOOLS).add(item);
                    break;
            }
        }
    }
}
