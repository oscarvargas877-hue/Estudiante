/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
    Persona persona1 = new Persona("Lucas","soltero", true);
        System.out.println(persona1.toString());
        System.out.println("\n");
        
    Estudiante estudiante1 = new Estudiante("Marco","20","ma@gmail.com",true);
        System.out.println(estudiante1.toString());
    }
    
}
