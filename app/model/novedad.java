package app.model;
import java.sql.*;
import conecction.conection;
import conecction.schema;

public class novedad {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    schema sh = new schema();
    conection con = new conection();
    ResultSet rs=null;

    schema Schema = new schema();

    conection javaPostgreSQLBasic = new conection();

    public boolean is_novedad_incapacidad(int empleado_id){
        Boolean validator = false;
        String sql = "";

        try{
            c = sh.connection();
            con.setConnection(c);
            stmt = c.createStatement(); 

            sql = "Select novedad_incapacidad From Novedad" + "WHERE(empleado_id = '"+empleado_id+"')";
            if (sql == "true"){
                validator = true;
            }

            if (stmt.executeQuery(sql).next()){
                validator = true;
            }

        }catch (Exception e){
        
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    
            System.exit(0);
    
        }
        return validator;
    }

    public int get_id_novedad(int novedad){
        int result = 0;

        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT novedad_id FROM public.novedad WHERE(empleado_id = '"+novedad+"')";
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
