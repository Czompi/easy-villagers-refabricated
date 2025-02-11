package de.maxhenkel.easyvillagers.gui;

import de.maxhenkel.corelib.ClientRegistry;
import de.maxhenkel.easyvillagers.Main;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Containers {

    private static final DeferredRegister<MenuType<?>> MENU_TYPE_REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Main.MODID);

    public static final RegistryObject<MenuType<AutoTraderContainer>> AUTO_TRADER_CONTAINER = MENU_TYPE_REGISTER.register("auto_trader", () ->
            IForgeMenuType.create((windowId, inv, data) -> new AutoTraderContainer(windowId, inv))
    );
    public static final RegistryObject<MenuType<BreederContainer>> BREEDER_CONTAINER = MENU_TYPE_REGISTER.register("breeder", () ->
            IForgeMenuType.create((windowId, inv, data) -> new BreederContainer(windowId, inv))
    );
    public static final RegistryObject<MenuType<ConverterContainer>> CONVERTER_CONTAINER = MENU_TYPE_REGISTER.register("converter", () ->
            IForgeMenuType.create((windowId, inv, data) -> new ConverterContainer(windowId, inv))
    );
    public static final RegistryObject<MenuType<IncubatorContainer>> INCUBATOR_CONTAINER = MENU_TYPE_REGISTER.register("incubator", () ->
            IForgeMenuType.create((windowId, inv, data) -> new IncubatorContainer(windowId, inv))
    );
    public static final RegistryObject<MenuType<OutputContainer>> OUTPUT_CONTAINER = MENU_TYPE_REGISTER.register("output", () ->
            IForgeMenuType.create((windowId, inv, data) -> new OutputContainer(windowId, inv))
    );

    public static void init() {
        MENU_TYPE_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @OnlyIn(Dist.CLIENT)
    public static void clientSetup() {
        ClientRegistry.<AutoTraderContainer, AutoTraderScreen>registerScreen(AUTO_TRADER_CONTAINER.get(), AutoTraderScreen::new);
        ClientRegistry.<BreederContainer, BreederScreen>registerScreen(BREEDER_CONTAINER.get(), BreederScreen::new);
        ClientRegistry.<ConverterContainer, ConverterScreen>registerScreen(CONVERTER_CONTAINER.get(), ConverterScreen::new);
        ClientRegistry.<IncubatorContainer, IncubatorScreen>registerScreen(INCUBATOR_CONTAINER.get(), IncubatorScreen::new);
        ClientRegistry.<OutputContainer, OutputScreen>registerScreen(OUTPUT_CONTAINER.get(), OutputScreen::new);
    }

}
