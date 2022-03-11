package com.tmb.automation.util.platform2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Html {
    public static String getString(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }
}
