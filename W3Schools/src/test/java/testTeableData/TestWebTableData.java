package testTeableData;

import org.testng.annotations.Test;
import table.SqlTablePage;

public class TestWebTableData extends SqlTablePage {

    @Test
    public void readWebText(){
        readTableData();
    }
}
