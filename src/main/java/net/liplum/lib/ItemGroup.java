package net.liplum.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * @author Liplum
 */
public class ItemGroup extends CreativeTabs {
    @Nonnull
    private ItemStack icon = ItemStack.EMPTY;

    public ItemGroup(@Nonnull String registerName) {
        super(registerName);
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return icon;
    }

    public boolean setIcon(@Nonnull ItemStack newIcon) {
        if (newIcon.isEmpty() && newIcon == this.icon) {
            return false;
        }
        this.icon = newIcon;
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> currentItemGroupItems) {
        super.displayAllRelevantItems(currentItemGroupItems);
        sortDisplayedItems(currentItemGroupItems);
    }

    @SideOnly(Side.CLIENT)
    protected void sortDisplayedItems(@Nonnull NonNullList<ItemStack> currentItemGroupItems) {

    }
}
