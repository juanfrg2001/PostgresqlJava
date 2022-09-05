package app.controller;
import java.sql.*;
import java.util.Date;

import conecction.conection;
import app.model.empleado;
import conecction.schema;

public class novedad_controller {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection(); 
    empleado user = new empleado();
    schema Schema = new schema();

    public void create(int empleado_id, Date fecha_novedad, boolean novedad_incapacidad, boolean novedad_vacaciones, int num_dias_trabajados, int bonificacion, int transporte){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);

            stmt = c.createStatement(); 
            System.out.println("Opened database successfully");
            CreateSql = "INSERT INTO Novedad (empleado_id,fecha_novedad,novedad_incapacidad,novedad_vacaciones,num_dias_trabajados,bonificacion,transporte) " + "values ('"+empleado_id+"','"+fecha_novedad+"','"+novedad_incapacidad+"','"+novedad_vacaciones+"','"+num_dias_trabajados+"','"+bonificacion+"','"+transporte+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }   
    
    
}
