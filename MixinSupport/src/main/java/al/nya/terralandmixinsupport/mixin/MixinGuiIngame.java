package al.nya.terralandmixinsupport.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.chat.IChatListener;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;


@Mixin(value = GuiIngameForge.class)//Stupid Forge WHY REWRITE GUIINGAME!!!
@Debug(export = true)
public class MixinGuiIngame{
    private GuiIngame mcGui;
    private Minecraft mc;


    /**
     * @author CanYingisme
     */
    @Inject(method = "renderGameOverlay",at = @At("HEAD"))
    public void renderGameOverlay(float partialTicks, CallbackInfo ci){
        try {
            Class.forName("al.nya.arkgui.gui.ArkInGame").getMethod("render2D", float.class, GuiIngameForge.class).invoke(null,partialTicks,this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Inject(method = "<init>",at = @At("RETURN"))
    public void fuckForge(Minecraft mc, CallbackInfo ci){
        this.mc = mc;
    }
    @Inject(method = "renderExperience", at = @At(value = "HEAD"), cancellable = true,remap = false)
    public void removeExp(int width, int height, CallbackInfo ci){
        ci.cancel();
    }
}
