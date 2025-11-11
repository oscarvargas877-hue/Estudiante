/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

import javax.swing.UIManager;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
//    Persona persona1 = new Persona("Lucas","soltero", true);
//        System.out.println(persona1.toString());

    //Estudiante.getIdEstudiante();
    //System.out.println("----" + Estudiante.idEstudiante);
//    System.out.println("----" + Estudiante.getIdEstudiante());
//    System.out.println("\n");
//
//    Estudiante estudiante1 = new Estudiante("Mayra","20","ma@gmail.com",true);
//    System.out.println(estudiante1.toString());
//    
//    System.out.println("\n");
//    Estudiante e1 = new Estudiante();
//    e1.setNombre("Oscar");
//    e1.toString();
//    System.out.println("###" + e1.toString());


        //  EXCEPCIONES EN MAIN
        // Vamos a probar crear estudiantes con diferentes valores de edad
        // para ver cómo se comportan las excepciones

        // Prueba 1: Edad correcta (20)
        System.out.println("===  Edad válida ===");
        // Creamos un estudiante con edad válida
        // El bloque try-catch en el constructor NO se activa porque "20" es un número válido
        Estudiante e1 = new Estudiante("Mayra", "20", "may@gmail.com", true);
        System.out.println( e1.getEdad()); // Imprime "20"
        System.out.println("\n");

        // Prueba 2: Edad con letras (veinte)
        System.out.println("=== Edad con letras ===");
        // Creamos un estudiante con edad inválida (letras)
        // El bloque try-catch en el constructor SÍ se activa porque "veinte" no es un número
        Estudiante e2 = new Estudiante("Renato", "veinte", "re@gmail.com", false);
        System.out.println(e2.getEdad()); // Imprime "Dato no válido" porque el catch la cambió
        System.out.println("\n");

        // Prueba 3: Edad muy grande (150)
        System.out.println("=== Edad muy grande ===");
        // Creamos un estudiante con edad inválida (fuera de rango)
        // El bloque try-catch en el constructor SÍ se activa porque 150 > 120
        Estudiante e3 = new Estudiante("Carlos", "150", "carlos@gmail.com", true);
        System.out.println(e3.getEdad()); // Imprime "Dato no válido" porque el if la cambió
        System.out.println("\n");

        // Prueba 4: Cambiar edad con texto
        System.out.println("===  Cambiar edad con texto ===");
        // Creamos un estudiante con edad válida
        Estudiante e4 = new Estudiante("Perla", "22", "pe@gmail.com", false);
        // Intentamos cambiar la edad a texto inválido
        // El bloque try-catch en el setter SÍ se activa porque "treinta" no es un número
        e4.setEdad("treinta");
        System.out.println("\n");

        // Prueba 5: Edad negativa (-5)
        System.out.println("===  Edad negativa ===");
        // Creamos un estudiante con edad inválida (negativa)
        // El bloque try-catch en el constructor SÍ se activa porque -5 < 0
        Estudiante e5 = new Estudiante("Paco", "-5", "pa@gmail.com", true);
        System.out.println(e5.getEdad()); // Imprime "Dato no válido" porque el if la cambió
        
    }
    
}
