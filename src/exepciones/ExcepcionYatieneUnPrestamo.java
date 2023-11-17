/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author JFGIR
 */
public class ExcepcionYatieneUnPrestamo  extends  RuntimeException{

    public ExcepcionYatieneUnPrestamo() {
        super(" YA TIENES UN LIBRO PRESTADO"+"\n DEVUELVE EL LIBRO Y PRESTAS OTRO LIBRO");
    }
    
}
