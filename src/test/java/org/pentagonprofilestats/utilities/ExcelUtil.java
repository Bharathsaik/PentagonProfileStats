package org.pentagonprofilestats.utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    FileInputStream fis;
    Workbook wb;
    Sheet sheet;
    Row row;

    //getting the row count from the sheet
    public int getRowCount(String filePath, String sheetName) throws IOException {
        fis  = new FileInputStream(filePath);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        wb.close();
        fis.close();
        return rowCount;
    }

    //getting cell count from the sheet
    public int getCellCount(String filePath, String sheetName, int rowCount) throws IOException {
        fis  = new FileInputStream(filePath);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowCount);
        int cellCount = row.getLastCellNum();
        wb.close();
        fis.close();
        return cellCount;
    }

    public String getCellData(String filePath, String sheetName, int rowCount, int cellCount) throws IOException {
        fis  = new FileInputStream(filePath);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowCount);
        Cell cell = row.getCell(cellCount);

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        wb.close();
        fis.close();
        return data;
    }
}
