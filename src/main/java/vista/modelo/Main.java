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
    Persona persona1 = new Persona("Lucas","soltero", true);
        System.out.println(persona1.toString());

        //Estudiante.getIdEstudiante();
        //System.out.println("----" + Estudiante.idEstudiante);
        System.out.println("----" + Estudiante.getIdEstudiante());
        System.out.println("\n");
        
    Estudiante estudiante1 = new Estudiante("Mayra","20","ma@gmail.com",true);
    System.out.println(estudiante1.toString());
    
    System.out.println("\n");
    Estudiante e1 = new Estudiante();
    e1.setNombre("Oscar");
    e1.toString();
    System.out.println("###" + e1.toString());
   
        
    }
    
}
