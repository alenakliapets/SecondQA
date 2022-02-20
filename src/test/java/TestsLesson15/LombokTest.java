package TestsLesson15;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LombokTest {
    @Test
    public void lombokToStringTest(){
        UserLombok userLombok = new UserLombok("","");

        System.out.println(userLombok);
    }
    @Test
    public void lombokEqualsTest(){
        UserLombok userLombok1 = new UserLombok("Alex", "");
        UserLombok userLombok2 = new UserLombok("Alex", "");
       Assert.assertEquals(userLombok1, userLombok2);
    }

    @Test
    public void lombokBuilderTest(){
        UserBuilderLombok userBuilderLombok1 = UserBuilderLombok.builder()
                .firstname("Alex")
                .lastname("Ivanov")
                .build();
        UserBuilderLombok userBuilderLombok2 = UserBuilderLombok.builder()
                .firstname("Alex")
                .lastname("Ivanov")
                .build();
        System.out.println(userBuilderLombok1);
        Assert.assertEquals(userBuilderLombok1, userBuilderLombok2);
    }
}
