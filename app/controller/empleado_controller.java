package app.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import app.model.consultas;
import app.model.operaciones.lectura_xlsx;
import app.view.PanelInicio;
import app.view.view;
import conecction.conection;
import app.model.empleado;
import conecction.schema;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;

import javax.swing.*;

public class empleado_controller implements ActionListener {

    private Connection c = null;
    private String CreateSql = null;
    private Statement stmt = null;
    private conection javaPostgreSQLBasic = new conection();
    private view vista = new view();
    private empleado user = new empleado();
    private schema Schema = new schema();

    private consultas consulta = new consultas();

    public empleado_controller(){
        asignarOyentes(this);
    }

    private void asignarOyentes(ActionListener escuchador) {
        vista.getpInicial().getLogin().addActionListener(escuchador);
        vista.getpPrincipal().getCargarBD().addActionListener(escuchador);
        vista.getpPrincipal().getConsulta1().addActionListener(escuchador);
        vista.getpPrincipal().getConsulta2().addActionListener(escuchador);
        vista.getpPrincipal().getConsulta3().addActionListener(escuchador);
        vista.getpPrincipal().getConsulta4().addActionListener(escuchador);
        vista.getpPrincipal().getConsulta5().addActionListener(escuchador);
        vista.getpPrincipal().getConsulta6().addActionListener(escuchador);
        vista.getpPrincipal().getConectarBD().addActionListener(escuchador);
        vista.getpPrincipal().getCargartxt().addActionListener(escuchador);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.getpInicial().getLogin() == e.getSource()){
            String user_name = vista.getpInicial().getUsuario().getText().toString();
            String password = vista.getpInicial().getClave().getText().toString();
            if (user.validate_user(user_name, password) == true) {
                JOptionPane.showMessageDialog(null, "Login");
                vista.getpInicial().setVisible(false);
                vista.getpPrincipal().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Not login");
            }
        }
        if(vista.getpPrincipal().getCargartxt() == e.getSource()){
            JOptionPane.showMessageDialog(null, "Txt ya se encuentra cargado");
        }

        if(vista.getpPrincipal().getConectarBD() == e.getSource()){
            Schema.connectDatabase();
            JOptionPane.showMessageDialog(null, "Se a conectado a la BD");
        }

        if(vista.getpPrincipal().getCargarBD() == e.getSource()){
            Schema.connectDatabase();
            Schema.createUser();
            Schema.createTablesNomina();
            Schema.createTableEmpleado();
            Schema.createTableNovedades();

            lectura_xlsx lec = new lectura_xlsx();
            try{
                //System.out.println(lec.readExcelNomina());
                System.out.println(lec.readExcelNovedades());
            }catch (Exception i){
                System.out.println(i);
            }

        }

        if(vista.getpPrincipal().getConsulta1() == e.getSource()){
            JOptionPane.showMessageDialog(null, consulta.consulta1());
        }
        if(vista.getpPrincipal().getConsulta2() == e.getSource()){
            JOptionPane.showMessageDialog(null, consulta.consulta2());
        }
        if(vista.getpPrincipal().getConsulta3() == e.getSource()){
            JOptionPane.showMessageDialog(null, consulta.consulta3());
        }
        if(vista.getpPrincipal().getConsulta4() == e.getSource()){
            JOptionPane.showMessageDialog(null, consulta.consulta4());
        }
        if(vista.getpPrincipal().getConsulta5() == e.getSource()){
            JOptionPane.showMessageDialog(null, consulta.consulta5());
        }
        if(vista.getpPrincipal().getConsulta6() == e.getSource()){
            JOptionPane.showMessageDialog(null, consulta.consulta6());
        }



    }

    public void create(String codigo, String nombre_empleado, String fecha_ingreso, String sueldo, int dependencia_id, int cargo_id, int eps_id, int arl_id, int pension_id){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            CreateSql = "INSERT INTO empleado (codigo,nombre_empleado ,fecha_ingreso ,sueldo  ,dependencia_id ,cargo_id ,eps_id ,arl_id ,pension_id ) " + "VALUES ('"+codigo+"', '"+nombre_empleado+"', '"+fecha_ingreso+"', '"+sueldo+"', '"+dependencia_id+"', '"+cargo_id+"', '"+eps_id+"', '"+arl_id+"', '"+pension_id+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();
        
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void createUser(String nombre, String user_name, String user_password){
        try{
            c = Schema.connection();
            javaPostgreSQLBasic.setConnection(c);
            stmt = c.createStatement();
            CreateSql = "INSERT INTO usuario (id, nombre,user_name ,user_password) " + "VALUES (3,'"+nombre+"', '"+user_name+"', '"+user.encrypt_password(user_password)+"');";
            stmt.executeUpdate(CreateSql);
            stmt.close();
            c.close();

        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

}
