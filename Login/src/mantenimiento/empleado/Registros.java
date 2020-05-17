/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento.empleado;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import principal.mdiMenuPrincipal;

/**
 *
 * @author ranbr
 */
public class Registros extends javax.swing.JFrame {

    /**
     * Creates new form Altas
     */
    public Registros() {
        initComponents();

        this.setTitle("Altas Empleados");

        try {
             Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select Nombre_Puesto from Puestos ");
            ResultSet rss = psttt.executeQuery();

            PreparedStatement pstt2 = cn.prepareStatement("select Nombre_Departamento from Departamentos");
            ResultSet rss2 = pstt2.executeQuery();

            PreparedStatement pstt3 = cn.prepareStatement("select Codigo_Empleado from Empleados");
            ResultSet rss3 = pstt3.executeQuery();

            cbox_Puesto.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_Puesto.addItem(rss.getString("Nombre_Puesto"));
            }

            cbox_Departamento.addItem("Seleccione una opción");
            while (rss2.next()) {
                cbox_Departamento.addItem(rss2.getString("Nombre_Departamento"));
            }

            cbox_Id.addItem("Seleccione una opción");
            while (rss3.next()) {
                cbox_Id.addItem(rss3.getString("Codigo_Empleado"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }

    public void tablas() {
        try {
             Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Empleados");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("DPI");
            modelo.addColumn("Sueldo");
            tbl_Empleados.setModel(modelo);
            String[] dato = new String[4];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);
                dato[2] = rss4.getString(3);
                dato[3] = rss4.getString(7);
                modelo.addRow(dato);
            }

            PreparedStatement pstt1 = cn.prepareStatement("select * from Altas");
            ResultSet rss1 = pstt1.executeQuery();

            DefaultTableModel modelo_A = new DefaultTableModel();
            modelo_A.addColumn("Codigo Empleado");
            modelo_A.addColumn("Fecha Inicio");
            modelo_A.addColumn("Departamento");
            modelo_A.addColumn("Puesto");
            tbl_Altas.setModel(modelo_A);
            String[] dato2 = new String[4];
            String[] info = new String[1];
            String[] infop = new String[1];

            PreparedStatement psti = cn.prepareStatement("select Nombre_Departamento from Departamentos where Codigo_Departamento=?");
            PreparedStatement pstp = cn.prepareStatement("select Nombre_Puesto from puestos where Codigo_Puesto=?");
            while (rss1.next()) {
                info[0] = rss1.getString(4);
                infop[0] = rss1.getString(5);
                psti.setString(1, info[0]);
                pstp.setString(1, infop[0]);
                ResultSet rssi = psti.executeQuery();
                ResultSet rssp = pstp.executeQuery();
                while (rssi.next()) {
                    dato2[2] = rssi.getString("Nombre_Departamento");

                }
                while (rssp.next()) {
                    dato2[3] = rssp.getString("Nombre_Puesto");

                }
                dato2[0] = rss1.getString(2);
                dato2[1] = rss1.getString(3);

                modelo_A.addRow(dato2);
            }

            PreparedStatement pstt2 = cn.prepareStatement("select * from Bajas");
            ResultSet rss2 = pstt2.executeQuery();

            DefaultTableModel modelo_B = new DefaultTableModel();
            modelo_B.addColumn("Codigo Empleado");
            modelo_B.addColumn("Fecha Final");
            modelo_B.addColumn("Departamento");
            modelo_B.addColumn("Puesto");
            tbl_Bajas.setModel(modelo_B);

            String[] dato3 = new String[4];

            while (rss2.next()) {
                info[0] = rss2.getString(4);
                infop[0] = rss2.getString(5);
                psti.setString(1, info[0]);
                pstp.setString(1, infop[0]);
                ResultSet rssi = psti.executeQuery();
                ResultSet rssp = pstp.executeQuery();
                while (rssi.next()) {
                    dato3[2] = rssi.getString("Nombre_Departamento");

                }
                while (rssp.next()) {
                    dato3[3] = rssp.getString("Nombre_Puesto");

                }
                dato3[0] = rss2.getString(2);
                dato3[1] = rss2.getString(3);

                modelo_B.addRow(dato3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        btngEstado = new javax.swing.ButtonGroup();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label9 = new java.awt.Label();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        txt_Nombre = new java.awt.TextField();
        txt_Dpi = new java.awt.TextField();
        cbox_Departamento = new javax.swing.JComboBox<>();
        cbox_Puesto = new javax.swing.JComboBox<>();
        txt_Ubicacion = new java.awt.TextField();
        txt_Tel = new java.awt.TextField();
        txt_Sueldo = new java.awt.TextField();
        label14 = new java.awt.Label();
        date_Nacimiento = new com.toedter.calendar.JDateChooser();
        date_Inicio = new com.toedter.calendar.JDateChooser();
        lb_Dep = new javax.swing.JLabel();
        lb_Pues = new javax.swing.JLabel();
        btn_Altas = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inactivo = new javax.swing.JRadioButton();
        activo = new javax.swing.JRadioButton();
        txt_Estado = new javax.swing.JTextField();
        cbox_Id = new javax.swing.JComboBox<>();
        label13 = new java.awt.Label();
        date_F = new com.toedter.calendar.JDateChooser();
        label6 = new java.awt.Label();
        btnBaja = new javax.swing.JButton();
        btn_Refrescar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jpEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Empleados = new javax.swing.JTable();
        jpAltas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Altas = new javax.swing.JTable();
        jpBajas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Bajas = new javax.swing.JTable();

        jButton1.setText("jButton1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setTitle("MANTENIMIENTO EMPLEADOS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        label1.setText("Nombre");

        label2.setText("DPI");

        label3.setText("Departamento");

        label4.setText("Puesto");

        label5.setText("Fecha de Inicio");

        label9.setText("Telefono");

        label10.setText("Ubicacion");

        label11.setText("Sueldo");

        cbox_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_DepartamentoActionPerformed(evt);
            }
        });

        cbox_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_PuestoActionPerformed(evt);
            }
        });

