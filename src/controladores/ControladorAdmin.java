/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.CategoriaDAO;
import dao.LibroDAO;
import dao.MovimientosDAO;
import dao.UsuarioDAO;
import exepciones.ExcepcionCategiraYaRegistrada;
import exepciones.ExepcionLibroYaExiste;
import exepciones.ExepcionesUsuarioRepetido;
import java.sql.SQLException;
import modelo.Usuario;
import modelo.Categoria;
import modelo.Libro;
import modelo.Movimientos;

/**
 *
 * @author felipe
 */
public class ControladorAdmin {

    UsuarioDAO usuarioDAO;
    LibroDAO libroDAO;
    CategoriaDAO categoriaDAO;
    MovimientosDAO movimientosDAO;

    public ControladorAdmin() {
        usuarioDAO = new UsuarioDAO();
        libroDAO = new LibroDAO();
        categoriaDAO = new CategoriaDAO();
        movimientosDAO = new MovimientosDAO();
    }

    public boolean validarUsuario(Usuario usuario) throws SQLException {
        return usuarioDAO.validarUsuario(usuario);
    }

    public void registrarUsuario(Usuario usuario) throws SQLException, ExepcionesUsuarioRepetido {

        usuarioDAO.registrarUsuario(usuario);
    }

    public boolean eliminarUsuario(String documento) throws SQLException {

        return usuarioDAO.eliminarUsuario(documento);

    }

    public boolean editarUsuario(Usuario usuario) throws SQLException, ExepcionesUsuarioRepetido {

        return usuarioDAO.editarUsuario(usuario);
    }

   

    public void registrarLibro(Libro libro) throws SQLException, ExepcionLibroYaExiste {

        libroDAO.registrarLibro(libro);
    }

    public boolean eliminarLIbro(String codigo) throws SQLException {

        return libroDAO.eliminarLIbro(codigo);
    }
    
    
    public boolean editarLibro(Libro libro) throws SQLException, ExepcionLibroYaExiste {
    
     return libroDAO.editarLibro(libro);
    }

    public void registrarCategoria(Categoria categoria) throws SQLException, ExcepcionCategiraYaRegistrada{
    categoriaDAO.registrarCategoria(categoria);
    
    }
    
      public boolean  eliminar(String nombre) throws SQLException {
      
        return categoriaDAO.eliminar(nombre);
      }
      
     public void movimientos(Movimientos movimientos) throws SQLException {
        
        movimientosDAO.movimientos(movimientos);
    }
    
     public void movimientosAdmin(Movimientos movimientos) throws SQLException {
        
        movimientosDAO.movimientosAdmin(movimientos);
    }
     
     public boolean buscarLibroCategoria(String categoria) throws SQLException {
     
    return libroDAO.buscarLibroCategoria(categoria);
     }
}
