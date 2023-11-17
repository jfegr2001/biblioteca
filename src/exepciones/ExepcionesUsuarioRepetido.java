/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author felipe
 */
public class ExepcionesUsuarioRepetido extends RuntimeException{

    public ExepcionesUsuarioRepetido() {
        super("EL USUARIO QUE ESTA INGRESANDO YA ESTA REGISTRADO");
    }
    
}
