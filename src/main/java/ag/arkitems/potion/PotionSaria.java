package ag.arkitems.potion;

import com.arkaddition.util.Reference;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionSaria extends Potion {
	public PotionSaria() {
		super(false, 0x806144);
		this.setRegistryName(Reference.Mod_ID + ":saria");
		this.setPotionName("effect." + Reference.Mod_ID + ".saria");
	}
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasStatusIcon()
	{
		return false;
	}
}