        txt_Ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UbicacionActionPerformed(evt);
            }
        });

        txt_Tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelActionPerformed(evt);
            }
        });
        txt_Tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelKeyTyped(evt);
            }
        });

        txt_Sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SueldoActionPerformed(evt);
            }
        });
        txt_Sueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SueldoKeyTyped(evt);
            }
        });

        label14.setText("Fecha de Nacimiento");

        lb_Dep.setText("Codigo");

        lb_Pues.setText("Codigo");
        lb_Pues.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_Altas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/save (1).png"))); // NOI18N
        btn_Altas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AltasActionPerformed(evt);
            }
        });

        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/modify.png"))); // NOI18N
        btn_Actualizar.setEnabled(false);
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Estado Empleado");

        btngEstado.add(inactivo);
        inactivo.setText("Inactivo");

        btngEstado.add(activo);
        activo.setText("Activo");

        txt_Estado.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inactivo)
                .addGap(18, 18, 18)
                .addComponent(txt_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activo)
                    .addComponent(inactivo)
                    .addComponent(txt_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        cbox_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_IdActionPerformed(evt);
            }
        });

        label13.setText("ID");

        date_F.setEnabled(false);

        label6.setText("Fecha Final");

        btnBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/gnome_edit_delete.png"))); // NOI18N
        btnBaja.setEnabled(false);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btn_Refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/refresh.png"))); // NOI18N
        btn_Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefrescarActionPerformed(evt);
            }
        });

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/edit_clear.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jpEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

        tbl_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "DPI", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Empleados.setName("Empleados"); // NOI18N
        jScrollPane1.setViewportView(tbl_Empleados);

        jpAltas.setBorder(javax.swing.BorderFactory.createTitledBorder("Altas"));

        tbl_Altas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha Inicio", "Departamento", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_Altas);

        javax.swing.GroupLayout jpAltasLayout = new javax.swing.GroupLayout(jpAltas);
        jpAltas.setLayout(jpAltasLayout);
        jpAltasLayout.setHorizontalGroup(
            jpAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAltasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpAltasLayout.setVerticalGroup(
            jpAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpBajas.setBorder(javax.swing.BorderFactory.createTitledBorder("Bajas"));
        jpBajas.setPreferredSize(new java.awt.Dimension(472, 233));

        tbl_Bajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha Final", "Departamento", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Bajas);

        javax.swing.GroupLayout jpBajasLayout = new javax.swing.GroupLayout(jpBajas);
        jpBajas.setLayout(jpBajasLayout);
        jpBajasLayout.setHorizontalGroup(
            jpBajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBajasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jpBajasLayout.setVerticalGroup(
            jpBajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBajasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpEmpleadosLayout = new javax.swing.GroupLayout(jpEmpleados);
        jpEmpleados.setLayout(jpEmpleadosLayout);
        jpEmpleadosLayout.setHorizontalGroup(
            jpEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpAltas, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpBajas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(96, 96, 96))
        );
        jpEmpleadosLayout.setVerticalGroup(
            jpEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpleadosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jpAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpBajas, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpEmpleadosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(date_Inicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Sueldo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbox_Puesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbox_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Dep)
                                    .addComponent(lb_Pues)))
                            .addComponent(date_F, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbox_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_Tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(date_Nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Dpi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_Altas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbox_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_Dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Altas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(date_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbox_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lb_Dep)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbox_Puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lb_Pues))))
                                    .addComponent(btn_Refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(date_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jpEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_UbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UbicacionActionPerformed

    private void txt_TelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelActionPerformed

    private void txt_SueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SueldoActionPerformed

    private void cbox_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_DepartamentoActionPerformed
        try {
             Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Departamento from Departamentos where Nombre_Departamento = ?");

            pst2.setString(1, cbox_Departamento.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                lb_Dep.setText(rs2.getString("Codigo_Departamento"));

            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_DepartamentoActionPerformed

    private void cbox_PuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_PuestoActionPerformed
        try {
             Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst3 = cn.prepareStatement("select Codigo_Puesto from Puestos where Nombre_Puesto = ?");

            pst3.setString(1, cbox_Puesto.getSelectedItem().toString());

            ResultSet rs3 = pst3.executeQuery();

            if (rs3.next()) {

                lb_Pues.setText(rs3.getString("Codigo_Puesto"));

            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_PuestoActionPerformed

    private void btn_AltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AltasActionPerformed
        

        if (txt_Nombre.getText().isEmpty() || txt_Dpi.getText().isEmpty() || txt_Tel.getText().isEmpty() || txt_Ubicacion.getText().isEmpty() || txt_Sueldo.getText().isEmpty()
                || lb_Dep.getText().isEmpty() || lb_Pues.getText().isEmpty() || date_Nacimiento.getCalendar() == null || date_Inicio.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "¡Debe Llenar todos los campos!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            java.util.Date fechaN = date_Nacimiento.getDate();
        long d = fechaN.getTime();
        java.sql.Date date = new java.sql.Date(d);

        java.util.Date fechaI = date_Inicio.getDate();
        long di = fechaI.getTime();
        java.sql.Date datei = new java.sql.Date(di);
        String valor = null;

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            String id = txt_Dpi.getText();

            PreparedStatement pstt = cn.prepareStatement("insert into Empleados values(?,?,?,?,?,?,?,?,?,?,?)");

            pstt.setString(1, "0");
            pstt.setString(2, txt_Nombre.getText().trim());
            pstt.setString(3, txt_Dpi.getText().trim());
            pstt.setString(4, date.toString());
            pstt.setString(5, txt_Tel.getText().trim());
            pstt.setString(6, txt_Ubicacion.getText().trim());
            pstt.setString(7, txt_Sueldo.getText().trim());
            pstt.setString(8, "A");
            pstt.setString(9, datei.toString());
            pstt.setString(10, lb_Pues.getText().trim());
            pstt.setString(11, lb_Dep.getText().trim());
            pstt.executeUpdate();

            PreparedStatement pst3 = cn.prepareStatement("select Codigo_Empleado from Empleados where Dpi_Empleado=?");
            pst3.setString(1, id);
            ResultSet rs = pst3.executeQuery();

            if (rs.next()) {
                valor = (rs.getString("Codigo_Empleado"));

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no registrado.");
            }

            PreparedStatement pst2 = cn.prepareStatement("insert into Altas values(?,?,?,?,?)");
            pst2.setString(1, "0");
            pst2.setString(2, valor);
            pst2.setString(3, datei.toString());
            pst2.setString(4, lb_Dep.getText().trim());
            pst2.setString(5, lb_Pues.getText().trim());

            pst2.executeUpdate();

            txt_Nombre.setText("");
            txt_Dpi.setText("");
            txt_Tel.setText("");
            txt_Ubicacion.setText("");
            txt_Sueldo.setText("");
            cbox_Departamento.setSelectedIndex(0);
            cbox_Puesto.setSelectedIndex(0);
            txt_Nombre.setEnabled(true);
            txt_Dpi.setEnabled(true);
            txt_Tel.setEnabled(true);
            txt_Ubicacion.setEnabled(true);
            txt_Sueldo.setEnabled(true);
            date_Nacimiento.setEnabled(true);
            date_Inicio.setEnabled(true);
            cbox_Departamento.setEnabled(true);
            cbox_Puesto.setEnabled(true);
            lb_Dep.setText("Codigo");
            lb_Pues.setText("Codigo");

            date_Nacimiento.setCalendar(null);
            date_Inicio.setCalendar(null);
            date_F.setCalendar(null);

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡REGISTRO FALLIDO!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }}

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AltasActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        java.util.Date fecha = date_Nacimiento.getDate();
        long d = fecha.getTime();
        java.sql.Date date = new java.sql.Date(d);

        java.util.Date fechaI = date_Inicio.getDate();
        long di = fechaI.getTime();
        java.sql.Date datei = new java.sql.Date(di);
        String codigo = cbox_Id.getSelectedItem().toString();

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update Empleados set Nombre_Empleado = ?, Dpi_Empleado = ?, Fecha_Nacimiento = ? ,Tel_Empleado = ?,Ubicacion_Empleado = ?,Sueldo_Empleado = ?, Estado_Empleado=?, Fecha_Inicio = ?,Codigo_Puesto =?,Codigo_Departamento=? where Codigo_Empleado=" + codigo);
            String mensaje = "";

            if (activo.isSelected()) {
                mensaje = "A";
            } else if (inactivo.isSelected()) {
                mensaje = "B";

            }

            pst.setString(1, txt_Nombre.getText().trim());
            pst.setString(2, txt_Dpi.getText().trim());
            pst.setString(3, date.toString());
            pst.setString(4, txt_Tel.getText().trim());
            pst.setString(5, txt_Ubicacion.getText().trim());
            pst.setString(6, txt_Sueldo.getText().trim());
            pst.setString(7, mensaje);
            pst.setString(8, datei.toString());
            pst.setString(9, lb_Pues.getText().trim());
            pst.setString(10, lb_Dep.getText().trim());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            txt_Nombre.setText("");
            txt_Dpi.setText("");
            txt_Tel.setText("");
            txt_Ubicacion.setText("");
            txt_Sueldo.setText("");
            cbox_Departamento.setSelectedIndex(0);
            cbox_Puesto.setSelectedIndex(0);
            txt_Nombre.setEnabled(true);
            txt_Dpi.setEnabled(true);
            txt_Tel.setEnabled(true);
            txt_Ubicacion.setEnabled(true);
            txt_Sueldo.setEnabled(true);
            date_Nacimiento.setEnabled(true);
            date_Inicio.setEnabled(true);
            cbox_Departamento.setEnabled(true);
            cbox_Puesto.setEnabled(true);
            lb_Dep.setText("Codigo");
            lb_Pues.setText("Codigo");
            cbox_Id.setSelectedIndex(0);
            txt_Estado.setText("");

            date_Nacimiento.setCalendar(null);
            date_Inicio.setCalendar(null);
            date_F.setCalendar(null);
            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡MODIFICACION FALLIDA!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void cbox_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_IdActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Empleados where Codigo_Empleado= ?");
            pst.setString(1, cbox_Id.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_Nombre.setText(rs.getString("Nombre_Empleado"));
                txt_Dpi.setText(rs.getString("Dpi_Empleado"));
                date_Nacimiento.setDate(rs.getDate("Fecha_Nacimiento"));
                txt_Tel.setText(rs.getString("Tel_Empleado"));
                txt_Ubicacion.setText(rs.getString("Ubicacion_Empleado"));
                txt_Sueldo.setText(rs.getString("Sueldo_Empleado"));
                txt_Estado.setText(rs.getString("Estado_Empleado"));
                date_Inicio.setDate(rs.getDate("Fecha_Inicio"));
                lb_Pues.setText(rs.getString("Codigo_Puesto"));
                lb_Dep.setText(rs.getString("Codigo_Departamento"));

                btn_Altas.setEnabled(false);
                btn_Actualizar.setEnabled(true);
                btnBaja.setEnabled(true);

                if (txt_Estado.getText().equals("A")) {
                    date_F.setEnabled(true);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_IdActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed

        java.util.Date fecha = date_F.getDate();
        long d = fecha.getTime();
        java.sql.Date date = new java.sql.Date(d);

        if (date_F.getDate().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "¡Debe Llenar el campo de fecha final para dar de baja al empleado!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            date_F.setFocusable(true);
            return;
        }

        try {
             Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("insert into Bajas values(?,?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, cbox_Id.getSelectedItem().toString());
            pst.setString(3, date.toString());
            pst.setString(4, lb_Dep.getText().trim());
            pst.setString(5, lb_Pues.getText().trim());

            pst.executeUpdate();

            PreparedStatement pst2 = cn.prepareStatement("delete from Altas where Codigo_Empleado= ?");
            pst2.setString(1, cbox_Id.getSelectedItem().toString());
            pst2.executeUpdate();

            String codigo = cbox_Id.getSelectedItem().toString();
            PreparedStatement pst3 = cn.prepareStatement("update Empleados set Estado_Empleado = ? where Codigo_Empleado = " + codigo);

            pst3.setString(1, "B");
            pst3.executeUpdate();

            btnBaja.setEnabled(false);

            txt_Nombre.setText("");
            lb_Dep.setText("");
            lb_Pues.setText("");

            cbox_Id.setSelectedItem(0);
            date_Nacimiento.setCalendar(null);
            date_Inicio.setCalendar(null);
            date_F.setCalendar(null);

            JOptionPane.showMessageDialog(this, "¡BAJA DE EMPLEADO EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            txt_Nombre.setText("");
            txt_Dpi.setText("");
            txt_Tel.setText("");
            txt_Ubicacion.setText("");
            txt_Sueldo.setText("");
            cbox_Departamento.setSelectedIndex(0);
            cbox_Puesto.setSelectedIndex(0);

            lb_Dep.setText("Codigo");
            lb_Pues.setText("Codigo");

            date_Nacimiento.setCalendar(null);
            date_Inicio.setCalendar(null);
            date_F.setCalendar(null);
            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡BAJA DE EMPLEADO FALLIDO!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btn_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefrescarActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select Nombre_Puesto from Puestos ");
            ResultSet rss = psttt.executeQuery();

            PreparedStatement pstt2 = cn.prepareStatement("select Nombre_Departamento from Departamentos");
            ResultSet rss2 = pstt2.executeQuery();

            PreparedStatement pstt3 = cn.prepareStatement("select Codigo_Empleado from Empleados");
            ResultSet rss3 = pstt3.executeQuery();

            cbox_Puesto.removeAllItems();
            cbox_Puesto.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_Puesto.addItem(rss.getString("Nombre_Puesto"));
            }

            cbox_Departamento.removeAllItems();
            cbox_Departamento.addItem("Seleccione una opción");
            while (rss2.next()) {
                cbox_Departamento.addItem(rss2.getString("Nombre_Departamento"));
            }

            cbox_Id.removeAllItems();
            cbox_Id.addItem("Seleccione una opción");
            while (rss3.next()) {
                cbox_Id.addItem(rss3.getString("Codigo_Empleado"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        tablas();

// TODO add your handling code here:
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txt_Nombre.setText("");
        txt_Dpi.setText("");
        txt_Tel.setText("");
        txt_Ubicacion.setText("");
        txt_Sueldo.setText("");
        cbox_Departamento.setSelectedIndex(0);
        cbox_Puesto.setSelectedIndex(0);
        cbox_Id.setSelectedIndex(0);
        txt_Estado.setText("");
        lb_Dep.setText("Codigo");
        lb_Pues.setText("Codigo");

        date_Nacimiento.setCalendar(null);
        date_Inicio.setCalendar(null);
        date_F.setCalendar(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_TelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelKeyTyped

    private void txt_SueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SueldoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SueldoKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Altas;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.ButtonGroup btngEstado;
    private javax.swing.JComboBox<String> cbox_Departamento;
    private javax.swing.JComboBox<String> cbox_Id;
    private javax.swing.JComboBox<String> cbox_Puesto;
    private com.toedter.calendar.JDateChooser date_F;
    private com.toedter.calendar.JDateChooser date_Inicio;
    private com.toedter.calendar.JDateChooser date_Nacimiento;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpAltas;
    private javax.swing.JPanel jpBajas;
    private javax.swing.JPanel jpEmpleados;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label9;
    private javax.swing.JLabel lb_Dep;
    private javax.swing.JLabel lb_Pues;
    private javax.swing.JTable tbl_Altas;
    private javax.swing.JTable tbl_Bajas;
    private javax.swing.JTable tbl_Empleados;
    private java.awt.TextField txt_Dpi;
    private javax.swing.JTextField txt_Estado;
    private java.awt.TextField txt_Nombre;
    private java.awt.TextField txt_Sueldo;
    private java.awt.TextField txt_Tel;
    private java.awt.TextField txt_Ubicacion;
    // End of variables declaration//GEN-END:variables
}
