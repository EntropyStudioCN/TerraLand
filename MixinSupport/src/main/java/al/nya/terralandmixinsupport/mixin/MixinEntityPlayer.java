package al.nya.terralandmixinsupport.mixin;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {
    @Inject(method = "getCooledAttackStrength",at = @At("HEAD"), cancellable = true)
    public void hookCoolDown(float p_184825_1_, CallbackInfoReturnable<Float> cir){
        cir.setReturnValue(0F);
    }
}