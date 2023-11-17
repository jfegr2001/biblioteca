/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import exepciones.ExcepcionYatieneUnPrestamo;
import java.sql.SQLException;
import modelo.Prestamo;

/**
 *
 * @author JFGIR
 */
public interface PrestamosDAOInterface {
    
    boolean AgregarPrestamo(Prestamo prestamo) throws SQLException, ExcepcionYatieneUnPrestamo;
    boolean devolverPrestamo(String documento_usuario, String codigo_libro, String fechaDevolucion) throws SQLException;
    
    
    
}
