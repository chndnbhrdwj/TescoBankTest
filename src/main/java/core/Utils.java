package core;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;
/**
 * Created by chandan on 4/10/19.
 */
public class Utils {

    static Properties props = new Properties();
    static File platformFile = new File("platform.yml");
    static File configFile = new File("config.properties");

    private static void loadPropertiesFile() {
        try {
            props.load(getInputStream(configFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputStream(File file) {
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static Map<String, Object> getPlatformCapabilities() {
        InputStream stream = getInputStream(platformFile);
        Map<String, Map<String, Object>> obj = new Yaml().load(stream);
        String platform = getProperty("runTestOn");
        return obj.get(platform);
    }

    public static String getProperty(String key) {
        loadPropertiesFile();
        return props.getProperty(key);
    }

    /*public static void setProperty(String key, String value) {
        OutputStream output = null;

            output = new FileOutputStream("platform.yml");

            loadPropertyFile();
        prop.setProperty(key, value);
        prop.store();
    }
*/

}
