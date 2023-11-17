/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author felipe
 */
public class Prestamo {
 
    private String documentoUsuario;
    private String CodigoLibro;
    private String fechaDePrestamo;
    private String fechaVencimiento;

    public Prestamo(String documentoUsuario, String CodigoLibro, String fechaDePrestamo, String fechaVencimiento) {
        this.documentoUsuario = documentoUsuario;
        this.CodigoLibro = CodigoLibro;
        this.fechaDePrestamo = fechaDePrestamo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getCodigoLibro() {
        return CodigoLibro;
    }

    public void setCodigoLibro(String CodigoLibro) {
        this.CodigoLibro = CodigoLibro;
    }

    public String getFechaDePrestamo() {
        return fechaDePrestamo;
    }

    public void setFechaDePrestamo(String fechaDePrestamo) {
        this.fechaDePrestamo = fechaDePrestamo;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    
    
    
}
