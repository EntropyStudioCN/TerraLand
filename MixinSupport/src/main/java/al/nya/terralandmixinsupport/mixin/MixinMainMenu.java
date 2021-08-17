package al.nya.terralandmixinsupport.mixin;

import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinMainMenu {
    @Inject(method = "updateScreen",at = @At("RETURN"))
    public void test(CallbackInfo ci){
        //System.out.println("test");
    }
}
