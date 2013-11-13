package dechmods.customcapes.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.HashMap;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.server.MinecraftServer;

public class CCServerHandler
{
    public static HashMap<String, String> capes = new HashMap<String, String>();
    
    public static void refreshCape(String username)
    {
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(outputBytes);
        
        try
        {
            outputStream.writeUTF(username);
            outputStream.writeUTF(capes.get(username));
            
            PacketDispatcher.sendPacketToAllPlayers(PacketDispatcher.getPacket("REFRESHCAPE", outputBytes.toByteArray()));
        }
        catch (Exception e) { }
    }

    public static void sendAllCapes(String username)
    {
        // TODO Auto-generated method stub
    }

    public static void loadCapes()
    {
        // TODO Auto-generated method stub
    }

    public static void saveCapes()
    {
        // TODO Auto-generated method stub
    }   
    
    public static boolean doesPlayerExist(String name)
    {
        return Arrays.asList(MinecraftServer.getServer().getAllUsernames()).contains(name);
    }
}
