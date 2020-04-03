
import static com.sun.javafx.fxml.expression.Expression.set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.reflect.Array.set;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Password;
import java.sql.*;



/**
 *
 * @author kievk
 */
public class frmLogin extends javax.swing.JFrame {

private static Scanner sc;
private static int Intentos;
private static String strUsuario, strContraseña; 

    public static void setIntentos(int Intentos) {
        frmLogin.Intentos = Intentos;
    }
    /**
     * Creates new form login
     */
    public frmLogin() {
        initComponents();
       setLocationRelativeTo(null);
       setSize(1000,800);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       rootPane.setDefaultButton(btnIniciarSesion);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblIniciosecion = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblSistemaNomina = new javax.swing.JLabel();
        lblFondoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Nomina");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(300, 300));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtContraseña.setToolTipText("Ingrese su contraseña");

        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setToolTipText("Ingrese su usuario");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblIniciosecion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIniciosecion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIniciosecion.setText("Iniciar sesión");
        lblIniciosecion.setToolTipText("");

        lblContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña");

        btnIniciarSesion.setBackground(new java.awt.Color(30, 30, 70));
        btnIniciarSesion.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar");
        btnIniciarSesion.setToolTipText("Inicia sesión");
        btnIniciarSesion.setName(""); // NOI18N
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ebrima", 0, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cierra la aplicación ");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");

        jPanel2.setBackground(new java.awt.Color(31, 31, 63));

        lblSistemaNomina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSistemaNomina.setForeground(new java.awt.Color(255, 255, 255));
        lblSistemaNomina.setText("Sistema de Nomina");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSistemaNomina)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSistemaNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(219, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(lblIniciosecion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIniciosecion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        lblFondoLogin.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        lblFondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo 4.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 180, Short.MAX_VALUE))
            .addComponent(lblFondoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFondoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
              /**
     * Inicia lectura de archivo
     */   
              FileReader fr=null;
    try {
        int nLineas=0;
        int i=0;
        String [] Usuario= null;
        String Linea;
        sc= new Scanner(new File("usuarios.txt"));
        File f=new File("usuarios.txt");
        fr = new FileReader(f);
        BufferedReader br= new BufferedReader(fr);
     
            try {
                while ((Linea=br.readLine())!=null)
                    nLineas++;
            } catch (IOException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        //tamaño del array
            Usuario=new String [nLineas];
        //almacenando cada linea en una posición del arreglo   
            while(sc.hasNextLine()){
            Usuario[i++]=sc.nextLine();
            
            }
            Intentos++;
               /**
     * Obtención de los datos ingresados en los JTextField
     */
            strUsuario= txtUsuario.getText();
            strContraseña= txtContraseña.getText();
            Seguridad s= new Seguridad();
            s.ValidarUsuarios(Usuario, strUsuario, strContraseña, Intentos);
                
    } catch (FileNotFoundException ex) {
        Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
      if(Intentos==0) this.dispose();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked

        
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblFondoLogin;
    private javax.swing.JLabel lblIniciosecion;
    private javax.swing.JLabel lblSistemaNomina;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void setBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
