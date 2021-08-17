package ag.arkitems.potion;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class PotionRegistryHandler {

	//public static final Potion POTION_ASTESIA = new PotionAstesia();
	//public static final Potion POTION_MAT = new PotionMatoimaru();
	//public static final Potion POTION_SARIA = new PotionSaria();
	//public static final Potion POTION_CUORA = new PotionCuora();
	//public static final Potion POTION_LISKARM = new PotionLiskarm();
	
	@SubscribeEvent
	public static void onPotionRegistry(RegistryEvent.Register<Potion> event){
		IForgeRegistry<Potion> registry = event.getRegistry();
		//registry.register(POTION_ASTESIA);
		//registry.register(POTION_MAT);
		//registry.register(POTION_SARIA);
		//registry.register(POTION_CUORA);
		//registry.register(POTION_LISKARM);
	}
}
