package com.arkaddition;

import com.arkaddition.entity.EntityInit;
import com.arkaddition.entity.render.ArkRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.arkaddition.proxy.CommonProxy;
import com.arkaddition.util.Reference;
import software.bernie.geckolib3.GeckoLib;


@Mod(modid = Reference.Mod_ID, name = Reference.NAME, version=Reference.VERSION)    
public class Main {
    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        EntityInit.registerEntities();
    }

    @EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        GeckoLib.initialize();
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        ArkRenderManager.register(renderManager);
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

}
