package PaqueteNomina;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Principal.mdiMenuPrincipal;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Calendar;

/**
 *
 * @author Heydi Quemé
 */
/*
 * La función de este form es permitir el registro de empleados en la nómina.
 * También se puede modificar y eliminar empleados de la misma.
 * Este form relaciona a los empleados con los conceptos según sus puestos, permitiéndo
 * de este modo la aplicacion de impuestos y cuotas a los mismos.
 */

public class Nómina extends javax.swing.JFrame {

    private int x;
    private int y;
    public static int clic;

    public void comboDB() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Nombre_Empleado from Empleados");
            ResultSet rs2 = pst2.executeQuery();

            cmbxNombreEmpleado.addItem("Seleccione una opción");
            while (rs2.next()) {
                cmbxNombreEmpleado.addItem(rs2.getString("Nombre_Empleado"));
            }
        } catch (Exception e) {

        }
    }

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Nomina");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Fecha");
            modelo.addColumn("Empleado");
            modelo.addColumn("Concepto");
            modelo.addColumn("Líquido");
            tbl_Nomina.setModel(modelo);
            String[] dato = new String[5];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(4);
                dato[4] = rss4.getString(5);

                modelo.addRow(dato);
            }

        } catch (Exception e) {

        }

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Empleados");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Empleado");
            tbl_Empleados.setModel(modelo);
            String[] dato = new String[5];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);

                modelo.addRow(dato);
            }

        } catch (Exception e) {

        }
    }

    public void tabla() {
        try {
            String ID = puesto.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Conceptos where codigo_puesto=" + ID);
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Valor");

            tbl_concep.setModel(modelo);
            String[] dato = new String[7];
            while (rss4.next()) {
                dato[0] = rss4.getString(3);
                dato[1] = rss4.getString(7);

                modelo.addRow(dato);
            }

        } catch (Exception e) {

        }

    }

    public void conceptos() {

        //IGSS
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Igss")) {
                    Double sb = Double.valueOf(txtSueldoBase.getText().trim());
                    Double res = sb * 0.0483;
                    txtIgss.setText(String.valueOf(res));
                } else {
                    txtIgss.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //ISR
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Isr")) {
                    Double sb = Double.valueOf(txtSueldoBase.getText().trim());
                    Double res = sb * 0.05;
                    txtIsr.setText(String.valueOf(res));
                } else {
                    txtIsr.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //ANTICIPOS
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Anticipos")) {
                    txtAnticipos.setText(String.valueOf(b));
                } else {
                    txtAnticipos.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //DESCUENTOS JUDICIALES
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Isr")) {
                    txtDescuentosJ.setText(String.valueOf(b));
                } else {
                    txtDescuentosJ.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //OTROS DESCUENTOS
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Otros Descuentos")) {
                    txtOtrosDescuentos.setText(String.valueOf(b));
                } else {
                    txtOtrosDescuentos.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //CUOTA PATRONAL
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Cuota Patronal")) {
                    Double sb = Double.valueOf(txtSueldoBase.getText().trim());
                    Double res = sb * 0.1264;
                    txtCuotaPatronal.setText(String.valueOf(res));
                } else {
                    txtCuotaPatronal.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //COMISIONES
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Comisiones")) {
                    txtComisiones.setText(String.valueOf(b));
                } else {
                    txtComisiones.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //HORAS EXTRAS
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Horas Extras")) {
                    txtBonificacionesExtra.setText(String.valueOf(b));
                } else {
                    txtBonificacionesExtra.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //INCENTIVO
        try {
            for (int i = 0; i < tbl_concep.getRowCount(); i++) {

                String a = tbl_concep.getValueAt(i, 0).toString();
                String b = tbl_concep.getValueAt(i, 1).toString();

                if (a.equals("Isr")) {
                    txtBonificacionIncentivo.setText(String.valueOf(b));
                } else {
                    txtBonificacionIncentivo.setText("0");
                }
            }
        } catch (Exception e1) {
            // ..................................
        }

        //SUELDO DEVENGADO
        Double sd = Double.valueOf(txtComisiones.getText()) + Double.valueOf(txtBonificacionesExtra.getText()) + Double.valueOf(txtBonificacionIncentivo.getText()) + Double.valueOf(txtSueldoBase.getText());
        txtSueldoDevengado.setText(String.valueOf(sd));

        //TOTAL DESCUENTOS
        Double desc = Double.valueOf(txtIgss.getText()) + Double.valueOf(txtIsr.getText()) + Double.valueOf(txtAnticipos.getText()) + Double.valueOf(txtDescuentosJ.getText()) + Double.valueOf(txtOtrosDescuentos.getText());
        txtTotalDescuentos.setText(String.valueOf(desc));

        //LIQUIDO
        Double liquido = Double.valueOf(txtSueldoDevengado.getText()) - Double.valueOf(txtTotalDescuentos.getText());
        txtSueldoLiquido.setText(String.valueOf(liquido));
    }

    public void buscar_nombreempleado() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Empleados where Codigo_Empleado = ?");

            pst.setString(1, codigoe.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                nombremp.setText(rs.getString("Nombre_Empleado"));
                String ne = nombremp.getText();
                cmbxNombreEmpleado.setSelectedItem(ne);

            } else {

            }

        } catch (Exception e) {

        }
    }

    public void bitacora_eliminar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());

            String u = buscar.getText();
            pst.setString(3, "Eliminó el registro de nómina " + u);

            Calendar calendario = Calendar.getInstance();

            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);

            Calendar c1 = Calendar.getInstance();
            String dia = Integer.toString(c1.get(Calendar.DATE));
            String mes = Integer.toString(c1.get(Calendar.MONTH));
            String annio = Integer.toString(c1.get(Calendar.YEAR));

            String fecha = dia + "/" + mes + "/" + annio;
            String time = hora + ":" + minutos + ":" + segundos;

            date1.setText(fecha);
            timee.setText(time);

            pst.setString(4, date1.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public void bitacora_guardar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = date.getDate().toString();
            empleado.setText(cmbxNombreEmpleado.getSelectedItem().toString());
            String emp = empleado.getText();
            pst.setString(3, "Registró el concepto " + u + " que pertenece al empleado " + emp);

            Calendar calendario = Calendar.getInstance();

            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);

            Calendar c1 = Calendar.getInstance();
            String dia = Integer.toString(c1.get(Calendar.DATE));
            String mes = Integer.toString(c1.get(Calendar.MONTH));
            String annio = Integer.toString(c1.get(Calendar.YEAR));

            String fecha = dia + "/" + mes + "/" + annio;
            String time = hora + ":" + minutos + ":" + segundos;

            date1.setText(fecha);
            timee.setText(time);

            pst.setString(4, date1.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public void bitacora_modificar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = buscar.getText();
            pst.setString(3, "Modificó el registro de nómina " + u);

            Calendar calendario = Calendar.getInstance();

            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);

            Calendar c1 = Calendar.getInstance();
            String dia = Integer.toString(c1.get(Calendar.DATE));
            String mes = Integer.toString(c1.get(Calendar.MONTH));
            String annio = Integer.toString(c1.get(Calendar.YEAR));

            String fecha = dia + "/" + mes + "/" + annio;
            String time = hora + ":" + minutos + ":" + segundos;

            date1.setText(fecha);
            timee.setText(time);

            pst.setString(4, date1.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public void bitacora_busqueda() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = buscar.getText();
            pst.setString(3, "Buscó el registro de nómina " + u);

            Calendar calendario = Calendar.getInstance();

            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);

            Calendar c1 = Calendar.getInstance();
            String dia = Integer.toString(c1.get(Calendar.DATE));
            String mes = Integer.toString(c1.get(Calendar.MONTH));
            String annio = Integer.toString(c1.get(Calendar.YEAR));

            String fecha = dia + "/" + mes + "/" + annio;
            String time = hora + ":" + minutos + ":" + segundos;

            date1.setText(fecha);
            timee.setText(time);

            pst.setString(4, date1.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public void tema() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    fechanomina.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                    lblIngresodeDatos.setForeground(new java.awt.Color(0, 0, 0));
                    lblNombreEmpleado.setForeground(new java.awt.Color(0, 0, 0));
                    codigoe.setForeground(new java.awt.Color(0, 0, 0));
                    lblSueldoBase.setForeground(new java.awt.Color(0, 0, 0));

                    lblCalculodeIngresos.setForeground(new java.awt.Color(0, 0, 0));
                    lblComisiones.setForeground(new java.awt.Color(0, 0, 0));
                    lblBonificacionesExtra.setForeground(new java.awt.Color(0, 0, 0));
                    lblBonificacionIncentivo.setForeground(new java.awt.Color(0, 0, 0));
                    lblSueldoDevengado.setForeground(new java.awt.Color(0, 0, 0));
                    lblCalculodeDescuentos.setForeground(new java.awt.Color(0, 0, 0));
                    lblIgss.setForeground(new java.awt.Color(0, 0, 0));
                    lblIsr.setForeground(new java.awt.Color(0, 0, 0));
                    lblAnticipos.setForeground(new java.awt.Color(0, 0, 0));
                    lblDescuentosJ.setForeground(new java.awt.Color(0, 0, 0));
                    lblOtrosDescuentos.setForeground(new java.awt.Color(0, 0, 0));
                    lblTotalDescuentos.setForeground(new java.awt.Color(0, 0, 0));
                    lblTotalDescuentos1.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
                    ln1.setVisible(false);
                    ln2.setVisible(false);
                    lb1.setVisible(true);
                    lb2.setVisible(true);
                    txtSueldoBase.setForeground(new java.awt.Color(0, 0, 0));
                    txtComisiones.setForeground(new java.awt.Color(0, 0, 0));
                    txtBonificacionIncentivo.setForeground(new java.awt.Color(0, 0, 0));
                    txtBonificacionesExtra.setForeground(new java.awt.Color(0, 0, 0));
                    txtSueldoDevengado.setForeground(new java.awt.Color(0, 0, 0));
                    txtIgss.setForeground(new java.awt.Color(0, 0, 0));
                    txtIsr.setForeground(new java.awt.Color(0, 0, 0));
                    txtAnticipos.setForeground(new java.awt.Color(0, 0, 0));
                    txtDescuentosJ.setForeground(new java.awt.Color(0, 0, 0));
                    txtOtrosDescuentos.setForeground(new java.awt.Color(0, 0, 0));
                    txtTotalDescuentos.setForeground(new java.awt.Color(0, 0, 0));
                    txtSueldoLiquido.setForeground(new java.awt.Color(0, 0, 0));
                    buscar.setForeground(new java.awt.Color(0, 0, 0));
                    lblCP.setForeground(new java.awt.Color(0, 0, 0));
                    txtCuotaPatronal.setForeground(new java.awt.Color(0, 0, 0));
                    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
                    btnIngresar.setVisible(true);
                    btnIngresar1.setVisible(false);
                    limpiarbtn1.setVisible(true);
                    btnLimpiar1.setVisible(false);
                    btnEliminar.setVisible(true);
                    btnEliminar1.setVisible(false);
                    btnModificar1.setVisible(true);
                    btnModificar2.setVisible(false);
                    buscarbtn1.setVisible(true);
                    btnBuscar1.setVisible(false);
                    btnCerrar1.setVisible(false);
                    cerrarbtn1.setVisible(true);
                    btnMinimizar1.setVisible(false);
                    minimizarbtn1.setVisible(true);

                } else {
                    if (code.getText().contains("Oscuro")) {
                        fechanomina.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                        lblIngresodeDatos.setForeground(new java.awt.Color(255, 255, 255));
                        lblNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
                        codigoe.setForeground(new java.awt.Color(255, 255, 255));
                        lblSueldoBase.setForeground(new java.awt.Color(255, 255, 255));

                        lblCalculodeIngresos.setForeground(new java.awt.Color(255, 255, 255));
                        lblComisiones.setForeground(new java.awt.Color(255, 255, 255));
                        lblBonificacionesExtra.setForeground(new java.awt.Color(255, 255, 255));
                        lblBonificacionIncentivo.setForeground(new java.awt.Color(255, 255, 255));
                        lblSueldoDevengado.setForeground(new java.awt.Color(255, 255, 255));
                        lblCalculodeDescuentos.setForeground(new java.awt.Color(255, 255, 255));
                        lblIgss.setForeground(new java.awt.Color(255, 255, 255));
                        lblIsr.setForeground(new java.awt.Color(255, 255, 255));
                        lblAnticipos.setForeground(new java.awt.Color(255, 255, 255));
                        lblDescuentosJ.setForeground(new java.awt.Color(255, 255, 255));
                        lblOtrosDescuentos.setForeground(new java.awt.Color(255, 255, 255));
                        lblCP.setForeground(new java.awt.Color(255, 255, 255));
                        txtCuotaPatronal.setForeground(new java.awt.Color(255, 255, 255));
                        lblTotalDescuentos.setForeground(new java.awt.Color(255, 255, 255));
                        lblTotalDescuentos1.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                        ln1.setVisible(true);
                        ln2.setVisible(true);
                        lb1.setVisible(false);
                        lb2.setVisible(false);
                        txtSueldoBase.setForeground(new java.awt.Color(255, 255, 255));
                        txtComisiones.setForeground(new java.awt.Color(255, 255, 255));
                        txtBonificacionIncentivo.setForeground(new java.awt.Color(255, 255, 255));
                        txtBonificacionesExtra.setForeground(new java.awt.Color(255, 255, 255));
                        txtSueldoDevengado.setForeground(new java.awt.Color(255, 255, 255));
                        txtIgss.setForeground(new java.awt.Color(255, 255, 255));
                        txtIsr.setForeground(new java.awt.Color(255, 255, 255));
                        txtAnticipos.setForeground(new java.awt.Color(255, 255, 255));
                        txtDescuentosJ.setForeground(new java.awt.Color(255, 255, 255));
                        txtOtrosDescuentos.setForeground(new java.awt.Color(255, 255, 255));
                        txtTotalDescuentos.setForeground(new java.awt.Color(255, 255, 255));
                        txtSueldoLiquido.setForeground(new java.awt.Color(255, 255, 255));
                        buscar.setForeground(new java.awt.Color(255, 255, 255));
                        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
                        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
                        btnIngresar.setVisible(false);
                        btnIngresar1.setVisible(true);
                        limpiarbtn1.setVisible(false);
                        btnLimpiar1.setVisible(true);
                        btnEliminar.setVisible(false);
                        btnEliminar1.setVisible(true);
                        btnModificar1.setVisible(false);
                        btnModificar2.setVisible(true);
                        buscarbtn1.setVisible(false);
                        btnBuscar1.setVisible(true);
                        btnCerrar1.setVisible(true);
                        cerrarbtn1.setVisible(false);
                        btnMinimizar1.setVisible(true);
                        minimizarbtn1.setVisible(false);
                    }
                }

            } else {
            }

        } catch (Exception e) {
        }
    }

    public int getClic() {
        int c = 0;

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                c = Integer.valueOf(rs.getString("clic"));
            } else {
            }

        } catch (Exception e) {
        }
        return c;
    }

    public Nómina() {
        initComponents();

        txtSueldoBase.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtComisiones.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtBonificacionIncentivo.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtBonificacionesExtra.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtSueldoDevengado.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtIgss.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtIsr.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtAnticipos.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtDescuentosJ.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtOtrosDescuentos.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtTotalDescuentos.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtSueldoLiquido.setBackground(new java.awt.Color(0, 0, 0, 1));
        buscar.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtCuotaPatronal.setBackground(new java.awt.Color(0, 0, 0, 1));

        tablas();
        comboDB();
        setLocationRelativeTo(null);
        getClic();
        this.clic = getClic();
        tema();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombremp = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        empleado = new javax.swing.JLabel();
        Claro = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        puesto = new javax.swing.JLabel();
        buscarbtn1 = new temaclaro.Buscarbtn();
        btnBuscar1 = new temanegro.btnBuscar();
        txtOtrosDescuentos = new javax.swing.JTextField();
        lblOtrosDescuentos = new javax.swing.JLabel();
        txtBonificacionesExtra = new javax.swing.JTextField();
        lblCalculodeIngresos = new javax.swing.JLabel();
        lblBonificacionesExtra = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        txtBonificacionIncentivo = new javax.swing.JTextField();
        lblComisiones = new javax.swing.JLabel();
        lblBonificacionIncentivo = new javax.swing.JLabel();
        fechanomina = new javax.swing.JLabel();
        txtSueldoDevengado = new javax.swing.JTextField();
        txtComisiones = new javax.swing.JTextField();
        lblSueldoDevengado = new javax.swing.JLabel();
        codigoe = new javax.swing.JLabel();
        txtSueldoBase = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Nomina = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Empleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblCalculodeDescuentos = new javax.swing.JLabel();
        lblSueldoBase = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblIgss = new javax.swing.JLabel();
        txtIgss = new javax.swing.JTextField();
        txtIsr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblIsr = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_concep = new javax.swing.JTable();
        txtTotalDescuentos = new javax.swing.JTextField();
        lblTotalDescuentos = new javax.swing.JLabel();
        txtSueldoLiquido = new javax.swing.JTextField();
        lblTotalDescuentos1 = new javax.swing.JLabel();
        txtAnticipos = new javax.swing.JTextField();
        lblAnticipos = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cmbxNombreEmpleado = new javax.swing.JComboBox<>();
        txtCuotaPatronal = new javax.swing.JTextField();
        lblCP = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtDescuentosJ = new javax.swing.JTextField();
        lblDescuentosJ = new javax.swing.JLabel();
        lblIngresodeDatos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        btnCerrar1 = new temanegro.btnCerrar();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        btnMinimizar1 = new temanegro.btnMinimizar();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnIngresar = new temaclaro.Guardarbtn();
        limpiarbtn1 = new temaclaro.Limpiarbtn();
        btnLimpiar1 = new temanegro.btnLimpiar();
        btnModificar1 = new temaclaro.Editarbtn();
        btnEliminar = new temaclaro.Eliminarbtn();
        btnEliminar1 = new temanegro.btnEliminar();
        btnModificar2 = new temanegro.btnEditar();
        btnIngresar1 = new temanegro.btnGuardar();
        buscar = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        ln1 = new javax.swing.JLabel();
        ln2 = new javax.swing.JLabel();

        nombremp.setText("jLabel2");

        usuario.setText("jLabel6");

        date1.setText("jLabel1");

        timee.setText("jLabel1");

        empleado.setText("jLabel2");

        Claro.setText("0");

        code.setText("0");

        puesto.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarbtn1.setText("buscarbtn1");
        buscarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarbtn1MousePressed(evt);
            }
        });
        getContentPane().add(buscarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        btnBuscar1.setText("btnBuscar1");
        btnBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscar1MousePressed(evt);
            }
        });
        getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        txtOtrosDescuentos.setEditable(false);
        txtOtrosDescuentos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOtrosDescuentos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtOtrosDescuentos.setOpaque(false);
        txtOtrosDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtrosDescuentosActionPerformed(evt);
            }
        });
        txtOtrosDescuentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtrosDescuentosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtrosDescuentosKeyTyped(evt);
            }
        });
        getContentPane().add(txtOtrosDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 120, -1));

        lblOtrosDescuentos.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblOtrosDescuentos.setText("Otros Descuentos:");
        getContentPane().add(lblOtrosDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 130, -1));

        txtBonificacionesExtra.setEditable(false);
        txtBonificacionesExtra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtBonificacionesExtra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtBonificacionesExtra.setOpaque(false);
        txtBonificacionesExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBonificacionesExtraActionPerformed(evt);
            }
        });
        txtBonificacionesExtra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBonificacionesExtraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBonificacionesExtraKeyTyped(evt);
            }
        });
        getContentPane().add(txtBonificacionesExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 120, -1));

        lblCalculodeIngresos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblCalculodeIngresos.setText("Calculo de Ingresos");
        getContentPane().add(lblCalculodeIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        lblBonificacionesExtra.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblBonificacionesExtra.setText("Horas Extras:");
        getContentPane().add(lblBonificacionesExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 120, -1));

        date.setOpaque(false);
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, -1));

        txtBonificacionIncentivo.setEditable(false);
        txtBonificacionIncentivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtBonificacionIncentivo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtBonificacionIncentivo.setOpaque(false);
        txtBonificacionIncentivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBonificacionIncentivoActionPerformed(evt);
            }
        });
        getContentPane().add(txtBonificacionIncentivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 120, -1));

        lblComisiones.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblComisiones.setText("Comisiones:");
        getContentPane().add(lblComisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 120, -1));

        lblBonificacionIncentivo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblBonificacionIncentivo.setText("B. Incentivo:");
        getContentPane().add(lblBonificacionIncentivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 90, -1));

        fechanomina.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        fechanomina.setText("fecha nomina");
        getContentPane().add(fechanomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        txtSueldoDevengado.setEditable(false);
        txtSueldoDevengado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSueldoDevengado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSueldoDevengado.setOpaque(false);
        txtSueldoDevengado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoDevengadoActionPerformed(evt);
            }
        });
        getContentPane().add(txtSueldoDevengado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 120, -1));

        txtComisiones.setEditable(false);
        txtComisiones.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtComisiones.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtComisiones.setOpaque(false);
        txtComisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComisionesActionPerformed(evt);
            }
        });
        txtComisiones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComisionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComisionesKeyTyped(evt);
            }
        });
        getContentPane().add(txtComisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 120, -1));

        lblSueldoDevengado.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblSueldoDevengado.setText("Sueldo Devengado:");
        getContentPane().add(lblSueldoDevengado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 120, -1));

        codigoe.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        codigoe.setText("Codigo");
        getContentPane().add(codigoe, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 50, -1));

        txtSueldoBase.setEditable(false);
        txtSueldoBase.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSueldoBase.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSueldoBase.setOpaque(false);
        txtSueldoBase.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSueldoBaseInputMethodTextChanged(evt);
            }
        });
        txtSueldoBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoBaseActionPerformed(evt);
            }
        });
        txtSueldoBase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoBaseKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoBaseKeyTyped(evt);
            }
        });
        getContentPane().add(txtSueldoBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 120, -1));

        tbl_Nomina.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_Nomina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Empleado", "Concepto", "Líquido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Nomina);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 320, 77));

        tbl_Empleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Empleados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 210, 79));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Empleados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        lblCalculodeDescuentos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblCalculodeDescuentos.setText("Calculo de Descuentos");
        getContentPane().add(lblCalculodeDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        lblSueldoBase.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblSueldoBase.setText("Sueldo Base:");
        getContentPane().add(lblSueldoBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 80, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Elementos de Nómina");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 200, -1));

        lblIgss.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblIgss.setText("IGSS:");
        getContentPane().add(lblIgss, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 120, -1));

        txtIgss.setEditable(false);
        txtIgss.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIgss.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtIgss.setOpaque(false);
        txtIgss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgssActionPerformed(evt);
            }
        });
        txtIgss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIgssKeyReleased(evt);
            }
        });
        getContentPane().add(txtIgss, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 112, -1));

        txtIsr.setEditable(false);
        txtIsr.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIsr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtIsr.setOpaque(false);
        txtIsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIsrActionPerformed(evt);
            }
        });
        txtIsr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIsrKeyReleased(evt);
            }
        });
        getContentPane().add(txtIsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 104, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Conceptos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, -1, -1));

        lblIsr.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblIsr.setText("ISR:");
        getContentPane().add(lblIsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 120, -1));

        tbl_concep.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_concep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_concep);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 290, 79));

        txtTotalDescuentos.setEditable(false);
        txtTotalDescuentos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTotalDescuentos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtTotalDescuentos.setOpaque(false);
        getContentPane().add(txtTotalDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 120, 20));

        lblTotalDescuentos.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTotalDescuentos.setText("Total Descuentos:");
        getContentPane().add(lblTotalDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 110, -1));

        txtSueldoLiquido.setEditable(false);
        txtSueldoLiquido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSueldoLiquido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSueldoLiquido.setOpaque(false);
        getContentPane().add(txtSueldoLiquido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 169, 20));

        lblTotalDescuentos1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTotalDescuentos1.setText("Sueldo Líquido:");
        getContentPane().add(lblTotalDescuentos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        txtAnticipos.setEditable(false);
        txtAnticipos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtAnticipos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtAnticipos.setOpaque(false);
        txtAnticipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnticiposActionPerformed(evt);
            }
        });
        txtAnticipos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnticiposKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnticiposKeyTyped(evt);
            }
        });
        getContentPane().add(txtAnticipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 120, -1));

        lblAnticipos.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblAnticipos.setText("Anticipos Concedidos:");
        getContentPane().add(lblAnticipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 140, -1));

        lblNombreEmpleado.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblNombreEmpleado.setText("Nombre Empleado:");
        getContentPane().add(lblNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 150, 120, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 880, -1));

        cmbxNombreEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbxNombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxNombreEmpleadoActionPerformed(evt);
            }
        });
        cmbxNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbxNombreEmpleadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbxNombreEmpleadoKeyReleased(evt);
            }
        });
        getContentPane().add(cmbxNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 173, 190, -1));

        txtCuotaPatronal.setEditable(false);
        txtCuotaPatronal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCuotaPatronal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCuotaPatronal.setOpaque(false);
        txtCuotaPatronal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuotaPatronalActionPerformed(evt);
            }
        });
        txtCuotaPatronal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCuotaPatronalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuotaPatronalKeyTyped(evt);
            }
        });
        getContentPane().add(txtCuotaPatronal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 120, -1));

        lblCP.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblCP.setText("Cuota Patronal");
        getContentPane().add(lblCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 130, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 10));

        txtDescuentosJ.setEditable(false);
        txtDescuentosJ.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDescuentosJ.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtDescuentosJ.setOpaque(false);
        txtDescuentosJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentosJActionPerformed(evt);
            }
        });
        txtDescuentosJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentosJKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentosJKeyTyped(evt);
            }
        });
        getContentPane().add(txtDescuentosJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 120, -1));

        lblDescuentosJ.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblDescuentosJ.setText("Descuentos Judiciales:");
        getContentPane().add(lblDescuentosJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 140, -1));

        lblIngresodeDatos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblIngresodeDatos.setText("Ingreso de Datos");
        getContentPane().add(lblIngresodeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 122, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("*Si el empleado no tiene algun ingreso o descuento, coloque un 0 en la casilla.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, -1, -1));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerrarbtn1.setText("cerrarbtn1");
        cerrarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(cerrarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 30, -1));

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrar1MousePressed(evt);
            }
        });
        jPanel1.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(minimizarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, -1));

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizar1MousePressed(evt);
            }
        });
        jPanel1.add(btnMinimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("Nómina");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setText("guardarbtn1");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresarMousePressed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        limpiarbtn1.setText("limpiarbtn1");
        limpiarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                limpiarbtn1MousePressed(evt);
            }
        });
        jPanel2.add(limpiarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        btnLimpiar1.setText("btnLimpiar1");
        btnLimpiar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLimpiar1MousePressed(evt);
            }
        });
        jPanel2.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        btnModificar1.setText("editarbtn1");
        btnModificar1.setEnabled(false);
        btnModificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificar1MousePressed(evt);
            }
        });
        jPanel2.add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        btnEliminar.setText("eliminarbtn1");
        btnEliminar.setEnabled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        btnEliminar1.setEnabled(false);
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminar1MousePressed(evt);
            }
        });
        jPanel2.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 40, -1));

        btnModificar2.setText("btnEditar1");
        btnModificar2.setEnabled(false);
        btnModificar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificar2MousePressed(evt);
            }
        });
        jPanel2.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        btnIngresar1.setText("btnGuardar1");
        btnIngresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresar1MousePressed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 160, 40));

        buscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        buscar.setOpaque(false);
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 65, 30));

        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar.png"))); // NOI18N
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 650));

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 650));

        ln1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar b.png"))); // NOI18N
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 650));

        ln2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        getContentPane().add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOtrosDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtrosDescuentosActionPerformed

    private void txtOtrosDescuentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosKeyReleased

    }//GEN-LAST:event_txtOtrosDescuentosKeyReleased

    private void txtOtrosDescuentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosKeyTyped

    }//GEN-LAST:event_txtOtrosDescuentosKeyTyped

    private void txtBonificacionesExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBonificacionesExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBonificacionesExtraActionPerformed

    private void txtBonificacionesExtraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonificacionesExtraKeyReleased


    }//GEN-LAST:event_txtBonificacionesExtraKeyReleased

    private void txtBonificacionesExtraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonificacionesExtraKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBonificacionesExtraKeyTyped

    private void txtBonificacionIncentivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBonificacionIncentivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBonificacionIncentivoActionPerformed

    private void txtSueldoDevengadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoDevengadoActionPerformed

    }//GEN-LAST:event_txtSueldoDevengadoActionPerformed

    private void txtComisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComisionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComisionesActionPerformed

    private void txtComisionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionesKeyReleased


    }//GEN-LAST:event_txtComisionesKeyReleased

    private void txtComisionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionesKeyTyped

    }//GEN-LAST:event_txtComisionesKeyTyped

    private void txtSueldoBaseInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSueldoBaseInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoBaseInputMethodTextChanged

    private void txtSueldoBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoBaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoBaseActionPerformed

    private void txtSueldoBaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoBaseKeyReleased

    }//GEN-LAST:event_txtSueldoBaseKeyReleased

    private void txtSueldoBaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoBaseKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoBaseKeyTyped

    private void txtIgssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgssActionPerformed

    private void txtIgssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgssKeyReleased


    }//GEN-LAST:event_txtIgssKeyReleased

    private void txtIsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsrActionPerformed

    private void txtIsrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIsrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsrKeyReleased

    private void txtAnticiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnticiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnticiposActionPerformed

    private void txtAnticiposKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnticiposKeyReleased

    }//GEN-LAST:event_txtAnticiposKeyReleased

    private void txtAnticiposKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnticiposKeyTyped

    }//GEN-LAST:event_txtAnticiposKeyTyped

    private void cmbxNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Empleado from Empleados where Nombre_Empleado = ?");
            PreparedStatement pst3 = cn.prepareStatement("select Sueldo_Empleado from Empleados where Nombre_Empleado = ?");
            PreparedStatement pst4 = cn.prepareStatement("select Codigo_Puesto from Empleados where Nombre_Empleado = ?");

            pst2.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());
            pst3.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());
            pst4.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();

            if (rs2.next()) {
                codigoe.setText(rs2.getString("Codigo_Empleado"));

            } else {

            }

            if (rs3.next()) {
                txtSueldoBase.setText(rs3.getString("Sueldo_Empleado"));

            } else {

            }

            if (rs4.next()) {
                puesto.setText(rs4.getString("Codigo_Puesto"));

            } else {

            }
            tabla();
            conceptos();

            if (cmbxNombreEmpleado.getSelectedItem().toString().contains("Seleccione una opción")) {
                cmbxNombreEmpleado.setSelectedIndex(0);
                txtSueldoBase.setText("");
                date.updateUI();
                txtComisiones.setText("");
                txtBonificacionesExtra.setText("");
                txtBonificacionIncentivo.setText("");
                txtSueldoDevengado.setText("");
                txtIgss.setText("");
                txtIsr.setText("");
                txtAnticipos.setText("");
                txtDescuentosJ.setText("");
                txtOtrosDescuentos.setText("");
                txtTotalDescuentos.setText("");
                txtSueldoLiquido.setText("");
                codigoe.setText("Codigo");
                date.setDate(null);
                txtCuotaPatronal.setText("");
            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_cmbxNombreEmpleadoActionPerformed

    private void cmbxNombreEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxNombreEmpleadoKeyPressed

    private void cmbxNombreEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxNombreEmpleadoKeyReleased

    private void txtDescuentosJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentosJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentosJActionPerformed

    private void txtDescuentosJKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentosJKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentosJKeyReleased

    private void txtDescuentosJKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentosJKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDescuentosJKeyTyped

    private void cerrarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarbtn1MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cerrarbtn1MousePressed

    private void minimizarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarbtn1MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizarbtn1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: (" + ubicacion.x + "," + ubicacion.y + ")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void buscarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarbtn1MousePressed

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from nomina where Codigo_Nomina = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                date.setDate(rs.getDate("Fecha_Inicial_Nomina"));
                codigoe.setText(rs.getString("Codigo_Empleado"));
                txtSueldoLiquido.setText(rs.getString("SueldoL"));
                txtSueldoBase.setText(rs.getString("SueldoBase"));
                txtComisiones.setText(rs.getString("Comisiones"));
                txtBonificacionesExtra.setText(rs.getString("Bonificaciones"));
                txtBonificacionIncentivo.setText(rs.getString("Incentivo"));
                txtSueldoDevengado.setText(rs.getString("Devengado"));
                txtIgss.setText(rs.getString("Igss"));
                txtIsr.setText(rs.getString("Isr"));
                txtAnticipos.setText(rs.getString("Anticipos"));
                txtDescuentosJ.setText(rs.getString("DescuentosJ"));
                txtOtrosDescuentos.setText(rs.getString("OtrosDescuentos"));
                txtTotalDescuentos.setText(rs.getString("TotalDesucentos"));
                txtCuotaPatronal.setText(rs.getString("Cuota_Patronal"));

                buscar_nombreempleado();
                bitacora_busqueda();

                btnEliminar.setEnabled(true);
                btnModificar1.setEnabled(true);
                btnIngresar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Nomina no registrada", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buscarbtn1MousePressed

    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed

        java.util.Date fechaN = date.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into nomina values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, dateN.toString());
            pst2.setString(3, codigoe.getText().trim());
            pst2.setString(4, txtSueldoLiquido.getText().trim());
            pst2.setString(5, txtSueldoBase.getText().trim());
            pst2.setString(6, txtComisiones.getText().trim());
            pst2.setString(7, txtBonificacionesExtra.getText().trim());
            pst2.setString(8, txtBonificacionIncentivo.getText().trim());
            pst2.setString(9, txtSueldoDevengado.getText().trim());
            pst2.setString(10, txtIgss.getText().trim());
            pst2.setString(11, txtIsr.getText().trim());
            pst2.setString(12, txtAnticipos.getText().trim());
            pst2.setString(13, txtDescuentosJ.getText().trim());
            pst2.setString(14, txtOtrosDescuentos.getText().trim());
            pst2.setString(15, txtTotalDescuentos.getText().trim());
            pst2.setString(16, txtCuotaPatronal.getText().trim());

            pst2.executeUpdate();

            bitacora_guardar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            codigoe.setText("Codigo");
            date.setDate(null);
            txtCuotaPatronal.setText("");
            txtComisiones.setText("0");
            txtBonificacionesExtra.setText("0");
            txtBonificacionIncentivo.setText("0");
            txtSueldoDevengado.setText("0");
            txtIgss.setText("0");
            txtIsr.setText("0");
            txtAnticipos.setText("0");
            txtDescuentosJ.setText("0");
            txtOtrosDescuentos.setText("0");
            txtCuotaPatronal.setText("0");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnIngresarMousePressed

    private void limpiarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarbtn1MousePressed

        cmbxNombreEmpleado.setSelectedIndex(0);
        txtSueldoBase.setText("");
        date.updateUI();
        txtComisiones.setText("");
        txtBonificacionesExtra.setText("");
        txtBonificacionIncentivo.setText("");
        txtSueldoDevengado.setText("");
        txtIgss.setText("");
        txtIsr.setText("");
        txtAnticipos.setText("");
        txtDescuentosJ.setText("");
        txtOtrosDescuentos.setText("");
        txtTotalDescuentos.setText("");
        txtSueldoLiquido.setText("");
        codigoe.setText("Codigo");
        date.setDate(null);
        buscar.setText("");
        txtCuotaPatronal.setText("");
         txtComisiones.setText("0");
        txtBonificacionesExtra.setText("0");
        txtBonificacionIncentivo.setText("0");
        txtSueldoDevengado.setText("0");
        txtIgss.setText("0");
        txtIsr.setText("0");
        txtAnticipos.setText("0");
        txtDescuentosJ.setText("0");
        txtOtrosDescuentos.setText("0");
        txtCuotaPatronal.setText("0");
        
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);

        btnIngresar.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_limpiarbtn1MousePressed

    private void btnLimpiar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiar1MousePressed

        cmbxNombreEmpleado.setSelectedIndex(0);
        txtSueldoBase.setText("");
        date.updateUI();
        txtComisiones.setText("");
        txtBonificacionesExtra.setText("");
        txtBonificacionIncentivo.setText("");
        txtSueldoDevengado.setText("");
        txtIgss.setText("");
        txtIsr.setText("");
        txtAnticipos.setText("");
        txtDescuentosJ.setText("");
        txtOtrosDescuentos.setText("");
        txtTotalDescuentos.setText("");
        txtSueldoLiquido.setText("");
        codigoe.setText("Codigo");
        date.setDate(null);
        buscar.setText("");
         txtComisiones.setText("0");
        txtBonificacionesExtra.setText("0");
        txtBonificacionIncentivo.setText("0");
        txtSueldoDevengado.setText("0");
        txtIgss.setText("0");
        txtIsr.setText("0");
        txtAnticipos.setText("0");
        txtDescuentosJ.setText("0");
        txtOtrosDescuentos.setText("0");
        txtCuotaPatronal.setText("0");
        
        txtCuotaPatronal.setText("");
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);

        btnIngresar1.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnEliminar1.setEnabled(false);
    }//GEN-LAST:event_btnLimpiar1MousePressed

    private void btnModificar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar1MousePressed

        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update nomina set codigo_empleado = ?, sueldol = ?, sueldobase = ? , comisiones= ?, bonificaciones=?, incentivo=?, devengado=?, igss=?, isr=?, anticipos=?, descuentosj=?,otrosdescuentos=?,totaldesucentos=?, cuota_patronal=? where codigo_nomina=" + ID);

            pst2.setString(1, codigoe.getText().trim());
            pst2.setString(3, txtSueldoLiquido.getText().trim());
            pst2.setString(4, txtSueldoBase.getText().trim());
            pst2.setString(5, txtComisiones.getText().trim());
            pst2.setString(6, txtBonificacionesExtra.getText().trim());
            pst2.setString(7, txtBonificacionIncentivo.getText().trim());
            pst2.setString(8, txtSueldoDevengado.getText().trim());
            pst2.setString(9, txtIgss.getText().trim());
            pst2.setString(10, txtIsr.getText().trim());
            pst2.setString(11, txtAnticipos.getText().trim());
            pst2.setString(12, txtDescuentosJ.getText().trim());
            pst2.setString(13, txtOtrosDescuentos.getText().trim());
            pst2.setString(14, txtTotalDescuentos.getText().trim());
            pst2.setString(15, txtCuotaPatronal.getText().trim());
            pst2.executeUpdate();

            bitacora_modificar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            codigoe.setText("Codigo");
            date.setDate(null);
            txtCuotaPatronal.setText("");
            txtComisiones.setText("0");
            txtBonificacionesExtra.setText("0");
            txtBonificacionIncentivo.setText("0");
            txtSueldoDevengado.setText("0");
            txtIgss.setText("0");
            txtIsr.setText("0");
            txtAnticipos.setText("0");
            txtDescuentosJ.setText("0");
            txtOtrosDescuentos.setText("0");
            txtCuotaPatronal.setText("0");

            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar1MousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from nomina where Codigo_Nomina = ?");

            pst2.setString(1, buscar.getText().trim());
            pst2.executeUpdate();

            bitacora_eliminar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            codigoe.setText("Codigo");
            date.setDate(null);
            txtCuotaPatronal.setText("");
            txtComisiones.setText("0");
            txtBonificacionesExtra.setText("0");
            txtBonificacionIncentivo.setText("0");
            txtSueldoDevengado.setText("0");
            txtIgss.setText("0");
            txtIsr.setText("0");
            txtAnticipos.setText("0");
            txtDescuentosJ.setText("0");
            txtOtrosDescuentos.setText("0");
            txtCuotaPatronal.setText("0");

            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();

    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from nomina where Codigo_Nomina = ?");

            pst2.setString(1, buscar.getText().trim());
            pst2.executeUpdate();

            bitacora_eliminar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            txtCuotaPatronal.setText("");
            txtComisiones.setText("0");
            txtBonificacionesExtra.setText("0");
            txtBonificacionIncentivo.setText("0");
            txtSueldoDevengado.setText("0");
            txtIgss.setText("0");
            txtIsr.setText("0");
            txtAnticipos.setText("0");
            txtDescuentosJ.setText("0");
            txtOtrosDescuentos.setText("0");
            txtCuotaPatronal.setText("0");

            codigoe.setText("Codigo");
            date.setDate(null);

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnEliminar1MousePressed

    private void btnModificar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar2MousePressed

        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update nomina set codigo_empleado = ?, sueldol = ?, sueldobase = ? , comisiones= ?, bonificaciones=?, incentivo=?, devengado=?, igss=?, isr=?, anticipos=?, descuentosj=?,otrosdescuentos=?,totaldesucentos=?, cuota_patronal=? where codigo_nomina=" + ID);

            pst2.setString(1, codigoe.getText().trim());
            pst2.setString(3, txtSueldoLiquido.getText().trim());
            pst2.setString(4, txtSueldoBase.getText().trim());
            pst2.setString(5, txtComisiones.getText().trim());
            pst2.setString(6, txtBonificacionesExtra.getText().trim());
            pst2.setString(7, txtBonificacionIncentivo.getText().trim());
            pst2.setString(8, txtSueldoDevengado.getText().trim());
            pst2.setString(9, txtIgss.getText().trim());
            pst2.setString(10, txtIsr.getText().trim());
            pst2.setString(11, txtAnticipos.getText().trim());
            pst2.setString(12, txtDescuentosJ.getText().trim());
            pst2.setString(13, txtOtrosDescuentos.getText().trim());
            pst2.setString(14, txtTotalDescuentos.getText().trim());
            pst2.setString(15, txtCuotaPatronal.getText().trim());
            pst2.executeUpdate();

            bitacora_modificar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            codigoe.setText("Codigo");
            date.setDate(null);
            txtCuotaPatronal.setText("");
            txtComisiones.setText("0");
            txtBonificacionesExtra.setText("0");
            txtBonificacionIncentivo.setText("0");
            txtSueldoDevengado.setText("0");
            txtIgss.setText("0");
            txtIsr.setText("0");
            txtAnticipos.setText("0");
            txtDescuentosJ.setText("0");
            txtOtrosDescuentos.setText("0");
            txtCuotaPatronal.setText("0");

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar2MousePressed

    private void btnIngresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MousePressed

        java.util.Date fechaN = date.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into nomina values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, dateN.toString());
            pst2.setString(3, codigoe.getText().trim());
            pst2.setString(4, txtSueldoLiquido.getText().trim());
            pst2.setString(5, txtSueldoBase.getText().trim());
            pst2.setString(6, txtComisiones.getText().trim());
            pst2.setString(7, txtBonificacionesExtra.getText().trim());
            pst2.setString(8, txtBonificacionIncentivo.getText().trim());
            pst2.setString(9, txtSueldoDevengado.getText().trim());
            pst2.setString(10, txtIgss.getText().trim());
            pst2.setString(11, txtIsr.getText().trim());
            pst2.setString(12, txtAnticipos.getText().trim());
            pst2.setString(13, txtDescuentosJ.getText().trim());
            pst2.setString(14, txtOtrosDescuentos.getText().trim());
            pst2.setString(15, txtTotalDescuentos.getText().trim());
            pst2.setString(16, txtCuotaPatronal.getText().trim());

            pst2.executeUpdate();

            bitacora_guardar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            codigoe.setText("Codigo");
            date.setDate(null);
            txtCuotaPatronal.setText("");
            txtComisiones.setText("0");
            txtBonificacionesExtra.setText("0");
            txtBonificacionIncentivo.setText("0");
            txtSueldoDevengado.setText("0");
            txtIgss.setText("0");
            txtIsr.setText("0");
            txtAnticipos.setText("0");
            txtDescuentosJ.setText("0");
            txtOtrosDescuentos.setText("0");
            txtCuotaPatronal.setText("0");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnIngresar1MousePressed

    private void btnBuscar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar1MousePressed

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from nomina where Codigo_Nomina = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                date.setDate(rs.getDate("Fecha_Inicial_Nomina"));
                codigoe.setText(rs.getString("Codigo_Empleado"));

                txtSueldoLiquido.setText(rs.getString("SueldoL"));
                txtSueldoBase.setText(rs.getString("SueldoBase"));
                txtComisiones.setText(rs.getString("Comisiones"));
                txtBonificacionesExtra.setText(rs.getString("Bonificaciones"));
                txtBonificacionIncentivo.setText(rs.getString("Incentivo"));
                txtSueldoDevengado.setText(rs.getString("Devengado"));
                txtIgss.setText(rs.getString("Igss"));
                txtIsr.setText(rs.getString("Isr"));
                txtAnticipos.setText(rs.getString("Anticipos"));
                txtDescuentosJ.setText(rs.getString("DescuentosJ"));
                txtOtrosDescuentos.setText(rs.getString("OtrosDescuentos"));
                txtTotalDescuentos.setText(rs.getString("TotalDesucentos"));
                txtCuotaPatronal.setText(rs.getString("Cuota_Patronal"));

                buscar_nombreempleado();
                bitacora_busqueda();

                btnEliminar.setEnabled(true);
                btnModificar1.setEnabled(true);
                btnIngresar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Nomina no registrada", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar1MousePressed

    private void btnMinimizar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizar1MousePressed

        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizar1MousePressed

    private void btnCerrar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MousePressed

        this.dispose();
    }//GEN-LAST:event_btnCerrar1MousePressed

    private void txtCuotaPatronalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuotaPatronalActionPerformed

    }//GEN-LAST:event_txtCuotaPatronalActionPerformed

    private void txtCuotaPatronalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotaPatronalKeyReleased

    }//GEN-LAST:event_txtCuotaPatronalKeyReleased

    private void txtCuotaPatronalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotaPatronalKeyTyped

    }//GEN-LAST:event_txtCuotaPatronalKeyTyped

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nómina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nómina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nómina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nómina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nómina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Claro;
    private temanegro.btnBuscar btnBuscar1;
    private temanegro.btnCerrar btnCerrar1;
    private temaclaro.Eliminarbtn btnEliminar;
    private temanegro.btnEliminar btnEliminar1;
    private temaclaro.Guardarbtn btnIngresar;
    private temanegro.btnGuardar btnIngresar1;
    private temanegro.btnLimpiar btnLimpiar1;
    private temanegro.btnMinimizar btnMinimizar1;
    private temaclaro.Editarbtn btnModificar1;
    private temanegro.btnEditar btnModificar2;
    private javax.swing.JTextField buscar;
    private temaclaro.Buscarbtn buscarbtn1;
    private temaclaro.Cerrarbtn cerrarbtn1;
    private javax.swing.JComboBox<String> cmbxNombreEmpleado;
    private javax.swing.JLabel code;
    private javax.swing.JLabel codigoe;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel empleado;
    private javax.swing.JLabel fechanomina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lblAnticipos;
    private javax.swing.JLabel lblBonificacionIncentivo;
    private javax.swing.JLabel lblBonificacionesExtra;
    private javax.swing.JLabel lblCP;
    private javax.swing.JLabel lblCalculodeDescuentos;
    private javax.swing.JLabel lblCalculodeIngresos;
    private javax.swing.JLabel lblComisiones;
    private javax.swing.JLabel lblDescuentosJ;
    private javax.swing.JLabel lblIgss;
    private javax.swing.JLabel lblIngresodeDatos;
    private javax.swing.JLabel lblIsr;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblOtrosDescuentos;
    private javax.swing.JLabel lblSueldoBase;
    private javax.swing.JLabel lblSueldoDevengado;
    private javax.swing.JLabel lblTotalDescuentos;
    private javax.swing.JLabel lblTotalDescuentos1;
    private temaclaro.Limpiarbtn limpiarbtn1;
    private javax.swing.JLabel ln1;
    private javax.swing.JLabel ln2;
    private temaclaro.Minimizarbtn minimizarbtn1;
    private javax.swing.JLabel nombremp;
    private javax.swing.JLabel puesto;
    private javax.swing.JTable tbl_Empleados;
    private javax.swing.JTable tbl_Nomina;
    private javax.swing.JTable tbl_concep;
    private javax.swing.JLabel timee;
    private javax.swing.JTextField txtAnticipos;
    private javax.swing.JTextField txtBonificacionIncentivo;
    private javax.swing.JTextField txtBonificacionesExtra;
    private javax.swing.JTextField txtComisiones;
    private javax.swing.JTextField txtCuotaPatronal;
    private javax.swing.JTextField txtDescuentosJ;
    private javax.swing.JTextField txtIgss;
    private javax.swing.JTextField txtIsr;
    private javax.swing.JTextField txtOtrosDescuentos;
    private javax.swing.JTextField txtSueldoBase;
    private javax.swing.JTextField txtSueldoDevengado;
    private javax.swing.JTextField txtSueldoLiquido;
    private javax.swing.JTextField txtTotalDescuentos;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
