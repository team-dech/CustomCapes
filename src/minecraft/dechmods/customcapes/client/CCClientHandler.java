package dechmods.customcapes.client;

import java.util.HashMap;

public class CCClientHandler
{
    public static HashMap<String, String> capes = new HashMap<String, String>();
    
    public static void refreshCape(String name, String url)
    {
        capes.put(name, url);
    }

    public static void getAllCapes(String[] names, String[] urls)
    {
        for (int i = 0; i < names.length; i++)
        {
            capes.put(names[i], urls[i]);
        }
    }

    public static void updateCapes()
    {
        // TODO Auto-generated method stub
    }   
}
