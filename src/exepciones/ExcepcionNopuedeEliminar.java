/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author JFGIR
 */
public class ExcepcionNopuedeEliminar extends  RuntimeException{

    public ExcepcionNopuedeEliminar() {
        
        super("\n NO FUE POSIBLE ELIMINARLA "+" HAY LIBROS QUE ESTAN REGISTRADOS CON ESTA CATEGORIA ");
    }
    
    
    
}
