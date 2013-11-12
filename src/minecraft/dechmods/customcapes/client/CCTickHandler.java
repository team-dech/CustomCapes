package dechmods.customcapes.client;

import java.util.EnumSet;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class CCTickHandler implements IScheduledTickHandler
{
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        CCClientHandler.updateCapes();
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) { }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel()
    {
        return "CCTickHandler";
    }

    @Override
    public int nextTickSpacing()
    {
        return 200;
    }   
}
