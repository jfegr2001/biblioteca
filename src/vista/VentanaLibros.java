/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Singleton.Singleton;
import controladores.ControladorAdmin;
import controladores.ControladorReportes;
import exepciones.ExepcionLibroYaExiste;
import exepciones.ExepcionTituloLibro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import modelo.Movimientos;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class VentanaLibros extends javax.swing.JFrame {

    ControladorAdmin controlador;
    ControladorReportes controladorReportes;
    Connection connection = Singleton.getInstancia().getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public VentanaLibros() {
        initComponents();
        this.setLocationRelativeTo(this);
        controlador = new ControladorAdmin();
        controladorReportes = new ControladorReportes();
        llenartabla();
        llenarComboBox();
        calendario.setMaxSelectableDate(new Date());
        txtCodigo.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCantidadCopias = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtAutor = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtTitulo = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        registrosDeLibros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        comoBoxGenero = new javax.swing.JComboBox<>();
        btnBusquedaAvanzada = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLibrosPrestados = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 550));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelPrincipal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 20, 550));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("GESTION DE LIBROS ");
        panelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        calendario.setBackground(new java.awt.Color(255, 255, 255));
        calendario.setBorder(javax.swing.BorderFactory.createTitledBorder("CALENDARIO"));
        calendario.setDateFormatString("yyyy-MM-dd\n");
        panelPrincipal.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 160, 70));

        jLabel3.setText("CANTIDAD DE COPIAS");
        panelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 130, -1));

        jLabel4.setText("CODIGO");
        panelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 20));

        jLabel5.setText("TITULO");
        panelPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 70, -1));

        jLabel6.setText("GENERO");
        panelPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 70, -1));

        jLabel7.setText("AUTOR");
        panelPrincipal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 70, -1));
        panelPrincipal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 70, -1));

        txtCantidadCopias.setBorder(null);
        panelPrincipal.add(txtCantidadCopias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 140, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 140, 10));

        txtAutor.setBorder(null);
        panelPrincipal.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 140, 10));

        jLabel10.setText("FECHA DE PUBLICACION");
        panelPrincipal.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 150, -1));

        txtCodigo.setBorder(null);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        panelPrincipal.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 140, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 140, 20));

        txtTitulo.setBorder(null);
        panelPrincipal.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 140, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, 10));

        registrosDeLibros.setBackground(new java.awt.Color(255, 255, 255));
        registrosDeLibros.setBorder(javax.swing.BorderFactory.createTitledBorder("LIBROS REGISTRADOS"));

        tablaLibros = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex ){
                return false;
            }
        };
        tablaLibros.getTableHeader().setReorderingAllowed(false);
        tablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        javax.swing.GroupLayout registrosDeLibrosLayout = new javax.swing.GroupLayout(registrosDeLibros);
        registrosDeLibros.setLayout(registrosDeLibrosLayout);
        registrosDeLibrosLayout.setHorizontalGroup(
            registrosDeLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrosDeLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        registrosDeLibrosLayout.setVerticalGroup(
            registrosDeLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrosDeLibrosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPrincipal.add(registrosDeLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 650, 240));

        comoBoxGenero.setBorder(null);
        panelPrincipal.add(comoBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 190, 30));

        btnBusquedaAvanzada.setBackground(new java.awt.Color(51, 204, 0));
        btnBusquedaAvanzada.setText("BUSQUEDAS AVANZADA");
        btnBusquedaAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaAvanzadaActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnBusquedaAvanzada, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 180, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("BOTONES"));

        btnAgregar.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 255));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 0, 255));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 340, 80));

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("INGRESE LOS DATOS SI DESEA ");
        panelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("AGREGAR UN LIBRO");
        panelPrincipal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, 20));

        btnLibrosPrestados.setBackground(new java.awt.Color(51, 204, 0));
        btnLibrosPrestados.setText("LIBROS EN PRESTAMO");
        btnLibrosPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosPrestadosActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnLibrosPrestados, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 180, -1));

        btnReportes.setBackground(new java.awt.Color(0, 0, 255));
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("GENERAR ");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));

        jLabel11.setText("GENERAR REPORTES DE LIBROS");
        panelPrincipal.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtCodigo.getText().isEmpty() || txtTitulo.getText().isEmpty() || txtAutor.getText().isEmpty() || txtCantidadCopias.getText().isEmpty()
                || comoBoxGenero.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(null, "SELECCIONA EL LIBRO QUE QUIERES EDITAR");
            return;

        }

        String codigo = txtCodigo.getText();
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        int numeroDeCopias = Integer.parseInt(txtCantidadCopias.getText());
        String genero = comoBoxGenero.getSelectedItem().toString().split("-")[0];

        String añoDePublicacion = ((JTextField) calendario.getDateEditor().getUiComponent()).getText(); // como obtener del jcalendar

        String tipoMovimiento = "Edito informacion de un libro";
        Libro libro = new Libro(codigo, titulo, genero, autor, añoDePublicacion, numeroDeCopias);

        Movimientos movimientos = new Movimientos(tipoMovimiento);
        try {
            controlador.editarLibro(libro);
            controlador.movimientosAdmin(movimientos);
            JOptionPane.showMessageDialog(null, " SE EDITO EL LIBRO: " + titulo);
            llenartabla();
            limpiarCampos();

        } catch (SQLException | ExepcionLibroYaExiste ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "SELECCIONE EL LIBRO QUE QUIERES ELIMINAR");
            return;
        }

        String codigo = txtCodigo.getText();
        String tipoMovimiento = "Elimino libro";

        Movimientos movimientos = new Movimientos(tipoMovimiento);

        try {
            int desicion = JOptionPane.showConfirmDialog(null, "SEGURO DESEA ELIMINAR EL LIBRO", "ADVERTENCIA", JOptionPane.YES_NO_CANCEL_OPTION);

            if (desicion == 0) {
                controlador.eliminarLIbro(codigo);
                controlador.movimientosAdmin(movimientos);
                JOptionPane.showMessageDialog(null, "LIBRO ELIMINADO");
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


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtTitulo.getText().isEmpty() || txtAutor.getText().isEmpty() || txtCantidadCopias.getText().isEmpty()
                || comoBoxGenero.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(null, "POR FAVOR COMPLETE TODA LA INFORMACION");
            return;

        }

        String codigo = generarCodigoAleatorio();
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        int numeroDeCopias = Integer.parseInt(txtCantidadCopias.getText());
        String genero = comoBoxGenero.getSelectedItem().toString();

        String añoDePublicacion = ((JTextField) calendario.getDateEditor().getUiComponent()).getText(); // como obtener del jcalendar

        String tipoMovimientos = "Agrego libro";

        Movimientos movimientos = new Movimientos(tipoMovimientos);
        Libro libro = new Libro(codigo, titulo, genero, autor, añoDePublicacion, numeroDeCopias);
        try {
            controlador.registrarLibro(libro);
            controlador.movimientosAdmin(movimientos);
            JOptionPane.showMessageDialog(null, " SE REGISTRO EL LIBRO: " + titulo);
            llenartabla();
            limpiarCampos();

        } catch (SQLException | ExepcionLibroYaExiste ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            txtCodigo.setText("");
        } catch (ExepcionTituloLibro e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            txtTitulo.setText("");
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibrosMouseClicked

        try {

            int Fila = tablaLibros.getSelectedRow();
            String codigo = tablaLibros.getValueAt(Fila, 0).toString();

            ps = connection.prepareStatement("SELECT lb.codigo, lb.titulo ,cg.id_categoria, cg.nombre as genero, lb.autor ,lb.añodepublicacion , lb.numerodeCopias FROM libro as lb inner join categoria as cg on genero = id_categoria WHERE lb.codigo =?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtCodigo.setText(rs.getString("lb.codigo"));
                txtTitulo.setText(rs.getString("lb.titulo"));
                comoBoxGenero.setSelectedItem(rs.getString("cg.id_categoria") + "-" + rs.getString("genero"));
                txtAutor.setText(rs.getString("lb.autor"));
                txtCantidadCopias.setText(rs.getString("lb.numerodeCopias"));
                calendario.setDate(rs.getDate("lb.añodepublicacion"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_tablaLibrosMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        VistaAdmi newframe = new VistaAdmi();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBusquedaAvanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaAvanzadaActionPerformed

        VentanaBusquedaAvanzada newframe = new VentanaBusquedaAvanzada();
        newframe.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBusquedaAvanzadaActionPerformed

    private void btnLibrosPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosPrestadosActionPerformed
        VentanaLibrosPrestados newframe = new VentanaLibrosPrestados();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLibrosPrestadosActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "SOLO PUEDES INGRESAR NUMEROS");
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        controladorReportes.ReporteLibros();
    }//GEN-LAST:event_btnReportesActionPerformed

    public void llenartabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaLibros.setModel(modelo);
            String sql = "SELECT libro.codigo, libro.titulo, categoria.nombre, libro.autor, libro.añodepublicacion,libro.numerodeCopias FROM libro inner join categoria on genero = categoria.id_categoria";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("Titulo");
            modelo.addColumn("Genero");
            modelo.addColumn("Autor");
            modelo.addColumn("Publicado");
            modelo.addColumn("Copias");

            int[] anchos = {40, 40, 40, 60, 40, 5};
            for (int i = 0; i < tablaLibros.getColumnCount(); i++) {
                tablaLibros.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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
            String sql = "select id_categoria,nombre From categoria";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            comoBoxGenero.addItem("Seleccione genero");
            while (rs.next()) {
                comoBoxGenero.addItem(rs.getString("id_categoria") + "-" + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void limpiarCampos() {

        txtCodigo.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCantidadCopias.setText("");
        comoBoxGenero.setSelectedIndex(0);
        calendario.setDate(null);
    }

    public String generarCodigoAleatorio() {
        Random rand = new Random();
        // Genera un número aleatorio en el rango de 1000 a 99,999 (5 dígitos)
        int numeroAleatorio = rand.nextInt(90000) + 1000;
        // Convierte el número a una cadena y devuelve el resultado
        return String.valueOf(numeroAleatorio);
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
            java.util.logging.Logger.getLogger(VentanaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBusquedaAvanzada;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLibrosPrestados;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReportes;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JComboBox<String> comoBoxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel registrosDeLibros;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantidadCopias;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
