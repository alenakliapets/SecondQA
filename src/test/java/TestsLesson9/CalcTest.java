package TestsLesson9;

import TestsLesson9.Data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest extends BaseTest{

    private Calculator calc = new Calculator("CalcTest");

    @Test(description = "Critical Path")
    public void testSum(){
        Assert.assertEquals(5, calc.sum(2, 3));
    }
    @Test(invocationCount = 20)
    public void testSum1(){
        Assert.assertEquals(6, calc.sum(2, 3));
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult){
Assert.assertEquals(expectedResult, calc.sum(a,b));
    }
}
