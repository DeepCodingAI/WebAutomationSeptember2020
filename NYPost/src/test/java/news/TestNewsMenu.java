package news;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestNewsMenu extends CommonAPI {

    @Test
    public void test1(){
        driver.findElement(By.cssSelector("svg.menu-icon-svg")).click();
    }
}
