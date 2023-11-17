/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author felipe
 */
public class Libro {
    
     private String codigo;
     private String titulo;
     private String categoria;
     private String autor;
     private String añoDepublicacion;
     private int numeroDeCopias;

    

    public Libro(String codigo, String titulo, String categoria, String autor, String añoDepublicacion, int numeroDeCopias) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.añoDepublicacion = añoDepublicacion;
        this.numeroDeCopias = numeroDeCopias;
    }

    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


  
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAñoDepublicacion() {
        return añoDepublicacion;
    }

    public void setAñoDepublicacion(String añoDepublicacion) {
        this.añoDepublicacion = añoDepublicacion;
    }

  

  

    public int getNumeroDeCopias() {
        return numeroDeCopias;
    }

    public void setNumeroDeCopias(int numeroDeCopias) {
        this.numeroDeCopias = numeroDeCopias;
    }
     
    
    
     
    
    
    
    
}
