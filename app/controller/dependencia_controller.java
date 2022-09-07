package app.controller;
import java.sql.*;
import conecction.conection;
import app.model.empleado;
import conecction.schema;


public class dependencia_controller {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection(); 
    empleado user = new empleado();
    schema Schema = new schema();

    public void create(String dependencia){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);

            stmt = c.createStatement(); 
            System.out.println("Opened database successfully");
            CreateSql = "INSERT INTO dependencia(dependencia) " + "values ('"+dependencia+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }    
}
