package dechmods.customcapes.server;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class CCLoginHandler implements IPlayerTracker
{
    @Override
    public void onPlayerLogin(EntityPlayer player)
    {
        CCServerHandler.refreshCape(player.username);
        CCServerHandler.sendAllCapes(player.username);
    }

    @Override
    public void onPlayerLogout(EntityPlayer player) { }

    @Override
    public void onPlayerChangedDimension(EntityPlayer player) { }

    @Override
    public void onPlayerRespawn(EntityPlayer player) { }
    
}
