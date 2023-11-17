/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Singleton.Singleton;
import controladores.ControladorAdmin;
import controladores.ControladorReportes;
import exepciones.ExcepcionDocumentoDuplicado;
import exepciones.ExepcionesUsuarioRepetido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Movimientos;
import modelo.Usuario;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author felipe
 */
public final class VistaAdmi extends javax.swing.JFrame {

    ControladorAdmin controlador;
    TableRowSorter<DefaultTableModel> sorter;
    ControladorReportes controladorReportes;
    Connection connection = Singleton.getInstancia().getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    // el verdadero

    public VistaAdmi() {
        initComponents();
        this.setLocationRelativeTo(this);
        controlador = new ControladorAdmin();
        sorter = new TableRowSorter<>();
        controladorReportes = new ControladorReportes();
        llenartabla();
        llenarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelRegistroUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelCrudLibros = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelCrudCategoria = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        menu = new javax.swing.JTabbedPane();
        usuarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtApellido = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtEdad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        comboUsuarios = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        libros = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("RGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 94, -1));

        panelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 620));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        panelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 10, 620));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRegistroUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegistroUsuarioMouseClicked(evt);
            }
        });
        panelRegistroUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CONTROL DE");
        panelRegistroUsuario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel2.setText("USUARIOS");
        panelRegistroUsuario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel3.add(panelRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 110, 40));

        panelCrudLibros.setBackground(new java.awt.Color(255, 255, 255));
        panelCrudLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCrudLibrosMouseClicked(evt);
            }
        });
        panelCrudLibros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("CONTROL DE ");
        panelCrudLibros.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jLabel15.setText("LIBROS");
        panelCrudLibros.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jPanel3.add(panelCrudLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 110, 40));

        panelCrudCategoria.setBackground(new java.awt.Color(255, 255, 255));
        panelCrudCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCrudCategoriaMouseClicked(evt);
            }
        });
        panelCrudCategoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("AGREGAR UNA");
        panelCrudCategoria.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel12.setText("CATEGORIA");
        panelCrudCategoria.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, -1));

        jPanel3.add(panelCrudCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 110, 40));

        panelPrincipal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 860, 90));

        menu.setBackground(new java.awt.Color(255, 255, 255));

        usuarios.setBackground(new java.awt.Color(255, 255, 255));
        usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("CONTRASEÑA");
        usuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 90, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 140, 10));

        jLabel4.setText("DIGUITE EL NOMBRE DEL USUARIO A BUSCAR");
        usuarios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, 20));

        txtUsuario.setBorder(null);
        usuarios.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 140, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 140, 20));

        txtDireccion.setBorder(null);
        usuarios.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 140, 30));

        jLabel5.setText("NOMBRE ");
        usuarios.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, -1));

        jLabel6.setText("APELLIDO");
        usuarios.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 70, -1));

        jLabel7.setText("EDAD");
        usuarios.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, -1));

        jLabel8.setText("DIRECCION");
        usuarios.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 70, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("DATOS DE USUARIO");
        usuarios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, -1));

        txtContraseña.setBorder(null);
        usuarios.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 140, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 170, 10));

        txtApellido.setBorder(null);
        usuarios.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 140, 10));

        txtEdad.setBorder(null);
        usuarios.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 140, 10));

        jLabel10.setText("USUARIO");
        usuarios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 70, -1));

        txtDocumento.setBorder(null);
        usuarios.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 20));

        txtNombre.setBorder(null);
        usuarios.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 140, 10));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 255));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        usuarios.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 140, 30));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 255));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        usuarios.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 140, 30));

        btnEditar.setBackground(new java.awt.Color(0, 0, 255));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        usuarios.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 150, 30));

        tablaUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex ){
                return false;
            }
        };
        tablaUsuarios.setShowGrid(false);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        usuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 620, 160));

        jLabel13.setText("DOCUMENTO");
        usuarios.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        txtBuscar.setBorder(null);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        usuarios.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 170, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        usuarios.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 140, 10));

        comboUsuarios.setBorder(null);
        usuarios.add(comboUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 180, 30));

        jLabel16.setText("GENERA REPORTE DE LOS MOVIMIENTOS DE LOS USUARIOS");
        usuarios.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        btnGenerarReporte.setBackground(new java.awt.Color(0, 0, 255));
        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setText("GENERAR");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        usuarios.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 90, 30));

        menu.addTab("Usuario", usuarios);

        libros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menu.addTab("tab2", libros);

        panelPrincipal.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 850, 560));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "QUERIDO ADMINISTRADOR LLENE TODOS LOS CAMPOS");
            return;
        }

        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();
        String direccion = txtDireccion.getText();
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();

        String tipoMovimiento = "Registro usuario";

        Usuario persona = new Usuario(documento, nombre, apellido, edad, direccion, usuario, contraseña);
        Movimientos movimientos = new Movimientos(tipoMovimiento);

        try {
            controlador.registrarUsuario(persona);
            controlador.movimientosAdmin(movimientos);
            llenartabla();
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");

            limpiarCampos();

        } catch (ExepcionesUsuarioRepetido | ExcepcionDocumentoDuplicado ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            txtDocumento.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " NO FUE POSIBLE EL REGISTRO");
            Logger.getLogger(VistaAdmi.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void panelRegistroUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistroUsuarioMouseClicked
        menu.setSelectedIndex(1);
    }//GEN-LAST:event_panelRegistroUsuarioMouseClicked

    private void panelCrudLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCrudLibrosMouseClicked
        VentanaLibros newframe = new VentanaLibros();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panelCrudLibrosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "SELECIONE EN LA TABLA  QUE USUARIO QUIERE ELIMINAR");
            return;
        }

        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();
        String direccion = txtDireccion.getText();
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();

        String tipoMovimiento = "Edito informacion de usuario";

        Movimientos movimientos = new Movimientos(tipoMovimiento);
        Usuario persona = new Usuario(documento, nombre, apellido, edad, direccion, usuario, contraseña);

        try {

            controlador.movimientosAdmin(movimientos);
            controlador.editarUsuario(persona);
            JOptionPane.showMessageDialog(null, "EXITOSO AL EDITAR");
            llenartabla();
            limpiarCampos();

        } catch (SQLException ex) {
            System.err.println(ex);

        } catch (ExepcionesUsuarioRepetido ex) {
            JOptionPane.showMessageDialog(null, " EL USUARIO QUE ESTAS INGRESANDO YA EXISTE");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "SELECCIONE EL USUARIO QUE  DESEA ELIMINAR");
            return;
        }

        String Documento = txtDocumento.getText();
        
        String tipoMovimiento = "Elimino usuario";
        
        Movimientos movimientos = new Movimientos(tipoMovimiento);

        try {
            int desicion = JOptionPane.showConfirmDialog(null, "SEGURO DESEA ELIMINAR EL USUARIO", "ADVERTENCIA", JOptionPane.YES_NO_CANCEL_OPTION);

            if (desicion == 0) {
                controlador.eliminarUsuario(Documento);
                controlador.movimientosAdmin(movimientos);
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
                llenartabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
                llenartabla();
            }

        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(VistaAdmi.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked

        try {

            int Fila = tablaUsuarios.getSelectedRow();
            String codigo = tablaUsuarios.getValueAt(Fila, 0).toString();

            ps = connection.prepareStatement("SELECT documento, nombre, apellido, edad, direccion, usuario, contraseña FROM usuario WHERE documento=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtDocumento.setText(rs.getString("documento"));
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtEdad.setText(rs.getString("edad"));
                txtDireccion.setText(rs.getString("direccion"));
                txtUsuario.setText(rs.getString("usuario"));
                txtContraseña.setText(rs.getString("contraseña"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrar();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Login newframe = new Login();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void panelCrudCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCrudCategoriaMouseClicked
        VentanaCategoria categoria = new VentanaCategoria();
        categoria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panelCrudCategoriaMouseClicked

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
       if (comboUsuarios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ELIGA UN USUARIO");
        } else {

            String documento = comboUsuarios.getSelectedItem().toString().split("-")[0];
            String nombre = comboUsuarios.getSelectedItem().toString().split("-")[1];

            controladorReportes.ReporteDeMvimientos(documento, nombre);
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    public void filtrar() {

        sorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(), 1));
    }

    public void llenartabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            //  TableRowSorter<DefaultTableModel> sorter;
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);

            tablaUsuarios.setModel(modelo);

            String sql = "SELECT documento, nombre, apellido, edad, direccion, usuario, contraseña FROM usuario";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Documento");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Edad");
            modelo.addColumn("Direccion");
            modelo.addColumn("Usuario");
            modelo.addColumn("Contraseña");

            int[] anchos = {40, 40, 40, 10, 40, 40, 40};
            for (int i = 0; i < tablaUsuarios.getColumnCount(); i++) {
                tablaUsuarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void llenarComboBox() {

        try {
            String sql = "select documento,nombre From usuario";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            comboUsuarios.addItem("Elije el Usuario");
            while (rs.next()) {
                comboUsuarios.addItem(rs.getString("documento")+"-"+ rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }
    public void limpiarCampos() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtEdad.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");

    }

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
            java.util.logging.Logger.getLogger(VistaAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdmi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboUsuarios;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel libros;
    private javax.swing.JTabbedPane menu;
    private javax.swing.JPanel panelCrudCategoria;
    private javax.swing.JPanel panelCrudLibros;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRegistroUsuario;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPanel usuarios;
    // End of variables declaration//GEN-END:variables
}
