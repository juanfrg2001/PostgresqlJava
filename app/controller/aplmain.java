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
        empleado_controller emp = new empleado_controller();
        empleado_controller cont_user = new empleado_controller();

    }
}
