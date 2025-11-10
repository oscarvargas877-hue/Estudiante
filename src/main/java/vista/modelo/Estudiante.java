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
    private static int idEstudiante=100;
    private final int id;
    private String nombre;
    private String edad;
    private String correo;
    private boolean genero;
    private static String carrera= "Tecnologia Superior en desarrollo de software";

    
    public static String getCarrera() {
        return carrera;
    }

    public Estudiante() {
        this.id=idEstudiante ++;
        getCarrera();
    }
    
    

    public Estudiante( String nombre, String edad ,String correo, boolean genero) {
        this.id=idEstudiante++;
        this.nombre = nombre;
        this.edad = edad;
        this.correo=correo;
        this.genero=genero;
        
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

    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public static int getIdEstudiante() {
        return idEstudiante;
    }

    public boolean isGenero() {
        return genero;
    }
    // Método para obtener el ID del estudiante
    public int getId() {
        return id;
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
    
    

    
    //Imprimir en pantalla

    @Override
    public String toString() {
        return "Datos del estudiante" +"\n"+
                "Id estudiante: " + id+"\n"+
                "Nombre: " + nombre+"\n"+
                "Edad: " + edad +"\n"+
                "Correo: "+ correo +"\n"+
                "Carrera: "+ carrera +"\n"+
                "Género: " +  ValidarGenero();
    }
    
    
    
}
