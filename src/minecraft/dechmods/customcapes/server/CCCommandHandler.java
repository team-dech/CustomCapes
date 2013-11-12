package dechmods.customcapes.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CCCommandHandler extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "cc";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "/cc < clear | set <URL> [player] >";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        // TODO Auto-generated method stub
    }   
}
