package Usuarios;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Principal.mdiMenuPrincipal;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Calendar;

/**
 *
 * @author Sucely Alvarez
 */
public class Usuarios extends javax.swing.JFrame {

    private int x;
    private int y;
    public static int clic;

    public void comboDB() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Empleados ");
            ResultSet rs = pst.executeQuery();

            cmbxCodigo_Empleado.addItem("Seleccione una opción");
            while (rs.next()) {
                cmbxCodigo_Empleado.addItem(rs.getString("Codigo_Empleado"));
            }

        } catch (Exception e) {

        }
    }

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Usarios");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Usuario");
            modelo.addColumn("Empleado");
            tbl_Usuarios.setModel(modelo);
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
            PreparedStatement pstt4 = cn.prepareStatement("select * from Empleados");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Empleado");
            tbl_Emp.setModel(modelo);
            String[] dato = new String[5];
            while (rss4.next()) {
                dato[0] = rss4.getString(1);
                dato[1] = rss4.getString(2);

                modelo.addRow(dato);
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
            pst.setString(2, usuario.getText());

            String u = txtUsuario.getText();
            String emp = txtNombre_E.getText();
            pst.setString(3, "Eliminó el usuario " + u + " que pertenecía al empleado " + emp);

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

    public void bitacora_guardar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txtUsuario.getText();
            String emp = txtNombre_E.getText();
            pst.setString(3, "Registró el usuario " + u + " que pertenece al empleado " + emp);

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

    public void bitacora_modificar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u1 = us.getText();
            String u2 = txtUsuario.getText();
            String emp = txtNombre_E.getText();
            String contra = txtContraseña.getText();
            pst.setString(3, "Modificó el usuario " + u1 + " que pertenecía al empleado " + emp + " a " + u2 + ", " + contra);

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

    public void bitacora_busqueda() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txtUsuario.getText();
            String emp = txtNombre_E.getText();
            pst.setString(3, "Buscó el usuario " + u);

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

    public void tema() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel6.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
                    txtNombre_E.setForeground(new java.awt.Color(0, 0, 0));
                    txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
                    txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
                    txtbuscado.setForeground(new java.awt.Color(0, 0, 0));
                    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
                    btnIngresar.setVisible(true);
                    limpiarbtn.setVisible(true);
                    btnModificar1.setVisible(true);
                    btnEliminar.setVisible(true);
                    buscarbtn1.setVisible(true);
                    cerrarbtn1.setVisible(true);
                    minimizarbtn1.setVisible(true);
                    lb1.setVisible(true);
                    lb2.setVisible(true);

                    btnIngresar1.setVisible(false);
                    btnLimpiar1.setVisible(false);
                    btnModificar2.setVisible(false);
                    btnEliminar1.setVisible(false);
                    btnBuscar1.setVisible(false);
                    btnCerrar1.setVisible(false);
                    btnMinimizar1.setVisible(false);
                    ln1.setVisible(false);
                    ln2.setVisible(false);

                } else {
                    if (code.getText().contains("Oscuro")) {
                        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                        txtNombre_E.setForeground(new java.awt.Color(255, 255, 255));
                        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
                        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
                        txtbuscado.setForeground(new java.awt.Color(255, 255, 255));
                        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
                        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
                        btnIngresar1.setVisible(true);
                        btnLimpiar1.setVisible(true);
                        btnModificar2.setVisible(true);
                        btnEliminar1.setVisible(true);
                        btnBuscar1.setVisible(true);
                        btnCerrar1.setVisible(true);
                        btnMinimizar1.setVisible(true);
                        ln1.setVisible(true);
                        ln2.setVisible(true);

                        btnIngresar.setVisible(false);
                        limpiarbtn.setVisible(false);
                        btnModificar1.setVisible(false);
                        btnEliminar.setVisible(false);
                        buscarbtn1.setVisible(false);
                        cerrarbtn1.setVisible(false);
                        minimizarbtn1.setVisible(false);
                        lb1.setVisible(false);
                        lb2.setVisible(false);

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

    public Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
        comboDB();
        tablas();
        this.clic = getClic();
        tema();

        txtNombre_E.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtUsuario.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtContraseña.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtbuscado.setBackground(new java.awt.Color(0, 0, 0, 1));
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
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtbuscado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre_E = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Usuarios = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cmbxCodigo_Empleado = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Emp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnIngresar = new temaclaro.Guardarbtn();
        btnIngresar1 = new temanegro.btnGuardar();
        limpiarbtn = new temaclaro.Limpiarbtn();
        btnLimpiar1 = new temanegro.btnLimpiar();
        btnModificar1 = new temaclaro.Editarbtn();
        btnModificar2 = new temanegro.btnEditar();
        btnEliminar = new temaclaro.Eliminarbtn();
        btnEliminar1 = new temanegro.btnEliminar();
        buscarbtn1 = new temaclaro.Buscarbtn();
        btnBuscar1 = new temanegro.btnBuscar();
        jPanel1 = new javax.swing.JPanel();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        btnCerrar1 = new temanegro.btnCerrar();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        btnMinimizar1 = new temanegro.btnMinimizar();
        jLabel12 = new javax.swing.JLabel();
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

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Codigo de empleado:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Codigo de empleado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Usuarios Registrados");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 60, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtUsuario.setOpaque(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 209, 30));

        txtbuscado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtbuscado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtbuscado.setOpaque(false);
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 102, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        txtNombre_E.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre_E.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre_E.setOpaque(false);
        txtNombre_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_EActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre_E, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 209, 30));

        tbl_Usuarios.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Usuarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 80, 271, 92));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Empleados");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 183, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Nombre de Empleado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtContraseña.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtContraseña.setOpaque(false);
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 209, 32));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        cmbxCodigo_Empleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbxCodigo_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxCodigo_EmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbxCodigo_Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 210, -1));

        tbl_Emp.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_Emp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_Emp);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 203, 271, 92));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setText("guardarbtn1");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresarMousePressed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnIngresar1.setText("btnGuardar1");
        btnIngresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresar1MousePressed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        limpiarbtn.setText("limpiarbtn1");
        limpiarbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                limpiarbtnMousePressed(evt);
            }
        });
        jPanel2.add(limpiarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

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

        btnModificar2.setText("btnEditar1");
        btnModificar2.setEnabled(false);
        btnModificar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificar2MousePressed(evt);
            }
        });
        jPanel2.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        btnEliminar.setText("eliminarbtn1");
        btnEliminar.setEnabled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        btnEliminar1.setText("btnEliminar1");
        btnEliminar1.setEnabled(false);
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminar1MousePressed(evt);
            }
        });
        jPanel2.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 315, 160, 40));

        buscarbtn1.setText("buscarbtn1");
        buscarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarbtn1MousePressed(evt);
            }
        });
        getContentPane().add(buscarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        btnBuscar1.setText("btnBuscar1");
        btnBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscar1MousePressed(evt);
            }
        });
        getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

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
        jPanel1.add(cerrarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, -1));

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrar1MousePressed(evt);
            }
        });
        jPanel1.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(minimizarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizar1MousePressed(evt);
            }
        });
        jPanel1.add(btnMinimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Gestor de Usuarios");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar.png"))); // NOI18N
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 680, 350));

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 680, 350));

        ln1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar b.png"))); // NOI18N
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 680, 350));

        ln2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        getContentPane().add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 680, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtNombre_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_EActionPerformed

    private void cmbxCodigo_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxCodigo_EmpleadoActionPerformed
        //cmbx codigo empleado

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Empleados where Codigo_Empleado = ?");
            pst.setString(1, cmbxCodigo_Empleado.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtNombre_E.setText(rs.getString("Nombre_Empleado"));

            } else {
                txtNombre_E.setText("");
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbxCodigo_EmpleadoActionPerformed

    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Usarios values(?,?,?)");

            pst.setString(1, txtUsuario.getText().trim());
            pst.setString(2, txtContraseña.getText());
            pst.setString(3, cmbxCodigo_Empleado.getSelectedItem().toString());

            bitacora_guardar();

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNombre_E.setText("");
            txtUsuario.setText("");
            cmbxCodigo_Empleado.setSelectedIndex(0);
            txtContraseña.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnIngresarMousePressed

    private void btnIngresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Usarios values(?,?,?)");

            pst.setString(1, txtUsuario.getText().trim());
            pst.setString(2, txtContraseña.getText());
            pst.setString(3, cmbxCodigo_Empleado.getSelectedItem().toString());

            bitacora_guardar();

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNombre_E.setText("");
            txtUsuario.setText("");
            cmbxCodigo_Empleado.setSelectedIndex(0);
            txtContraseña.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnIngresar1MousePressed

    private void limpiarbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarbtnMousePressed
        // TODO add your handling code here:
        cmbxCodigo_Empleado.setSelectedIndex(0);
        txtNombre_E.setText("");;
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtbuscado.setText("");
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);
    }//GEN-LAST:event_limpiarbtnMousePressed

    private void btnLimpiar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiar1MousePressed
        // TODO add your handling code here:
        cmbxCodigo_Empleado.setSelectedIndex(0);
        txtNombre_E.setText("");;
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtbuscado.setText("");
        btnModificar2.setEnabled(false);
        btnEliminar1.setEnabled(false);
        btnIngresar1.setEnabled(true);

    }//GEN-LAST:event_btnLimpiar1MousePressed

    private void btnModificar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar1MousePressed
        try {
            String ID = txtbuscado.getText().trim();

            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update Usarios set  contraseña_usuario = ? where codigo_usuario =" + ID);

            pst.setString(1, txtContraseña.getText());

            pst.executeUpdate();

            bitacora_modificar();
            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNombre_E.setText("");
            txtUsuario.setText("");
            cmbxCodigo_Empleado.setSelectedIndex(0);
            txtContraseña.setText("");

            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Modificacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar1MousePressed

    private void btnModificar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar2MousePressed
        try {
            String ID = txtbuscado.getText().trim();

            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update Usarios set  contraseña_usuario = ? where codigo_usuario =" + ID);

            pst.setString(1, txtContraseña.getText());

            pst.executeUpdate();

            bitacora_modificar();
            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNombre_E.setText("");
            txtUsuario.setText("");
            cmbxCodigo_Empleado.setSelectedIndex(0);
            txtContraseña.setText("");

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Modificacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar2MousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from Usarios where codigo_usuario = ?");

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

            bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNombre_E.setText("");
            txtUsuario.setText("");
            cmbxCodigo_Empleado.setSelectedIndex(0);
            txtContraseña.setText("");

            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Eliminacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from Usarios where codigo_usuario = ?");

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();

            bitacora_eliminar();
            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNombre_E.setText("");
            txtUsuario.setText("");
            cmbxCodigo_Empleado.setSelectedIndex(0);
            txtContraseña.setText("");

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en Eliminacion", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnEliminar1MousePressed

    private void buscarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarbtn1MousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Usarios where codigo_usuario =?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtUsuario.setText(rs.getString("Nombre_Usuario"));
                txtContraseña.setText(rs.getString("Contraseña_Usuario"));

                cmbxCodigo_Empleado.setSelectedItem(rs.getString("Codigo_Usuario"));
                us.setText(rs.getString("Nombre_Usuario"));

                btnModificar1.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnIngresar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no registrado.");
            }

        } catch (Exception e) {

        }
        tablas();
        bitacora_busqueda();
    }//GEN-LAST:event_buscarbtn1MousePressed

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

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: (" + ubicacion.x + "," + ubicacion.y + ")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnBuscar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar1MousePressed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Usarios where codigo_usuario =?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtUsuario.setText(rs.getString("Nombre_Usuario"));
                txtContraseña.setText(rs.getString("Contraseña_Usuario"));

                cmbxCodigo_Empleado.setSelectedItem(rs.getString("Codigo_Usuario"));
                us.setText(rs.getString("Nombre_Usuario"));

                btnModificar2.setEnabled(true);
                btnEliminar1.setEnabled(true);
                btnIngresar1.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no registrado.");
            }

        } catch (Exception e) {

        }
        tablas();
        bitacora_busqueda();
    }//GEN-LAST:event_btnBuscar1MousePressed

 
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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
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
    private temaclaro.Buscarbtn buscarbtn1;
    private temaclaro.Cerrarbtn cerrarbtn1;
    private javax.swing.JComboBox<String> cmbxCodigo_Empleado;
    private javax.swing.JLabel code;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private temaclaro.Limpiarbtn limpiarbtn;
    private javax.swing.JLabel ln1;
    private javax.swing.JLabel ln2;
    private temaclaro.Minimizarbtn minimizarbtn1;
    private javax.swing.JTable tbl_Emp;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JLabel timee;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNombre_E;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtbuscado;
    public static javax.swing.JLabel us;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
