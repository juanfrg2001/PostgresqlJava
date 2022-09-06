package app.controller;
import conecction.conection;
import app.controller.empleado_controller;
import conecction.schema;
import app.model.operaciones.lectura_xlsx;
import app.model.empleado;

import java.io.File;
import java.util.ArrayList;

public class aplmain {

    public static void main(String[] args) {
        schema Schema = new schema();
        empleado_controller cont_user = new empleado_controller();
        //Schema.connectDatabase();
        lectura_xlsx lec = new lectura_xlsx();
        //Schema.createTables();
        //cont_user.create("juan", "juan","felipe1972");
        try{
            lec.readExcelNomina();
        }catch (Exception e){
            System.out.println(e);
        }






    }
}
