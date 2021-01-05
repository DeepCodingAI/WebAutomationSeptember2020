package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

public class News {

    @FindBy(how = How.CSS, using = "div.headline-container a:nth-child(2) h3")
    public static WebElement headLineNewsWebElement;

    public WebElement getHeadLineNewsWebElement(){
           return headLineNewsWebElement;
    }

    public void clickOnHeadLineNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        CommonAPI.waitUntilVisible(headLineNewsWebElement);
        String headLineNews = getHeadLineNewsWebElement().getText();
        System.out.println(headLineNews);
        CommonAPI.waitUntilClickAble(headLineNewsWebElement);
        getHeadLineNewsWebElement().click();
    }
}
