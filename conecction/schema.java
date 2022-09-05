package conecction;
import java.sql.*;
import conecction.conection;

public class schema {

    Connection c = null;

    String CreateSql = null;

    Statement stmt = null;

    conection javaPostgreSQLBasic = new conection(); 

    public boolean connectDatabase() {
        boolean vreturn = false;
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            // Database connect
            // Conectamos con la base de datos
            c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/PostgresqlJava",
                "postgres", "root");

            javaPostgreSQLBasic.setConnection(c);
            boolean valid = c.isValid(50000);
            
            if (valid == true){
                vreturn = true;
            }

        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return vreturn;
    } 

    public void createTables(){
        try{

            c = javaPostgreSQLBasic.getConnection();
    
            stmt = c.createStatement(); 
    
            CreateSql = "Create Table Usuario(user_id SERIAL NOT NULL PRIMARY KEY, name varchar, user_name varchar(225) NOT NULL UNIQUE, password varchar) ";
    
            stmt.executeUpdate(CreateSql);
    
            stmt.close();
    
            c.close();

            System.out.println("Se crearon las tablas");
    
        }catch (Exception e){
    
          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    
          System.exit(0);
    
        }

    }
    
}
