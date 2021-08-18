package ag.arkitems.event;

import ag.arkitems.potion.PotionRegistryHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
    public class EventHandler {
    /*
        public static int level;
        public static EntityLivingBase ent;


    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        if (event.player.isPotionActive(PotionRegistryHandler.POTION_SARIA)) {
            int level = event.player.getActivePotionEffect(PotionRegistryHandler.POTION_SARIA).getAmplifier();
           // if (level <= 30) {
              //  if (event.player.motionX < 0.1 * (1 + level / 10))//(float)(5 * (level / 6)) / 100))
                   event.player.addVelocity(event.player.motionX *= 1.1, 0, 0);
               // if (event.player.motionZ < 0.1 * (1 + level / 10))//(float)(5 * (level / 6)) / 100))
            event.player.addVelocity(0, 0, event.player.motionZ *= 1.1);
                  event.player.velocityChanged = true;
            //} else if (level > 30 && level <= 40) {

            //} else if (level > 40) {

            //}

        }
        if (ent != null && event.player.equals(ent)) {
            event.player.addPotionEffect(new PotionEffect(PotionRegistryHandler.POTION_SARIA, 999999999, level, false, false));
            ent = null;
        }
    }
    @SubscribeEvent
    public static void onLeft2(BreakEvent event) {
        if (event.getPlayer().isPotionActive(PotionRegistryHandler.POTION_SARIA)) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionRegistryHandler.POTION_SARIA, 999999999, event.getPlayer().getActivePotionEffect(PotionRegistryHandler.POTION_SARIA).getAmplifier() + 1, false, false));
        } else {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionRegistryHandler.POTION_SARIA, 999999999, 1, false, false));
        }
        level = event.getPlayer().getActivePotionEffect(PotionRegistryHandler.POTION_SARIA).getAmplifier();
    }



    @SubscribeEvent
    public static void onRiggt(PlayerInteractEvent.RightClickItem event) {
        if(event.getItemStack().getItem().equals(Items.MILK_BUCKET) && event.getEntityLiving().isPotionActive(PotionRegistryHandler.POTION_SARIA)) {
            int level = event.getEntityLiving().getActivePotionEffect(PotionRegistryHandler.POTION_SARIA).getAmplifier();
            EventHandler.level = level;
            EventHandler.ent = event.getEntityLiving();
        }
    }

        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event) {
            if(event.getEntityLiving().isPotionActive(PotionRegistryHandler.POTION_SARIA)) {
                int level = event.getEntityLiving().getActivePotionEffect(PotionRegistryHandler.POTION_SARIA).getAmplifier();
                EventHandler.level = level;
                EventHandler.ent = event.getEntityLiving();
            }
        }
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event) {
            if (event.getSource() != null && event.getSource().getTrueSource() instanceof EntityLivingBase) {
                EntityLivingBase sou = event.getEntityLiving();
                if (sou.isPotionActive(PotionRegistryHandler.POTION_SARIA)) {
                    float level = event.getEntityLiving().getActivePotionEffect(PotionRegistryHandler.POTION_SARIA).getAmplifier();
                    if (level <= 30) {
                        event.setAmount(event.getAmount() + event.getAmount() * 5.0f * level / 600.0f);
                    } else if (level > 30 && level <= 40) {
                        event.setAmount(event.getAmount() + event.getAmount() * 2.7f);
                    } else if (level > 40) {
                        event.setAmount(event.getAmount() + event.getAmount() * 2.7f - event.getAmount() * 0.2f * (level - 40) / 10.0f);
                    }
                }
            }
        }*/
}
