package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SectionPage {

    @FindBy(how = How.CSS, using = "svg.menu-icon-svg")
    public static WebElement sectionNavBarWebElement;

    @FindBy(how = How.CSS, using = "#menu-main-menu li:nth-child(2)")
    public static WebElement metroMenuWebElement;

    public WebElement getSectionNavBarWebElement(){
        return sectionNavBarWebElement;
    }

    public WebElement getMetroMenuWebElement(){
        return metroMenuWebElement;
    }
    public void clickOnSectionTabMenu(){
        getSectionNavBarWebElement().click();
    }
    public MetroPage goToMetroPage(WebDriver driver){
        clickOnSectionTabMenu();
        getMetroMenuWebElement().click();
        return new MetroPage(driver);
    }
}
