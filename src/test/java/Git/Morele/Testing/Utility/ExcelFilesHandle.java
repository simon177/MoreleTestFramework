package Git.Morele.Testing.Utility;

import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by simon on 12.03.2017.
 */
public class ExcelFilesHandle {

    private static XSSFSheet workSheet;

    private static XSSFWorkbook workBook;

    private static XSSFCell cell;

    private static XSSFRow row;

    public static void getExcelFile(String Path, String SheetName) throws IOException {
        try {
            FileInputStream exclFile = new FileInputStream(Path);
            workBook = new XSSFWorkbook(exclFile);
            workSheet = workBook.getSheet(SheetName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String getData(int row, int column ){
        cell = workSheet.getRow(row).getCell(column);
        String returnData = cell.getStringCellValue();
        return returnData;
    }
}
