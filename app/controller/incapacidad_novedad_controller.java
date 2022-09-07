package app.controller;
import java.sql.*;
import java.util.Date;

import conecction.conection;
import app.model.empleado;
import conecction.schema;

public class incapacidad_novedad_controller {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection(); 
    empleado user = new empleado();
    schema Schema = new schema();

    public void create(int novedad_id ,int num_dias_vacaciones, String fecha_inicio, String fecha_fin){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);

            stmt = c.createStatement();
            CreateSql = "INSERT INTO incapacidad(novedad_id,num_dias_incapacidad,fecha_inicio,fecha_fin) " + "values ('"+novedad_id+"','"+num_dias_vacaciones+"','"+fecha_inicio+"','"+fecha_fin+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    } 
    
}
