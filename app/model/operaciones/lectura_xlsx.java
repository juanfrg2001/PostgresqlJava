package app.model.operaciones;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import app.controller.*;
import app.model.empleado;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;


public class lectura_xlsx {

    empleado_controller empleado = new empleado_controller();

    empleado emp = new empleado();
    dependencia_controller dependencia = new dependencia_controller();
    arl_controller arl = new arl_controller();
    cargo_controller cargo = new cargo_controller();
    eps_controller eps = new eps_controller();
    pension_controller pension = new pension_controller();
    public String readExcelNomina() throws IOException {
        ArrayList<String>arr = new ArrayList<String>();
        String path = "../PostgresqlJavaBD/app/Test2.xlsx";
        ArrayList<String>array = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator iterator = firstSheet.iterator();

        DataFormatter formatter = new DataFormatter();

        int cont = 0;
        while (iterator.hasNext()) {
            Row nextRow = (Row) iterator.next();
            Iterator cellIterator = nextRow.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = (Cell) cellIterator.next();
                String contenidoCelda = formatter.formatCellValue(cell);
                array.add(contenidoCelda);
            }
            if (cont > 0){

                String codigo = array.get(0);
                String nomber_empleado = array.get(1);
                String dependencia_v = array.get(2);
                String cargo_v = array.get(3);
                String fecha_ingreso = array.get(4);
                String eps_v = array.get(5);
                String arl_v = array.get(6);
                String pension_v = array.get(7);
                String sueldo = array.get(8);

                dependencia.create(dependencia_v);
                cargo.create(cargo_v);
                eps.create(eps_v);
                arl.create(arl_v);
                pension.create(pension_v);

                int id_dependencia = emp.get_id_dependencia(dependencia_v);
                int id_cargo = emp.get_id_cargo(cargo_v);
                int id_eps = emp.get_id_eps(eps_v);
                int id_arl = emp.get_id_arl(arl_v);
                int id_pension = emp.get_id_pension(pension_v);

                empleado.create(codigo,nomber_empleado,fecha_ingreso, sueldo,id_dependencia,id_cargo,id_eps,id_arl,id_pension);
            }
            cont++;
            array.clear();
        }
        String termino = "Se logro";

        return termino;


    }

    public void readExcelNovedades() throws IOException {
        String path = "../app/Test2.xlsx";
        ArrayList<String>arr = new ArrayList<String>();
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
                arr.add(contenidoCelda);
            }


        }


    }
}
