/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteNomina;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import Principal.mdiMenuPrincipal;
import java.util.Calendar;

/**
 *
 * @author Sucely Alvarez
 */
public class Aplicacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Aplicacion
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


    public Aplicacion() {
        initComponents();
        comboDB();
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

        p1 = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        excepcion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        codigop1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_puestos = new javax.swing.JTable();
        btnIngresar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        nombreap = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        puesto = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Ap = new javax.swing.JTable();
        codigop = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        p1.setText("jLabel6");

        p.setText("jLabel6");

        usuario.setText("jLabel6");

        timee.setText("jLabel1");

        date.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestor de Aplicaciones");
        setVisible(true);

        excepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excepcionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Puestos");

        codigop1.setText("Codigo");

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

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/save (1).png"))); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/edit_clear.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/modify.png"))); // NOI18N
        btnModificar1.setEnabled(false);
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Aplicacion");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/gnome_edit_delete.png"))); // NOI18N
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/busqueda1bf.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Puesto");

        buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puestoActionPerformed(evt);
            }
        });

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

        codigop.setText("Codigo");

        jLabel3.setText("Excepción");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Aplicaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(excepcion, 0, 198, Short.MAX_VALUE)
                            .addComponent(nombreap)
                            .addComponent(puesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigop)
                            .addComponent(codigop1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombreap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigop))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(excepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigop1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        } catch (Exception e) {
        }
    }//GEN-LAST:event_excepcionActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
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

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
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
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
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
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            if (puesto.getSelectedItem().toString() == "Seleccione una opción") {
                codigop.setText("Codigo");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_puestoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel codigop;
    private javax.swing.JLabel codigop1;
    private javax.swing.JLabel date;
    private javax.swing.JComboBox<String> excepcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombreap;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private javax.swing.JComboBox<String> puesto;
    private javax.swing.JTable tbl_Ap;
    private javax.swing.JTable tbl_puestos;
    private javax.swing.JLabel timee;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
