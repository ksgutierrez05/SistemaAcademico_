/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Main {

    ArrayList<Object> listaest = new ArrayList<>();
    ArrayList<Object> listaasig = new ArrayList<>();
    ArrayList<Object> listanota = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "====== SISTEMA ACADÉMICO ======\n"
                    + "1. Gestión Estudiantes\n"
                    + "2. Gestión Asignaturas\n"
                    + "3. Gestión Notas\n"
                    + "4. Salir\n"
                    + "Elija su opción..."));

            switch (op) {
                case 1:    //menuEstudiantes();
                    break;
                case 2:    //menuAsignaturas();
                    break;
                case 3:    //menuNotas();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera de rango...");
            }

        } while (op != 4);
        

    }
    
     public static void menuEstudiantes() {
        int op;
        
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "====== GESTIÓN ESTUDIANTES ======\n"
                    + "1. Registrar nuevo estudiante\n"
                    + "2. Consultar lista de estudiantes\n"
                    + "3. Buscar estudiante por codigo\n"
                    + "4. Modificar datos de un estudiante\n"
                    + "5. Eliminar estudiante\n"
                    + "6. Volver a menú principal\n"
                    + "Elija su opción..."));

            switch (op) {
                case 1:   //registrarEstudiante();
                    break;
                case 2:   //listarEstudiantes();
                    break;
                case 3:   //buscarEstudiante();
                    break;
                case 4:   //actualizarEstudiante();
                    break;
                case 5:   //eliminarEstudiante();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera de rango...");
            }

        } while (op != 6);


    }
    
    
}
