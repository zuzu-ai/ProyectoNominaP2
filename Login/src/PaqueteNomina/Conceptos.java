
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
 * La función de este form es la gestión de los conceptos relacionados a los puestos registrados en
 * el sistema, lo que comprende el resgistro, modificación y eliminación de los mismos.
 * 
 */
public class Conceptos extends javax.swing.JFrame {

    private int x;
    private int y;
    public static int clic;

    public void comboDBe() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Nombre_Puesto from Puestos");
            ResultSet rs2 = pst2.executeQuery();

            cmbxNombreEmpleado.addItem("Seleccione una opción");
            while (rs2.next()) {
                cmbxNombreEmpleado.addItem(rs2.getString("Nombre_Puesto"));
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

    public void bitacora_eliminar() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());

            String u = nombreconcepto.getText();
            pst.setString(3, "Eliminó el concepto " + u);

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
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());

            String u = nombreconcepto.getText();
            pst.setString(3, "Registró el concepto " + u);

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
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());

            String u = nombreconcepto.getText();
            pst.setString(3, "Modificó el concepto " + u);

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
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());

            String u = nombreconcepto.getText();
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

    public void tema() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    nombreconcepto.setForeground(new java.awt.Color(0, 0, 0));
                    valorconcepto.setForeground(new java.awt.Color(0, 0, 0));
                    buscar.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel6.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel7.setForeground(new java.awt.Color(0, 0, 0));
                    //jLabel8.setForeground(new java.awt.Color(0,0,0));
                    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
                    //jLabel10.setForeground(new java.awt.Color(0,0,0));
                    jLabel11.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
                    //codigoe.setForeground(new java.awt.Color(0,0,0));
                    codigop.setForeground(new java.awt.Color(0, 0, 0));
                    tipo.setForeground(new java.awt.Color(0, 0, 0));
                    clase.setForeground(new java.awt.Color(0, 0, 0));
                    codigo_ap.setForeground(new java.awt.Color(0, 0, 0));
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
                        nombreconcepto.setForeground(new java.awt.Color(255, 255, 255));
                        valorconcepto.setForeground(new java.awt.Color(255, 255, 255));
                        buscar.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                        // jLabel8.setForeground(new java.awt.Color(255,255,255));
                        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                        //jLabel10.setForeground(new java.awt.Color(255,255,255));
                        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                        //codigoe.setForeground(new java.awt.Color(255,255,255));
                        codigop.setForeground(new java.awt.Color(255, 255, 255));
                        tipo.setForeground(new java.awt.Color(255, 255, 255));
                        clase.setForeground(new java.awt.Color(255, 255, 255));
                        codigo_ap.setForeground(new java.awt.Color(255, 255, 255));
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

    public void buscar_nombrepuesto() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Puestos where Codigo_Puesto = ?");

            pst.setString(1, codigop.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                nombre_emp.setText(rs.getString("Nombre_Puesto"));
                String pc = nombre_emp.getText();
                cmbxNombreEmpleado.setSelectedItem(pc);

            } else {

            }

        } catch (Exception e) {

        }
    }

    /**
     * Creates new form Conceptos
     */
    public Conceptos() {
        initComponents();
        setLocationRelativeTo(null);
        tablas();
        comboDB();
        comboDBe();
        this.clic = getClic();

        tema();

        nombreconcepto.setBackground(new java.awt.Color(0, 0, 0, 1));
        buscar.setBackground(new java.awt.Color(0, 0, 0, 1));
        valorconcepto.setBackground(new java.awt.Color(0, 0, 0, 1));

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
        code = new javax.swing.JLabel();
        Claro = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        valorconcepto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        clase = new javax.swing.JLabel();
        codigo_ap = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        aplicacion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        claseconcepto = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_ap = new javax.swing.JTable();
        tipoconcepto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreconcepto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Conceptos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_puestos = new javax.swing.JTable();
        cmbxNombreEmpleado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        btnCerrar1 = new temanegro.btnCerrar();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        btnMinimizar1 = new temanegro.btnMinimizar();
        jLabel12 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        codigop = new javax.swing.JLabel();
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
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        ln1 = new javax.swing.JLabel();
        ln2 = new javax.swing.JLabel();

        nombre_emp.setText("jLabel12");

        nombre_ap.setText("jLabel12");

        usuario.setText("jLabel6");

        timee.setText("jLabel1");

        date.setText("jLabel1");

        code.setText("0");

        Claro.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tipo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tipo.setText("Codigo");
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        valorconcepto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        valorconcepto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        valorconcepto.setOpaque(false);
        getContentPane().add(valorconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 101, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Valor");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        clase.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        clase.setText("Codigo");
        getContentPane().add(clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        codigo_ap.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        codigo_ap.setText("Codigo");
        getContentPane().add(codigo_ap, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 60, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Aplicacion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        aplicacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        aplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicacionActionPerformed(evt);
            }
        });
        getContentPane().add(aplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 170, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Aplicaciones");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Clase");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 199, -1, -1));

        claseconcepto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        claseconcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "+", "-" }));
        claseconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claseconceptoActionPerformed(evt);
            }
        });
        getContentPane().add(claseconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 196, 170, -1));

        tbl_ap.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 271, 80));

        tipoconcepto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tipoconcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "%", "C" }));
        tipoconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoconceptoActionPerformed(evt);
            }
        });
        getContentPane().add(tipoconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 165, 170, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 168, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Conceptos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        nombreconcepto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nombreconcepto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        nombreconcepto.setOpaque(false);
        getContentPane().add(nombreconcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 185, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Puestos");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Nombre del Concepto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Puesto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        tbl_Conceptos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 271, 69));

        tbl_puestos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 271, 80));

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
        getContentPane().add(cmbxNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 96, 120, -1));

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
        jPanel1.add(cerrarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 30, -1));

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrar1MousePressed(evt);
            }
        });
        jPanel1.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(minimizarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, -1));

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizar1MousePressed(evt);
            }
        });
        jPanel1.add(btnMinimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Gestor de Conceptos");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, -1));

        buscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        buscar.setOpaque(false);
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 50, 20));

        codigop.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        codigop.setText("Codigo");
        getContentPane().add(codigop, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 160, 40));

        buscarbtn1.setText("buscarbtn1");
        buscarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarbtn1MousePressed(evt);
            }
        });
        getContentPane().add(buscarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        btnBuscar1.setText("btnBuscar1");
        btnBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscar1MousePressed(evt);
            }
        });
        getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar.png"))); // NOI18N
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 660, 400));

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 660, 400));

        ln1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar b.png"))); // NOI18N
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 660, 400));

        ln2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        getContentPane().add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 660, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            if (aplicacion.getSelectedItem().toString().contains("Seleccione una opción")) {
            codigo_ap.setText("Codigo");
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

        if (claseconcepto.getSelectedItem().toString().contains("Seleccione una opción")) {
            clase.setText("Codigo");
        }
    }//GEN-LAST:event_claseconceptoActionPerformed

    private void tipoconceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoconceptoActionPerformed
        // TODO add your handling code here:
         if (tipoconcepto.getSelectedItem().toString().contains("Seleccione una opción") ) {
            tipo.setText("Codigo");
        }else {
            String tipos = tipoconcepto.getSelectedItem().toString();
        tipo.setText(tipos);  
         }                      
    }//GEN-LAST:event_tipoconceptoActionPerformed

    private void cmbxNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxNombreEmpleadoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            //PreparedStatement pst2 = cn.prepareStatement("select Codigo_Empleado from Empleados where Nombre_Empleado = ?");
            PreparedStatement pst3 = cn.prepareStatement("select Codigo_Puesto from Puestos where Nombre_Puesto = ?");

            //pst2.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());
            pst3.setString(1, cmbxNombreEmpleado.getSelectedItem().toString());

            //ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();

            // if (rs2.next()) {
            //   codigoe.setText(rs2.getString("Codigo_Empleado"));
            //} else {
            //  codigoe.setText("Codigo");
            //}
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

    private void cerrarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarbtn1MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cerrarbtn1MousePressed

    private void minimizarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarbtn1MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizarbtn1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: (" + ubicacion.x + "," + ubicacion.y + ")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into Conceptos values(?,?,?,?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, codigop.getText());
            pst2.setString(3, nombreconcepto.getText());
            pst2.setString(4, tipo.getText());
            pst2.setString(5, clase.getText());
            pst2.setString(6, codigo_ap.getText());
            pst2.setString(7, valorconcepto.getText());

            pst2.executeUpdate();

            bitacora_guardar();

            cmbxNombreEmpleado.setSelectedIndex(0);
            codigop.setText("Codigo");
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
    }//GEN-LAST:event_btnIngresarMousePressed

    private void limpiarbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarbtnMousePressed
        // TODO add your handling code here:
        cmbxNombreEmpleado.setSelectedIndex(0);
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
    }//GEN-LAST:event_limpiarbtnMousePressed

    private void btnModificar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar1MousePressed
        // TODO add your handling code here:
        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update Conceptos set codigo_puesto = ?, nombre_concepto = ?, tipo_concepto = ?, clase_concepto = ? , aplicacion_concepto = ?, valor=? where codigo_concepto=" + ID);

            pst2.setString(1, codigop.getText());
            pst2.setString(2, nombreconcepto.getText());
            pst2.setString(3, tipo.getText());
            pst2.setString(4, clase.getText());
            pst2.setString(5, codigo_ap.getText());
            pst2.setString(6, valorconcepto.getText());

            bitacora_modificar();
            pst2.executeUpdate();

            cmbxNombreEmpleado.setSelectedIndex(0);
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
    }//GEN-LAST:event_btnModificar1MousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from conceptos where Codigo_concepto = ?");

            pst2.setString(1, buscar.getText().trim());

            bitacora_eliminar();
            pst2.executeUpdate();

            cmbxNombreEmpleado.setSelectedIndex(0);
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

    }//GEN-LAST:event_btnEliminarMousePressed

    private void buscarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarbtn1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Conceptos where Codigo_Concepto = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                codigop.setText(rs.getString("Codigo_Puesto"));
                nombreconcepto.setText(rs.getString("Nombre_Concepto"));
                tipo.setText(rs.getString("Tipo_Concepto"));
                clase.setText(rs.getString("Clase_Concepto"));
                codigo_ap.setText(rs.getString("Aplicacion_Concepto"));
                valorconcepto.setText(rs.getString("Valor"));
                //buscar_codigop();
                buscar_nombrepuesto();

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
    }//GEN-LAST:event_buscarbtn1MousePressed

    private void btnIngresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into Conceptos values(?,?,?,?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, codigop.getText());
            pst2.setString(3, nombreconcepto.getText());
            pst2.setString(4, tipo.getText());
            pst2.setString(5, clase.getText());
            pst2.setString(6, codigo_ap.getText());
            pst2.setString(7, valorconcepto.getText());

            pst2.executeUpdate();

            bitacora_guardar();

            cmbxNombreEmpleado.setSelectedIndex(0);
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
    }//GEN-LAST:event_btnIngresar1MousePressed

    private void btnLimpiar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiar1MousePressed
        // TODO add your handling code here:
        cmbxNombreEmpleado.setSelectedIndex(0);
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

        btnIngresar1.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnEliminar1.setEnabled(false);
    }//GEN-LAST:event_btnLimpiar1MousePressed

    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from conceptos where Codigo_concepto = ?");

            pst2.setString(1, buscar.getText().trim());

            bitacora_eliminar();
            pst2.executeUpdate();

            cmbxNombreEmpleado.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigo_ap.setText("Codigo");
            nombreconcepto.setText("");
            tipoconcepto.setSelectedIndex(0);
            claseconcepto.setSelectedIndex(0);
            aplicacion.removeAllItems();
            nombreconcepto.setText("");
            valorconcepto.setText("");

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
        // TODO add your handling code here:
        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update Conceptos set codigo_puesto = ?, nombre_concepto = ?, tipo_concepto = ?, clase_concepto = ? , aplicacion_concepto = ?, valor=? where codigo_concepto=" + ID);

            pst2.setString(1, codigop.getText());
            pst2.setString(2, nombreconcepto.getText());
            pst2.setString(3, tipo.getText());
            pst2.setString(4, clase.getText());
            pst2.setString(5, codigo_ap.getText());
            pst2.setString(6, valorconcepto.getText());

            bitacora_modificar();
            pst2.executeUpdate();

            cmbxNombreEmpleado.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigo_ap.setText("Codigo");
            nombreconcepto.setText("");
            tipoconcepto.setSelectedIndex(0);
            claseconcepto.setSelectedIndex(0);
            aplicacion.removeAllItems();
            nombreconcepto.setText("");
            valorconcepto.setText("");

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar2MousePressed

    private void btnBuscar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Conceptos where Codigo_Concepto = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                codigop.setText(rs.getString("Codigo_Puesto"));
                nombreconcepto.setText(rs.getString("Nombre_Concepto"));
                tipo.setText(rs.getString("Tipo_Concepto"));
                clase.setText(rs.getString("Clase_Concepto"));
                codigo_ap.setText(rs.getString("Aplicacion_Concepto"));
                valorconcepto.setText(rs.getString("Valor"));
                //buscar_codigop();
                buscar_nombrepuesto();

                String tip = tipo.getText();
                tipoconcepto.setSelectedItem(tip);

                String clas = clase.getText();
                claseconcepto.setSelectedItem(clas);

                buscar_aplicacion();
                bitacora_busqueda();

                btnModificar2.setEnabled(true);
                btnEliminar1.setEnabled(true);
                btnIngresar1.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Concepto no registrado", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar1MousePressed

    private void btnMinimizar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizar1MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizar1MousePressed

    private void btnCerrar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrar1MousePressed

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
            java.util.logging.Logger.getLogger(Conceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conceptos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conceptos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Claro;
    private javax.swing.JComboBox<String> aplicacion;
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
    private javax.swing.JLabel clase;
    private javax.swing.JComboBox<String> claseconcepto;
    private javax.swing.JComboBox<String> cmbxNombreEmpleado;
    private javax.swing.JLabel code;
    private javax.swing.JLabel codigo_ap;
    private javax.swing.JLabel codigop;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private temaclaro.Limpiarbtn limpiarbtn;
    private javax.swing.JLabel ln1;
    private javax.swing.JLabel ln2;
    private temaclaro.Minimizarbtn minimizarbtn1;
    private javax.swing.JLabel nombre_ap;
    private javax.swing.JLabel nombre_emp;
    private javax.swing.JTextField nombreconcepto;
    private javax.swing.JTable tbl_Conceptos;
    private javax.swing.JTable tbl_ap;
    private javax.swing.JTable tbl_puestos;
    private javax.swing.JLabel timee;
    private javax.swing.JLabel tipo;
    private javax.swing.JComboBox<String> tipoconcepto;
    public static javax.swing.JLabel usuario;
    private javax.swing.JTextField valorconcepto;
    // End of variables declaration//GEN-END:variables
}
