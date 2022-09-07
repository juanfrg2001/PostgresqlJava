package app.model.operaciones;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import app.controller.*;
import app.model.empleado;
import app.model.novedad;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;


public class lectura_xlsx {

    empleado_controller empleado = new empleado_controller();

    novedad_controller novedad = new novedad_controller();

    vacaciones_incapacidad_controller vac = new vacaciones_incapacidad_controller();

    incapacidad_novedad_controller inc = new incapacidad_novedad_controller();

    empleado emp = new empleado();

    novedad nov = new novedad();
    dependencia_controller dependencia = new dependencia_controller();
    arl_controller arl = new arl_controller();
    cargo_controller cargo = new cargo_controller();
    eps_controller eps = new eps_controller();
    pension_controller pension = new pension_controller();
    public String readExcelNomina() throws IOException {
        String path = "../PostgresqlJavaBD/app/Nomina_Empleados.xlsx";
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

    public String readExcelNovedades() throws IOException {
        String path = "../PostgresqlJavaBD/app/Nomina_Empleados.xlsx";
        ArrayList<String>array = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(1);
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
                try {
                    int codigo = 0;
                    if (array.get(3) != "") {
                        codigo = Integer.parseInt(array.get(0));
                    }
                    String fecha_novedad = "06/09/2022";
                    String novedad_incapacidad = array.get(1);
                    String novedad_vacaciones = array.get(2);
                    int num_dias_trabajados_mes = 0;
                    if (array.get(3) != "") {
                        num_dias_trabajados_mes = Integer.parseInt(array.get(3));
                    }
                    String bonificacion = array.get(10);
                    String transporte = array.get(11);
                    Boolean nov_vacaciones = false;
                    Boolean nov_incapacidad = false;

                    if (novedad_vacaciones != "") {
                        nov_vacaciones = true;
                    }
                    if (novedad_incapacidad != "") {
                        nov_incapacidad = true;
                    }
                    int id = emp.get_id_empleado(codigo);

                    if (id != 0) {
                        novedad.create(emp.get_id_empleado(codigo), fecha_novedad, nov_incapacidad, nov_vacaciones, num_dias_trabajados_mes, bonificacion, transporte);
                    }

                    if (novedad_vacaciones != ""){
                        try{
                            int num_dias_incapacidad_mes = 0;
                            int id_novedad = nov.get_id_novedad(emp.get_id_empleado(codigo));
                            if(array.get(5) != ""){
                                num_dias_incapacidad_mes = Integer.parseInt(array.get(5));
                            }
                            String fecha_inicio_incapacidad = array.get(6);
                            String fecha_fin_incapacidad = array.get(7);
                            System.out.println("vacacion" + id_novedad);
                            if(id_novedad != 0){
                                vac.create(id_novedad,num_dias_incapacidad_mes,fecha_inicio_incapacidad,fecha_fin_incapacidad);
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }

                    if (novedad_incapacidad != ""){
                        try{
                            int id_novedad = nov.get_id_novedad(emp.get_id_empleado(codigo));
                            int num_dias_incapacidad_mes = 0;
                            if(array.get(4) != ""){
                                num_dias_incapacidad_mes = Integer.parseInt(array.get(4));
                            }
                            String fecha_inicio_incapacidad = array.get(8);
                            String fecha_fin_incapacidad = array.get(9);

                            if(id_novedad != 0){
                                inc.create(id_novedad,num_dias_incapacidad_mes,fecha_inicio_incapacidad,fecha_fin_incapacidad);
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
            cont++;
            array.clear();
        }
        String termino = "Se logro";

        return termino;
    }
}
