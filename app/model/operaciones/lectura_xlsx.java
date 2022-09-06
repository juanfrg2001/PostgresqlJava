package app.model.operaciones;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;


public class lectura_xlsx {


    public ArrayList<String> readExcelNomina() throws IOException {
        String path = "../PostgresqlJava/app/Nomina_Empleados.xlsx";
        ArrayList<String>array = new ArrayList<String>();
        FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator iterator = firstSheet.iterator();

        DataFormatter formatter = new DataFormatter();

        while (iterator.hasNext()) {
            Row nextRow = (Row) iterator.next();
            Iterator cellIterator = nextRow.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = (Cell) cellIterator.next();
                String contenidoCelda = formatter.formatCellValue(cell);
                array.add(contenidoCelda);
            }
        }
        System.out.println(array);
        return array;


    }

    public void readExcelNovedades() throws IOException {
        String path = "../PostgresqlJava/app/Nomina_Empleados.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator iterator = firstSheet.iterator();

        DataFormatter formatter = new DataFormatter();
        while (iterator.hasNext()) {
            Row nextRow = (Row) iterator.next();
            Iterator cellIterator = nextRow.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = (Cell) cellIterator.next();
                String contenidoCelda = formatter.formatCellValue(cell);
                System.out.println("celda: " + contenidoCelda);
            }

        }


    }
}
