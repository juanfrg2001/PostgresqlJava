package app.controller;
import conecction.conection;
import conecction.schema;

public class aplmain {

    public static void main(String[] args) {
        conection javaPostgreSQLBasic = new conection();
        schema Schema = new schema();
        Schema.connectDatabase(); 
        Schema.createTableTest();
    }
}
