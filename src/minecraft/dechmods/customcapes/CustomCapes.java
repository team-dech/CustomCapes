package dechmods.customcapes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "ccapes", name = "Custom Capes", version = "0.0.0.1a_dev")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CustomCapes
{
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
    }
    
    @EventHandler
    public void mainLoad(FMLLoadEvent event)
    {
    }
    
    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
    }
}