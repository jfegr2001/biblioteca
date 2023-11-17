/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Singleton.Singleton;
import interfacesDAO.MovimientosDAOInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelo.Movimientos;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JFGIR
 */
public class MovimientosDAO implements MovimientosDAOInterface {

    private final Connection connection;
    PreparedStatement ps = null;
    // Obtener la hora actual 
    LocalTime horaActual = LocalTime.now();
    DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("hh:mm a");
    String hora12HorasSinPuntosAMPM = horaActual.format(formatoPersonalizado);
    String hora = hora12HorasSinPuntosAMPM.replace("p.m.", "Pm");

    // Obtener la fecha
    LocalDate fechaActual = LocalDate.now();
    String fecha = fechaActual.toString();

    public MovimientosDAO() {

        connection = Singleton.getInstancia().getConnection();

    }

    @Override
    public void movimientos(Movimientos movimientos) throws SQLException {

        ps = connection.prepareStatement("INSERT INTO movimientos(Codigo_usuario, tipo_movimiento, hora, fecha ) VALUES (?,?,?,?)");
        ps.setString(1, movimientos.getCodigo_usuario());
        ps.setString(2, movimientos.getTipo_movimiento());
        ps.setString(3, hora);
        ps.setString(4, fecha);
        ps.execute();

    }

    @Override
    public void movimientosAdmin(Movimientos movimientos) throws SQLException {

        ps = connection.prepareStatement("INSERT INTO movimientosadmin(tipo_de_movimiento, hora, fecha ) VALUES (?,?,?)");
        ps.setString(1, movimientos.getTipo_movimiento());
        ps.setString(2, hora);
        ps.setString(3, fecha);
        ps.execute();

    }

}
