package al.nya.arkgui.gui;

import al.nya.arkgui.utils.RenderUtil;
import com.arkaddition.Main;
import com.arkaddition.blocks.SourceStoneCore;
import com.arkaddition.util.ARKNBTDef.ARKNBTDef;
import com.arkaddition.util.ARKNBTDef.ARKNBTUtil;
import com.arkaddition.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.GuiIngameForge;

import java.awt.*;

public class ArkInGame {
    private static final ResourceLocation BOX = new ResourceLocation(Reference.Mod_ID,"textures/gui/side1.png");
    private static final ResourceLocation ICONS = new ResourceLocation("textures/gui/icons.png");

    public static void render2D(float p_175180_1_, GuiIngameForge guiIn){
        ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
        int scaledWidth = scaledresolution.getScaledWidth();
        int scaledHeight = scaledresolution.getScaledHeight();
        if (Main.DEV_VERSION){//Draw debug Info
            RenderUtil.drawRect(5,5,125,105,Integer.MIN_VALUE);
            Minecraft mc = Minecraft.getMinecraft();
            guiIn.drawString(mc.fontRenderer,"TerraLand Debug:"+ Reference.VERSION,6,5, Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"Vanilla CoolDown:"+mc.player.getCooldownPeriod(),6,15,Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"Vanilla Exp:"+mc.player.experience,6,25,Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"Player Health:"+mc.player.getHealth(),6,35,Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"Player Food Level:"+mc.player.getFoodStats().getFoodLevel(),6,45,Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"Client Radiation:"+(mc.player.getDataManager().get(SourceStoneCore.RADIATION)) +"("+danger()+")",6,55,Color.WHITE.getRGB());
            guiIn.drawString(mc.fontRenderer,"Client Strength:"+(ARKNBTUtil.GetInt(mc.player, ARKNBTDef.ARK_STRENGTH.getName(), -1)) ,6,65,Color.WHITE.getRGB());
            //guiIn.drawString(mc.fontRenderer,"Core Distance:"+mc.player.getDataManager().get(SourceStoneCore.DISTANCE) +"("+danger()+")",6,65,Color.WHITE.getRGB());
        }
        Minecraft mc = Minecraft.getMinecraft();
        //RenderBox
        int boxWidth = 64;
        int boxHeight = 64;
        int boxX = (scaledWidth / 2) - (boxWidth / 2);
        int boxY = scaledHeight - 22 - boxHeight;
        //guiIn.drawTexturedModalRect(boxX, boxY, 0, 0, 64, 64);
        RenderUtil.drawImage(BOX,boxX,boxY,64,64);
        //RenderHealth
        int healthX = boxX + (boxWidth / 8);
        int healthY = boxY + (boxHeight / 8);
        int MARGIN = 16;
        final int TOP =  9 * (mc.world.getWorldInfo().isHardcoreModeEnabled() ? 5 : 0);
        mc.getTextureManager().bindTexture(ICONS);
        guiIn.drawTexturedModalRect(healthX, healthY , MARGIN + 36, TOP, 9, 9);
        int healthProgressLength = 80;
        int healthProgressX = healthX - healthProgressLength;
        int healthProgressBottom = healthY + 9;
        RenderUtil.drawRect(healthProgressX,healthProgressBottom,healthProgressX+healthProgressLength,healthProgressBottom+1,Color.GRAY.getRGB());
        IAttributeInstance attrMaxHealth = mc.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        float healthMax = (float)attrMaxHealth.getAttributeValue();
        float health = MathHelper.ceil(mc.player.getHealth());
        float percent = health/healthMax;
        float healthLength = percent*healthProgressLength;
        float healthBarX = healthX - healthLength;
        RenderUtil.drawRect(healthBarX,healthProgressBottom-4 ,healthBarX + healthLength,healthProgressBottom-1,Color.RED.getRGB());
    }
    private static boolean isDanger(){
        Minecraft mc =Minecraft.getMinecraft();
        return mc.player.getDataManager().get(SourceStoneCore.RADIATION)>6;
    }
    private static String danger(){
        String s;
        if (isDanger()){
            s = "Danger";
        }else {
            s = "safe";
        }
        return s;
    }
}
