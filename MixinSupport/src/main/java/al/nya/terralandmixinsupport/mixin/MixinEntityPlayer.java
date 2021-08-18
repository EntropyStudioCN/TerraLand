package al.nya.terralandmixinsupport.mixin;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {
    @Inject(method = "getCooledAttackStrength",at = @At("HEAD"), cancellable = true)
    public void hookCoolDown(float p_184825_1_, CallbackInfoReturnable<Float> cir){
        cir.setReturnValue(1F);
    }
    @Inject(method = "entityInit",at = @At("RETURN"))
    public void hookInit(CallbackInfo ci){
        DataParameter<Float> dataParameter = null;
        try {
            dataParameter = (DataParameter<Float>) Class.forName("com.arkaddition.blocks.SourceStoneCore").getField("RADIATION").get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (dataParameter != null)((EntityPlayer)(Object)this).getDataManager().register(dataParameter,0F);
    }
}