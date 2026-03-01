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

    ArrayList<Estudiante> listaest = new ArrayList<>();
    ArrayList<Object> listaasig = new ArrayList<>();
    ArrayList<Object> listanota = new ArrayList<>();

    public void main(String[] args) {

        mostrarMenu();
    }

    private void mostrarMenu() {
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
                case 1:
                    menuEstudiantes();
                    break;
                case 2:
                    menuAsignaturas();
                    break;
                case 3:
                    menuNotas();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera de rango...");
            }

        } while (op != 4);

    }

    public void menuEstudiantes() {
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
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    listarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    //actualizarEstudiante();
                    break;
                case 5:
                    //eliminarEstudiante();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera de rango...");
            }

        } while (op != 6);

    }

    //OPCIONES DE MENU ESTUDIANTE
    public void registrarEstudiante() {
        String cod, ape, nom, prog;
        int seleccion, sem, edad;

        do {

            try {
                cod = JOptionPane.showInputDialog("Ingrese el código del estudiante:");
                boolean encontrado = false;

                for (Estudiante e : listaest) {
                    if (e.getCodigo().equalsIgnoreCase(cod)) {
                        encontrado = true;
                        break;
                    }
                }

                if (encontrado) {
                    JOptionPane.showMessageDialog(null,
                            "El código ya está registrado");
                } else {

                    nom = JOptionPane.showInputDialog("Ingrese el nombre:");
                    ape = JOptionPane.showInputDialog("Ingrese el apellido:");
                    prog = JOptionPane.showInputDialog("Ingrese el programa:");

                    if (cod == null || cod.trim().isEmpty()
                            || nom == null || nom.trim().isEmpty()
                            || ape == null || ape.trim().isEmpty()
                            || prog == null || prog.trim().isEmpty()) {

                        JOptionPane.showMessageDialog(null,
                                "Todos los campos son obligatorios");

                    } else {

                        sem = Integer.parseInt(
                                JOptionPane.showInputDialog("Ingrese el semestre:")
                        );

                        edad = Integer.parseInt(
                                JOptionPane.showInputDialog("Ingrese la edad:")
                        );

                        Estudiante estu = new Estudiante(cod, nom, ape, prog, sem, edad);
                        listaest.add(estu);

                        JOptionPane.showMessageDialog(null,
                                "Estudiante agregado correctamente");
                    }
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,
                        "Debe ingresar valores numéricos válidos");
            }

            seleccion = JOptionPane.showConfirmDialog(null,
                    "¿Desea seguir agregando?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION);

        } while (seleccion == JOptionPane.YES_OPTION);
    }

    public void listarEstudiantes() {
        StringBuilder lista = new StringBuilder();

        lista.append("LISTA DE ESTUDIANTES:");

        for (Estudiante estu : listaest) {
            lista.append("\n" + estu.toString());
            lista.append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void buscarEstudiante() {
        String cod;
        boolean encontrado = false;
        cod = JOptionPane.showInputDialog("Ingrese el código del estudiante: ");
        for (Estudiante estu : listaest) {
            if (estu.getCodigo().equalsIgnoreCase(cod)) {

                JOptionPane.showMessageDialog(null,
                        "Estudiante encontrado:\n" + estu.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null,
                    "Estudiante no encontrado");
        }

    }
    
     
     public void menuAsignaturas() {
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "====== GESTIÓN ASIGNATURAS ======\n"
                    + "1. Registrar nueva asignaturas\n"
                    + "2. Consultar lista de asignaturas registradas\n"
                    + "3. Buscar asignatura por codigo\n"
                    + "4. Modificar datos de una asignatura\n"
                    + "5. Eliminar asignatura\n"
                    + "6. Volver a menú principal\n"
                    + "Elija su opción..."));

            switch (op) {
                case 1:   //registrarAsignatura();
                    break;
                case 2:   //listarAsignaturas();
                    break;
                case 3:   //buscarAsignatura();
                    break;
                case 4:   //actualizarAsignatura();
                    break;
                case 5:   //eliminarAsignatura();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera de rango...");
            }

        } while (op != 6);

    }

    public void menuNotas() {
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "====== GESTIÓN NOTAS ======\n"
                    + "1. Registrar nueva nota\n"
                    + "2. Consultar lista de notas registradas\n"
                    + "3. Buscar nota por codigo de estudiante\n"
                    + "4. Modificar datos de una asignatura\n"
                    + "5. Eliminar asignatura\n"
                    + "6. Volver a menú principal\n"
                    + "Elija su opción..."));

            switch (op) {
                case 1:   //registrarNotas();
                    break;
                case 2:   //listarNotas();
                    break;
                case 3:   //buscarNotas();
                    break;
                case 4:   //actualizarNotas();
                    break;
                case 5:   //eliminarNotas();
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

class Estudiante {

    private String codigo;
    private String nombre;
    private String apellido;
    private String programa;
    private int semestre;
    private int edad;

    public Estudiante(String codigo, String nombre, String apellido, String programa, int semestre, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.programa = programa;
        this.semestre = semestre;
        this.edad = edad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + ", Nombre: " + nombre
                + ", Apellido: " + apellido
                + ", Programa: " + programa
                + ", Semestre: " + semestre
                + ", Edad: " + edad;
    }
}

class asignatura {

    private String codigo;
    private String nombre;
    private int creditos;
    private String docente;

    public asignatura() {
    }

    public asignatura(String codigo, String nombre, int creditos, String docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "asignatura{" + "codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + ", docente=" + docente + '}';
    }

}

class Nota {

    private double Nota1;
    private double Nota2;
    private double Nota3;
    private String periodo;
    private double promedio;

    public void calcularpromedio() {
        promedio = (double) (Nota1 * 0.3 + Nota2 * 0.3 + Nota3 * 0.4);

    }

    public Nota() {
    }

    public Nota(double Nota1, double Nota2, double Nota3, String periodo, double promedio) {
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
        this.periodo = periodo;
        this.promedio = promedio;
    }

    public double getNota1() {
        return Nota1;
    }

    public void setNota1(double Nota1) {
        this.Nota1 = Nota1;
    }

    public double getNota2() {
        return Nota2;
    }

    public void setNota2(double Nota2) {
        this.Nota2 = Nota2;
    }

    public double getNota3() {
        return Nota3;
    }

    public void setNota3(double Nota3) {
        this.Nota3 = Nota3;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Nota{" + "Nota1=" + Nota1 + ", Nota2=" + Nota2 + ", Nota3=" + Nota3 + ", periodo=" + periodo + ", promedio=" + promedio + '}';
    }

}
