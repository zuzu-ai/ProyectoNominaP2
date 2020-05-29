package mantenimiento.empleado;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import Principal.mdiMenuPrincipal;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Calendar;
/**
 *
 * @author Ashly Barrios 9959-18-649
 */
public class Departamento extends javax.swing.JFrame {

    public static int clic;
    private int x;
    private int y;
/**
 *
 * Funcion para que se muestre la tabla con la informacion que esta en la base de datos 
 */
    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from departamentos");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Nombre Departamento");
            modelo.addColumn("Estado");
            tbl_Dep.setModel(modelo);
            String[] dato = new String[2];
            while (rss4.next()) {
                dato[0] = rss4.getString(2);
                dato[1] = rss4.getString(3);

                modelo.addRow(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 *
 * Funcion para actualizar los combobox
 */
    public void refrescar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select Codigo_Departamento from departamentos ");
            ResultSet rss = psttt.executeQuery();

            cbox_Departamento.removeAllItems();
            cbox_Departamento.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_Departamento.addItem(rss.getString("Codigo_Departamento"));
            }
            tablas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }
/**
 *
 * Funcion para poblar el combobox con la informacion correspondiente segun la base de datos
 */
    public void iniciar_combo() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement psttt = cn.prepareStatement("select Codigo_Departamento from departamentos ");
            ResultSet rss = psttt.executeQuery();

            cbox_Departamento.addItem("Seleccione una opción");
            while (rss.next()) {
                cbox_Departamento.addItem(rss.getString("Codigo_Departamento"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablas();
    }
 /**
 *
 * Funcion para poblar la tabla de bitacora en la base de datos con la funcion de eliminar
 */
    public void bitacora_eliminar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txt_CrearDep.getText();
            pst.setString(3, "Eliminó el departamento " + u);

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

            date.setText(fecha);
            timee.setText(time);

            pst.setString(4, date.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }
/**
 *
 * Funcion para poblar la tabla bitacora con la funcion de guardar
 */
    public void bitacora_guardar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txt_CrearDep.getText();
            pst.setString(3, "Registró el departamento " + u);

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

            date.setText(fecha);
            timee.setText(time);

            pst.setString(4, date.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }
/**
 *
 * Funcion para poblar la tabla bitacora con la funcion modificar
 */
    public void bitacora_modificar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txt_CrearDep.getText();
            pst.setString(3, "Modificó el departamento " + u);

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

            date.setText(fecha);
            timee.setText(time);

            pst.setString(4, date.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }
 /**
 *
 * Funcion para poblar la tabla bitacora para la funcion busqueda
 */
    public void bitacora_busqueda() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txt_CrearDep.getText();
            pst.setString(3, "Buscó el concepto " + u);

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

            date.setText(fecha);
            timee.setText(time);

            pst.setString(4, date.getText());
            pst.setString(5, timee.getText());

            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }
 /**
 *
 * Funcion para poblar la tabla del tema en la base de datos
 */
    public void tema() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    label4.setForeground(new java.awt.Color(0, 0, 0));
                    label3.setForeground(new java.awt.Color(0, 0, 0));
                    label8.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
                    txt_CrearDep.setForeground(new java.awt.Color(0, 0, 0));
                    txt_estado.setForeground(new java.awt.Color(0, 0, 0));
                    ln1.setVisible(false);
                    ln2.setVisible(false);
                    lb1.setVisible(true);
                    lb2.setVisible(true);
                    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                    label1.setForeground(new java.awt.Color(0, 0, 0));
                    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
                    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
                    activo.setForeground(new java.awt.Color(0, 0, 0));
                    inactivo.setForeground(new java.awt.Color(0, 0, 0));

                    jPanel3.setForeground(new java.awt.Color(0, 0, 0));
                    btnIngresar.setVisible(true);
                    btnIngresar1.setVisible(false);
                    limpiarbtn.setVisible(true);
                    btnLimpiar1.setVisible(false);
                    btnEliminar.setVisible(true);
                    btnEliminar1.setVisible(false);
                    btnModificar1.setVisible(true);
                    btnModificar2.setVisible(false);

                    btnCerrar1.setVisible(false);
                    cerrarbtn1.setVisible(true);
                    btnMinimizar1.setVisible(false);
                    minimizarbtn1.setVisible(true);

                } else {
                    if (code.getText().contains("Oscuro")) {
                        label4.setForeground(new java.awt.Color(255, 255, 255));
                        label3.setForeground(new java.awt.Color(255, 255, 255));
                        label8.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                        txt_CrearDep.setForeground(new java.awt.Color(255, 255, 255));
                        txt_estado.setForeground(new java.awt.Color(255, 255, 255));
                        ln1.setVisible(true);
                        ln2.setVisible(true);
                        lb1.setVisible(false);
                        lb2.setVisible(false);
                        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
                        label1.setForeground(new java.awt.Color(255, 255, 255));
                        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
                        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
                        activo.setForeground(new java.awt.Color(255, 255, 255));
                        inactivo.setForeground(new java.awt.Color(255, 255, 255));

                        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
                        btnIngresar.setVisible(false);
                        btnIngresar1.setVisible(true);
                        limpiarbtn.setVisible(false);
                        btnLimpiar1.setVisible(true);
                        btnEliminar.setVisible(false);
                        btnEliminar1.setVisible(true);
                        btnModificar1.setVisible(false);
                        btnModificar2.setVisible(true);

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
/**
 *
 * Funcion para buscar la informacion que esta en la tabla del tema 
 */
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
/**
 *
 * Funcion principal de la clase
 */
    public Departamento() {
        initComponents();
        setLocationRelativeTo(null);
        tablas();
        iniciar_combo();

        this.clic = getClic();
        tema();

        label8.setBackground(new java.awt.Color(0, 0, 0, 1));
        label3.setBackground(new java.awt.Color(0, 0, 0, 1));
        label4.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_CrearDep.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_estado.setBackground(new java.awt.Color(0, 0, 0, 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timee = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        us = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        Claro = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        cbox_Departamento = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        btnCerrar1 = new temanegro.btnCerrar();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        btnMinimizar1 = new temanegro.btnMinimizar();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnIngresar = new temaclaro.Guardarbtn();
        btnIngresar1 = new temanegro.btnGuardar();
        limpiarbtn = new temaclaro.Limpiarbtn();
        btnLimpiar1 = new temanegro.btnLimpiar();
        btnModificar1 = new temaclaro.Editarbtn();
        btnModificar2 = new temanegro.btnEditar();
        btnEliminar = new temaclaro.Eliminarbtn();
        btnEliminar1 = new temanegro.btnEliminar();
        txt_CrearDep = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Dep = new javax.swing.JTable();
        label8 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        ln1 = new javax.swing.JLabel();
        ln2 = new javax.swing.JLabel();

        timee.setText("jLabel7");

        date.setText("jLabel7");

        us.setText("jLabel7");

        usuario.setText("jLabel7");

        Claro.setText("0");

        code.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbox_Departamento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_DepartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 64, 242, -1));

        jPanel1.setOpaque(false);

        activo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        activo.setText("Activo");
        activo.setOpaque(false);

        inactivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        inactivo.setText("Inactivo");
        inactivo.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(inactivo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activo)
                    .addComponent(inactivo)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 141, -1, -1));

        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerrarbtn1.setText("cerrarbtn1");
        cerrarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarbtn1MousePressed(evt);
            }
        });
        jPanel3.add(cerrarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 30, -1));

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrar1MousePressed(evt);
            }
        });
        jPanel3.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, -1, -1));

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel3.add(minimizarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizar1MousePressed(evt);
            }
        });
        jPanel3.add(btnMinimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Gestor de Departamentos");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setText("guardarbtn1");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresarMousePressed(evt);
            }
        });
        jPanel4.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnIngresar1.setText("btnGuardar1");
        btnIngresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresar1MousePressed(evt);
            }
        });
        jPanel4.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        limpiarbtn.setText("limpiarbtn1");
        limpiarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                limpiarbtnMousePressed(evt);
            }
        });
        jPanel4.add(limpiarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        btnLimpiar1.setText("btnLimpiar1");
        btnLimpiar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLimpiar1MousePressed(evt);
            }
        });
        jPanel4.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        btnModificar1.setText("editarbtn1");
        btnModificar1.setEnabled(false);
        btnModificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificar1MousePressed(evt);
            }
        });
        jPanel4.add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        btnModificar2.setText("btnEditar1");
        btnModificar2.setEnabled(false);
        btnModificar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificar2MousePressed(evt);
            }
        });
        jPanel4.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        btnEliminar.setText("eliminarbtn1");
        btnEliminar.setEnabled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        btnEliminar1.setText("btnEliminar1");
        btnEliminar1.setEnabled(false);
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminar1MousePressed(evt);
            }
        });
        jPanel4.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 160, 40));

        txt_CrearDep.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_CrearDep.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_CrearDep.setOpaque(false);
        getContentPane().add(txt_CrearDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 240, -1));

        tbl_Dep.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_Dep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Departamento", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Dep);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 262, 165));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Estado:");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Departamentos");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Departamento:");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("ID Departamento:");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_estado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_estado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_estado.setOpaque(false);
        getContentPane().add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 40, 20));

        lb1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar.png"))); // NOI18N
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 700, 280));

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 700, 280));

        ln1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar b.png"))); // NOI18N
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 700, 280));

        ln2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        getContentPane().add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 700, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 *
 * Funcion para mostrar el codigo del combobox
 */
    private void cbox_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_DepartamentoActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from Departamentos where Codigo_Departamento = ?");
            pst2.setString(1, cbox_Departamento.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                txt_CrearDep.setText(rs2.getString("Nombre_Departamento"));
                txt_estado.setText(rs2.getString("Estado_Departamento"));
                btnEliminar.setEnabled(true);
                btnModificar1.setEnabled(true);
                btnIngresar.setEnabled(false);
                btnEliminar1.setEnabled(true);
                btnModificar2.setEnabled(true);
                btnIngresar1.setEnabled(false);

                bitacora_busqueda();
            } else {
                if (cbox_Departamento.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_CrearDep.setText("");
                    txt_estado.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_DepartamentoActionPerformed

    private void cerrarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarbtn1MousePressed
        this.dispose();
    }//GEN-LAST:event_cerrarbtn1MousePressed

    private void btnCerrar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MousePressed
        this.dispose();
    }//GEN-LAST:event_btnCerrar1MousePressed

    private void minimizarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarbtn1MousePressed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizarbtn1MousePressed

    private void btnMinimizar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizar1MousePressed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizar1MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: (" + ubicacion.x + "," + ubicacion.y + ")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed
