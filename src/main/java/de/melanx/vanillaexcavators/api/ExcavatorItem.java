package de.melanx.vanillaexcavators.api;

import de.melanx.vanillaexcavators.common.ExcavatorMaterials;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExcavatorItem extends ShovelItem {
    private IItemTier toolMaterial;

    public ExcavatorItem(IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
        this.toolMaterial = toolMaterial;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (player.isSneaking()) {
            return true;
        }

        float originHardness = world.getBlockState(pos).getBlockHardness(null, null);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getHeldItemMainhand().canHarvestBlock(world.getBlockState(pos))) {
            BlockBreaker.breakInRadius(world, player, 1, (breakState) -> {
                double hardness = breakState.getBlockHardness(null, null);
                boolean isEffective = player.getHeldItemMainhand().canHarvestBlock(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            }, true);
        }

        return true;
    }

    @Override
    public void onCreated(ItemStack stack, World world, PlayerEntity player) {
        if (this.getToolMaterial() == ExcavatorMaterials.SLIME)
            stack.addEnchantment(Enchantments.KNOCKBACK, 3);
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        if (getToolMaterial() == ExcavatorMaterials.WOOD)
            return 400;
        return 0;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.TOOLS || group == ItemGroup.SEARCH) {
            ItemStack item = new ItemStack(this);
            if (this.getToolMaterial() == ExcavatorMaterials.SLIME) {
                item.addEnchantment(Enchantments.KNOCKBACK, 3);
            }
            items.add(item);
        }
    }

    public IItemTier getToolMaterial() {
        return toolMaterial;
    }
}
