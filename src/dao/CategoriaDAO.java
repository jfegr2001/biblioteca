/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Singleton.Singleton;

import exepciones.ExcepcionCategiraYaRegistrada;
import exepciones.ExcepcionNopuedeEliminar;
import interfacesDAO.CategoriaDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Categoria;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class CategoriaDAO implements CategoriaDAOInterface {

    private final Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public CategoriaDAO() {

        connection = Singleton.getInstancia().getConnection();
    }

    @Override
    public boolean buscarCategoria(Categoria categoria) throws SQLException {

        ps = connection.prepareStatement(" SELECT * FROM categoria WHERE nombre=?");
        ps.setString(1, categoria.getNombre());
        rs = ps.executeQuery();

        return rs.next();
    }

    @Override
    public void registrarCategoria(Categoria categoria) throws SQLException, ExcepcionCategiraYaRegistrada {

        if (buscarCategoria(categoria)) {
            throw new ExcepcionCategiraYaRegistrada();
        }
        ps = connection.prepareStatement("INSERT INTO categoria (nombre ) VALUES (?)");
        ps.setString(1, categoria.getNombre());

        ps.execute();

    }

    @Override
    public boolean eliminar(String nombre) throws SQLException, ExcepcionNopuedeEliminar {

        ps = connection.prepareStatement("SELECT COUNT(*) FROM libro WHERE genero =?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {

            throw new ExcepcionNopuedeEliminar();

        }
        ps = connection.prepareStatement("DELETE FROM categoria WHERE nombre=?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        return rs.next();
    }

}
