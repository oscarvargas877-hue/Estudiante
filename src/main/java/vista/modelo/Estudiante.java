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
        
        // INICIO DEL BLOQUE DE EXCEPCIONES 
        // Este bloque 'try' intenta ejecutar código que PUEDE fallar
        try {

            // Convertir edad de texto a número
            // Si 'edad' es "20", parseInt devuelve el número 20
            // Si 'edad' es "abc", parseInt falla y lanza un error
            int edadNumerica = Integer.parseInt(edad);

            // Validamos que la edad esté entre 0 y 120
            if (edadNumerica >= 0 && edadNumerica <= 120) {
                // Si está bien, guardamos la edad original como texto
                this.edad = edad;
            } else {
                // Si es mayor a 120 o negativa, no es válida
                this.edad = "Dato no válido"; // Ponemos un valor por defecto
                System.out.println("Error: La edad debe ser entre 0 y 120: " + edad); // Mostramos mensaje
            }

        } catch (NumberFormatException error) {
            // Este bloque 'catch' se ejecuta SIEMPRE que ocurra un error del tipo 'NumberFormatException'
            // Es decir, si parseInt falla porque 'edad' no era un número
            this.edad = "Dato no válido"; // Ponemos un valor por defecto
            // Mostramos un mensaje de error con el valor que causó el problema
            System.out.println("Error: La edad debe ser un número, recibimos: " + edad);
        }
        // FIN DEL BLOQUE DE EXCEPCIONES 
        
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
       //  INICIO DEL BLOQUE DE EXCEPCIONES EN SETTER
        // Este bloque 'try' intenta ejecutar código que PUEDE fallar
        try {

            // Convertir a número
            // Si 'edad' es "25", parseInt devuelve el número 25
            // Si 'edad' es "treinta", parseInt falla y lanza un error
            int edadNumerica = Integer.parseInt(edad);

            // Validar rango
            if (edadNumerica >= 0 && edadNumerica <= 120) {
                // Si está bien, guardamos la edad original como texto
                this.edad = edad;
                System.out.println("Edad actualizada correctamente: " + edad); // Mensaje de éxito
            } else {
                // Si no está en el rango, mostramos un mensaje de error
                System.out.println("Error: La edad debe estar entre 0 y 120: " + edad);
            }

        } catch (NumberFormatException error) {
            // Este bloque 'catch' se ejecuta SIEMPRE que ocurra un error del tipo 'NumberFormatException'
            // Es decir, si parseInt falla porque 'edad' no era un número
            System.out.println("Error: Debes ingresar un número, no texto: " + edad);
        }
        // FIN DEL BLOQUE DE EXCEPCIONES EN SETTER 
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
