package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    Properties property;

  /*  public PropertyManager() {
        Properties props = new Properties();
        try {
            props.load(new FileReader(new File(ClassLoader.getSystemResource("config.properties").getPath())));
            property = props;
        } catch (IOException ex) {
            // handle error
            System.out.println("Properties file not found!");
        }
    }*/


    public PropertyManager() {
        property = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Properties file not found!");
                return;
            }
            // Dosyayı yükle
            property.load(input);
        } catch (IOException ex) {
            ex.printStackTrace(); // Hata mesajını yazdır
        }
    }



    public String getProperty(String key) {
        Properties props = property;
        if (props != null) {
            return props.getProperty(key);
        }
        return null;
    }
}