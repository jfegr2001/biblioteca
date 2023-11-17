/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Singleton.Singleton;
import exepciones.ExepcionLibroYaExiste;
import exepciones.ExepcionTituloLibro;
import interfacesDAO.LibroDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Libro;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class LibroDAO implements LibroDAOInterface {

    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public LibroDAO() {
        connection = Singleton.getInstancia().getConnection();
    }

    @Override
    public boolean buscarLibro(Libro libro) throws SQLException {

        ps = connection.prepareStatement(" SELECT * FROM libro WHERE codigo=?");
        ps.setString(1, libro.getCodigo());
        rs = ps.executeQuery();

        return rs.next();
    }
    @Override
    public boolean buscarLibroCategoria(String categoria) throws SQLException {

        ps = connection.prepareStatement("SELECT lb.titulo FROM libro AS lb inner join categoria as ca on lb.genero = ca.id_categoria WHERE ca.nombre =?");
        ps.setString(1, categoria);
        rs = ps.executeQuery();

        return rs.next();
    }

    @Override
    public boolean buscarLibroNombre(Libro libro) throws SQLException {

        ps = connection.prepareStatement(" SELECT * FROM libro WHERE titulo=?");
        ps.setString(1, libro.getTitulo());
        rs = ps.executeQuery();

        return rs.next();
    }

    @Override
    public void registrarLibro(Libro libro) throws SQLException, ExepcionLibroYaExiste, ExepcionTituloLibro {

        if (buscarLibro(libro)) {

            throw new ExepcionLibroYaExiste();
        }

        if (buscarLibroNombre(libro)) {

            throw new ExepcionTituloLibro();

        }

        ps = connection.prepareStatement("INSERT INTO libro (codigo, titulo, genero, autor, añodepublicacion, numerodeCopias) VALUES (?,?,?,?,?,?)");
        ps.setString(1, libro.getCodigo());
        ps.setString(2, libro.getTitulo());
        ps.setString(3, String.valueOf(libro.getCategoria()));
        ps.setString(4, libro.getAutor());
        ps.setString(5, libro.getAñoDepublicacion());
        ps.setInt(6, libro.getNumeroDeCopias());
        ps.execute();

    }

    @Override
    public boolean eliminarLIbro(String codigo) throws SQLException {

        ps = connection.prepareStatement("DELETE FROM libro WHERE codigo=?");
        ps.setString(1, codigo);
        int resusalto = ps.executeUpdate();

        return resusalto > 0;

    }

    
    @Override
    public boolean editarLibro(Libro libro) throws SQLException, ExepcionLibroYaExiste {
        ps = connection.prepareStatement("SELECT * FROM libro WHERE codigo=? AND codigo <> ?");
        ps.setString(1, libro.getCodigo());
        ps.setString(2, libro.getCodigo());
        rs = ps.executeQuery();

        if (rs.next()) {
            throw new ExepcionLibroYaExiste(); // Nombre de usuario ya existe para otro usuario
        }

        ps = connection.prepareStatement("UPDATE  libro SET codigo=?, titulo=?, genero=?, autor=?, añodepublicacion=?, numerodeCopias=? WHERE codigo=?");
        ps.setString(1, libro.getCodigo());
        ps.setString(2, libro.getTitulo());
        ps.setString(3, String.valueOf(libro.getCategoria()));
        ps.setString(4, libro.getAutor());
        ps.setString(5, libro.getAñoDepublicacion());
        ps.setInt(6, libro.getNumeroDeCopias());
        ps.setString(7, libro.getCodigo());
        ps.executeUpdate();
        return true;
    }

}
