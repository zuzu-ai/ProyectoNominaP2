/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteNomina;

import Principal.mdiMenuPrincipal;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Heydi Quemé
 */
/*
 * La función de este form es la gestión de las aplicaciones relacionadas con los puestos registrados
 * en el sistema. Esto es, el registro, eliminación y modificación de los mismos.
 * 
 */
public class Aplicaciones extends javax.swing.JFrame {
private int x;
    private int y;
    public static int clic=mdiMenuPrincipal.clic;
    /**
     * Creates new form Aplicaciones
     */
    public void comboDB() {

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Nombre_Puesto from Puestos");
            ResultSet rs2 = pst2.executeQuery();

            puesto.addItem("Seleccione una opción");
            while (rs2.next()) {
                puesto.addItem(rs2.getString("Nombre_Puesto"));
            }

        } catch (Exception e) {

        }
    }

    public void comboDBe() {

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select NombreExcpecion from Excepcion");
            ResultSet rs2 = pst2.executeQuery();

            excepcion.addItem("Seleccione una opción");
            while (rs2.next()) {
                excepcion.addItem(rs2.getString("NombreExcpecion"));
            }

        } catch (Exception e) {

        }
    }

    public void tablas() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pstt4 = cn.prepareStatement("select * from Aplicacion");
            ResultSet rss4 = pstt4.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Aplicacion");
            tbl_Ap.setModel(modelo);
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

    public void buscar_nombrepuesto() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Puestos where Codigo_Puesto = ?");

            pst.setString(1, codigop.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                p.setText(rs.getString("Nombre_Puesto"));
                String pc = p.getText();
                puesto.setSelectedItem(pc);

            } else {

            }

        } catch (Exception e) {

        }
    }

    public void buscar_nombrexcep() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from Excepcion where CodigoExcepcion = ?");

            pst.setString(1, codigop1.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                p1.setText(rs.getString("NombreExcpecion"));
                String pc = p1.getText();

                excepcion.setSelectedItem(pc);

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
            
            String u=nombreap.getText();
            pst.setString(3, "Eliminó la aplicación "+u);
            
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
            
            String u=nombreap.getText();
            pst.setString(3, "Registró la aplicación "+u);
            
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
            
            String u=nombreap.getText();
            pst.setString(3, "Modificó la aplicación "+u);
            
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
            
            String u=nombreap.getText();
            pst.setString(3, "Buscó la aplicación "+u);
            
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
    
    
    public void tema(){
    try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if(code.getText().contains("Claro")){
                    lb1.setVisible(true);
            lb2.setVisible(true);
            
            ln1.setVisible(false);
            ln2.setVisible(false);
            
            jLabel1.setForeground(new java.awt.Color(0,0,0));
                    jLabel2.setForeground(new java.awt.Color(0,0,0));
                    jLabel3.setForeground(new java.awt.Color(0,0,0));
                            codigop.setForeground(new java.awt.Color(0,0,0));
                            codigop1.setForeground(new java.awt.Color(0,0,0));
                                    jLabel4.setForeground(new java.awt.Color(0,0,0));
                                    jLabel5.setForeground(new java.awt.Color(0,0,0));
                                    jLabel6.setForeground(new java.awt.Color(0,0,0));
                                    jPanel1.setBackground(new java.awt.Color(255,255,255));
                                    jPanel2.setBackground(new java.awt.Color(255,255,255));
                                    nombreap.setForeground(new java.awt.Color(0,0,0));
                                    buscar.setForeground(new java.awt.Color(0,0,0));
                                    
                                    
                                    cerrarbtn1.setVisible(true);
                                    minimizarbtn1.setVisible(true);
                                    btnIngresar.setVisible(true);
                                    btnModificar1.setVisible(true);
                                    btnEliminar.setVisible(true);
                                    limpiarbtn1.setVisible(true);
                                    buscarbtn1.setVisible(true);
                                    
                                    btnCerrar1.setVisible(false);
                                    btnMinimizar1.setVisible(false);
                                    btnBuscar1.setVisible(false);
                                    btnIngresar1.setVisible(false);
                                    btnEliminar1.setVisible(false);
                                    btnLimpiar1.setVisible(false);
                                    btnModificar2.setVisible(false);
 }
        else{
            if(code.getText().contains("Oscuro")){
         lb1.setVisible(false);
            lb2.setVisible(false);
            
            ln1.setVisible(true);
            ln2.setVisible(true);
            
            jLabel1.setForeground(new java.awt.Color(255,255,255));
                    jLabel2.setForeground(new java.awt.Color(255,255,255));
                    jLabel3.setForeground(new java.awt.Color(255,255,255));
                            codigop.setForeground(new java.awt.Color(255,255,255));
                            codigop1.setForeground(new java.awt.Color(255,255,255));
                                    jLabel4.setForeground(new java.awt.Color(255,255,255));
                                    jLabel5.setForeground(new java.awt.Color(255,255,255));
                                    jLabel6.setForeground(new java.awt.Color(255,255,255));
                                    jPanel1.setBackground(new java.awt.Color(0,0,0));
                                    jPanel2.setBackground(new java.awt.Color(0,0,0));
                                    nombreap.setForeground(new java.awt.Color(255,255,255));
                                    buscar.setForeground(new java.awt.Color(255,255,255));
                                    
                                    
                                    cerrarbtn1.setVisible(false);
                                    minimizarbtn1.setVisible(false);
                                    btnIngresar.setVisible(false);
                                    btnModificar1.setVisible(false);
                                    btnEliminar.setVisible(false);
                                    limpiarbtn1.setVisible(false);
                                    buscarbtn1.setVisible(false);
                                    
                                    btnCerrar1.setVisible(true);
                                    btnMinimizar1.setVisible(true);
                                    btnBuscar1.setVisible(true);
                                    btnIngresar1.setVisible(true);
                                    btnEliminar1.setVisible(true);
                                    btnLimpiar1.setVisible(true);
                                    btnModificar2.setVisible(true);
            }
                }

            } else {
            }
        } catch (Exception e) {
        }
    }
    
    public int getClic(){
        int c=0;
        
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                c=Integer.valueOf(rs.getString("clic"));
            } else {
            }

        } catch (Exception e) {
        }
        return c;
    }


    public Aplicaciones() {
        initComponents();
        comboDB();
        comboDBe();
        tablas();
       setLocationRelativeTo(null); 
       this.clic=getClic();
       
       nombreap.setBackground(new java.awt.Color(0,0,0,1));
       buscar.setBackground(new java.awt.Color(0,0,0,1));
       tema();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        Claro = new javax.swing.JLabel();
        excepcion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        codigop1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_puestos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nombreap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        puesto = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Ap = new javax.swing.JTable();
        codigop = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        btnCerrar1 = new temanegro.btnCerrar();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        jLabel6 = new javax.swing.JLabel();
        btnMinimizar1 = new temanegro.btnMinimizar();
        buscarbtn1 = new temaclaro.Buscarbtn();
        btnBuscar1 = new temanegro.btnBuscar();
        jPanel2 = new javax.swing.JPanel();
        btnIngresar = new temaclaro.Guardarbtn();
        limpiarbtn1 = new temaclaro.Limpiarbtn();
        btnLimpiar1 = new temanegro.btnLimpiar();
        btnModificar1 = new temaclaro.Editarbtn();
        btnEliminar = new temaclaro.Eliminarbtn();
        btnEliminar1 = new temanegro.btnEliminar();
        btnModificar2 = new temanegro.btnEditar();
        btnIngresar1 = new temanegro.btnGuardar();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        ln1 = new javax.swing.JLabel();
        ln2 = new javax.swing.JLabel();

        p1.setText("jLabel6");

        p.setText("jLabel6");

        usuario.setText("jLabel6");

        timee.setText("jLabel1");

        date.setText("jLabel1");

        code.setText("0");

        Claro.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        excepcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        excepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excepcionActionPerformed(evt);
            }
        });
        getContentPane().add(excepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 130, 198, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Puestos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        codigop1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        codigop1.setText("Codigo");
        getContentPane().add(codigop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 133, -1, -1));

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
        jScrollPane3.setViewportView(tbl_puestos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 202, 271, 92));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Nombre Aplicacion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        nombreap.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nombreap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        nombreap.setOpaque(false);
        nombreap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreapActionPerformed(evt);
            }
        });
        getContentPane().add(nombreap, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 198, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Puesto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 95, -1, -1));

        buscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        buscar.setOpaque(false);
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 65, 20));

        puesto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puestoActionPerformed(evt);
            }
        });
        getContentPane().add(puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 92, 198, -1));

        tbl_Ap.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tbl_Ap.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_Ap);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 84, 271, 92));

        codigop.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        codigop.setText("Codigo");
        getContentPane().add(codigop, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Excepción");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Aplicaciones");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

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
        jPanel1.add(cerrarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, -1));

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrar1MousePressed(evt);
            }
        });
        jPanel1.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, -1));

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(minimizarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Gestor de Aplicaciones");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizar1MousePressed(evt);
            }
        });
        jPanel1.add(btnMinimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        buscarbtn1.setText("buscarbtn1");
        buscarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarbtn1MousePressed(evt);
            }
        });
        getContentPane().add(buscarbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        btnBuscar1.setText("btnBuscar1");
        btnBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscar1MousePressed(evt);
            }
        });
        getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresarMousePressed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        btnModificar1.setEnabled(false);
        btnModificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificar1MousePressed(evt);
            }
        });
        jPanel2.add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        btnEliminar.setEnabled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        btnEliminar1.setText("btnEliminar1");
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 40));

        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar.png"))); // NOI18N
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 300));

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 300));

        ln1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ventana desenfocar b.png"))); // NOI18N
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 300));

        ln2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        getContentPane().add(ln2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excepcionActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select CodigoExcepcion from Excepcion where NombreExcpecion = ?");

            pst2.setString(1, excepcion.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                codigop1.setText(rs2.getString("CodigoExcepcion"));
            }
             if (excepcion.getSelectedItem().toString().contains("Seleccione una opción")) {
            codigop1.setText("Codigo");
        }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_excepcionActionPerformed

    private void puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puestoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select Codigo_Puesto from Puestos where Nombre_Puesto = ?");

            pst2.setString(1, puesto.getSelectedItem().toString());

            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                codigop.setText(rs2.getString("Codigo_Puesto"));
            }
            if (puesto.getSelectedItem().toString().contains("Seleccione una opción")) {
                codigop.setText("Codigo");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_puestoActionPerformed

    private void cerrarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarbtn1MousePressed
        // TODO add your handling code here:
        this.dispose();
        this.clic=0;
    }//GEN-LAST:event_cerrarbtn1MousePressed

    private void minimizarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarbtn1MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizarbtn1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: ("+ubicacion.x+","+ubicacion.y+")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    private void buscarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarbtn1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion where Codigo_Aplicacion = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombreap.setText(rs.getString("Nombre_Aplicacion"));
                codigop.setText(rs.getString("Codigo_Puesto"));
                codigop1.setText(rs.getString("Excepcion"));

                buscar_nombrepuesto();
                buscar_nombrexcep();

                bitacora_busqueda();

                btnEliminar.setEnabled(true);
                btnModificar1.setEnabled(true);
                btnIngresar.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Aplicacion no registrada", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buscarbtn1MousePressed

    private void btnModificar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar1MousePressed
        // TODO add your handling code here:
        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update Aplicacion set nombre_aplicacion = ?, codigo_puesto = ?, excepcion = ? where codigo_aplicacion=" + ID);

            pst2.setString(1, nombreap.getText());
            pst2.setString(2, codigop.getText());
            pst2.setString(3, codigop1.getText());

            pst2.executeUpdate();

            bitacora_modificar();
            puesto.setSelectedIndex(0);
            excepcion.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigop1.setText("Codigo");
            nombreap.setText("");

            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar1MousePressed

    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into Aplicacion values(?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, nombreap.getText());
            pst2.setString(3, codigop.getText());
            pst2.setString(4, codigop1.getText());

            pst2.executeUpdate();

            bitacora_guardar();

            puesto.setSelectedIndex(0);
            excepcion.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigop1.setText("Codigo");
            nombreap.setText("");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnIngresarMousePressed

    private void limpiarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarbtn1MousePressed
        // TODO add your handling code here:
        puesto.setSelectedIndex(0);
        excepcion.setSelectedIndex(0);
        codigop.setText("Codigo");
        codigop1.setText("Codigo");
        nombreap.setText("");
        buscar.setText("");
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);

        btnIngresar.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_limpiarbtn1MousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from aplicacion where Codigo_aplicacion = ?");

            pst2.setString(1, buscar.getText().trim());
            pst2.executeUpdate();

            bitacora_eliminar();
            puesto.setSelectedIndex(0);
            excepcion.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigop1.setText("Codigo");
            nombreap.setText("");

            btnIngresar.setEnabled(true);
            btnModificar1.setEnabled(false);
            btnEliminar.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnMinimizar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizar1MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizar1MousePressed

    private void btnCerrar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrar1MousePressed

    private void btnBuscar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from aplicacion where Codigo_Aplicacion = ?");

            pst.setString(1, buscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombreap.setText(rs.getString("Nombre_Aplicacion"));
                codigop.setText(rs.getString("Codigo_Puesto"));
                codigop1.setText(rs.getString("Excepcion"));

                buscar_nombrepuesto();
                buscar_nombrexcep();

                bitacora_busqueda();

                btnEliminar1.setEnabled(true);
                btnModificar2.setEnabled(true);
                btnIngresar1.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Aplicacion no registrada", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    
    }//GEN-LAST:event_btnBuscar1MousePressed

    private void btnModificar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificar2MousePressed
        // TODO add your handling code here:
        try {
            String ID = buscar.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update Aplicacion set nombre_aplicacion = ?, codigo_puesto = ?, excepcion = ? where codigo_aplicacion=" + ID);

            pst2.setString(1, nombreap.getText());
            pst2.setString(2, codigop.getText());
            pst2.setString(3, codigop1.getText());

            pst2.executeUpdate();

            bitacora_modificar();
            puesto.setSelectedIndex(0);
            excepcion.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigop1.setText("Codigo");
            nombreap.setText("");

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡MODIFICACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en modificación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnModificar2MousePressed

    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("delete from aplicacion where Codigo_aplicacion = ?");

            pst2.setString(1, buscar.getText().trim());
            pst2.executeUpdate();

            bitacora_eliminar();
            puesto.setSelectedIndex(0);
            excepcion.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigop1.setText("Codigo");
            nombreap.setText("");

            btnIngresar1.setEnabled(true);
            btnModificar2.setEnabled(false);
            btnEliminar1.setEnabled(false);

            JOptionPane.showMessageDialog(this, "¡ELIMINACION EXITOSA!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en eliminación", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnEliminar1MousePressed

    private void btnLimpiar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiar1MousePressed
        // TODO add your handling code here:
        puesto.setSelectedIndex(0);
        excepcion.setSelectedIndex(0);
        codigop.setText("Codigo");
        codigop1.setText("Codigo");
        nombreap.setText("");
        buscar.setText("");
        btnModificar1.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnIngresar.setEnabled(true);

        btnIngresar1.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnEliminar1.setEnabled(false);
    }//GEN-LAST:event_btnLimpiar1MousePressed

    private void btnIngresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MousePressed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("insert into Aplicacion values(?,?,?,?)");

            pst2.setString(1, "0");
            pst2.setString(2, nombreap.getText());
            pst2.setString(3, codigop.getText());
            pst2.setString(4, codigop1.getText());

            pst2.executeUpdate();

            bitacora_guardar();

            puesto.setSelectedIndex(0);
            excepcion.setSelectedIndex(0);
            codigop.setText("Codigo");
            codigop1.setText("Codigo");
            nombreap.setText("");

            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en registro", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tablas();
    }//GEN-LAST:event_btnIngresar1MousePressed

    private void nombreapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreapActionPerformed

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
            java.util.logging.Logger.getLogger(Aplicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Claro;
    public static temanegro.btnBuscar btnBuscar1;
    public static temanegro.btnCerrar btnCerrar1;
    public static temaclaro.Eliminarbtn btnEliminar;
    public static temanegro.btnEliminar btnEliminar1;
    public static temaclaro.Guardarbtn btnIngresar;
    public static temanegro.btnGuardar btnIngresar1;
    public static temanegro.btnLimpiar btnLimpiar1;
    public static temanegro.btnMinimizar btnMinimizar1;
    public static temaclaro.Editarbtn btnModificar1;
    public static temanegro.btnEditar btnModificar2;
    public static javax.swing.JTextField buscar;
    public static temaclaro.Buscarbtn buscarbtn1;
    public static temaclaro.Cerrarbtn cerrarbtn1;
    private javax.swing.JLabel code;
    public static javax.swing.JLabel codigop;
    public static javax.swing.JLabel codigop1;
    private javax.swing.JLabel date;
    private javax.swing.JComboBox<String> excepcion;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lb1;
    public static javax.swing.JLabel lb2;
    public static temaclaro.Limpiarbtn limpiarbtn1;
    public static javax.swing.JLabel ln1;
    public static javax.swing.JLabel ln2;
    public static temaclaro.Minimizarbtn minimizarbtn1;
    public static javax.swing.JTextField nombreap;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private javax.swing.JComboBox<String> puesto;
    private javax.swing.JTable tbl_Ap;
    private javax.swing.JTable tbl_puestos;
    private javax.swing.JLabel timee;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
