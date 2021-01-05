package datafetch;

import base.CommonAPI;
import datasources.ConnectToExcelFile;
import reporting.TestLogger;

import java.io.IOException;

public class FetchTheSteps {

    ConnectToExcelFile excelFile = new ConnectToExcelFile();

    public String[] getDataFromExcelFile() throws IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String path = System.getProperty("user.dir")+"/data/nyp-test-steps.xls";
        String [] data = excelFile.fileReader2(path, 0);

        return data;
    }
}
