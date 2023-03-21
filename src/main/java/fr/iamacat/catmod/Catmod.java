package fr.iamacat.catmod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.catmod.entities.tnt.EntityCatTnt;
import fr.iamacat.catmod.init.RegisterEntity;
import fr.iamacat.catmod.proxy.CommonProxy;
import fr.iamacat.catmod.renders.tnt.RenderCatTnt;
import fr.iamacat.catmod.init.RegisterBlocks;
import fr.iamacat.catmod.init.RegisterItems;
import fr.iamacat.catmod.utils.CatTab;
import fr.iamacat.catmod.utils.Reference;
import fr.iamacat.catmod.worldgen.oregen.CatOreGen;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSION)
public class Catmod {
    @Mod.Instance(Reference.MOD_ID)
    public static Catmod instance;

    public static CommonProxy proxy;

    public static CreativeTabs catTab = new CatTab("catTab");

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegisterItems.init();
        RegisterItems.register();
        RegisterBlocks.init();
        RegisterBlocks.register();
        GameRegistry.registerWorldGenerator(new CatOreGen(), 0);

        // Register your custom entity here
        EntityRegistry.registerModEntity(EntityCatTnt.class, "CatTntEntity", 1, Catmod.instance, 64, 1, true);

        // Register your entity rendering handler
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        RenderingRegistry.registerEntityRenderingHandler(EntityCatTnt.class, new RenderCatTnt());

         /*
Register your entity rendering handler
int entityId = EntityRegistry.findGlobalUniqueEntityId();
RenderingRegistry.registerEntityRenderingHandler(EntityCatTnt.class, new RenderCatTnt());
Register your custom dimension here
If you want to add more custom entities, you can use the code below as a template
EntityRegistry.registerModEntity(EntityCatTnt.class, "my_custom_entity", 1, Catmod.instance, 64, 1, true);
RenderingRegistry.registerEntityRenderingHandler(EntityCatTnt.class, new EntityCatTnt.RenderCatTnt(RenderManager.instance));
        */
    }
    public static class WorldLoadHandler {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegisterEntity.init();
        }
    }