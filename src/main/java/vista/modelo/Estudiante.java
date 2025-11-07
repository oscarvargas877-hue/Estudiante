/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

/**
 *
 * @author Usuario
 */
public class Estudiante {
    private String nombre;
    private String edad;
    private String correo;

    public Estudiante(String nombre, String edad ,String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo=correo;
    }
    
    //metodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void imprimir(){
        System.out.println("nombre: "+ nombre + " edad: "+edad + " Correo: " + correo);
    
    }
    
    
}
