package TestsLesson14;

import TestsLesson10.HomeWork.BaseTest;
import TestsLesson14.Models.Singleton;
import TestsLesson14.Models.User;
import TestsLesson14.Models.UserBuilder;
import org.testng.annotations.Test;

public class ValueObjectTest extends BaseTest {

    @Test
    public void valueObjectTest1(){
        User user = setupUser();
LoginStep loginStep = new LoginStep(driver);
loginStep.login(user);
    }

    @Test
    public void singletonTest(){
        System.out.println(Singleton.getInstance());

    }

    private User setupUser(){
        User user = new User();
        user.setEmail("ckarlettt@rambler.ru");
        user.setPassword("R36jfYvh2I1qvUBBSOSe");
        user.setFirstname("Alex");
        user.setLastname("Ivanov");
        return user;
    }

    private UserBuilder setupUserBuilder(){
        UserBuilder user = new UserBuilder.Builder()
                .withFirstName("Alex")
                .withLastName("Ivanov")
                .withPasswordName("R36jfYvh2I1qvUBBSOSe")
                .withEmailName("ckarlettt@rambler.ru")
                .build();
        return user;
    }
}
