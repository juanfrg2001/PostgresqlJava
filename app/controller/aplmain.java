package app.controller;
import conecction.conection;

public class aplmain {

    public static void main(String[] args) {
        conection javaPostgreSQLBasic = new conection();
        javaPostgreSQLBasic.connectDatabase(); 
    }

    
}
