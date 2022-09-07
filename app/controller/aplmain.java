package app.controller;
import app.view.view;
import conecction.conection;
import app.controller.empleado_controller;
import conecction.schema;
import app.model.operaciones.lectura_xlsx;
import app.model.empleado;

import javax.xml.validation.Schema;
import java.io.File;
import java.util.ArrayList;

public class aplmain {

    public static void main(String[] args) {
        schema Schema = new schema();
        Schema.connectDatabase();
        Schema.createUser();
        Schema.createTablesNomina();
        Schema.createTableEmpleado();
        Schema.createTableNovedades();

        lectura_xlsx lec = new lectura_xlsx();
        try{
            System.out.println(lec.readExcelNomina());
        }catch (Exception e){
            System.out.println(e);
        }




        empleado_controller cont_user = new empleado_controller();

    }
}
