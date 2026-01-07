package org.pentagonprofilestats.utilities;

import java.io.IOException;

public class ExcelDataProvider {

    ExcelUtil excelUtil = new ExcelUtil();

    public Object[][] getData(String filepath, String sheetName) throws IOException {

        int rowCount = excelUtil.getRowCount(filepath, sheetName);
        int cellCount = excelUtil.getCellCount(filepath, sheetName, 0);

        Object[][] data = new Object[rowCount][cellCount];

        for(int i=1; i<=rowCount; i++){
            for(int j=0; j<cellCount; j++){
                data[i-1][j]=excelUtil.getCellData(filepath, sheetName, i, j);
            }
        }
        return data;
    }
}