/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.ReportesDAO;
import modelo.Usuario;

/**
 *
 * @author JFGIR
 */
public class ControladorReportes {

    ReportesDAO reportesDAO;

    public ControladorReportes() {

        reportesDAO = new ReportesDAO();
    }

    public void ReporteLibros() {
        reportesDAO.ReporteLibros();
    }

    public void ReporteHistorialDePrestamos() {
        reportesDAO.ReporteHistorialDePrestamos();
    }

    public void ReporteHistorialDePrestamos(String Usuario) {
        reportesDAO.ReporteHistorialDePrestamosFiltrado(Usuario);
    }

    public void ReporteDeMvimientos(String documento, String usuario) {
        reportesDAO.ReporteDeMvimientos(documento, usuario);
    }

}
