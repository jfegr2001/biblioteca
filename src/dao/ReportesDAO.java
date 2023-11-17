/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Singleton.Singleton;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class ReportesDAO {

    private final Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ReportesDAO() {

        connection = Singleton.getInstancia().getConnection();
    }

    public void ReporteLibros() {
        Document document = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/OneDrive/Escritorio/Reporte_libros.pdf"));

            document.open();
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Codigo libro");
            tabla.addCell("Titulo");
            tabla.addCell("Autor");
            tabla.addCell("Genero");
            tabla.addCell("Año de publicacion");
            tabla.addCell("Numero de copias");

            try {
                ps = connection.prepareStatement("SELECT * FROM libro");

                rs = ps.executeQuery();
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    document.add(tabla);

                }
            } catch (DocumentException | SQLException e) {
                System.out.println(e.getMessage());
            }
            document.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ReporteHistorialDePrestamos() {
        Document document = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/OneDrive/Escritorio/Historial de Prestamos.pdf"));

            document.open();
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Usuario");
            tabla.addCell("Libro prestado");
            tabla.addCell("Genero");
            tabla.addCell("Fecha de prestamo");

            try {
                ps = connection.prepareStatement("SELECT us.nombre, lb.titulo, ca.nombre, ht.fechaprestamo FROM historialprestamos AS ht INNER JOIN usuario AS us on ht.documento_usuario = us.documento INNER JOIN libro AS lb on lb.codigo = ht.codigo_libro"
                        + " INNER JOIN categoria AS ca on ca.id_categoria = lb.genero");

                rs = ps.executeQuery();
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));

                    } while (rs.next());
                    document.add(tabla);

                }
            } catch (DocumentException | SQLException e) {
                System.out.println(e.getMessage());
            }
            document.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ReporteHistorialDePrestamosFiltrado(String Usuario) {
        Document document = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/OneDrive/Escritorio/Historial de Prestamos de "+Usuario+".pdf"));

            document.open();
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Usuario");
            tabla.addCell("Libro prestado");
            tabla.addCell("Genero");
            tabla.addCell("Fecha de prestamo");

            try {
                ps = connection.prepareStatement("SELECT us.nombre, lb.titulo, ca.nombre, ht.fechaprestamo FROM historialprestamos AS ht INNER JOIN usuario AS us on ht.documento_usuario = us.documento INNER JOIN libro AS lb on lb.codigo = ht.codigo_libro"
                        + " INNER JOIN categoria AS ca on ca.id_categoria = lb.genero WHERE us.nombre= ?");

                ps.setString(1, Usuario);
                rs = ps.executeQuery();
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));

                    } while (rs.next());
                    document.add(tabla);

                }
            } catch (DocumentException | SQLException e) {
                System.out.println(e.getMessage());
            }
            document.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
     public void ReporteDeMvimientos(String documento , String usuario) {
        Document document = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/OneDrive/Escritorio/Movimientos de "+usuario+".pdf"));

            document.open();
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Documento");
            tabla.addCell("Usuario");
            tabla.addCell("Fecha");
            tabla.addCell("Hora");
            tabla.addCell("Tipo de movimiento");

            try {
                ps = connection.prepareStatement("SELECT us.documento,us.nombre,fecha,hora,tipo_movimiento FROM movimientos INNER JOIN usuario AS us on movimientos.codigo_usuario = us.documento WHERE us.documento = ?");

                ps.setString(1, documento);
                rs = ps.executeQuery();
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                         tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    document.add(tabla);

                }
            } catch (DocumentException | SQLException e) {
                System.out.println(e.getMessage());
            }
            document.close();
            JOptionPane.showMessageDialog(null, "REPORTE GENERADO");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "EL USUARIO NO TIENE MOVIENTOS");
        }
    }
    
}
