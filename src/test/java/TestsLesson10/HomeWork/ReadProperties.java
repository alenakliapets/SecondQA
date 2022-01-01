package TestsLesson10.HomeWork;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("HomeworkLesson10.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUserDir() {
        return properties.getProperty("userDirectory");
    }

    public String getDownloadDir() {
        return properties.getProperty("downloadDirectory");
    }

    public int getTimeout(){return Integer.parseInt(properties.getProperty("timeout"));}
}

