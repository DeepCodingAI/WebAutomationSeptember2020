package table;

import base.CommonAPI;

public class SqlTablePage extends CommonAPI {

    public void readTableData(){
        String tableData = getWebText(".w3-table-all.notranslate tr:nth-child(4) td:nth-child(4)");
        System.out.println(tableData);
    }

}
