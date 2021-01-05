package datasuply;

import base.CommonAPI;
import datasources.ConnectToSqlDB;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    public List<String> getItemListFromDB() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = connectToSqlDB.readDataBase("ItemList", "items");
        return list;

    }
}
