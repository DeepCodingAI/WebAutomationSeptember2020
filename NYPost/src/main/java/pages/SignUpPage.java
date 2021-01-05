package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

public class SignUpPage {

    @FindBy(how = How.CSS, using = "#contact_fields_email")
    public static WebElement emailFieldWebElement;

    @FindBy(how = How.CSS, using = "div.submit-field > input[type=submit]")
    public static WebElement signUpWebElement;

    public WebElement getEmailFieldWebElement(){
        return emailFieldWebElement;
    }

    public WebElement getSignUpWebElement(){
        return signUpWebElement;
    }

    public void enterEmailAddress(String value){
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getEmailFieldWebElement().sendKeys(value);
    }

    public void clickOnSignUp(){
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getSignUpWebElement().click();
    }

}
