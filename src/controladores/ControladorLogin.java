/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.Singleton;
import dao.MovimientosDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.MovimientosDAO;
import modelo.Movimientos;
import modelo.Usuario;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class ControladorLogin {

    private Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    MovimientosDAO MovimientosDAO;

    public ControladorLogin() {
        connection = Singleton.getInstancia().getConnection();
        MovimientosDAO = new MovimientosDAO();
    }

    public ArrayList<Usuario> login(String usuario, String contraseña) throws SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        ps = connection.prepareStatement("SELECT documento, nombre, apellido, edad, direccion, usuario, contraseña FROM usuario WHERE usuario = ? AND  contraseña = ? ");
        ps.setString(1, usuario);
        ps.setString(2, contraseña);

        rs = ps.executeQuery();

        while (rs.next()) {

            Usuario us = new Usuario();
            us.setDocumento(rs.getString("documento"));
            us.setNombre(rs.getString("nombre"));
            us.setApellido(rs.getString("apellido"));
            us.setEdad(rs.getString("edad"));
            us.setDireccion(rs.getString("direccion"));
            us.setUsuario(rs.getString("usuario"));
            us.setContraseña(rs.getString("contraseña"));
            lista.add(us);
        }
        if (lista.isEmpty()) {
            System.out.println("ACCESO DENEGADO");
        } else {
            System.out.println(" INGRESO EXITOSO");

        }

        return lista;

    }
    
    public void movimientos(Movimientos movimientos) throws SQLException {
        
        MovimientosDAO.movimientos(movimientos);
    }
    
    public void movimientosAdmin(Movimientos movimientos) throws SQLException{
        
        MovimientosDAO.movimientosAdmin(movimientos);
    }

}
