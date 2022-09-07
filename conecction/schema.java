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

    public void createUser(){
        try{

            c = connection();

            stmt = c.createStatement();

            CreateSql = "CREATE TABLE usuario (id int NOT NULL PRIMARY KEY, nombre varchar(50), user_name  varchar(260), password varchar(260));";

            stmt.executeUpdate(CreateSql);

            stmt.close();

            c.close();

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

    }

    public void createTableEmpleado(){
        try{

            c = connection();
    
            stmt = c.createStatement(); 
    
            CreateSql = "CREATE TABLE empleado (empleado_id SERIAL NOT NULL PRIMARY KEY, codigo int NOT NULL ,nombre_empleado varchar(50), fecha_ingreso varchar(50), sueldo varchar(50),dependencia_id int,cargo_id int,eps_id int,arl_id int,pension_id int,CONSTRAINT fk_dependencia_id FOREIGN KEY(dependencia_id) REFERENCES dependencia(dependencia_id), CONSTRAINT fk_cargo_id FOREIGN KEY(cargo_id) REFERENCES cargo(cargo_id), CONSTRAINT fk_eps_id FOREIGN KEY(eps_id) REFERENCES eps(eps_id), CONSTRAINT fk_arl_id FOREIGN KEY(arl_id) REFERENCES arl(arl_id), CONSTRAINT fk_pension_id FOREIGN KEY(pension_id) REFERENCES pension(pension_id));";

            stmt.executeUpdate(CreateSql);
    
            stmt.close();
    
            c.close();

    
        }catch (Exception e){
    
          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    
          System.exit(0);
    
        }

    }

    public void createTablesNomina(){
        try{

            c = connection();

            stmt = c.createStatement();

            String CreateSqlDependencia = "Create Table dependencia (dependencia_id SERIAL NOT NULL PRIMARY KEY, dependencia varchar(50) NOT NULL UNIQUE) ";
            String CreateSqlCargo = "Create Table cargo (cargo_id SERIAL NOT NULL PRIMARY KEY, cargo varchar(50) NOT NULL UNIQUE) ";
            String CreateSqlEps = "Create Table eps (eps_id SERIAL NOT NULL PRIMARY KEY, eps varchar(50) NOT NULL UNIQUE) ";
            String CreateSqlArl = "Create Table arl (arl_id SERIAL NOT NULL PRIMARY KEY, arl varchar(50) NOT NULL UNIQUE) ";
            String CreateSqlPension = "Create Table pension (pension_id SERIAL NOT NULL PRIMARY KEY, pension varchar(50) NOT NULL UNIQUE) ";

            stmt.executeUpdate(CreateSqlDependencia);
            stmt.executeUpdate(CreateSqlCargo);
            stmt.executeUpdate(CreateSqlEps);
            stmt.executeUpdate(CreateSqlArl);
            stmt.executeUpdate(CreateSqlPension);

            stmt.close();

            c.close();


        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

    }

    public void createTableNovedades(){
        try{

            c = connection();

            stmt = c.createStatement();

            String CreateNovedad = "CREATE TABLE novedad (novedad_id SERIAL NOT NULL PRIMARY KEY, empleado_id int,fecha_novedad date, novedad_incapacidad boolean,novedad_vacaciones boolean,num_dias_trabajados int,bonificacion int,transporte int,CONSTRAINT fk_empleado_id FOREIGN KEY(empleado_id) REFERENCES empleado(empleado_id)); ";

            String CreateVacaciones = "CREATE TABLE vacacion (vacacion_id SERIAL NOT NULL PRIMARY KEY, novedad_id int NOT NULL, num_dias_vacaciones int,fecha_inicio date, fecha_fin date, CONSTRAINT fk_novedad_id FOREIGN KEY(novedad_id) REFERENCES novedad(novedad_id));";
            String CreateIncapacidad = "CREATE TABLE incapacidad (incapacidad_id SERIAL NOT NULL PRIMARY KEY, novedad_id int NOT NULL, num_dias_incapacidad int,fecha_inicio date, fecha_fin date, CONSTRAINT fk_novedad_id2 FOREIGN KEY(novedad_id) REFERENCES novedad(novedad_id));";


            stmt.executeUpdate(CreateNovedad);
            stmt.executeUpdate(CreateVacaciones);
            stmt.executeUpdate(CreateIncapacidad);


            stmt.close();

            c.close();


        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

    }



    public Connection connection(){
        Connection connect = null;
        try{
            connect = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/PostgresqlJava",
                "postgres", "root");
            javaPostgreSQLBasic.setConnection(c);
        }catch(java.sql.SQLException sqle){
            System.out.println("Error: " + sqle);
        }
        return connect;       
    }
    
}
