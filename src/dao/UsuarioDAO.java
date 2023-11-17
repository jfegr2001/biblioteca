/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Singleton.Singleton;
import exepciones.ExcepcionDocumentoDuplicado;
import exepciones.ExepcionesUsuarioRepetido;
import interfacesDAO.UsuarioDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class UsuarioDAO implements UsuarioDAOInterface {

    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UsuarioDAO() {

        connection = Singleton.getInstancia().getConnection();

    }

    @Override
    public boolean validarUsuario(Usuario usuario) throws SQLException {

        ps = connection.prepareStatement(" SELECT * FROM usuario WHERE usuario=?");
        ps.setString(1, usuario.getUsuario());
        rs = ps.executeQuery();

        return rs.next();
    }

    @Override
    public boolean validarDocumento(Usuario usuario) throws SQLException {
        ps = connection.prepareStatement(" SELECT * FROM usuario WHERE documento=?");
        ps.setString(1, usuario.getDocumento());
        rs = ps.executeQuery();

        return rs.next();
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws SQLException, ExepcionesUsuarioRepetido,
            ExcepcionDocumentoDuplicado {

        if (validarUsuario(usuario)) {

            throw new ExepcionesUsuarioRepetido();
        }
        
        if(validarDocumento(usuario)){
            throw  new ExcepcionDocumentoDuplicado();
         
        }

        ps = connection.prepareStatement("INSERT INTO usuario (documento, nombre, apellido, edad, direccion, usuario, contraseña ) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, usuario.getDocumento());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getApellido());
        ps.setString(4, usuario.getEdad());
        ps.setString(5, usuario.getDireccion());
        ps.setString(6, usuario.getUsuario());
        ps.setString(7, usuario.getContraseña());
        ps.execute();

    }

    @Override
    public boolean eliminarUsuario(String documento) throws SQLException {

        ps = connection.prepareStatement("DELETE FROM usuario WHERE documento=?");
        ps.setString(1, documento);
        rs = ps.executeQuery();

        return rs.next();

    }

    @Override
    public boolean editarUsuario(Usuario usuario) throws SQLException, ExepcionesUsuarioRepetido {

        ps = connection.prepareStatement("SELECT * FROM usuario WHERE usuario=? AND documento <> ?");
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getDocumento());
        rs = ps.executeQuery();

        if (rs.next()) {
            throw new ExepcionesUsuarioRepetido(); // Nombre de usuario ya existe para otro usuario
        }

        ps = connection.prepareStatement("UPDATE  usuario SET documento=?, nombre=?, apellido=?, edad=?, direccion=?, usuario=?, contraseña=? WHERE documento=?");
        ps.setString(1, usuario.getDocumento());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getApellido());
        ps.setString(4, usuario.getEdad());
        ps.setString(5, usuario.getDireccion());
        ps.setString(6, usuario.getUsuario());
        ps.setString(7, usuario.getContraseña());
        ps.setString(8, usuario.getDocumento());
        ps.executeUpdate();
        return true;
    }

}
