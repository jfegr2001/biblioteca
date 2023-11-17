/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import java.sql.SQLException;
import modelo.Movimientos;

/**
 *
 * @author JFGIR
 */
public interface MovimientosDAOInterface {

    void movimientos(Movimientos movimientos) throws SQLException;
    void movimientosAdmin(Movimientos movimientos) throws SQLException;
}
