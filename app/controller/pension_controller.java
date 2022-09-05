package app.controller;
import conecction.conection;

import java.sql.Connection;
import java.sql.Statement;
import app.model.empleado;
import conecction.schema;

public class pension_controller {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection(); 
    empleado user = new empleado();
    schema Schema = new schema();

    public void create(String pension){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);

            stmt = c.createStatement(); 
            System.out.println("Opened database successfully");
            CreateSql = "INSERT INTO Pension (pension) " + "values ('"+pension+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }    
}
