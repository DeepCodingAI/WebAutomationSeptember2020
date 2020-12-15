package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownMenu extends CommonAPI {

    @Test
    public void dropDown(){
        List<String> textList = getListOfText(".nav-search-dropdown.searchSelect option");
        printText(textList);
    }
}
