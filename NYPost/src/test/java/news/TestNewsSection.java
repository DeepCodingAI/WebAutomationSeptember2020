package news;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SectionPage;

public class TestNewsSection extends CommonAPI {

    @Test
    public void allFeatures(){
        SectionPage sectionPage = PageFactory.initElements(driver, SectionPage.class);
        sectionPage.goToMetroPage(driver);
    }
}
