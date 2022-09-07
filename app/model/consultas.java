package app.model;

import conecction.conection;
import conecction.schema;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class consultas {

    Connection c = null;

    String CreateSql = null;

    Statement stmt = null;

    ResultSet rs=null;

    conection javaPostgreSQLBasic = new conection();

    schema sh = new schema();

    conection connection = new conection();

    public String consulta1(){
        String result = "";

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT a.nombre_empleado, b.dependencia, c.cargo, d.eps, f.num_dias_incapacidad, f.fecha_inicio, f.fecha_fin FROM empleado a INNER JOIN dependencia b ON a.dependencia_id = b.dependencia_id INNER JOIN cargo c ON c.cargo_id = a.cargo_id INNER JOIN eps d ON d.eps_id = a.eps_id INNER JOIN novedad e ON e.empleado_id = a.empleado_id INNER JOIN incapacidad f ON f.novedad_id = e.novedad_id WHERE e.novedad_incapacidad = true;";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7) + result + "\n";
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public String consulta2(){
        String result = "";

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT a.nombre_empleado, b.dependencia, c.cargo, e.num_dias_vacaciones, e.fecha_inicio, e.fecha_fin FROM empleado a INNER JOIN dependencia b ON a.dependencia_id = b.dependencia_id INNER JOIN cargo c ON c.cargo_id = a.cargo_id INNER JOIN novedad d ON d.empleado_id = a.empleado_id INNER JOIN vacacion e ON e.novedad_id = e.novedad_id WHERE d.novedad_vacaciones = true;";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7) + result + "\n";
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public String consulta3(){
        String result = "";

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT a.empleado_id, a.nombre_empleado, c.cargo, b.dependencia, d.bonificacion, d.transporte FROM empleado a INNER JOIN dependencia b ON b.dependencia_id = a.dependencia_id INNER JOIN cargo c ON c.cargo_id = a.cargo_id INNER JOIN novedad d ON d.empleado_id = a.empleado_id;";


            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7) + result + "\n";
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public String consulta4(){
        String result = "";

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT b.empleado_id, b.nombre_empleado, a.num_dias_trabajados, a.transporte, a.bonificacion FROM novedad a INNER JOIN empleado b ON b.empleado_id = a.empleado_id WHERE a.num_dias_trabajados <= 20;";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7) + result + "\n";
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public String consulta5(){
        String result = "";

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT c.dependencia, b.cargo, count(a.empleado_id) AS NumeroTrabajadores FROM empleado a INNER JOIN cargo b ON b.cargo_id = a.cargo_id INNER JOIN dependencia c ON c.dependencia_id = a.dependencia_id GROUP BY c.dependencia, b.cargo ORDER BY c.dependencia;";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7) + result + "\n";
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }

    public String consulta6(){
        String result = "";

        try{
            c = sh.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT a.nombre_empleado, b.eps, c.arl, d.pension FROM empleado a INNER JOIN eps b ON b.eps_id = a.eps_id INNER JOIN arl c ON c.arl_id = a.arl_id INNER JOIN pension d ON d.pension_id = a.pension_id;";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7) + result + "\n";
            }

        }catch (Exception e){

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }

        return result;
    }



}
