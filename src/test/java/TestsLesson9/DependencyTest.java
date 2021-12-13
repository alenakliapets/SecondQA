package TestsLesson9;

import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void stepb(){
        System.out.println("Step 1");
    }

    @Test(dependsOnMethods = "stepb")
    public void steps(){
        System.out.println("Step 2");
    }

    @Test
    public void stepa(){
        System.out.println("Step 3");
    }

    @Test(dependsOnMethods = {"stepa","stepa"})
    public void stepc(){
        System.out.println("Step 4");
    }
}
