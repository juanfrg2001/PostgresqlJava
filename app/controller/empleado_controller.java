package app.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import app.view.PanelInicio;
import app.view.view;
import conecction.conection;
import app.model.empleado;
import conecction.schema;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;

import javax.swing.*;

public class empleado_controller implements ActionListener {

    Connection c = null;
    String CreateSql = null;
    Statement stmt = null;
    conection javaPostgreSQLBasic = new conection();

    view vista = new view();
    empleado user = new empleado();
    schema Schema = new schema();

    public empleado_controller(){
        asignarOyentes(this);
    }

    private void asignarOyentes(ActionListener escuchador) {
        vista.getpInicial().getLogin().addActionListener(escuchador);

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

}
