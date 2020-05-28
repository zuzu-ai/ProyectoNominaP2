package mantenimiento.empleado;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import Principal.mdiMenuPrincipal;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Calendar;
import java.sql.SQLException;
import java.util.HashSet;

public class Empleado extends javax.swing.JFrame {

    public static int clic;
    private int x;
    private int y;

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

    public void iniciar_combo() {
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

    public void refrescar() {
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
    }

    public void bitacora_eliminar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());

            String u = txt_Nombre.getText();
            pst.setString(3, "Eliminó el empleado " + u);

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

            String u = txt_Nombre.getText();
            pst.setString(3, "Registró el empleado " + u);

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

            String u = txt_Nombre.getText();
            pst.setString(3, "Modificó el empleado " + u);

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

            String u = txt_Nombre.getText();
            pst.setString(3, "Buscó el empleado " + u);

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
                    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel6.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel7.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel8.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel11.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel13.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel14.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel15.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel16.setForeground(new java.awt.Color(0, 0, 0));
                    lb_Dep.setForeground(new java.awt.Color(0, 0, 0));
                    lb_Pues.setForeground(new java.awt.Color(0, 0, 0));

                    txt_Nombre.setForeground(new java.awt.Color(0, 0, 0));
                    txt_Dpi.setForeground(new java.awt.Color(0, 0, 0));
                    txt_Tel.setForeground(new java.awt.Color(0, 0, 0));
                    txt_Ubicacion.setForeground(new java.awt.Color(0, 0, 0));
                    txt_Sueldo.setForeground(new java.awt.Color(0, 0, 0));

                    ln1.setVisible(false);
                    ln2.setVisible(false);
                    lb1.setVisible(true);
                    lb2.setVisible(true);

                    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
                        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

                        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
                        txt_Dpi.setForeground(new java.awt.Color(255, 255, 255));
                        txt_Tel.setForeground(new java.awt.Color(255, 255, 255));
                        txt_Ubicacion.setForeground(new java.awt.Color(255, 255, 255));
                        txt_Sueldo.setForeground(new java.awt.Color(255, 255, 255));

                        ln1.setVisible(true);
                        ln2.setVisible(true);
                        lb1.setVisible(false);
                        lb2.setVisible(false);

                        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
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

