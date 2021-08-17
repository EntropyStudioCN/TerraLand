package ag.arkitems.potion;

import ag.arkitems.ArkItems;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionSaria extends Potion {
	public PotionSaria() {
		super(false, 0x806144);
		this.setRegistryName(ArkItems.MODID + ":saria");
		this.setPotionName("effect." + ArkItems.MODID + ".saria");
	}
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasStatusIcon()
	{
		return false;
	}
}
