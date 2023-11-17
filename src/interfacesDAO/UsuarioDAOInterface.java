/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import exepciones.ExepcionesUsuarioRepetido;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author JFGIR
 */
public interface UsuarioDAOInterface {

    void registrarUsuario(Usuario usuario) throws SQLException, ExepcionesUsuarioRepetido;
    boolean validarUsuario(Usuario usuario) throws SQLException ;
    boolean validarDocumento(Usuario usuario) throws SQLException;
    boolean eliminarUsuario(String documento) throws SQLException ;
    boolean editarUsuario(Usuario usuario) throws SQLException, ExepcionesUsuarioRepetido ;
    
    
    

}
