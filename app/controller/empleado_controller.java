package app.controller;
import java.sql.*;
import conecction.conection;
import app.model.empleado;
import conecction.schema;

public class empleado_controller {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection(); 
    empleado user = new empleado();
    schema Schema = new schema();

    /**
     * @param nombre
     * @param usern_name
     * @param contrasena
     */
    public void create(String nombre, String usern_name, String contrasena){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);

            stmt = c.createStatement(); 
            System.out.println("Opened database successfully");
            String encrypt = user.encrypt_password(contrasena);
            CreateSql = "INSERT INTO Usuario (name,user_name,password) " + "values ('"+nombre+"', '"+usern_name+"', '"+encrypt+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    /**
     * @param user_name
     * @param password
     */
    public void login(String user_name , String password){
        if (user.validate_user(user_name, password) == true){
            System.out.println("Paso");
        }else{
            System.out.println("No paso");
        }
    }
    
}
