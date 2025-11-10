/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

/**
 *
 * @author Usuario
 */
public class Persona {
    //Atributos
    private String nombre;
    private String estadoCivil;
    private boolean genero;
    
//constructor vacio
    public Persona() {
    }
//constructor completo
    public Persona(String nombre, String estadoCivil, boolean genero) {
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
    }
//metodos set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    // metodo de logica
    //validar el genero
    public String ValidarGenero(){
        if(genero == true){
            return "Masculino";
        }else{
            return "Femenino";
        }
    
    }

    //imprimir en pantalla

    @Override
    public String toString() {
        return "Datos Personales" + "\n "+
                "nombre: "+ nombre + "\n "+
                "Estado Civil: " + estadoCivil+ "\n "+
                "Genero: "+ ValidarGenero();
    }
    
    
    
    
}
