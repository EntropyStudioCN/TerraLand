package com.arkaddition.hooks;

import com.arkaddition.util.RenderUtil;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class InGameHud {
    public static void render(float p_175180_1_, CallbackInfo ci){
        System.out.println("render Invoke");
        RenderUtil.drawRect(5,5,55,55,Integer.MAX_VALUE);
    }
}
