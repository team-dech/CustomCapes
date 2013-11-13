package dechmods.customcapes.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

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
        return "/cc < clear [player] | set <URL> [player] >";
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) sender;
            
            if (args.length == 0)
            {
                sendUsage(sender);
            }
            else
            {
                if (args.length == 1 && args[0].equals("clear"))
                {
                    CCServerHandler.capes.put(player.username, "");
                    CCServerHandler.refreshCape(player.username);
                }
                else if (args.length == 2) // clear [player] / set <URL>
                {
                    String arg1 = args[0], arg2 = args[1];
                    
                    if (arg1.equals("clear"))
                    {
                        CCServerHandler.capes.put(args[1], "");
                        CCServerHandler.refreshCape(args[1]);
                    }
                    else if (arg1.equals("set"))
                    {
                        CCServerHandler.capes.put(player.username, args[1]);
                        CCServerHandler.refreshCape(player.username);
                    }
                    else
                    {
                        sendUsage(sender);
                    }
                }
                else if (args.length == 3)
                {
                    String arg1 = args[0], arg2 = args[1], arg3 = args[2];
                    
                    if (arg1.equals("set"))
                    {   
                        CCServerHandler.capes.put(args[2], args[1]);
                        CCServerHandler.refreshCape(args[2]);
                    }
                    else
                    {
                        sendUsage(sender);
                    }
                }
                else
                {
                    sendUsage(sender);
                }
            }
        }
    }
    
    public void sendUsage(ICommandSender ics)
    {
        ics.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.DARK_RED + "USAGE: " + getCommandUsage(ics)));
    }
}
