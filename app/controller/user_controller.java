package app.controller;
import java.sql.*;
import conecction.conection;
import app.model.user;

public class user_controller {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection(); 
    user user = new user();

    public void create(String nombre, String usern_name, String contrasena){

        try{
            c = javaPostgreSQLBasic.getConnection();
            stmt = c.createStatement(); 
            System.out.println("Opened database successfully");
            String encrypt = user.encrypt_password(contrasena);
            CreateSql = "insert into Usuario (name,user_name,password) " + "values ('"+nombre+"', '"+usern_name+"', '"+encrypt+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch(Exception e){
            System.out.println("problemas");
        }

    }

    public void update(){

    }

    public void destroy(){

    }

    public void login(){

    }
    
}
