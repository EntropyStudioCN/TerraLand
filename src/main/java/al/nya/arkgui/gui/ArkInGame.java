package al.nya.arkgui.gui;

import al.nya.arkgui.utils.RenderUtil;
import com.arkaddition.Main;
import com.arkaddition.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.GuiIngameForge;

import java.awt.*;

public class ArkInGame {
    public static void render2D(float p_175180_1_, GuiIngameForge guiIn){
        if (Main.DEV_VERSION){//Draw debug Info
            RenderUtil.drawRect(5,5,125,105,Integer.MIN_VALUE);
            Minecraft mc = Minecraft.getMinecraft();
            guiIn.drawString(mc.fontRenderer,"TerraLand Debug:"+ Reference.VERSION,6,5, Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"VanillaCoolDown:"+mc.player.getCooldownPeriod(),6,15,Color.WHITE.getRGB());
        }
    }
}
