package com.theredinventor.minerology;

import com.theredinventor.minerology.util.RegistryHandler;
import com.theredinventor.minerology.world.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("minerology")
@Mod.EventBusSubscriber(modid = Minerology.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Minerology
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "minerology";

    public Minerology() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        OreGeneration.generationOre();
    }

    public static final ItemGroup TAB = new ItemGroup("minerology_ores"){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(RegistryHandler.Actinium_Ingot.get());
        }
    };
}