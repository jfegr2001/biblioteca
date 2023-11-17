/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author JFGIR
 */
public class ExcepcionDocumentoDuplicado extends RuntimeException{

    public ExcepcionDocumentoDuplicado() {
        super("EL DOCUMENTO QUE ESTA INGRESANDO YA ESTA REGISTRADO");
    }
    
    
    
    
}
