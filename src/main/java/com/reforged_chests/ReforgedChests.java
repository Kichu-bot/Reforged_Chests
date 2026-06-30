package com.reforged_chests;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import com.reforged_chests.registration.ModRegistration;
import com.reforged_chests.client.ModChestScreen;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import com.reforged_chests.client.renderer.ModChestRenderer;

@Mod(ReforgedChests.MODID)
public class ReforgedChests {

    public static final String MODID = "reforged_chests";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ReforgedChests(IEventBus modEventBus) {
        ModRegistration.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::registerCapabilities);
        modEventBus.addListener(this::registerScreens);
        modEventBus.addListener(this::registerRenderers);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Reforged Chests: Inicializando backend...");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Reforged Chests: Configurando cliente...");
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                ModRegistration.MOD_CHEST_BE.get(),
                (blockEntity, side) -> blockEntity.getItemHandler()
        );
    }

    private void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModRegistration.MOD_CHEST_MENU.get(), ModChestScreen::new);
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModRegistration.MOD_CHEST_BE.get(), ModChestRenderer::new);
    }
}