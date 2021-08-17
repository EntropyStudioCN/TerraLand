package al.nya.arkgui.utils;

import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RenderUtil {
    public static void drawRect(final float x, final float y, final float x2, final float y2, final int color) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);

        glColor(color);
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glVertex2f(x2, y);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x, y2);
        GL11.glVertex2f(x2, y2);
        GL11.glEnd();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }

    public static void drawRect(final int x, final int y, final int x2, final int y2, final int color) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11. glEnable(GL11.GL_LINE_SMOOTH);

        glColor(color);
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glVertex2i(x2, y);
        GL11.glVertex2i(x, y);
        GL11.glVertex2i(x, y2);
        GL11.glVertex2i(x2, y2);
        GL11.glEnd();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }
    public static void glColor(final int red, final int green, final int blue, final int alpha) {
        GL11.glColor4f(red / 255F, green / 255F, blue / 255F, alpha / 255F);
    }

    public static void glColor(final Color color) {
        glColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public static void glColor(final int hex) {
        glColor(hex >> 16 & 0xFF, hex >> 8 & 0xFF, hex & 0xFF, hex >> 24 & 0xFF);
    }
}
