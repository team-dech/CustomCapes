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
                else if (args.length == 2)
                {                    
                    if (args[0].equals("clear"))
                    {
                        if (CCServerHandler.doesPlayerExist(args[1]))
                        {
                            CCServerHandler.capes.put(args[1], "");
                            CCServerHandler.refreshCape(args[1]);
                        }
                        else sender.sendChatToPlayer(ChatMessageComponent.createFromText("Couldn't find player " + args[1]));
                    }
                    else if (args[0].equals("set"))
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
                    if (CCServerHandler.doesPlayerExist(args[2]))
                    {
                        if (args[0].equals("set"))
                        {
                            CCServerHandler.capes.put(args[2], args[1]);
                            CCServerHandler.refreshCape(args[2]);
                        }
                        else
                        {
                            sendUsage(sender);
                        }
                    }
                    else sender.sendChatToPlayer(ChatMessageComponent.createFromText("Couldn't find player " + args[2]));
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
