package com.arkaddition;

import com.arkaddition.entity.EntityInit;
import com.arkaddition.entity.render.ArkRenderManager;
import com.arkaddition.event.ArkEventHandler;
import com.arkaddition.event.S_stone;
import com.arkaddition.world.GenOreArks;
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
import net.minecraftforge.fml.common.registry.GameRegistry;
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
        GameRegistry.registerWorldGenerator(new GenOreArks(),3);
    }

    @EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        GeckoLib.initialize();
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        ArkRenderManager.register(renderManager);
        new ArkEventHandler();
        new S_stone();
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

}
