package al.nya.terralandmixinsupport.mixin;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngameForge.class)
@Debug(export = true)
public class MixinGuiIngame {
    /**
     * @author CanYingisme
     */
    @Overwrite
    public void renderGameOverlay(float p_175180_1_){
        System.out.println("Render2D "+p_175180_1_);
    }

}