    public Empleado() {
        initComponents();
        setLocationRelativeTo(null);
        txt_Nombre.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Dpi.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Tel.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Ubicacion.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Sueldo.setBackground(new java.awt.Color(0, 0, 0, 1));
        txt_Estado.setBackground(new java.awt.Color(0, 0, 0, 1));

        tablas();
        iniciar_combo();
        this.clic = getClic();
        tema();
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
        jPanel3 = new javax.swing.JPanel();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        btnCerrar1 = new temanegro.btnCerrar();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        btnMinimizar1 = new temanegro.btnMinimizar();
        jLabel12 = new javax.swing.JLabel();
        lb_Pues = new javax.swing.JLabel();
        lb_Dep = new javax.swing.JLabel();
        date_F = new com.toedter.calendar.JDateChooser();
        date_Inicio = new com.toedter.calendar.JDateChooser();
        cbox_Puesto = new javax.swing.JComboBox<>();
        cbox_Departamento = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        inactivo = new javax.swing.JRadioButton();
        activo = new javax.swing.JRadioButton();
        txt_Estado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        date_Nacimiento = new com.toedter.calendar.JDateChooser();
        cbox_Id = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Empleados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Bajas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Altas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnIngresar = new temaclaro.Guardarbtn();
        btnIngresar1 = new temanegro.btnGuardar();
        limpiarbtn = new temaclaro.Limpiarbtn();
        btnLimpiar1 = new temanegro.btnLimpiar();
        btnModificar1 = new temaclaro.Editarbtn();
        btnModificar2 = new temanegro.btnEditar();
        btnEliminar = new temaclaro.Eliminarbtn();
        btnEliminar1 = new temanegro.btnEliminar();
        txt_Nombre = new javax.swing.JTextField();
        txt_Dpi = new javax.swing.JTextField();
        txt_Tel = new javax.swing.JTextField();
        txt_Ubicacion = new javax.swing.JTextField();
        txt_Sueldo = new javax.swing.JTextField();
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
        jPanel3.add(cerrarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 30, -1));

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrar1MousePressed(evt);
            }
        });
        jPanel3.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel3.add(minimizarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, -1));

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizar1MousePressed(evt);
            }
        });
        jPanel3.add(btnMinimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Gestor de Empleados");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        lb_Pues.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lb_Pues.setText("Codigo");
        lb_Pues.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lb_Pues, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 316, -1, 20));

        lb_Dep.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lb_Dep.setText("Codigo");
        getContentPane().add(lb_Dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, 20));

        date_F.setEnabled(false);
        date_F.setOpaque(false);
        getContentPane().add(date_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 210, -1));

        date_Inicio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        date_Inicio.setOpaque(false);
        getContentPane().add(date_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 261, 210, -1));

        cbox_Puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_PuestoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_Puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 313, 170, -1));

        cbox_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_DepartamentoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 287, 170, -1));

        jPanel1.setOpaque(false);

        inactivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inactivo.setText("Inactivo");
        inactivo.setOpaque(false);

        activo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        activo.setText("Activo");
        activo.setOpaque(false);
        activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activoActionPerformed(evt);
            }
        });

        txt_Estado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Estado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Estado.setEnabled(false);
        txt_Estado.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inactivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activo)
                    .addComponent(inactivo)
                    .addComponent(txt_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Estado Empleado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        date_Nacimiento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        date_Nacimiento.setOpaque(false);
        getContentPane().add(date_Nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 157, 190, -1));

        cbox_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_IdActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 79, 190, -1));

        tbl_Empleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, 152));

        tbl_Bajas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, 152));

        tbl_Altas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, 136));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 82, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 105, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("DPI");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 131, 36, 18));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 157, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Teléfono");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 183, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Ubicación");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 209, 64, 19));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Sueldo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 235, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de Inicio");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 261, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Departamento");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 287, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Puesto");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 313, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setText("Fecha Final");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 339, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setText("Empleados");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Altas");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, -1, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setText("Bajas");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

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

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 160, 40));

        txt_Nombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Nombre.setOpaque(false);
        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 105, 190, -1));

        txt_Dpi.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Dpi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Dpi.setOpaque(false);
        getContentPane().add(txt_Dpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 131, 190, -1));

        txt_Tel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Tel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Tel.setOpaque(false);
        getContentPane().add(txt_Tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 183, 190, -1));

        txt_Ubicacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Ubicacion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Ubicacion.setOpaque(false);
        txt_Ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UbicacionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 209, 190, -1));

        txt_Sueldo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Sueldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txt_Sueldo.setOpaque(false);
        getContentPane().add(txt_Sueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 235, 190, -1));

        lb1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar.png"))); // NOI18N
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 630));

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 630));

        ln1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar b.png"))); // NOI18N
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 630));

        ln2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        getContentPane().add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 890, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    }//GEN-LAST:event_cbox_DepartamentoActionPerformed

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
                date_Inicio.setDate(rs.getDate("Fecha_Inicio"));
                lb_Pues.setText(rs.getString("Codigo_Puesto"));
                lb_Dep.setText(rs.getString("Codigo_Departamento"));
                txt_Estado.setText(rs.getString("Estado_Empleado"));

                btnIngresar.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnModificar1.setEnabled(true);
                btnIngresar1.setEnabled(false);
                btnEliminar1.setEnabled(true);
                btnModificar2.setEnabled(true);
                txt_Estado.setEnabled(true);

                if (txt_Estado.getText().equals("A")) {
                    date_F.setEnabled(true);
                }

                bitacora_busqueda();

            } else {
                if (cbox_Id.getSelectedItem().toString().contains("Seleccione una opción")) {
                    txt_Nombre.setText("");
                    txt_Dpi.setText("");
                    date_Nacimiento.setDate(null);
                    txt_Tel.setText("");
                    txt_Ubicacion.setText("");
                    txt_Sueldo.setText("");
                    txt_Estado.setText("");
                    date_Inicio.setDate(null);
                    lb_Pues.setText("");
                    lb_Dep.setText("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }//GEN-LAST:event_cbox_IdActionPerformed

    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed
        if (txt_Nombre.getText().isEmpty() || txt_Dpi.getText().isEmpty() || txt_Tel.getText().isEmpty() || txt_Ubicacion.getText().isEmpty() || txt_Sueldo.getText().isEmpty()
                || lb_Dep.getText().isEmpty() || lb_Pues.getText().isEmpty() || date_Nacimiento.getCalendar() == null || date_Inicio.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "¡Debe Llenar todos los campos!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
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
                bitacora_guardar();
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
            }
        }
        refrescar();
    }//GEN-LAST:event_btnIngresarMousePressed

    private void btnIngresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MousePressed
        if (txt_Nombre.getText().isEmpty() || txt_Dpi.getText().isEmpty() || txt_Tel.getText().isEmpty() || txt_Ubicacion.getText().isEmpty() || txt_Sueldo.getText().isEmpty()
                || lb_Dep.getText().isEmpty() || lb_Pues.getText().isEmpty() || date_Nacimiento.getCalendar() == null || date_Inicio.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "¡Debe Llenar todos los campos!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
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
                bitacora_guardar();
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
            }
        }
        refrescar();
    }//GEN-LAST:event_btnIngresar1MousePressed

    private void limpiarbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarbtnMousePressed
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
        btnIngresar.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        txt_Estado.setEnabled(false);

    }//GEN-LAST:event_limpiarbtnMousePressed

    private void btnLimpiar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiar1MousePressed
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
        btnIngresar1.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnEliminar1.setEnabled(false);

    }//GEN-LAST:event_btnLimpiar1MousePressed

    private void btnModificar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar1MousePressed
        // TODO add your handling code here:
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

            bitacora_modificar();

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
            btnEliminar.setEnabled(false);
            btnModificar1.setEnabled(false);
            btnIngresar.setEnabled(true);
            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡MODIFICACION FALLIDA!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnModificar1MousePressed

    private void btnModificar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar2MousePressed
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

            bitacora_modificar();

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
            btnEliminar1.setEnabled(false);
            btnModificar2.setEnabled(false);
            btnIngresar1.setEnabled(true);
            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡MODIFICACION FALLIDA!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnModificar2MousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
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

            bitacora_eliminar();

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
            btnEliminar.setEnabled(false);
            btnModificar1.setEnabled(false);
            btnIngresar.setEnabled(true);

            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡BAJA DE EMPLEADO FALLIDO!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();


    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed
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

            bitacora_eliminar();

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
            btnEliminar1.setEnabled(false);
            btnModificar2.setEnabled(false);
            btnIngresar1.setEnabled(true);

            tablas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡BAJA DE EMPLEADO FALLIDO!", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();
    }//GEN-LAST:event_btnEliminar1MousePressed

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
      
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void txt_UbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UbicacionActionPerformed
       
    }//GEN-LAST:event_txt_UbicacionActionPerformed

    private void activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoActionPerformed
      
    }//GEN-LAST:event_activoActionPerformed

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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleado().setVisible(true);
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
    private javax.swing.JComboBox<String> cbox_Id;
    private javax.swing.JComboBox<String> cbox_Puesto;
    private temaclaro.Cerrarbtn cerrarbtn1;
    private javax.swing.JLabel code;
    private javax.swing.JLabel date;
    private com.toedter.calendar.JDateChooser date_F;
    private com.toedter.calendar.JDateChooser date_Inicio;
    private com.toedter.calendar.JDateChooser date_Nacimiento;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb_Dep;
    private javax.swing.JLabel lb_Pues;
    private temaclaro.Limpiarbtn limpiarbtn;
    private javax.swing.JLabel ln1;
    private javax.swing.JLabel ln2;
    private temaclaro.Minimizarbtn minimizarbtn1;
    private javax.swing.JTable tbl_Altas;
    private javax.swing.JTable tbl_Bajas;
    private javax.swing.JTable tbl_Empleados;
    private javax.swing.JLabel timee;
    private javax.swing.JTextField txt_Dpi;
    private javax.swing.JTextField txt_Estado;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Sueldo;
    private javax.swing.JTextField txt_Tel;
    private javax.swing.JTextField txt_Ubicacion;
    public static javax.swing.JLabel us;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
