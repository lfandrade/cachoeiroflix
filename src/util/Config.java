package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Config {
    
    public Properties loadProperties(String file) {
        
        
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(file)) {

            prop.load(input);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;

    }
}
