package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Core;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "dataForTestCase")
    public static Object[][] dataForTestCase(){
        return new Object[][]{
                {"Test Case Title", "Test Cases"+ "\n", "Test Case (Steps)"+"\n",
                        "Regression"+"\n", "Critical"+"\n"},
        };
    }
}

