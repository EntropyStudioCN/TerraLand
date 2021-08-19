package com.arkaddition.util.handlers;


import com.arkaddition.blocks.SourceStoneCore;
import com.arkaddition.blocks.TileEnity.SSCTileEnity;
import com.arkaddition.init.ModBlocks;
import com.arkaddition.init.ModItems;
import com.arkaddition.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }
    //�¼������Ʒ��ע���¼�
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }
    
    public static void initRegistries() {
        SoundsHandler.registerSounds();
    }
    @SubscribeEvent
    public static void onBlockRegistration(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new SourceStoneCore ().setRegistryName("SSCTileEnity", "soucestonecore"));
        // 第一个参数是你要注册的 TileEntity 对应的 class 对象。必须 extends TileEntity。
        // 第二个参数的要求和方块的注册名一致。
        GameRegistry.registerTileEntity(SSCTileEnity.class, new ResourceLocation ("SSCTileEnity", "soucestonecore"));
    }
    
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
    	
    	for(Item item: ModItems.ITEMS){
           if(item instanceof IHasModel) {
              ((IHasModel)item).registerModels();           
            }
        }

    	
    	
        //�¼������block����Ϣע��
        for (Block block: ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }

    }
}

