package Principal;

import static com.sun.javafx.fxml.expression.Expression.set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.reflect.Array.set;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.security.util.Password;
import Principal.mdiMenuPrincipal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
/**
 *
 * @author Kevin Flores 9959-18-17632
 * 
 */
public class frmLogin extends javax.swing.JFrame {

    public int clic;

    private static Scanner sc;
    private int Intentos = 3;
    private static String strUsuario, strContraseña;
/**
 *
 * Envio de datos a bitacora.
 * 
 */
    public void ingreso_bitacora() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, txtUsuario.getText());
            pst.setString(3, "Ingresó a la plataforma");

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
 * Temas de aspecto visal creados.
 */
    public void tema() {
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    loginbtn1.setVisible(true);
                    cerrarbtn1.setVisible(true);
                    minimizarbtn1.setVisible(true);
                    fondoclarologin.setVisible(true);
                    lblUsuario1.setVisible(true);
                    lblContraseña1.setVisible(true);

                    btnLogin1.setVisible(false);
                    btnCerrar1.setVisible(false);
                    btnMinimizar1.setVisible(false);
                    fondoscurologin.setVisible(false);
                    lblUsuario.setVisible(false);
                    lblContraseña.setVisible(false);

                    txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
                    txtUsuario.setForeground(new java.awt.Color(0, 0, 0));

                    btnToggle1.setVisible(true);
                    btnToggle11.setVisible(false);
                } else {
                    if (code.getText().contains("Oscuro")) {
                        loginbtn1.setVisible(false);
                        cerrarbtn1.setVisible(false);
                        minimizarbtn1.setVisible(false);
                        fondoclarologin.setVisible(false);
                        lblUsuario1.setVisible(false);
                        lblContraseña1.setVisible(false);

                        btnLogin1.setVisible(true);
                        btnCerrar1.setVisible(true);
                        btnMinimizar1.setVisible(true);
                        fondoscurologin.setVisible(true);
                        lblUsuario.setVisible(true);
                        lblContraseña.setVisible(true);

                        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
                        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));

                        btnToggle1.setVisible(false);
                        btnToggle11.setVisible(true);
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
/**
 *
 * Inicio de componentes.
 * 
 */
    public frmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        txtUsuario.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtContraseña.setBackground(new java.awt.Color(0, 0, 0, 1));
        System.out.println(clic);
        tema();
        this.clic = getClic();
        System.out.println(clic);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        Claro = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblContraseña1 = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        minimizarbtn1 = new temaclaro.Minimizarbtn();
        cerrarbtn1 = new temaclaro.Cerrarbtn();
        loginbtn1 = new temaclaro.Loginbtn();
        btnLogin1 = new temanegro.btnLogin();
        btnCerrar1 = new temanegro.btnCerrar();
        btnMinimizar1 = new temanegro.btnMinimizar();
        btnToggle1 = new temanegro.btnToggle();
        btnToggle11 = new temanegro.btnToggle1();
        lblUsuario1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        fondoclarologin = new javax.swing.JLabel();
        fondoscurologin = new javax.swing.JLabel();

        date.setText("jLabel1");

        timee.setText("jLabel1");

        Claro.setText("0");

        code.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Nomina");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(300, 300));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        txtContraseña.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtContraseña.setToolTipText("Ingrese su contraseña");
        txtContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        txtContraseña.setOpaque(false);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });
        jPanel1.add(txtContraseña);
        txtContraseña.setBounds(590, 370, 200, 30);

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setToolTipText("Ingrese su usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        txtUsuario.setOpaque(false);
        txtUsuario.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(590, 330, 200, 29);

        lblContraseña1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/pasword.png"))); // NOI18N
        jPanel1.add(lblContraseña1);
        lblContraseña1.setBounds(550, 370, 40, 30);

        lblContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jicon/pass.png"))); // NOI18N
        jPanel1.add(lblContraseña);
        lblContraseña.setBounds(550, 370, 40, 30);

        minimizarbtn1.setText("minimizarbtn1");
        minimizarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(minimizarbtn1);
        minimizarbtn1.setBounds(800, 20, 32, 32);

        cerrarbtn1.setText("cerrarbtn1");
        cerrarbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarbtn1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarbtn1MousePressed(evt);
            }
        });
        jPanel1.add(cerrarbtn1);
        cerrarbtn1.setBounds(840, 20, 32, 32);

        loginbtn1.setText("loginbtn1");
        loginbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtn1MouseClicked(evt);
            }
        });
        jPanel1.add(loginbtn1);
        loginbtn1.setBounds(750, 480, 32, 32);

        btnLogin1.setText("btnLogin1");
        btnLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin1MouseEntered(evt);
            }
        });
        jPanel1.add(btnLogin1);
        btnLogin1.setBounds(750, 480, 32, 32);

        btnCerrar1.setText("btnCerrar1");
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrar1MouseClicked(evt);
            }
        });
        jPanel1.add(btnCerrar1);
        btnCerrar1.setBounds(840, 20, 32, 32);

        btnMinimizar1.setText("btnMinimizar1");
        btnMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizar1MouseClicked(evt);
            }
        });
        jPanel1.add(btnMinimizar1);
        btnMinimizar1.setBounds(800, 20, 32, 32);

        btnToggle1.setText("btnToggle1");
        btnToggle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnToggle1MouseClicked(evt);
            }
        });
        jPanel1.add(btnToggle1);
        btnToggle1.setBounds(570, 490, 32, 32);

        btnToggle11.setText("btnToggle11");
        btnToggle11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnToggle11MousePressed(evt);
            }
        });
        jPanel1.add(btnToggle11);
        btnToggle11.setBounds(570, 490, 32, 32);

        lblUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/user2.png"))); // NOI18N
        jPanel1.add(lblUsuario1);
        lblUsuario1.setBounds(550, 320, 40, 40);

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jicon/Usuario.png"))); // NOI18N
        jPanel1.add(lblUsuario);
        lblUsuario.setBounds(550, 320, 40, 40);

        fondoclarologin.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        fondoclarologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FondosLogin/TemaClaro.jpg"))); // NOI18N
        fondoclarologin.setName("temaclaro"); // NOI18N
        jPanel1.add(fondoclarologin);
        fondoclarologin.setBounds(0, 0, 900, 600);

        fondoscurologin.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        fondoscurologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FondosLogin/TemaNegro.jpg"))); // NOI18N
        jPanel1.add(fondoscurologin);
        fondoscurologin.setBounds(0, 0, 900, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrar1MouseClicked
/**
 *
 * Boton para el inicio de sesion. 
 * 
 */   
    private void btnLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseClicked

        /**
         * Inicia lectura de archivo
         */
        if (Intentos != 0) {
            try {
                String usuario = txtUsuario.getText();
                String contrasenia = txtContraseña.getText();

                Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
                PreparedStatement pst = cn.prepareStatement("select * from usarios where nombre_usuario = '" + usuario + "' and contraseña_usuario ='" + contrasenia + "'");

                ResultSet rs = pst.executeQuery();

                rs.last();
                int encontrado = rs.getRow();

                if (encontrado == 1) {
                    new mdiMenuPrincipal().setVisible(true);
                    this.setVisible(false);

                    ingreso_bitacora();

                    String us = this.txtUsuario.getText();
                    mdiMenuPrincipal.usuario.setText(us);

                   
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Usuario no registrado", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            //Intentos--;
        }
        if (Intentos == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnLogin1MouseClicked

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void btnMinimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizar1MouseClicked

        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizar1MouseClicked

    private void btnToggle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnToggle1MouseClicked
        int c1 = 0, c2 = 0, c3 = 0;
        c1 = this.clic;
        c2++;
        c3 = c1 + c2;
        this.clic = c3;
        System.out.println(c3);
        try {
            String ID = Claro.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update togglereg set nombre = ?, clic=? where codigo=" + ID);

            if (clic % 2 == 0) {
                pst2.setString(1, "Oscuro".trim());
                String c = String.valueOf(c2);
                pst2.setString(2, String.valueOf(c3));
                pst2.executeUpdate();
            } else {
                pst2.setString(1, "Claro".trim());
                String c = String.valueOf(c2);
                pst2.setString(2, String.valueOf(c3));
                pst2.executeUpdate();
            }

        } catch (Exception e) {

        }

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    loginbtn1.setVisible(true);
                    cerrarbtn1.setVisible(true);
                    minimizarbtn1.setVisible(true);
                    fondoclarologin.setVisible(true);
                    lblUsuario1.setVisible(true);
                    lblContraseña1.setVisible(true);

                    btnLogin1.setVisible(false);
                    btnCerrar1.setVisible(false);
                    btnMinimizar1.setVisible(false);
                    fondoscurologin.setVisible(false);
                    lblUsuario.setVisible(false);
                    lblContraseña.setVisible(false);

                    txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
                    txtUsuario.setForeground(new java.awt.Color(0, 0, 0));

                    //btnToggle1.setVisible(true);
                    //btnToggle11.setVisible(false);
                } else {
                    if (code.getText().contains("Oscuro")) {
                        loginbtn1.setVisible(false);
                        cerrarbtn1.setVisible(false);
                        minimizarbtn1.setVisible(false);
                        fondoclarologin.setVisible(false);
                        lblUsuario1.setVisible(false);
                        lblContraseña1.setVisible(false);

                        btnLogin1.setVisible(true);
                        btnCerrar1.setVisible(true);
                        btnMinimizar1.setVisible(true);
                        fondoscurologin.setVisible(true);
                        lblUsuario.setVisible(true);
                        lblContraseña.setVisible(true);

                        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
                        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));

                    }
                }

            } else {
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnToggle1MouseClicked

    private void minimizarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarbtn1MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizarbtn1MousePressed

    private void cerrarbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarbtn1MouseClicked
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_cerrarbtn1MouseClicked

    private void cerrarbtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarbtn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarbtn1MousePressed

    private void loginbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtn1MouseClicked
        if (Intentos != 0) {
            try {
                String usuario = txtUsuario.getText();
                String contrasenia = txtContraseña.getText();

                Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
                PreparedStatement pst = cn.prepareStatement("select * from usarios where nombre_usuario = '" + usuario + "' and contraseña_usuario ='" + contrasenia + "'");

                ResultSet rs = pst.executeQuery();

                rs.last();
                int encontrado = rs.getRow();

                if (encontrado == 1) {
                    new mdiMenuPrincipal().setVisible(true);
                    this.setVisible(false);

                    ingreso_bitacora();

                    String us = this.txtUsuario.getText();
                    mdiMenuPrincipal.usuario.setText(us);

                   
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Usuario no registrado", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            //Intentos--;
        }
        if (Intentos == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_loginbtn1MouseClicked

    private void btnLogin1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin1MouseEntered
/**
 *
 * Boton que hace el cambio de tema. 
 * 
 */
    private void btnToggle11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnToggle11MousePressed
        // TODO add your handling code here:
        int c1 = 0, c2 = 0, c3 = 0;
        c1 = this.clic;
        c2++;
        c3 = c1 + c2;
        this.clic = c3;
        System.out.println(c3);
        System.out.println(this.clic);
        try {
            String ID = Claro.getText().trim();
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst2 = cn.prepareStatement("update togglereg set nombre = ?, clic=? where codigo=" + ID);

            if (clic % 2 == 0) {
                pst2.setString(1, "Oscuro".trim());
                String c = String.valueOf(c2);
                pst2.setString(2, String.valueOf(c3));
                pst2.executeUpdate();
            } else {
                pst2.setString(1, "Claro".trim());
                String c = String.valueOf(c2);
                pst2.setString(2, String.valueOf(c3));
                pst2.executeUpdate();
            }

        } catch (Exception e) {

        }
        tema();

        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from togglereg");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                code.setText(rs.getString("nombre"));
                if (code.getText().contains("Claro")) {
                    loginbtn1.setVisible(true);
                    cerrarbtn1.setVisible(true);
                    minimizarbtn1.setVisible(true);
                    fondoclarologin.setVisible(true);
                    lblUsuario1.setVisible(true);
                    lblContraseña1.setVisible(true);

                    btnLogin1.setVisible(false);
                    btnCerrar1.setVisible(false);
                    btnMinimizar1.setVisible(false);
                    fondoscurologin.setVisible(false);
                    lblUsuario.setVisible(false);
                    lblContraseña.setVisible(false);

                    txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
                    txtUsuario.setForeground(new java.awt.Color(0, 0, 0));

                } else {
                    if (code.getText().contains("Oscuro")) {
                        loginbtn1.setVisible(false);
                        cerrarbtn1.setVisible(false);
                        minimizarbtn1.setVisible(false);
                        fondoclarologin.setVisible(false);
                        lblUsuario1.setVisible(false);
                        lblContraseña1.setVisible(false);

                        btnLogin1.setVisible(true);
                        btnCerrar1.setVisible(true);
                        btnMinimizar1.setVisible(true);
                        fondoscurologin.setVisible(true);
                        lblUsuario.setVisible(true);
                        lblContraseña.setVisible(true);

                        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
                        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));

                    }
                }

            } else {
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnToggle11MousePressed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Claro;
    private temanegro.btnCerrar btnCerrar1;
    private temanegro.btnLogin btnLogin1;
    private temanegro.btnMinimizar btnMinimizar1;
    private temanegro.btnToggle btnToggle1;
    private temanegro.btnToggle1 btnToggle11;
    private temaclaro.Cerrarbtn cerrarbtn1;
    private javax.swing.JLabel code;
    private javax.swing.JLabel date;
    private javax.swing.JLabel fondoclarologin;
    private javax.swing.JLabel fondoscurologin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblContraseña1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private temaclaro.Loginbtn loginbtn1;
    private temaclaro.Minimizarbtn minimizarbtn1;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel timee;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void setBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
