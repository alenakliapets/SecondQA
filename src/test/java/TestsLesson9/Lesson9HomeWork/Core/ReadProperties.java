package TestsLesson9.Lesson9HomeWork.Core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("HomeworkLesson9Properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return properties.getProperty("url");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getEmail() {
        return properties.getProperty("Email");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getProjectName(){return properties.getProperty("projectName");}

    public String getEditedProjectName(){return properties.getProperty("editedProjectName");}

    public String getProjectNameFor6Test(){return properties.getProperty("projectNameFor6Test");}

    public int getTimeout(){return Integer.parseInt(properties.getProperty("timeout"));}
}
