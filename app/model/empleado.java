package app.model;
import java.sql.*;
import conecction.conection;
import conecction.schema;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import app.model.encrypt_password;

public class empleado {

    Connection c = null;

    String CreateSql = null;

    Statement stmt = null;

    conection javaPostgreSQLBasic = new conection(); 

    conection connection = new conection(); 
    encrypt_password encriptador = new encrypt_password();

    public String encrypt_password(String password){

        String encrypt_password = "";

        try {
            final String claveEncriptacion = "secreto!";            
            String datosOriginales = password;    
            
            String encriptado = encriptador.encriptar(datosOriginales, claveEncriptacion);
            encrypt_password = encriptado;
            String desencriptado = encriptador.desencriptar(encriptado, claveEncriptacion);
            
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(encrypt_password.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encrypt_password;

    }

    public String desencrypt_password(String password){

        String desencryp_password = "";

        try {
            final String claveEncriptacion = "secreto!";            
            String datosOriginales = password;    
            
            String encriptado = encriptador.encriptar(datosOriginales, claveEncriptacion);
            String desencriptado = encriptador.desencriptar(encriptado, claveEncriptacion);
            desencryp_password = desencriptado;
            
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(encrypt_password.class.getName()).log(Level.SEVERE, null, ex);
        }

        return desencryp_password;

    }

    public Boolean validate_user(String user_name, String password){

        Boolean validator = false;

        try{
            c = javaPostgreSQLBasic.getConnection();
            stmt = c.createStatement(); 

            String sql = "Select * From User" + "WHERE(user_name = '"+user_name+"' AND password = '"+desencrypt_password(password)+"'";
            if (stmt.executeQuery(sql).next()){
                validator = true;
            }

        }catch (Exception e){
        
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    
            System.exit(0);
    
        }
    
        return validator;
    }



   

    
    
    
}
