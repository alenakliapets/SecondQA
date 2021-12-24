package TestsLesson9.Lesson9Classwork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flakyTest(){
       if (attempt == 4){
           Assert.assertTrue(true);
       }
       else {
           attempt++;
           throw new NullPointerException();
       }
    }
}
