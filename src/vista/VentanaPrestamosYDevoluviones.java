/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Singleton.Singleton;
import controladores.ControladorPrestamos;
import exepciones.ExcepcionYatieneUnPrestamo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Movimientos;
import modelo.Prestamo;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class VentanaPrestamosYDevoluviones extends javax.swing.JFrame {

    private String[] datosUsuario;
    Connection connection = Singleton.getInstancia().getConnection();

    ControladorPrestamos controladorPrestamos;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public VentanaPrestamosYDevoluviones(String[] datosUsuario) {
        initComponents();
        setLocationRelativeTo(this);
        this.datosUsuario = datosUsuario;
        controladorPrestamos = new ControladorPrestamos();
        Calendar calendar = Calendar.getInstance();
        calendario.setMinSelectableDate(calendar.getTime()); // Fecha actual como mínimo
        calendar.add(Calendar.DAY_OF_MONTH, 15); // Sumar 15 días a la fecha actual
        calendario.setMaxSelectableDate(calendar.getTime());
        llenarDatos();
        llenartabla();
        llenarComboBox();

    }

    private VentanaPrestamosYDevoluviones() {
        initComponents();
        Calendar calendar = Calendar.getInstance();
        calendario.setMinSelectableDate(calendar.getTime()); // Fecha actual como mínimo
        calendar.add(Calendar.DAY_OF_MONTH, 15); // Sumar 15 días a la fecha actual
        calendario.setMaxSelectableDate(calendar.getTime());
        setLocationRelativeTo(this);

        llenartabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelDeTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreDeUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoLibro = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtDocumento = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        calendario = new com.toedter.calendar.JDateChooser();
        btnPrestarLibro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        comboPrestamo = new javax.swing.JComboBox<>();
        btnDevolucion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        panelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 510));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelPrincipal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 20, 510));

        panelDeTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelDeTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("LIBROS DISPONIBLES "));

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

        javax.swing.GroupLayout panelDeTablaLayout = new javax.swing.GroupLayout(panelDeTabla);
        panelDeTabla.setLayout(panelDeTablaLayout);
        panelDeTablaLayout.setHorizontalGroup(
            panelDeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDeTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDeTablaLayout.setVerticalGroup(
            panelDeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPrincipal.add(panelDeTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 810, 180));

        jLabel1.setText("USUARIO ");
        panelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 20));

        txtNombreDeUsuario.setBorder(null);
        panelPrincipal.add(txtNombreDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 160, 20));

        jLabel2.setText("DOCUMENTO ");
        panelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 110, -1));

        jLabel3.setText("CODIGO DEL LIBRO");
        panelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        txtCodigoLibro.setBorder(null);
        panelPrincipal.add(txtCodigoLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 160, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 160, 20));

        txtDocumento.setBorder(null);
        panelPrincipal.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 160, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ELIJA LA FECHA LIMITE "));

        calendario.setBackground(new java.awt.Color(255, 255, 255));
        calendario.setDateFormatString("yyyy-MM-dd ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 190, 80));

        btnPrestarLibro.setBackground(new java.awt.Color(0, 0, 255));
        btnPrestarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestarLibro.setText("PRESTAR LIBRO");
        btnPrestarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarLibroActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnPrestarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 140, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("ELIJE EL LIBRO QUE DESEAS  PRESTAR");
        panelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("LIBRO PRESTADO"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(comboPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 248, 37));

        panelPrincipal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 270, 70));

        btnDevolucion.setBackground(new java.awt.Color(0, 0, 255));
        btnDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolucion.setText("DEVOLVER LIBRO");
        btnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VentanaDeUsuarios usuarios = new VentanaDeUsuarios(datosUsuario);
        usuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnPrestarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarLibroActionPerformed
        Date obtrnerfecha = calendario.getDate();
        if (txtCodigoLibro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ELIJA EN LA TABLA QUE LIBRO QUIERES PRESTAR");
        } else if (obtrnerfecha == null) {
            JOptionPane.showMessageDialog(null, "ELIJE LA FECHA DE DEVOLUCIÓN");
        }
        String documento = txtDocumento.getText();
        String codigoLibro = txtCodigoLibro.getText();

        Date fechaDePrestamo = new Date(); // obtenemos la fecha actual
        SimpleDateFormat formatoFceha = new SimpleDateFormat("yyyy-MM-dd "); // le damos el formato de la fecha
        String fechaConvertida = formatoFceha.format(fechaDePrestamo); // la convertimos a String

        String fechaDeVencimiento = ((JTextField) calendario.getDateEditor().getUiComponent()).getText();
        Prestamo prestamo = new Prestamo(documento, codigoLibro, fechaConvertida, fechaDeVencimiento);

        String tipoMovimiento = "Presto libro";
        Movimientos movimientos = new Movimientos(datosUsuario[0], tipoMovimiento);
        try {
            controladorPrestamos.AgregarPrestamo(prestamo);
            controladorPrestamos.AgregarHistorial(prestamo);
            controladorPrestamos.movimientos(movimientos);
            JOptionPane.showMessageDialog(null, "PRESTAMO EXITOSO"
                    + "\nRECUERDA LA FECHA DE ENTREGA: " + fechaDeVencimiento);
            llenartabla();
            llenarComboBox();
            vaciarCampos();
        } catch (ExcepcionYatieneUnPrestamo e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE REALIZAR EL PRESTAMO");
        }


    }//GEN-LAST:event_btnPrestarLibroActionPerformed

    private void tablaLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibrosMouseClicked

        try {

            int Fila = tablaLibros.getSelectedRow();
            String codigo = tablaLibros.getValueAt(Fila, 0).toString();

            ps = connection.prepareStatement("SELECT lb.codigo, lb.titulo ,cg.id_categoria, cg.nombre as genero, lb.autor ,lb.añodepublicacion , lb.numerodeCopias FROM libro as lb inner join categoria as cg on genero = id_categoria WHERE lb.codigo =?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtCodigoLibro.setText(rs.getString("lb.codigo"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_tablaLibrosMouseClicked

    private void btnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionActionPerformed

        if (comboPrestamo.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(null, "NO TIENES  UN LIBRO EN PRESTAMO");
            return;
        }
        String documento = txtDocumento.getText();
        String codigoLibro = comboPrestamo.getSelectedItem().toString().split("-")[0];
        Date fechaDePrestamo = new Date(); // obtenemos la fecha actual
        SimpleDateFormat formatoFceha = new SimpleDateFormat("yyyy-MM-dd "); // le damos el formato de la fecha
        String fechaDevolucion = formatoFceha.format(fechaDePrestamo); // la convertimos a String

        // Obtener la hora actual 
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("hh:mm a");
        String hora12HorasSinPuntosAMPM = horaActual.format(formatoPersonalizado);
        String hora = hora12HorasSinPuntosAMPM.replace("p.m.", "Pm");
        System.out.println(hora);

        // Obtener la fecha
        LocalDate fechaActual = LocalDate.now();
        String fecha = fechaActual.toString();
        System.out.println(fecha);

        String tipoMovimiento = "Devolución de libro";

        Movimientos movimientos = new Movimientos(datosUsuario[0], tipoMovimiento, hora, fecha);

        try {
//            controladorPrestamos.devolverPrestamo(documento, codigoLibro);
            int desicion = JOptionPane.showConfirmDialog(null, "SEGURO DESEAS DEVOLVER EL LIBRO", "ADVERTENCIA",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (desicion == 0) {
                controladorPrestamos.devolverPrestamo(documento, codigoLibro, fechaDevolucion);
                controladorPrestamos.movimientos(movimientos);
                JOptionPane.showMessageDialog(null, " EXITO AL DEVOLVER");
                llenartabla();
                comboPrestamo.removeAllItems();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE DEVOLVIO EL LIBRO");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_btnDevolucionActionPerformed
    public void llenarDatos() {

        txtDocumento.setText(datosUsuario[0]);
        txtNombreDeUsuario.setText(datosUsuario[1].toUpperCase());
        txtDocumento.setEditable(false);
        txtNombreDeUsuario.setEditable(false);
        txtCodigoLibro.setEditable(false);

    }

    public void llenartabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaLibros.setModel(modelo);

            String sql = "SELECT libro.codigo, libro.titulo, categoria.nombre, libro.autor, libro.añodepublicacion,libro.numerodeCopias FROM libro"
                    + " inner join categoria on genero = categoria.id_categoria"
                    + " WHERE libro.numerodeCopias>= 1 ";
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
            String sql = "SELECT libro.codigo, libro.titulo FROM prestamos INNER JOIN libro ON libro.codigo = prestamos.codigo_libro WHERE prestamos.documento_usuario =?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, datosUsuario[0]);
            rs = ps.executeQuery();
            while (rs.next()) {
                comboPrestamo.addItem(rs.getString("libro.codigo") + "-" + rs.getString("libro.titulo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void vaciarCampos() {
        txtCodigoLibro.setText("");
        calendario.setDate(null);
    }

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
            java.util.logging.Logger.getLogger(VentanaPrestamosYDevoluviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrestamosYDevoluviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrestamosYDevoluviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrestamosYDevoluviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrestamosYDevoluviones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnPrestarLibro;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JComboBox<String> comboPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel panelDeTabla;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtCodigoLibro;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombreDeUsuario;
    // End of variables declaration//GEN-END:variables
}
