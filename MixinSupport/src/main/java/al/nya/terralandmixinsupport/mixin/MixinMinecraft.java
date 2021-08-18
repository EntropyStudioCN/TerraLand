package al.nya.terralandmixinsupport.mixin;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "createDisplay",at = @At("RETURN"))
    public void setTitle(CallbackInfo ci){
        Display.setTitle("Minecraft 1.12.2 | TerraLand");
    }
}
