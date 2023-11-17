/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.MovimientosDAO;
import dao.PrestamoDAO;
import exepciones.ExcepcionYatieneUnPrestamo;
import java.sql.SQLException;
import modelo.Movimientos;
import modelo.Prestamo;

/**
 *
 * @author JFGIR
 */
public class ControladorPrestamos {

    PrestamoDAO prestamoDAO;
    MovimientosDAO movimientosDAO;

    public ControladorPrestamos() {

        prestamoDAO = new PrestamoDAO();
        movimientosDAO = new MovimientosDAO();
    }

    public void AgregarPrestamo(Prestamo prestamo) throws SQLException, ExcepcionYatieneUnPrestamo {

        prestamoDAO.AgregarPrestamo(prestamo);
    }

    public boolean devolverPrestamo(String documento_usuario, String codigo_libro, String fechaDevolucion) throws SQLException {
        return prestamoDAO.devolverPrestamo(documento_usuario, codigo_libro, fechaDevolucion);
    }

    public boolean AgregarHistorial(Prestamo prestamo) throws SQLException {
        return prestamoDAO.AgregarHistorial(prestamo);

    }
    
    
      public void movimientos(Movimientos movimientos) throws SQLException {
        
        movimientosDAO.movimientos(movimientos);
    }
    

}
