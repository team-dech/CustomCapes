package dechmods.customcapes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import dechmods.customcapes.client.CCTickHandler;
import dechmods.customcapes.network.CCPacketHandler;
import dechmods.customcapes.server.CCServerHandler;

@Mod(modid = "customcapes", name = "CustomCapes", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "ALLCAPES", "REFRESHCAPE" }, packetHandler = CCPacketHandler.class)
public class CustomCapes
{
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        CCServerHandler.loadCapes();
    }
    
    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event)
    {
        CCServerHandler.saveCapes();
    }
    
    @EventHandler
    public void load(FMLLoadEvent event)
    {
        TickRegistry.registerScheduledTickHandler(new CCTickHandler(), Side.CLIENT);
    }
}