package news;

import base.CommonAPI;
import features.AllFunctionality;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SectionPage;

public class TestNewsSection extends CommonAPI {

    @Test
    public void allFeatures()throws InterruptedException{
        AllFunctionality functionality = PageFactory.initElements(driver, AllFunctionality.class);
        functionality.sectionsMenu(driver);

    }
}
