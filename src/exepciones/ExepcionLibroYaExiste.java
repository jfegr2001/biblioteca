/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

/**
 *
 * @author JFGIR
 */
public class ExepcionLibroYaExiste  extends  RuntimeException{

    public ExepcionLibroYaExiste() {
        super("YA EXISTE UN LIBRO CON ESE CODIGO");
    }
    
}
