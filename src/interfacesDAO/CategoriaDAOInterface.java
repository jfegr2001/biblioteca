/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import exepciones.ExcepcionCategiraYaRegistrada;
import exepciones.ExcepcionNopuedeEliminar;
import java.sql.SQLException;
import modelo.Categoria;

/**
 *
 * @author JFGIR
 */
public interface CategoriaDAOInterface {
    
    boolean buscarCategoria(Categoria categoria) throws SQLException ;
    void registrarCategoria(Categoria categoria) throws SQLException, ExcepcionCategiraYaRegistrada ;
    boolean eliminar(String nombre) throws SQLException, ExcepcionNopuedeEliminar;
    
    
    
}
