package app.controller;
import conecction.conection;
import app.controller.empleado_controller;
import conecction.schema;
import app.model.empleado;

public class aplmain {

    public static void main(String[] args) {
        schema Schema = new schema();
        empleado_controller cont_user = new empleado_controller();
        Schema.connectDatabase(); 
        //Schema.createTables();
        cont_user.create("juan", "juan","felipe1972");




    }
}
