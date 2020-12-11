package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestSearch extends CommonAPI {

    @Test
    public void test1(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books", Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).clear();
    }

    @Test
    public void test2(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Honey", Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).clear();
    }
}
