/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Singleton.Singleton;
import exepciones.ExcepcionYatieneUnPrestamo;
import interfacesDAO.PrestamosDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelo.Prestamo;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class PrestamoDAO implements PrestamosDAOInterface {

    private final Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public PrestamoDAO() {

        connection = Singleton.getInstancia().getConnection();
    }

    @Override
    public boolean AgregarPrestamo(Prestamo prestamo) throws SQLException, ExcepcionYatieneUnPrestamo {

        if (validarPrestamo(prestamo.getDocumentoUsuario())) {

            throw new ExcepcionYatieneUnPrestamo();
        }

        ps = connection.prepareStatement("INSERT INTO prestamos(documento_usuario, codigo_libro,fecha_prestamo,fecha_vencimiento) VALUES(?,?,?,?)");
        ps.setString(1, prestamo.getDocumentoUsuario());
        ps.setString(2, prestamo.getCodigoLibro());
        ps.setString(3, prestamo.getFechaDePrestamo());
        ps.setString(4, prestamo.getFechaVencimiento());
        int prestamoRealizado = ps.executeUpdate();

        ps = connection.prepareStatement("UPDATE libro SET numerodeCopias = numerodeCopias -1 WHERE codigo =?");
        ps.setString(1, prestamo.getCodigoLibro());
        int copiaActualizada = ps.executeUpdate();

        return prestamoRealizado > 0 && copiaActualizada > 0;
    }

    @Override
    public boolean devolverPrestamo(String documento_usuario, String codigo_libro, String fechaDevolucion) throws SQLException {

        ps = connection.prepareStatement("DELETE FROM prestamos WHERE documento_usuario = ? AND codigo_libro = ?");
        ps.setString(1, documento_usuario);
        ps.setString(2, codigo_libro);

        int prestamoEliminado = ps.executeUpdate();

        if (prestamoEliminado > 0) {

            ps = connection.prepareStatement("UPDATE libro SET numerodeCopias = numerodeCopias+ 1 WHERE codigo = ?");
            ps.setString(1, codigo_libro);
            int copiasActulizadas = ps.executeUpdate();

            if (copiasActulizadas > 0) {

                ps = connection.prepareStatement("INSERT INTO historialdevoluciones (documento_usuario, libro_codigo,fechaDevolucion) VALUES (?,?,?)");
                ps.setString(1, documento_usuario);
                ps.setString(2, codigo_libro);
                ps.setString(3, fechaDevolucion);
                int devolucionrealizada = ps.executeUpdate();

                if (devolucionrealizada > 0) {
                    return true;
                }
            }

        }

        return false;

    }

    public boolean AgregarHistorial(Prestamo prestamo) throws SQLException {

        ps = connection.prepareStatement("INSERT INTO historialprestamos(documento_usuario,codigo_libro,fechaprestamo) VALUES(?,?,?)");
        ps.setString(1, prestamo.getDocumentoUsuario());
        ps.setString(2, prestamo.getCodigoLibro());
        ps.setString(3, prestamo.getFechaDePrestamo());
        int registrarHistorial = ps.executeUpdate();

        return registrarHistorial > 0;
    }

    private boolean validarPrestamo(String documentoUsuario) throws SQLException {

        ps = connection.prepareStatement("SELECT COUNT(*) FROM prestamos WHERE documento_usuario =?");
        ps.setString(1, documentoUsuario);
        rs = ps.executeQuery();

        if (rs.next()) {
            int contador = rs.getInt(1);
            return contador > 0;

        }
        return false;
    }

}
