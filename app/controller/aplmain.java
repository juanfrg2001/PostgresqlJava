package app.controller;
import conecction.conection;
import app.controller.user_controller;
import conecction.schema;
import app.model.user;

public class aplmain {

    public static void main(String[] args) {
        schema Schema = new schema();
        user_controller cont_user = new user_controller();
        Schema.connectDatabase(); 
        //Schema.createTables();
        cont_user.create("Juan", "juan", "felipe");



    }
}
