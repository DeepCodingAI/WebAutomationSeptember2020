package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {

    @FindBy(how = How.CSS, using = "span.menu-icon-svg")
    public static WebElement sectionNavBarWebElement;

    public static WebElement getSectionNavBarWebElement(){
        return sectionNavBarWebElement;
    }
    public static void clickOnSectionMenu(){
        getSectionNavBarWebElement().click();
    }
}
