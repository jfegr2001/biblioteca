/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JFGIR
 */
public class Movimientos {

    private String codigo_usuario;
    private String tipo_movimiento;
    private String hora;
    private String fecha;

    public Movimientos(String codigo_usuario, String tipo_movimiento, String hora, String fecha) {
        this.codigo_usuario = codigo_usuario;
        this.tipo_movimiento = tipo_movimiento;
        this.hora = hora;
        this.fecha = fecha;
    }

    public Movimientos(String codigo_usuario, String tipo_movimiento) {
        this.codigo_usuario = codigo_usuario;
        this.tipo_movimiento = tipo_movimiento;
    }

    public Movimientos(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    

}
