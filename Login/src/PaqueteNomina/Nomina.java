/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteNomina;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Principal.mdiMenuPrincipal;
import java.util.Calendar;

/**
 *
 * @author Sucely Alvarez
 */
public class Nomina extends javax.swing.JInternalFrame {

    /**
     * Creates new form Nomina
     */
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

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Conceptos");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Concepto");
            modelo.addColumn("Tipo");
            modelo.addColumn("Clase");
            modelo.addColumn("Valor");
            tbl_concep.setModel(modelo);
            String[] dato = new String[5];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(3);
                dato[2] = rss4.getString(4);
                dato[3] = rss4.getString(5);
                dato[4] = rss4.getString(7);

                modelo.addRow(dato);
            }

        } catch (Exception e) {

        }
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
    
     public void bitacora_eliminar(){
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());
            
            String u=buscar.getText();
            pst.setString(3, "Eliminó el registro de nómina "+u);
            
            Calendar calendario = Calendar.getInstance();
                
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minutos = calendario.get(Calendar.MINUTE);
                int segundos = calendario.get(Calendar.SECOND);
                
                Calendar c1 = Calendar.getInstance();
                String dia = Integer.toString(c1.get(Calendar.DATE));
                String mes = Integer.toString(c1.get(Calendar.MONTH));
                String annio = Integer.toString(c1.get(Calendar.YEAR));
                
                String fecha=dia+"/"+mes+"/"+annio;
                String time=hora+":"+minutos+":"+segundos;
                
                date1.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date1.getText());
                pst.setString(5, timee.getText());
            
            

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }
    
    public void bitacora_guardar(){
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());
            
            String u=date.getDate().toString();
            empleado.setText(cmbxNombreEmpleado.getSelectedItem().toString());
            String emp=empleado.getText();
            pst.setString(3, "Registró el concepto "+u+" que pertenece al empleado "+emp);
            
            Calendar calendario = Calendar.getInstance();
                
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minutos = calendario.get(Calendar.MINUTE);
                int segundos = calendario.get(Calendar.SECOND);
                
                Calendar c1 = Calendar.getInstance();
                String dia = Integer.toString(c1.get(Calendar.DATE));
                String mes = Integer.toString(c1.get(Calendar.MONTH));
                String annio = Integer.toString(c1.get(Calendar.YEAR));
                
                String fecha=dia+"/"+mes+"/"+annio;
                String time=hora+":"+minutos+":"+segundos;
                
                date1.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date1.getText());
                pst.setString(5, timee.getText());
            
            

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }
    
    public void bitacora_modificar(){
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());
            
            String u=buscar.getText();
            pst.setString(3, "Modificó el registro de nómina "+u);
            
            Calendar calendario = Calendar.getInstance();
                
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minutos = calendario.get(Calendar.MINUTE);
                int segundos = calendario.get(Calendar.SECOND);
                
                Calendar c1 = Calendar.getInstance();
                String dia = Integer.toString(c1.get(Calendar.DATE));
                String mes = Integer.toString(c1.get(Calendar.MONTH));
                String annio = Integer.toString(c1.get(Calendar.YEAR));
                
                String fecha=dia+"/"+mes+"/"+annio;
                String time=hora+":"+minutos+":"+segundos;
                
                date1.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date1.getText());
                pst.setString(5, timee.getText());
            
            

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }
    
    public void bitacora_busqueda(){
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());
            
            String u=buscar.getText();
            pst.setString(3, "Buscó el registro de nómina "+u);
            
            Calendar calendario = Calendar.getInstance();
                
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minutos = calendario.get(Calendar.MINUTE);
                int segundos = calendario.get(Calendar.SECOND);
                
                Calendar c1 = Calendar.getInstance();
                String dia = Integer.toString(c1.get(Calendar.DATE));
                String mes = Integer.toString(c1.get(Calendar.MONTH));
                String annio = Integer.toString(c1.get(Calendar.YEAR));
                
                String fecha=dia+"/"+mes+"/"+annio;
                String time=hora+":"+minutos+":"+segundos;
                
                date1.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date1.getText());
                pst.setString(5, timee.getText());
            
            

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public Nomina() {
        initComponents();
        lblIngreseNum1.setVisible(false);
        lblIngreseNum2.setVisible(false);
        lblIngreseNum4.setVisible(false);
        lblIngreseNum5.setVisible(false);
        txtBonificacionIncentivo.setText("250.00");
        txtIsr.setText("0");
        tablas();
        comboDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombremp = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        empleado = new javax.swing.JLabel();
        lblIngresodeDatos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCalculodeIngresos = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        lblComisiones = new javax.swing.JLabel();
        fechanomina = new javax.swing.JLabel();
        txtComisiones = new javax.swing.JTextField();
        codigoe = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        ConceptoE = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Nomina = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Empleados = new javax.swing.JTable();
        lblIngreseNum1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCalculodeDescuentos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblIgss = new javax.swing.JLabel();
        txtIgss = new javax.swing.JTextField();
        lblSueldoBase1 = new javax.swing.JLabel();
        txtIsr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblIsr = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_concep = new javax.swing.JTable();
        txtTotalDescuentos = new javax.swing.JTextField();
        lblTotalDescuentos = new javax.swing.JLabel();
        txtSueldoLiquido = new javax.swing.JTextField();
        lblTotalDescuentos1 = new javax.swing.JLabel();
        lblIngreseNum6 = new javax.swing.JLabel();
        txtAnticipos = new javax.swing.JTextField();
        lblAnticipos = new javax.swing.JLabel();
        lblIngreseNum4 = new javax.swing.JLabel();
        txtDescuentosJ = new javax.swing.JTextField();
        lblDescuentosJ = new javax.swing.JLabel();
        lblIngreseNum5 = new javax.swing.JLabel();
        txtOtrosDescuentos = new javax.swing.JTextField();
        lblOtrosDescuentos = new javax.swing.JLabel();
        lblIngreseNum2 = new javax.swing.JLabel();
        txtBonificacionesExtra = new javax.swing.JTextField();
        lblBonificacionesExtra = new javax.swing.JLabel();
        txtBonificacionIncentivo = new javax.swing.JTextField();
        lblBonificacionIncentivo = new javax.swing.JLabel();
        txtSueldoDevengado = new javax.swing.JTextField();
        lblSueldoDevengado = new javax.swing.JLabel();
        txtSueldoBase = new javax.swing.JTextField();
        lblSueldoBase = new javax.swing.JLabel();
        cmbxNombreEmpleado = new javax.swing.JComboBox<>();
        lblNombreEmpleado = new javax.swing.JLabel();

        nombremp.setText("jLabel2");

        usuario.setText("jLabel6");

        timee.setText("jLabel1");

        date1.setText("jLabel1");

        empleado.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setTitle("Nómina");
        setVisible(true);

        lblIngresodeDatos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIngresodeDatos.setText("Ingreso de Datos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("*Si el empleado no tiene algun ingreso o descuento, coloque un 0 en la casilla.");

        lblCalculodeIngresos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCalculodeIngresos.setText("Calculo de Ingresos");

        lblComisiones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblComisiones.setText("Comisiones:");

        fechanomina.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fechanomina.setText("fecha nomina");

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

        codigoe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        codigoe.setText("Codigo");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/busqueda1bf.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ConceptoE.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ConceptoE.setText("Concepto");

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/save (1).png"))); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/gnome_edit_delete.png"))); // NOI18N
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/modify.png"))); // NOI18N
        btnModificar1.setEnabled(false);
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/edit_clear.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

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

        lblIngreseNum1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIngreseNum1.setText("Ingrese números");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Empleados");

        lblCalculodeDescuentos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCalculodeDescuentos.setText("Calculo de Descuentos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Elementos de Nómina");

        lblIgss.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIgss.setText("IGSS:");

        txtIgss.setEditable(false);
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

        lblSueldoBase1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSueldoBase1.setText("Concepto");

        txtIsr.setEditable(false);
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Conceptos");

        lblIsr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIsr.setText("ISR:");

        tbl_concep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Concepto", "Tipo", "Clase", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_concep);

        txtTotalDescuentos.setEditable(false);

        lblTotalDescuentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalDescuentos.setText("Total Descuentos:");

        txtSueldoLiquido.setEditable(false);
        txtSueldoLiquido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblTotalDescuentos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalDescuentos1.setText("Sueldo Líquido:");

        lblIngreseNum6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIngreseNum6.setText("Ingrese números");

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

        lblAnticipos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnticipos.setText("Anticipos Concedidos:");

        lblIngreseNum4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIngreseNum4.setText("Ingrese números");

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

        lblDescuentosJ.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDescuentosJ.setText("Descuentos Judiciales:");

        lblIngreseNum5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIngreseNum5.setText("Ingrese números");

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

        lblOtrosDescuentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOtrosDescuentos.setText("Otros Descuentos:");

        lblIngreseNum2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIngreseNum2.setText("Ingrese números");

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

        lblBonificacionesExtra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBonificacionesExtra.setText("Bonificaciones Extra:");

        txtBonificacionIncentivo.setEditable(false);
        txtBonificacionIncentivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBonificacionIncentivoActionPerformed(evt);
            }
        });

        lblBonificacionIncentivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBonificacionIncentivo.setText("Bonificacion Incentivo:");

        txtSueldoDevengado.setEditable(false);
        txtSueldoDevengado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoDevengadoActionPerformed(evt);
            }
        });

        lblSueldoDevengado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSueldoDevengado.setText("Sueldo Devengado:");

        txtSueldoBase.setEditable(false);
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

        lblSueldoBase.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSueldoBase.setText("Sueldo Base:");

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

        lblNombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreEmpleado.setText("Nombre Empleado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnModificar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel3))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(lblIngresodeDatos))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fechanomina, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addComponent(jLabel4))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblIngreseNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblIngreseNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblIgss, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblIsr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblAnticipos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblDescuentosJ, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblOtrosDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtIgss, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtIsr, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txtAnticipos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtDescuentosJ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtOtrosDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(lblIngreseNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lblIngreseNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblIngreseNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblTotalDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(lblTotalDescuentos1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(txtTotalDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtSueldoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCalculodeIngresos)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblBonificacionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addComponent(lblSueldoDevengado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblBonificacionIncentivo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(lblCalculodeDescuentos))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBonificacionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBonificacionIncentivo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSueldoDevengado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbxNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(codigoe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(txtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(lblSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSueldoBase1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ConceptoE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(167, 167, 167))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(fechanomina))
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(lblIngresodeDatos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreEmpleado)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lblSueldoBase)))
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSueldoBase1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbxNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoe)
                                    .addComponent(ConceptoE))))
                        .addGap(19, 19, 19)
                        .addComponent(lblCalculodeIngresos)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComisiones)
                            .addComponent(lblBonificacionesExtra)
                            .addComponent(lblSueldoDevengado)
                            .addComponent(lblBonificacionIncentivo))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBonificacionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBonificacionIncentivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldoDevengado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIngreseNum1)
                            .addComponent(lblIngreseNum2))
                        .addGap(27, 27, 27)
                        .addComponent(lblCalculodeDescuentos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblIgss))
                    .addComponent(lblIsr)
                    .addComponent(lblAnticipos)
                    .addComponent(lblDescuentosJ)
                    .addComponent(lblOtrosDescuentos))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtIgss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtAnticipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtDescuentosJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtOtrosDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIngreseNum5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIngreseNum6)
                            .addComponent(lblIngreseNum4))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblTotalDescuentos))
                    .addComponent(lblTotalDescuentos1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtTotalDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSueldoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtComisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComisionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComisionesActionPerformed

    private void txtComisionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionesKeyReleased

        String strSueldoBase = txtSueldoBase.getText();
        String strComisiones = txtComisiones.getText();
        String strBonificacionesExtra = txtBonificacionesExtra.getText();
        String strBonificacionIncentivo = txtBonificacionIncentivo.getText();

        if (strSueldoBase.equals("") == false && strBonificacionIncentivo.equals("") == false) {
            //CALCULO DE SUELDO DEVENGADO
            //CONVERSION DE STRING A DOUBLE
            double dbSueldoBase = Double.parseDouble(txtSueldoBase.getText());
            double dbComisiones = Double.parseDouble(txtComisiones.getText());
            double dbBonificacionesExtra = Double.parseDouble(txtBonificacionesExtra.getText());
            double dbBonificacionIncentivo = Double.parseDouble(txtBonificacionIncentivo.getText());

            //CALCULO DE SUELDO DEVENGADO
            double dbSueldoDevengado = dbSueldoBase + dbComisiones + dbBonificacionesExtra + dbBonificacionIncentivo;
            dbSueldoDevengado = Math.round(dbSueldoDevengado * 100) / 100;
            //CONVERSION DE DOUBLE A STRING
            String strSueldoDevengado = String.valueOf(dbSueldoDevengado);
            //IMPRESIÓN EN PANTALLA
            txtSueldoDevengado.setText(strSueldoDevengado);

            //CALCULO DE DESCUENTOS
            //IGSS
            double dbIgss = dbSueldoBase * 0.0483;
            //CONVERSION DE DOUBLE A STRING
            dbIgss = Math.round(dbIgss * 100) / 100;
            String strIgss = String.valueOf(dbIgss);
            //IMPRESION EN PANTALLA
            txtIgss.setText(strIgss);

            //ISR
            double dbIsr;
            if (dbSueldoBase < 6000) {
                dbIsr = 0;
            } else {
                //CALCULO TOTAL INGRESOS
                double dbSueldoAnual = dbSueldoBase * 12;
                double dbBonificacionIncentivoAnual = dbBonificacionIncentivo * 12;
                double dbIngresoAnual = dbSueldoAnual + dbBonificacionIncentivoAnual;
                //CALCULO TOTAL DESCUENTOS
                double dbIgssAnual = dbIgss * 12;
                double dbDescuentoAnual = dbIgssAnual + 48000;
                //CALCULO RENTA BRUTA
                double dbRentaBruta = dbIngresoAnual - dbDescuentoAnual;
                //CALCULO ISR ANUAL
                double dbIsrAnual = dbRentaBruta * 0.05;
                //CALCULO ISR MENSUAL
                dbIsr = dbIsrAnual / 12;
                //CONVERSION DE DOUBLE A STRING
                String strIsr = String.valueOf(dbIsr);
                dbIsr = Math.round(dbIsr * 100) / 100;
                //IMPRESION EN PANTALLA
                txtIsr.setText(strIsr);
            }
        }
    }//GEN-LAST:event_txtComisionesKeyReleased

    private void txtComisionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionesKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            lblIngreseNum1.setVisible(true);
        } else {
            lblIngreseNum1.setVisible(false);
        }
    }//GEN-LAST:event_txtComisionesKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from nomina where Codigo_Nomina = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                date.setDate(rs.getDate("Fecha_Inicial_Nomina"));
                codigoe.setText(rs.getString("Codigo_Empleado"));
                ConceptoE.setText(rs.getString("Codigo_Concepto"));
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
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
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
            pst2.setString(4, ConceptoE.getText().trim());
            pst2.setString(5, txtSueldoLiquido.getText().trim());
            pst2.setString(6, txtSueldoBase.getText().trim());
            pst2.setString(7, txtComisiones.getText().trim());
            pst2.setString(8, txtBonificacionesExtra.getText().trim());
            pst2.setString(9, txtBonificacionIncentivo.getText().trim());
            pst2.setString(10, txtSueldoDevengado.getText().trim());
            pst2.setString(11, txtIgss.getText().trim());
            pst2.setString(12, txtIsr.getText().trim());
            pst2.setString(13, txtAnticipos.getText().trim());
            pst2.setString(14, txtDescuentosJ.getText().trim());
            pst2.setString(15, txtOtrosDescuentos.getText().trim());
            pst2.setString(16, txtTotalDescuentos.getText().trim());
            
            pst2.executeUpdate();
            
            bitacora_guardar();
            
            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("250.00");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("0");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            ConceptoE.setText("Codigo");
            codigoe.setText("Codigo");
            date.setDate(null);

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
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
            txtBonificacionIncentivo.setText("250.00");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("0");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            ConceptoE.setText("Codigo");
            codigoe.setText("Codigo");
            date.setDate(null);
            
            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update nomina set codigo_empleado = ?, codigo_concepto = ?, sueldol = ?, sueldobase = ? , comisiones= ?, bonificaciones=?, incentivo=?, devengado=?, igss=?, isr=?, anticipos=?, descuentosj=?,otrosdescuentos=?,totaldesucentos=? where codigo_nomina=" + ID);

            pst2.setString(1, codigoe.getText().trim());
            pst2.setString(2, ConceptoE.getText().trim());
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
            pst2.executeUpdate();

            bitacora_modificar();
            
            cmbxNombreEmpleado.setSelectedIndex(0);
            txtSueldoBase.setText("");
            date.updateUI();
            txtComisiones.setText("");
            txtBonificacionesExtra.setText("");
            txtBonificacionIncentivo.setText("250.00");
            txtSueldoDevengado.setText("");
            txtIgss.setText("");
            txtIsr.setText("0");
            txtAnticipos.setText("");
            txtDescuentosJ.setText("");
            txtOtrosDescuentos.setText("");
            txtTotalDescuentos.setText("");
            txtSueldoLiquido.setText("");
            ConceptoE.setText("Codigo");
            codigoe.setText("Codigo");
            date.setDate(null);
            
            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        cmbxNombreEmpleado.setSelectedIndex(0);
        txtSueldoBase.setText("");
        date.updateUI();
        txtComisiones.setText("");
        txtBonificacionesExtra.setText("");
        txtBonificacionIncentivo.setText("250.00");
        txtSueldoDevengado.setText("");
        txtIgss.setText("");
        txtIsr.setText("0");
        txtAnticipos.setText("");
        txtDescuentosJ.setText("");
        txtOtrosDescuentos.setText("");
        txtTotalDescuentos.setText("");
        txtSueldoLiquido.setText("");
        ConceptoE.setText("Codigo");
        codigoe.setText("Codigo");
        date.setDate(null);
        buscar.setText("");
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);
        
        btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txtIgssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgssActionPerformed

    private void txtIgssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgssKeyReleased

        String strIgss = txtIgss.getText();
        String strIsr = txtIsr.getText();
        String strAnticipos = txtAnticipos.getText();
        String strDescuentosJ = txtDescuentosJ.getText();
        String strOtrosDescuentos = txtOtrosDescuentos.getText();

        if (strIgss.equals("") == false) {

            //CONVERSION DE STRING A DOUBLE
            double dbIgss = Double.parseDouble(txtIgss.getText());
            double dbIsr = Double.parseDouble(txtIsr.getText());
            double dbAnticipos = Double.parseDouble(txtAnticipos.getText());
            double dbDescuentosJ = Double.parseDouble(txtDescuentosJ.getText());
            double dbOtrosDescuentos = Double.parseDouble(txtOtrosDescuentos.getText());

            //CALCULO DE TOTAL DESCUENTOS
            double dbTotalDescuentos = dbIgss + dbIsr + dbAnticipos + dbDescuentosJ + dbOtrosDescuentos;
            dbTotalDescuentos = Math.round(dbTotalDescuentos * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strTotalDescuentos = String.valueOf(dbTotalDescuentos);
            //IMPRESIÓN EN PANTALLA
            txtTotalDescuentos.setText(strTotalDescuentos);

            //CALCULO DE SUELDO LIQUIDO
            //CONVERSION DE STRING A DOUBLE
            double dbIngresos = Double.parseDouble(txtSueldoDevengado.getText());

            double dbSueldoLiquido = dbIngresos - dbTotalDescuentos;
            //CONVERSION DE DOUBLE A STRING
            dbSueldoLiquido = Math.round(dbSueldoLiquido * 100) / 100d;
            String strSueldoLiquido = String.valueOf(dbSueldoLiquido);
            //IMPRESION EN PANTALLA
            txtSueldoLiquido.setText(strSueldoLiquido);

        }
    }//GEN-LAST:event_txtIgssKeyReleased

    private void txtIsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsrActionPerformed

    private void txtIsrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIsrKeyReleased
        String strIgss = txtIgss.getText();
        String strIsr = txtIsr.getText();
        String strAnticipos = txtAnticipos.getText();
        String strDescuentosJ = txtDescuentosJ.getText();
        String strOtrosDescuentos = txtOtrosDescuentos.getText();

        if (strIgss.equals("") == false) {

            //CONVERSION DE STRING A DOUBLE
            double dbIgss = Double.parseDouble(txtIgss.getText());
            double dbIsr = Double.parseDouble(txtIsr.getText());
            double dbAnticipos = Double.parseDouble(txtAnticipos.getText());
            double dbDescuentosJ = Double.parseDouble(txtDescuentosJ.getText());
            double dbOtrosDescuentos = Double.parseDouble(txtOtrosDescuentos.getText());

            //CALCULO DE TOTAL DESCUENTOS
            double dbTotalDescuentos = dbIgss + dbIsr + dbAnticipos + dbDescuentosJ + dbOtrosDescuentos;
            dbTotalDescuentos = Math.round(dbTotalDescuentos * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strTotalDescuentos = String.valueOf(dbTotalDescuentos);
            //IMPRESIÓN EN PANTALLA
            txtTotalDescuentos.setText(strTotalDescuentos);

            //CALCULO DE SUELDO LIQUIDO
            //CONVERSION DE STRING A DOUBLE
            double dbIngresos = Double.parseDouble(txtSueldoDevengado.getText());

            double dbSueldoLiquido = dbIngresos - dbTotalDescuentos;
            //CONVERSION DE DOUBLE A STRING
            dbSueldoLiquido = Math.round(dbSueldoLiquido * 100) / 100d;
            String strSueldoLiquido = String.valueOf(dbSueldoLiquido);
            //IMPRESION EN PANTALLA
            txtSueldoLiquido.setText(strSueldoLiquido);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsrKeyReleased

    private void txtAnticiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnticiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnticiposActionPerformed

    private void txtAnticiposKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnticiposKeyReleased
        String strIgss = txtIgss.getText();
        String strIsr = txtIsr.getText();
        String strAnticipos = txtAnticipos.getText();
        String strDescuentosJ = txtDescuentosJ.getText();
        String strOtrosDescuentos = txtOtrosDescuentos.getText();

        if (strIgss.equals("") == false) {

            //CONVERSION DE STRING A DOUBLE
            double dbIgss = Double.parseDouble(txtIgss.getText());
            double dbIsr = Double.parseDouble(txtIsr.getText());
            double dbAnticipos = Double.parseDouble(txtAnticipos.getText());
            double dbDescuentosJ = Double.parseDouble(txtDescuentosJ.getText());
            double dbOtrosDescuentos = Double.parseDouble(txtOtrosDescuentos.getText());

            //CALCULO DE TOTAL DESCUENTOS
            double dbTotalDescuentos = dbIgss + dbIsr + dbAnticipos + dbDescuentosJ + dbOtrosDescuentos;
            dbTotalDescuentos = Math.round(dbTotalDescuentos * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strTotalDescuentos = String.valueOf(dbTotalDescuentos);
            //IMPRESIÓN EN PANTALLA
            txtTotalDescuentos.setText(strTotalDescuentos);

            //CALCULO DE SUELDO LIQUIDO
            //CONVERSION DE STRING A DOUBLE
            double dbIngresos = Double.parseDouble(txtSueldoDevengado.getText());

            double dbSueldoLiquido = dbIngresos - dbTotalDescuentos;
            //CONVERSION DE DOUBLE A STRING
            dbSueldoLiquido = Math.round(dbSueldoLiquido * 100) / 100d;
            String strSueldoLiquido = String.valueOf(dbSueldoLiquido);
            //IMPRESION EN PANTALLA
            txtSueldoLiquido.setText(strSueldoLiquido);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnticiposKeyReleased

    private void txtAnticiposKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnticiposKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnticiposKeyTyped

    private void txtDescuentosJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentosJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentosJActionPerformed

    private void txtDescuentosJKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentosJKeyReleased
        String strIgss = txtIgss.getText();
        String strIsr = txtIsr.getText();
        String strAnticipos = txtAnticipos.getText();
        String strDescuentosJ = txtDescuentosJ.getText();
        String strOtrosDescuentos = txtOtrosDescuentos.getText();

        if (strIgss.equals("") == false) {

            //CONVERSION DE STRING A DOUBLE
            double dbIgss = Double.parseDouble(txtIgss.getText());
            double dbIsr = Double.parseDouble(txtIsr.getText());
            double dbAnticipos = Double.parseDouble(txtAnticipos.getText());
            double dbDescuentosJ = Double.parseDouble(txtDescuentosJ.getText());
            double dbOtrosDescuentos = Double.parseDouble(txtOtrosDescuentos.getText());

            //CALCULO DE TOTAL DESCUENTOS
            double dbTotalDescuentos = dbIgss + dbIsr + dbAnticipos + dbDescuentosJ + dbOtrosDescuentos;
            dbTotalDescuentos = Math.round(dbTotalDescuentos * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strTotalDescuentos = String.valueOf(dbTotalDescuentos);
            //IMPRESIÓN EN PANTALLA
            txtTotalDescuentos.setText(strTotalDescuentos);

            //CALCULO DE SUELDO LIQUIDO
            //CONVERSION DE STRING A DOUBLE
            double dbIngresos = Double.parseDouble(txtSueldoDevengado.getText());

            double dbSueldoLiquido = dbIngresos - dbTotalDescuentos;
            //CONVERSION DE DOUBLE A STRING
            dbSueldoLiquido = Math.round(dbSueldoLiquido * 100) / 100d;
            String strSueldoLiquido = String.valueOf(dbSueldoLiquido);
            //IMPRESION EN PANTALLA
            txtSueldoLiquido.setText(strSueldoLiquido);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentosJKeyReleased

    private void txtDescuentosJKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentosJKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            lblIngreseNum4.setVisible(true);
        } else {
            lblIngreseNum4.setVisible(false);
        }
    }//GEN-LAST:event_txtDescuentosJKeyTyped

    private void txtOtrosDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtrosDescuentosActionPerformed

    private void txtOtrosDescuentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosKeyReleased
        String strIgss = txtIgss.getText();
        String strIsr = txtIsr.getText();
        String strAnticipos = txtAnticipos.getText();
        String strDescuentosJ = txtDescuentosJ.getText();
        String strOtrosDescuentos = txtOtrosDescuentos.getText();

        if (strIgss.equals("") == false) {

            //CONVERSION DE STRING A DOUBLE
            double dbIgss = Double.parseDouble(txtIgss.getText());
            double dbIsr = Double.parseDouble(txtIsr.getText());
            double dbAnticipos = Double.parseDouble(txtAnticipos.getText());
            double dbDescuentosJ = Double.parseDouble(txtDescuentosJ.getText());
            double dbOtrosDescuentos = Double.parseDouble(txtOtrosDescuentos.getText());

            //CALCULO DE TOTAL DESCUENTOS
            double dbTotalDescuentos = dbIgss + dbIsr + dbAnticipos + dbDescuentosJ + dbOtrosDescuentos;
            dbTotalDescuentos = Math.round(dbTotalDescuentos * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strTotalDescuentos = String.valueOf(dbTotalDescuentos);
            //IMPRESIÓN EN PANTALLA
            txtTotalDescuentos.setText(strTotalDescuentos);

            //CALCULO DE SUELDO LIQUIDO
            //CONVERSION DE STRING A DOUBLE
            double dbIngresos = Double.parseDouble(txtSueldoDevengado.getText());

            double dbSueldoLiquido = dbIngresos - dbTotalDescuentos;
            //CONVERSION DE DOUBLE A STRING
            dbSueldoLiquido = Math.round(dbSueldoLiquido * 100) / 100d;
            String strSueldoLiquido = String.valueOf(dbSueldoLiquido);
            //IMPRESION EN PANTALLA
            txtSueldoLiquido.setText(strSueldoLiquido);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtrosDescuentosKeyReleased

    private void txtOtrosDescuentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            lblIngreseNum5.setVisible(true);
        } else {
            lblIngreseNum5.setVisible(false);
        }
    }//GEN-LAST:event_txtOtrosDescuentosKeyTyped

    private void txtBonificacionesExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBonificacionesExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBonificacionesExtraActionPerformed

    private void txtBonificacionesExtraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonificacionesExtraKeyReleased

        String strSueldoBase = txtSueldoBase.getText();
        String strComisiones = txtComisiones.getText();
        String strBonificacionesExtra = txtBonificacionesExtra.getText();
        String strBonificacionIncentivo = txtBonificacionIncentivo.getText();

        if (strSueldoBase.equals("") == false && strBonificacionIncentivo.equals("") == false) {
            //CALCULO DE SUELDO DEVENGADO
            //CONVERSION DE STRING A DOUBLE
            double dbSueldoBase = Double.parseDouble(txtSueldoBase.getText());
            double dbComisiones = Double.parseDouble(txtComisiones.getText());
            double dbBonificacionesExtra = Double.parseDouble(txtBonificacionesExtra.getText());
            double dbBonificacionIncentivo = Double.parseDouble(txtBonificacionIncentivo.getText());

            //CALCULO DE SUELDO DEVENGADO
            double dbSueldoDevengado = dbSueldoBase + dbComisiones + dbBonificacionesExtra + dbBonificacionIncentivo;
            dbSueldoDevengado = Math.round(dbSueldoDevengado * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strSueldoDevengado = String.valueOf(dbSueldoDevengado);
            //IMPRESIÓN EN PANTALLA
            txtSueldoDevengado.setText(strSueldoDevengado);

            //CALCULO DE DESCUENTOS
            //IGSS
            double dbIgss = dbSueldoBase * 0.0483;
            //CONVERSION DE DOUBLE A STRING
            dbIgss = Math.round(dbIgss * 100) / 100d;
            String strIgss = String.valueOf(dbIgss);
            //IMPRESION EN PANTALLA
            txtIgss.setText(strIgss);

            //ISR
            double dbIsr;
            if (dbSueldoBase < 6000) {
                dbIsr = 0;
            } else {
                //CALCULO TOTAL INGRESOS
                double dbSueldoAnual = dbSueldoBase * 12;
                double dbBonificacionIncentivoAnual = dbBonificacionIncentivo * 12;
                double dbIngresoAnual = dbSueldoAnual + dbBonificacionIncentivoAnual;
                //CALCULO TOTAL DESCUENTOS
                double dbIgssAnual = dbIgss * 12;
                double dbDescuentoAnual = dbIgssAnual + 48000;
                //CALCULO RENTA BRUTA
                double dbRentaBruta = dbIngresoAnual - dbDescuentoAnual;
                //CALCULO ISR ANUAL
                double dbIsrAnual = dbRentaBruta * 0.05;
                //CALCULO ISR MENSUAL
                dbIsr = dbIsrAnual / 12;
                //CONVERSION DE DOUBLE A STRING
                String strIsr = String.valueOf(dbIsr);
                dbIsr = Math.round(dbIsr * 100) / 100d;
                //IMPRESION EN PANTALLA
                txtIsr.setText(strIsr);
            }
        }
    }//GEN-LAST:event_txtBonificacionesExtraKeyReleased

    private void txtBonificacionesExtraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonificacionesExtraKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            lblIngreseNum2.setVisible(true);
        } else {
            lblIngreseNum2.setVisible(false);
        }
    }//GEN-LAST:event_txtBonificacionesExtraKeyTyped

    private void txtBonificacionIncentivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBonificacionIncentivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBonificacionIncentivoActionPerformed

    private void txtSueldoDevengadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoDevengadoActionPerformed

    }//GEN-LAST:event_txtSueldoDevengadoActionPerformed

    private void txtSueldoBaseInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSueldoBaseInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoBaseInputMethodTextChanged

    private void txtSueldoBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoBaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoBaseActionPerformed

    private void txtSueldoBaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoBaseKeyReleased

        String strSueldoBase = txtSueldoBase.getText();
        String strComisiones = txtComisiones.getText();
        String strBonificacionesExtra = txtBonificacionesExtra.getText();
        String strBonificacionIncentivo = txtBonificacionIncentivo.getText();

        if (strSueldoBase.equals("") == false && strBonificacionIncentivo.equals("") == false) {
            //CALCULO DE SUELDO DEVENGADO
            //CONVERSION DE STRING A DOUBLE
            double dbSueldoBase = Double.parseDouble(txtSueldoBase.getText());
            double dbComisiones = Double.parseDouble(txtComisiones.getText());
            double dbBonificacionesExtra = Double.parseDouble(txtBonificacionesExtra.getText());
            double dbBonificacionIncentivo = Double.parseDouble(txtBonificacionIncentivo.getText());

            //CALCULO DE SUELDO DEVENGADO
            double dbSueldoDevengado = dbSueldoBase + dbComisiones + dbBonificacionesExtra + dbBonificacionIncentivo;
            dbSueldoDevengado = Math.round(dbSueldoDevengado * 100) / 100d;
            //CONVERSION DE DOUBLE A STRING
            String strSueldoDevengado = String.valueOf(dbSueldoDevengado);
            //IMPRESIÓN EN PANTALLA
            txtSueldoDevengado.setText(strSueldoDevengado);

            //CALCULO DE DESCUENTOS
            //IGSS
            double dbIgss = dbSueldoBase * 0.0483;
            //CONVERSION DE DOUBLE A STRING
            dbIgss = Math.round(dbIgss * 100) / 100d;
            String strIgss = String.valueOf(dbIgss);
            //IMPRESION EN PANTALLA
            txtIgss.setText(strIgss);

            //ISR
            double dbIsr;
            if (dbSueldoBase < 6000) {
                dbIsr = 0;
                txtIsr.setText("0");
            } else {
                //CALCULO TOTAL INGRESOS
                double dbSueldoAnual = dbSueldoBase * 12;
                double dbBonificacionIncentivoAnual = dbBonificacionIncentivo * 12;
                double dbIngresoAnual = dbSueldoAnual + dbBonificacionIncentivoAnual;
                //CALCULO TOTAL DESCUENTOS
                double dbIgssAnual = dbIgss * 12;
                double dbDescuentoAnual = dbIgssAnual + 48000;
                //CALCULO RENTA BRUTA
                double dbRentaBruta = dbIngresoAnual - dbDescuentoAnual;
                //CALCULO ISR ANUAL
                double dbIsrAnual = dbRentaBruta * 0.05;
                //CALCULO ISR MENSUAL
                dbIsr = dbIsrAnual / 12;
                //CONVERSION DE DOUBLE A STRING
                String strIsr = String.valueOf(dbIsr);
                dbIsr = Math.round(dbIsr * 100) / 100d;
                //IMPRESION EN PANTALLA
                txtIsr.setText(strIsr);
            }

        }
    }//GEN-LAST:event_txtSueldoBaseKeyReleased

    private void txtSueldoBaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoBaseKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSueldoBaseKeyTyped

    private void cmbxNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Empleado from Empleados where Nombre_Empleado = ?");
            PreparedStatement pst3 = cn.prepareStatement("select Sueldo_Empleado from Empleados where Nombre_Empleado = ?");

            pst2.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());
            pst3.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();

            if (rs2.next()) {
                codigoe.setText(rs2.getString("Codigo_Empleado"));

            } else {

            }

            if (rs3.next()) {
                txtSueldoBase.setText(rs3.getString("Sueldo_Empleado"));

            } else {

            }

        } catch (Exception e) {
        }

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Concepto from Conceptos where Codigo_Empleado = ?");

            pst2.setString(1, codigoe.getText().trim());

            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                ConceptoE.setText(rs2.getString("Codigo_Concepto"));
            } else {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConceptoE;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> cmbxNombreEmpleado;
    private javax.swing.JLabel codigoe;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel empleado;
    private javax.swing.JLabel fechanomina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnticipos;
    private javax.swing.JLabel lblBonificacionIncentivo;
    private javax.swing.JLabel lblBonificacionesExtra;
    private javax.swing.JLabel lblCalculodeDescuentos;
    private javax.swing.JLabel lblCalculodeIngresos;
    private javax.swing.JLabel lblComisiones;
    private javax.swing.JLabel lblDescuentosJ;
    private javax.swing.JLabel lblIgss;
    private javax.swing.JLabel lblIngreseNum1;
    private javax.swing.JLabel lblIngreseNum2;
    private javax.swing.JLabel lblIngreseNum4;
    private javax.swing.JLabel lblIngreseNum5;
    private javax.swing.JLabel lblIngreseNum6;
    private javax.swing.JLabel lblIngresodeDatos;
    private javax.swing.JLabel lblIsr;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblOtrosDescuentos;
    private javax.swing.JLabel lblSueldoBase;
    private javax.swing.JLabel lblSueldoBase1;
    private javax.swing.JLabel lblSueldoDevengado;
    private javax.swing.JLabel lblTotalDescuentos;
    private javax.swing.JLabel lblTotalDescuentos1;
    private javax.swing.JLabel nombremp;
    private javax.swing.JTable tbl_Empleados;
    private javax.swing.JTable tbl_Nomina;
    private javax.swing.JTable tbl_concep;
    private javax.swing.JLabel timee;
    private javax.swing.JTextField txtAnticipos;
    private javax.swing.JTextField txtBonificacionIncentivo;
    private javax.swing.JTextField txtBonificacionesExtra;
    private javax.swing.JTextField txtComisiones;
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