/**
 *
 * Funcion para ingresar los datos en la base de datos
 */
    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed
        String puesto = txt_CrearDep.getText().trim();
        if (puesto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el nombre del departamento!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("insert into Departamentos values(?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, txt_CrearDep.getText().trim());
            pst.setString(3, "A");

            pst.executeUpdate();
            bitacora_guardar();
            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            tablas();

            txt_CrearDep.setText("");
            cbox_Departamento.setSelectedIndex(0);
            txt_estado.setText("");
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡REGISTRO FALLIDO!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnIngresarMousePressed
/**
 *
 * Funcion para ingresar los datos en la base de datos
 */
    private void btnIngresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MousePressed
        String puesto = txt_CrearDep.getText().trim();
        if (puesto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el nombre del departamento!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("insert into Departamentos values(?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, txt_CrearDep.getText().trim());
            pst.setString(3, "A");

            pst.executeUpdate();
            bitacora_guardar();
            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            tablas();

            txt_CrearDep.setText("");
            cbox_Departamento.setSelectedIndex(0);
            txt_estado.setText("");
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡REGISTRO FALLIDO!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnIngresar1MousePressed
/**
 *
 * Funcion para limpiar los elementos en ek form
 */
    private void limpiarbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarbtnMousePressed
        txt_CrearDep.setText("");
        cbox_Departamento.setSelectedIndex(0);
        txt_estado.setText("");
        btnIngresar.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);

        inactivo.setSelected(false);
        activo.setSelected(false);


    }//GEN-LAST:event_limpiarbtnMousePressed

    private void btnLimpiar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiar1MousePressed
        txt_CrearDep.setText("");
        cbox_Departamento.setSelectedIndex(0);
        txt_estado.setText("");
        btnIngresar1.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnEliminar1.setEnabled(false);
        inactivo.setSelected(false);
        activo.setSelected(false);

    }//GEN-LAST:event_btnLimpiar1MousePressed
/**
 *
 * Funcion para limpiar los elementos en ek form
 */
    private void btnModificar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar1MousePressed
        try {
            String codigo = cbox_Departamento.getSelectedItem().toString();

            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update Departamentos set Nombre_Departamento = ?,Estado_Departamento = ? where Codigo_Departamento = " + codigo);
            String mensaje = "";

            if (activo.isSelected()) {
                mensaje = "A";
            } else if (inactivo.isSelected()) {
                mensaje = "I";
            }
            pst.setString(1, txt_CrearDep.getText().trim());
            pst.setString(2, mensaje);

            pst.executeUpdate();
            bitacora_modificar();
            JOptionPane.showMessageDialog(this, "MODIFICACION EXITOSA.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            tablas();

            txt_CrearDep.setText("");
            cbox_Departamento.setSelectedIndex(0);
            txt_estado.setText("");
            btnEliminar.setEnabled(false);
            btnModificar1.setEnabled(false);
            btnIngresar.setEnabled(true);
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnModificar1MousePressed
/**
 *
 * Funcion para modificar los datos en la base de datos
 */
    private void btnModificar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar2MousePressed
        try {
            String codigo = cbox_Departamento.getSelectedItem().toString();

            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update Departamentos set Nombre_Departamento = ?,Estado_Departamento = ? where Codigo_Departamento = " + codigo);
            String mensaje = "";

            if (activo.isSelected()) {
                mensaje = "A";
            } else if (inactivo.isSelected()) {
                mensaje = "I";

            }
            pst.setString(1, txt_CrearDep.getText().trim());
            pst.setString(2, mensaje);

            pst.executeUpdate();
            bitacora_modificar();
            JOptionPane.showMessageDialog(this, "MODIFICACION EXITOSA.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            tablas();

            txt_CrearDep.setText("");
            cbox_Departamento.setSelectedIndex(0);
            txt_estado.setText("");
            btnEliminar1.setEnabled(false);
            btnModificar2.setEnabled(false);
            btnIngresar1.setEnabled(true);
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnModificar2MousePressed
/**
 *
 * Funcion para modificar los datos en la base de datos
 */
    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from Departamentos where Codigo_Departamento = ?");

            pst.setString(1, cbox_Departamento.getSelectedItem().toString());

            pst.executeUpdate();
            bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "DEPARTAMENTO ELIMINADO.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            txt_CrearDep.setText("");
            cbox_Departamento.setSelectedIndex(0);
            txt_estado.setText("");
            tablas();
            btnEliminar.setEnabled(false);
            btnModificar1.setEnabled(false);
            btnIngresar.setEnabled(true);
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la eliminación del departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnEliminarMousePressed
/**
 *
 * Funcion para eliminar los datos en la base de datos
 */
    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from Departamentos where Codigo_Departamento = ?");

            pst.setString(1, cbox_Departamento.getSelectedItem().toString());

            pst.executeUpdate();
            bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "DEPARTAMENTO ELIMINADO.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            txt_CrearDep.setText("");
            cbox_Departamento.setSelectedIndex(0);
            txt_estado.setText("");
            tablas();
            btnEliminar1.setEnabled(false);
            btnModificar2.setEnabled(false);
            btnIngresar1.setEnabled(true);
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la eliminación del departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnEliminar1MousePressed

    
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
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Departamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Claro;
    private javax.swing.JRadioButton activo;
    private temanegro.btnCerrar btnCerrar1;
    private temaclaro.Eliminarbtn btnEliminar;
    private temanegro.btnEliminar btnEliminar1;
    private temaclaro.Guardarbtn btnIngresar;
    private temanegro.btnGuardar btnIngresar1;
    private temanegro.btnLimpiar btnLimpiar1;
    private temanegro.btnMinimizar btnMinimizar1;
    private temaclaro.Editarbtn btnModificar1;
    private temanegro.btnEditar btnModificar2;
    private javax.swing.JComboBox<String> cbox_Departamento;
    private temaclaro.Cerrarbtn cerrarbtn1;
    private javax.swing.JLabel code;
    private javax.swing.JLabel date;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private temaclaro.Limpiarbtn limpiarbtn;
    private javax.swing.JLabel ln1;
    private javax.swing.JLabel ln2;
    private temaclaro.Minimizarbtn minimizarbtn1;
    private javax.swing.JTable tbl_Dep;
    private javax.swing.JLabel timee;
    private javax.swing.JTextField txt_CrearDep;
    private javax.swing.JTextField txt_estado;
    public static javax.swing.JLabel us;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
