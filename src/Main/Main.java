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
        return "Codigo: " + codigo +
               ", Nombre: " + nombre +
               ", Apellido: " + apellido +
               ", Programa: " + programa +
               ", Semestre: " + semestre +
               ", Edad: " + edad;
    }
}
class asignatura{
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

class Nota{
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