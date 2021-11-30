package TestsLesson7.Steps;

import TestsLesson7.BaseEntities.BaseStep;
import TestsLesson7.Pages.CheckOutPage;
import org.openqa.selenium.WebDriver;

public class CheckOutStep extends BaseStep {
    public CheckOutStep(WebDriver driver) {
        super(driver);
    }
    public void checkOut (String firstName, String lastName, String postalCode){
        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setFirstName(firstName);
        checkOutPage.setLastName(lastName);
        checkOutPage.setPostalCode(postalCode);
        checkOutPage.clickContinue();
    }
}
