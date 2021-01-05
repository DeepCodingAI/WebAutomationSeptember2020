package search;

import base.CommonAPI;
import datasuply.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestSearch extends CommonAPI {
    DataReader dataReader = new DataReader();
    @Test
    public void search() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = dataReader.getItemListFromDB();
        for(String items:list) {
            typeOnWebElementNHitEnter("#twotabsearchtextbox", items);
            clearInputField("#twotabsearchtextbox");
        }

    }
}
