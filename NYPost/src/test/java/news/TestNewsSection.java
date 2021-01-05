package news;

import base.CommonAPI;
import features.AllFunctionality;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SectionPage;
import reporting.TestLogger;

import java.io.IOException;

public class TestNewsSection extends CommonAPI {

    @Test
    public void allFeatures() throws InterruptedException, IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        AllFunctionality functionality = PageFactory.initElements(driver, AllFunctionality.class);
        functionality.runAllTheFeatureTest(driver);

    }
}
