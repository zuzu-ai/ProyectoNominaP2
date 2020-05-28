/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import PaqueteNomina.Nómina;
import PaqueteNomina.Aplicaciones;
import mantenimiento.empleado.Departamento;
import Usuarios.Usuarios;
import PaqueteNomina.Conceptos;
import static Principal.mdiMenuPrincipal.BD;
import static Principal.mdiMenuPrincipal.clic;
import static Principal.mdiMenuPrincipal.label;
import static Principal.mdiMenuPrincipal.label1;
import static Principal.mdiMenuPrincipal.usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.Calendar;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import mantenimiento.empleado.Empleado;
import mantenimiento.empleado.Puesto;

public class mdiMenuPrincipal extends javax.swing.JFrame {

   
    public mdiMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(mdiMenuPrincipal.MAXIMIZED_BOTH);
        this.setTitle("Nomina");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.clic = getClic();
        System.out.println(clic);
        tema();
        label.setBounds(0, 0, 1366, 768);
        label1.setBounds(0, 0, 1366, 768);
        usuario.setBounds(1200, 4, 100, 42);
        logoutbtn1.setBounds(1200, 40, 32, 32);
        btnLogout1.setBounds(1200, 40, 32, 32);
        lblUsuario.setBounds(1160, 4, 40, 40);
        lblUsuario1.setBounds(1160, 4, 40, 40);
        btnApaga1.setBounds(1200, 80, 32, 32);
        btnApagar1.setBounds(1200, 80, 32, 32);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());

        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
    }

    public static int clic;

    public static String BD = "jdbc:mysql://localhost/nominaproyect";
    public static String Usuario = "root";
    public static String Contraseña = "6182";

    public static Connection getConeccion() {
        Connection cn = null;
        try {
            Class.forName(BD);
            cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return cn;

    }

    public void tema() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    jMenuBar1.setBackground(new Color(56, 54, 55));
                    label.setVisible(false);
                    label1.setVisible(true);
                    logoutbtn1.setVisible(true);
                    btnLogout1.setVisible(false);
                    usuario.setForeground(new java.awt.Color(0, 0, 0));
                    lblUsuario1.setVisible(true);
                    lblUsuario.setVisible(false);
                    btnApaga1.setVisible(true);
                    btnApagar1.setVisible(false);
                } else {
                    if (code.getText().contains("Oscuro")) {
                        jMenuBar1.setBackground(new Color(56, 54, 55));
                        label.setVisible(true);
                        label1.setVisible(false);
                        logoutbtn1.setVisible(false);
                        btnLogout1.setVisible(true);
                        usuario.setForeground(new java.awt.Color(255, 255, 255));
                        lblUsuario.setVisible(true);
                        lblUsuario1.setVisible(false);
                        btnApaga1.setVisible(false);
                        btnApagar1.setVisible(true);
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

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        lclic = new javax.swing.JLabel();
        Claro = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        logoutbtn1 = new temaclaro.Logoutbtn();
        btnApaga1 = new temaclaro.btnApaga();
        btnApagar1 = new temanegro.btnApagar();
        label1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnLogout1 = new temanegro.btnLogout();
        label = new javax.swing.JLabel();
        usuario1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        date.setText("jLabel1");

        timee.setText("jLabel1");

        code.setText("0");

        lclic.setText("jLabel1");

        Claro.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        lblUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/user2.png"))); // NOI18N
        getContentPane().add(lblUsuario1);
        lblUsuario1.setBounds(610, 0, 40, 40);

        usuario.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        usuario.setText("Usuario");
        usuario.setMaximumSize(new java.awt.Dimension(91, 91));
        usuario.setPreferredSize(new java.awt.Dimension(91, 91));
        getContentPane().add(usuario);
        usuario.setBounds(650, 0, 100, 42);

        logoutbtn1.setText("logoutbtn1");
        logoutbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutbtn1MousePressed(evt);
            }
        });
        getContentPane().add(logoutbtn1);
        logoutbtn1.setBounds(680, 40, 32, 32);

        btnApaga1.setText("btnApaga1");
        btnApaga1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnApaga1MousePressed(evt);
            }
        });
        getContentPane().add(btnApaga1);
        btnApaga1.setBounds(680, 80, 32, 32);

        btnApagar1.setText("btnApagar1");
        btnApagar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnApagar1MousePressed(evt);
            }
        });
        getContentPane().add(btnApagar1);
        btnApagar1.setBounds(680, 80, 32, 32);

        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo blanco.jpg"))); // NOI18N
        label1.setName(""); // NOI18N
        label1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                label1PropertyChange(evt);
            }
        });
        getContentPane().add(label1);
        label1.setBounds(0, 0, 750, 454);

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jicon/Usuario.png"))); // NOI18N
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(610, 0, 40, 40);

        btnLogout1.setText("btnLogout1");
        btnLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogout1MousePressed(evt);
            }
        });
        getContentPane().add(btnLogout1);
        btnLogout1.setBounds(680, 40, 32, 32);

        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N
        label.setMaximumSize(new java.awt.Dimension(1366, 768));
        label.setMinimumSize(new java.awt.Dimension(1366, 768));
        label.setPreferredSize(new java.awt.Dimension(1366, 768));
        label.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                labelPropertyChange(evt);
            }
        });
        getContentPane().add(label);
        label.setBounds(0, 0, 750, 454);

        usuario1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        usuario1.setText("Usuario");
        usuario1.setMaximumSize(new java.awt.Dimension(91, 91));
        usuario1.setPreferredSize(new java.awt.Dimension(91, 91));
        getContentPane().add(usuario1);
        usuario1.setBounds(650, 0, 100, 42);

        jMenuBar1.setBackground(new java.awt.Color(56, 54, 55));
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(60, 2));
        jMenuBar1.setRequestFocusEnabled(false);

        jMenu3.setText("        ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        jMenu5.setBackground(new java.awt.Color(56, 54, 55));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosmenu/Archivo60.png"))); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(70, 60));
        jMenuBar1.add(jMenu5);

        editMenu.setBackground(new java.awt.Color(56, 54, 55));
        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosmenu/Catalogos60.png"))); // NOI18N
        editMenu.setMnemonic('e');

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Gestor de Empleados");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(openMenuItem);

        jMenuItem1.setText("Gestor de Departamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        jMenuItem2.setText("Gestor de Puestos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem2);

        jMenuBar1.add(editMenu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosmenu/procoso60.png"))); // NOI18N

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Nómina");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(cutMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosmenu/Informes60.png"))); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosmenu/herraminetas60.png"))); // NOI18N

        jMenuItem3.setText("Gestor de Conceptos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Gestor de Usuarios");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Gestor de Aplicaciones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosmenu/Ayuda60.png"))); // NOI18N

        jMenuItem7.setText("Instrucciones");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        Empleado e = new Empleado();
        e.setVisible(true);
       
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó al Gestor de Empleados");

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

            String us = this.usuario.getText();
            Empleado.usuario.setText(us);

            pst.executeUpdate();

        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Departamento depto = new Departamento();
        depto.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó al Gestor de Departamentos");

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

            String us = this.usuario.getText();
            Departamento.usuario.setText(us);

            pst.executeUpdate();

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Puesto p = new Puesto();
        p.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó al Gestor de Puestos");

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

            String us = this.usuario.getText();
            Puesto.usuario.setText(us);

            pst.executeUpdate();

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        Nómina nomina = new Nómina();
        nomina.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó a la Nómina");

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

            String us = this.usuario.getText();
            Nómina.usuario.setText(us);

            pst.executeUpdate();

        } catch (SQLException ex) {

        }
        
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Conceptos concepto = new Conceptos();
        concepto.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó al Gestor de Conceptos");

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

            String us = this.usuario.getText();
            Conceptos.usuario.setText(us);

            pst.executeUpdate();

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Usuarios usuarios = new Usuarios();
        usuarios.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó al Gestor de Usuarios");

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

            String us = this.usuario.getText();
            Usuarios.usuario.setText(us);

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Aplicaciones aplicacion = new Aplicaciones();
        aplicacion.setVisible(true);
        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Ingresó al Gestor de Aplicaciones");

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

            String us = this.usuario.getText();
            Aplicaciones.usuario.setText(us);

            Aplicaciones.clic = this.clic;

            pst.executeUpdate();

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void label1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_label1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_label1PropertyChange

    private void logoutbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutbtn1MousePressed
        // TODO add your handling code here:
        dispose();
        frmLogin login = new frmLogin();
        login.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Cerró sesión");

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

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_logoutbtn1MousePressed

    private void btnApaga1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApaga1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnApaga1MousePressed

    private void btnLogout1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MousePressed
        // TODO add your handling code here:
        dispose();
        frmLogin login = new frmLogin();
        login.setVisible(true);

        //registro en bitacora
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, usuario.getText());
            pst.setString(3, "Cerró sesión");

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

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btnLogout1MousePressed

    private void labelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_labelPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_labelPropertyChange

    private void btnApagar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApagar1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnApagar1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mdiMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Claro;
    private temaclaro.btnApaga btnApaga1;
    private temanegro.btnApagar btnApagar1;
    private temanegro.btnLogout btnLogout1;
    private javax.swing.JLabel code;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JLabel date;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    public static javax.swing.JLabel label;
    public static javax.swing.JLabel label1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    public static javax.swing.JLabel lclic;
    private temaclaro.Logoutbtn logoutbtn1;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JLabel timee;
    public static javax.swing.JLabel usuario;
    public static javax.swing.JLabel usuario1;
    // End of variables declaration//GEN-END:variables

}
