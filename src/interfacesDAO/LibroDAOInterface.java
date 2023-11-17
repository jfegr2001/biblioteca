/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import exepciones.ExepcionLibroYaExiste;
import exepciones.ExepcionTituloLibro;
import java.sql.SQLException;
import modelo.Libro;

/**
 *
 * @author JFGIR
 */
public interface LibroDAOInterface {
    
    
    boolean buscarLibro(Libro libro) throws SQLException;
    boolean buscarLibroNombre(Libro libro) throws SQLException ;
    boolean buscarLibroCategoria(String categoria) throws SQLException ;
    void registrarLibro(Libro libro) throws SQLException, ExepcionLibroYaExiste, ExepcionTituloLibro;
    boolean eliminarLIbro(String codigo) throws SQLException ;
    boolean editarLibro(Libro libro) throws SQLException, ExepcionLibroYaExiste;
}
