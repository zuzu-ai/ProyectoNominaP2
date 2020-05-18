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
public class Concepto extends javax.swing.JInternalFrame {

    /**
     * Creates new form Concepto
     */
    public void comboDBe() {
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

    public void comboDB() {

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from Aplicacion where Codigo_Puesto=?");
            pst2.setString(1, codigop.getText());
            ResultSet rs2 = pst2.executeQuery();

            aplicacion.addItem("Seleccione una opción");
            while (rs2.next()) {
                aplicacion.addItem(rs2.getString("Nombre_Aplicacion"));
            }

        } catch (Exception e) {

        }
    }

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Conceptos");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Concepto");
            tbl_Conceptos.setModel(modelo);
            String[] dato = new String[5];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(3);

                modelo.addRow(dato);
            }

        } catch (Exception e) {

        }

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Aplicacion");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Aplicacion");
            tbl_ap.setModel(modelo);
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
            PreparedStatement pstt4 = cn.prepareStatement("select * from Empleados");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Empleado");
            tbl_empleados.setModel(modelo);
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
            PreparedStatement pstt4 = cn.prepareStatement("select * from Puestos");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Puesto");
            tbl_puestos.setModel(modelo);
            String[] dato = new String[5];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);

                modelo.addRow(dato);
            }

        } catch (Exception e) {

        }
    }

    public void buscar_codigop() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Empleados where Codigo_Empleado = ?");

            pst.setString(1, codigoe.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                codigop.setText(rs.getString("Codigo_Puesto"));

            } else {

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

                nombre_emp.setText(rs.getString("Nombre_Empleado"));
                String ne = nombre_emp.getText();
                cmbxNombreEmpleado.setSelectedItem(ne);

            } else {

            }

        } catch (Exception e) {

        }
    }

    public void buscar_aplicacion() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Aplicacion where Codigo_Aplicacion = ?");

            pst.setString(1, codigo_ap.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                nombre_ap.setText(rs.getString("Nombre_Aplicacion"));
                String na = nombre_ap.getText();
                aplicacion.setSelectedItem(na);

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
            
            String u=nombreconcepto.getText();
            pst.setString(3, "Eliminó el concepto "+u);
            
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
                
                date.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date.getText());
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
            
            String u=nombreconcepto.getText();
            pst.setString(3, "Registró el concepto "+u);
            
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
                
                date.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date.getText());
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
            
            String u=nombreconcepto.getText();
            pst.setString(3, "Modificó el concepto "+u);
            
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
                
                date.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date.getText());
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
            
            String u=nombreconcepto.getText();
            pst.setString(3, "Buscó el concepto "+u);
            
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
                
                date.setText(fecha);
                timee.setText(time);
                
                pst.setString(4, date.getText());
                pst.setString(5, timee.getText());
            
            

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }


    public Concepto() {
        initComponents();
        comboDBe();
        tablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre_emp = new javax.swing.JLabel();
        nombre_ap = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        valorconcepto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        codigo_ap = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnModificar1 = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_puestos = new javax.swing.JTable();
        codigop = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        aplicacion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        claseconcepto = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_ap = new javax.swing.JTable();
        tipoconcepto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_empleados = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        nombreconcepto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigoe = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Conceptos = new javax.swing.JTable();
        cmbxNombreEmpleado = new javax.swing.JComboBox<>();
        clase = new javax.swing.JLabel();

        nombre_emp.setText("jLabel12");

        nombre_ap.setText("jLabel12");

        usuario.setText("jLabel6");

        timee.setText("jLabel1");

        date.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestor de Conceptos");
        setVisible(true);

        tipo.setText("Codigo");

        jLabel6.setText("Valor");

        codigo_ap.setText("Codigo");

        buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/busqueda1bf.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/gnome_edit_delete.png"))); // NOI18N
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Puestos");

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

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/save (1).png"))); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        tbl_puestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_puestos);

        codigop.setText("Codigo");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Puesto");

        jLabel5.setText("Aplicacion");

        aplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicacionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Aplicaciones");

        jLabel4.setText("Clase");

        claseconcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "+", "-" }));
        claseconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claseconceptoActionPerformed(evt);
            }
        });

        tbl_ap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Aplicacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_ap);

        tipoconcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "%", "C" }));
        tipoconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoconceptoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Empleados");

        jLabel3.setText("Tipo");

        tbl_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Empleados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_empleados);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Conceptos");

        jLabel2.setText("Nombre del Concepto");

        jLabel1.setText("Empleado");

        codigoe.setText("Codigo");

        tbl_Conceptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Conceptos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Conceptos);

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

        clase.setText("Codigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cmbxNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(codigoe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(codigop))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nombreconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(claseconcepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tipoconcepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codigo_ap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(193, 193, 193))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tipo)
                                            .addComponent(clase))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel11))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(valorconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel8))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel7))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbxNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoe)
                            .addComponent(jLabel1)
                            .addComponent(codigop))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tipoconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(claseconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(clase))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(codigo_ap))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(valorconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Conceptos where Codigo_Concepto = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                codigoe.setText(rs.getString("Codigo_Empleado"));
                nombreconcepto.setText(rs.getString("Nombre_Concepto"));
                tipo.setText(rs.getString("Tipo_Concepto"));
                clase.setText(rs.getString("Clase_Concepto"));
                codigo_ap.setText(rs.getString("Aplicacion_Concepto"));
                valorconcepto.setText(rs.getString("Valor"));
                buscar_codigop();
                buscar_nombreempleado();

                String tip = tipo.getText();
                tipoconcepto.setSelectedItem(tip);

                String clas = clase.getText();
                claseconcepto.setSelectedItem(clas);

                buscar_aplicacion();
                bitacora_busqueda();

                btnModificar1.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnIngresar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Concepto no registrado", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from conceptos where Codigo_concepto = ?");

            pst2.setString(1, buscar.getText().trim());
            
            bitacora_eliminar();
            pst2.executeUpdate();

            cmbxNombreEmpleado.setSelectedIndex(0);
            codigoe.setText("Codigo");
            codigop.setText("Codigo");
            codigo_ap.setText("Codigo");
            nombreconcepto.setText("");
            tipoconcepto.setSelectedIndex(0);
            claseconcepto.setSelectedIndex(0);
            aplicacion.removeAllItems();
            nombreconcepto.setText("");
            valorconcepto.setText("");
            
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
            PreparedStatement pst2 = cn.prepareStatement("update Conceptos set codigo_empleado = ?, nombre_concepto = ?, tipo_concepto = ?, clase_concepto = ? , aplicacion_concepto = ?, valor=? where codigo_concepto=" + ID);

            pst2.setString(1, codigoe.getText());
            pst2.setString(2, nombreconcepto.getText());
            pst2.setString(3, tipo.getText());
            pst2.setString(4, clase.getText());
            pst2.setString(5, codigo_ap.getText());
            pst2.setString(6, valorconcepto.getText());
            
            bitacora_modificar();
            pst2.executeUpdate();

            cmbxNombreEmpleado.setSelectedIndex(0);
            codigoe.setText("Codigo");
            codigop.setText("Codigo");
            codigo_ap.setText("Codigo");
            nombreconcepto.setText("");
            tipoconcepto.setSelectedIndex(0);
            claseconcepto.setSelectedIndex(0);
            aplicacion.removeAllItems();
            nombreconcepto.setText("");
            valorconcepto.setText("");
            
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
        codigoe.setText("Codigo");
        codigop.setText("Codigo");
        codigo_ap.setText("Codigo");
        nombreconcepto.setText("");
        tipoconcepto.setSelectedIndex(0);
        claseconcepto.setSelectedIndex(0);
        aplicacion.removeAllItems();
        nombreconcepto.setText("");
        valorconcepto.setText("");
        buscar.setText("");
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);
        
        btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into Conceptos values(?,?,?,?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, codigoe.getText());
            pst2.setString(3, nombreconcepto.getText());
            pst2.setString(4, tipo.getText());
            pst2.setString(5, clase.getText());
            pst2.setString(6, codigo_ap.getText());
            pst2.setString(7, valorconcepto.getText());

            pst2.executeUpdate();
            
            bitacora_guardar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            codigoe.setText("Codigo");
            codigop.setText("Codigo");
            codigo_ap.setText("Codigo");
            nombreconcepto.setText("");
            tipoconcepto.setSelectedIndex(0);
            claseconcepto.setSelectedIndex(0);
            aplicacion.removeAllItems();
            nombreconcepto.setText("");
            valorconcepto.setText("");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        // TODO add your handling code here:
        tablas();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void aplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicacionActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Aplicacion from Aplicacion where Nombre_Aplicacion = ?");

            pst2.setString(1, aplicacion.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                codigo_ap.setText(rs2.getString("Codigo_Aplicacion"));
            }

            //if(aplicacion.getSelectedItem().toString()=="Seleccione una opción"){ codigo_ap.setText("Codigo");}
        } catch (Exception e) {
        }

        tablas();

    }//GEN-LAST:event_aplicacionActionPerformed

    private void claseconceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claseconceptoActionPerformed
        // TODO add your handling code here:
        String clas = claseconcepto.getSelectedItem().toString();
        clase.setText(clas);

        if (claseconcepto.getSelectedItem().toString() == "Seleccione una opción") {
            clase.setText("Codigo");
        }
    }//GEN-LAST:event_claseconceptoActionPerformed

    private void tipoconceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoconceptoActionPerformed
        // TODO add your handling code here:
        String tipos = tipoconcepto.getSelectedItem().toString();
        tipo.setText(tipos);

        if (tipoconcepto.getSelectedItem().toString() == "Seleccione una opción") {
            tipo.setText("Codigo");
        }
    }//GEN-LAST:event_tipoconceptoActionPerformed

    private void cmbxNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Empleado from Empleados where Nombre_Empleado = ?");
            PreparedStatement pst3 = cn.prepareStatement("select Codigo_Puesto from Empleados where Nombre_Empleado = ?");

            pst2.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());
            pst3.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();

            if (rs2.next()) {
                codigoe.setText(rs2.getString("Codigo_Empleado"));

            } else {
                codigoe.setText("Codigo");
            }
            if (rs3.next()) {
                codigop.setText(rs3.getString("Codigo_Puesto"));
            } else {
                codigop.setText("Codigo");
            }

        } catch (Exception e) {
        }
        tablas();
        aplicacion.removeAllItems();
        comboDB();
    }//GEN-LAST:event_cmbxNombreEmpleadoActionPerformed

    private void cmbxNombreEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxNombreEmpleadoKeyPressed

    private void cmbxNombreEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxNombreEmpleadoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> aplicacion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel clase;
    private javax.swing.JComboBox<String> claseconcepto;
    private javax.swing.JComboBox<String> cmbxNombreEmpleado;
    private javax.swing.JLabel codigo_ap;
    private javax.swing.JLabel codigoe;
    private javax.swing.JLabel codigop;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nombre_ap;
    private javax.swing.JLabel nombre_emp;
    private javax.swing.JTextField nombreconcepto;
    private javax.swing.JTable tbl_Conceptos;
    private javax.swing.JTable tbl_ap;
    private javax.swing.JTable tbl_empleados;
    private javax.swing.JTable tbl_puestos;
    private javax.swing.JLabel timee;
    private javax.swing.JLabel tipo;
    private javax.swing.JComboBox<String> tipoconcepto;
    public static javax.swing.JLabel usuario;
    private javax.swing.JTextField valorconcepto;
    // End of variables declaration//GEN-END:variables
}
