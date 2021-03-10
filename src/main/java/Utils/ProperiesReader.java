package Utils;

import java.io.*;
import java.util.Properties;
import static Utils.Log.info;

public class ProperiesReader {

    private Properties properties;
    private static final String PROPERTIES_CRED_FILE ="\\src\\test\\resources\\cred.properties";
    private static final String PROPERTIES_TEST_FILE ="\\src\\test\\resources\\test.properties";

    private Properties fileReader(String path) {
        try {
            String filename = getProjectDir() + path;
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

            if (inputStream == null){
               inputStream = new FileInputStream(new File(filename));
            }
            Properties result = new Properties();
            result.load(inputStream);
            return result;
        } catch (IOException e) {
            info("property file not found in the classpath");
            e.printStackTrace();
            return null;
        }

    }
    public String getProperty(String name, String path) {
        properties = fileReader(path);
        assert properties != null;
        String result = properties.getProperty(name);
        if ((result) != null && result.length() > 0) {
            return result;
        }
        return result;
    }

    public String getAtlassianLogin() {
        return getProperty("login", PROPERTIES_CRED_FILE);
    }
    public String getOctaPassword() {
        return getProperty("octaPassword", PROPERTIES_CRED_FILE);
    }
    public String getOctaLogin() {
        return getProperty("octaLogin", PROPERTIES_CRED_FILE);
    }
    public String getOctaSecret() {
        return getProperty("secret", PROPERTIES_CRED_FILE);
    }
    private String getProjectDir() {
        return System.getProperty("user.dir");
    }
    public String getDashboardName(){
        return  getProperty("dashboard", PROPERTIES_TEST_FILE);}
}