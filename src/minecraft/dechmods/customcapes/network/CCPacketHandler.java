package dechmods.customcapes.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import dechmods.customcapes.client.CCClientHandler;

public class CCPacketHandler implements IPacketHandler
{
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        if (packet.channel == "REFRESHCAPE")
        {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        
            String name = "", url = "";
            
            try
            {
                name = inputStream.readUTF();
                url = inputStream.readUTF();
                CCClientHandler.refreshCape(name, url);
            }
            catch (Exception e) { }
        }
        
        if (packet.channel == "ALLCAPES")
        {
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
            
            String[] names, urls;
            short playerCount;
            
            try
            {
                playerCount = inputStream.readShort();
                
                names = new String[playerCount];
                urls = new String[playerCount];
                
                for (int i = 0; i < playerCount; i++)
                {
                    names[i] = inputStream.readUTF();
                    urls[i] = inputStream.readUTF();
                }
                
                CCClientHandler.getAllCapes(names, urls);
            }
            catch (Exception e) { }
            
            
        }
    }   
}
