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

public class empleado {

    Connection c = null;

    String CreateSql = null;

    Statement stmt = null;

    ResultSet rs=null;

    conection javaPostgreSQLBasic = new conection();
    
    schema sh = new schema();

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
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            System.out.println(desencrypt_password(password));
            String sql = "SELECT * FROM usuario WHERE(user_name = '"+user_name+"' AND user_password = '"+encrypt_password(password)+"')";
            rs = stmt.executeQuery(sql);
            validator = rs.next();

        }catch (Exception e){
        
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    
            System.exit(0);
    
        }
    
        return validator;
    }

    public int get_id_dependencia(String dependencia){
        int result = 0;

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT dependencia_id FROM public.dependencia WHERE(dependencia = '"+dependencia+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public int get_id_arl(String arl){
        int result = 0;

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT arl_id FROM public.arl WHERE(arl = '"+arl+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public int get_id_cargo(String cargo){
        int result = 0;

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT cargo_id FROM public.cargo WHERE(cargo = '"+cargo+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public int get_id_eps(String eps){
        int result = 0;

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT eps_id FROM public.eps WHERE(eps = '"+eps+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public int get_id_pension(String pension){
        int result = 0;

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT pension_id FROM public.pension WHERE(pension = '"+pension+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public int get_id_empleado(int codigo){
        int result = 0;

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT empleado_id FROM public.empleado WHERE(codigo = '"+codigo+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }


}
