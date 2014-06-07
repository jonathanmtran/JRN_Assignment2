package data;

import java.io.*;
import java.util.*;
import business.*;

public class DataIO
{
    public static CellPhone getCellPhone(String code, String filepath)
    {
        try
        {
            File file = new File(filepath);
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String cellPhoneCode = t.nextToken();
                
                if (code.equals(cellPhoneCode))
                {
                    CellPhone c = new CellPhone();
                    c.setCode(cellPhoneCode);
                    c.setName(t.nextToken());
                    c.setImageLoc(t.nextToken());
                    c.setDescription(t.nextToken());
                    c.setSpecs(t.nextToken());
                    c.setPrice(Double.parseDouble(t.nextToken()));
                    in.close();
                    return c;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
}