package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

public class ExcelUtil {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtil(String sheetName) {
        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("SauceDemo.xlsx");

            if (is == null) {
                throw new RuntimeException("Excel file not found in resources");
            }

            workbook = new XSSFWorkbook(is);
            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file", e);
        }
    }

    public String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).toString();
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }
}