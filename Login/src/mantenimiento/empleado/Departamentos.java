/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento.empleado;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import Principal.mdiMenuPrincipal;
import java.util.Calendar;

/**
 *
 * @author Sucely Alvarez
 */
public class Departamentos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Departamentos
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
    
    
    public void refrescar(){
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
    
    public void iniciar_combo(){
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
    
    public void bitacora_eliminar(){
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into Bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            //mdiMenuPrincipal principal=new mdiMenuPrincipal();
            pst.setString(2, usuario.getText());
            
            String u=txt_CrearDep.getText();
            pst.setString(3, "Eliminó el departamento "+u);
            
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
            
            String u=txt_CrearDep.getText();
            pst.setString(3, "Registró el departamento "+u);
            
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
            
            String u=txt_CrearDep.getText();
            pst.setString(3, "Modificó el departamento "+u);
            
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
            
            String u=txt_CrearDep.getText();
            pst.setString(3, "Buscó el concepto "+u);
            
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

    
    public Departamentos() {
        initComponents();
        tablas();
        iniciar_combo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnModificar = new javax.swing.JButton();
        cbox_Departamento = new javax.swing.JComboBox<>();
        txt_CrearDep = new java.awt.TextField();
        btnEliminarDep = new javax.swing.JButton();
        btnCrearDep = new javax.swing.JButton();
        label8 = new java.awt.Label();
        txt_estado = new java.awt.TextField();
        label3 = new java.awt.Label();
        btn_limpiar = new javax.swing.JButton();
        label4 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Dep = new javax.swing.JTable();

        usuario.setText("jLabel6");

        timee.setText("jLabel1");

        date.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gestor de Departamentos");
        setVisible(true);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/modify.png"))); // NOI18N
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        cbox_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_DepartamentoActionPerformed(evt);
            }
        });

        txt_CrearDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CrearDepActionPerformed(evt);
            }
        });

        btnEliminarDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/gnome_edit_delete.png"))); // NOI18N
        btnEliminarDep.setEnabled(false);
        btnEliminarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDepActionPerformed(evt);
            }
        });

        btnCrearDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/save (1).png"))); // NOI18N
        btnCrearDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDepActionPerformed(evt);
            }
        });

        label8.setText("Estado");

        txt_estado.setEnabled(false);
        txt_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadoActionPerformed(evt);
            }
        });

        label3.setText("Departamento");

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/edit_clear.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        label4.setText("ID Departamento");

        activo.setText("Activo");

        inactivo.setText("Inactivo");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbox_Departamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_CrearDep, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCrearDep, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(btnEliminarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnCrearDep, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbox_Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_CrearDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
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
            btnEliminarDep.setEnabled(false);
            btnModificar.setEnabled(false);
            btnCrearDep.setEnabled(true);
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        refrescar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cbox_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_DepartamentoActionPerformed
        try {
            Connection cn = DriverManager.getConnection(mdiMenuPrincipal.BD, mdiMenuPrincipal.Usuario, mdiMenuPrincipal.Contraseña);

            PreparedStatement pst2 = cn.prepareStatement("select * from Departamentos where Codigo_Departamento = ?");
            pst2.setString(1, cbox_Departamento.getSelectedItem().toString());
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                txt_CrearDep.setText(rs2.getString("Nombre_Departamento"));
                txt_estado.setText(rs2.getString("Estado_Departamento"));
                btnEliminarDep.setEnabled(true);
                btnModificar.setEnabled(true);
                btnCrearDep.setEnabled(false);
                
                 bitacora_busqueda();
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_DepartamentoActionPerformed

    private void txt_CrearDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CrearDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CrearDepActionPerformed

    private void btnEliminarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDepActionPerformed
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
            btnEliminarDep.setEnabled(false);
            btnModificar.setEnabled(false);
            btnCrearDep.setEnabled(true);
            inactivo.setSelected(false);
            activo.setSelected(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la eliminación del departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        refrescar();// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDepActionPerformed

    private void btnCrearDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDepActionPerformed
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearDepActionPerformed

    private void txt_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txt_CrearDep.setText("");
        cbox_Departamento.setSelectedIndex(0);
        txt_estado.setText("");
        btnEliminarDep.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCrearDep.setEnabled(true);
        inactivo.setSelected(false);
        activo.setSelected(false);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btnCrearDep;
    private javax.swing.JButton btnEliminarDep;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbox_Departamento;
    private javax.swing.JLabel date;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label8;
    private javax.swing.JTable tbl_Dep;
    private javax.swing.JLabel timee;
    private java.awt.TextField txt_CrearDep;
    private java.awt.TextField txt_estado;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
