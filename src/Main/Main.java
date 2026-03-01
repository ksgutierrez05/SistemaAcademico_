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
    ArrayList<asignatura> listaasig = new ArrayList<>();
    ArrayList<Nota> listanota = new ArrayList<>();

    //OPCIONES DE MENU NOTA
    //regsitrar nota
    public void registrarNota() {
        int seleccion;
        if (listaest.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay estudiantes registrados.");
            return;
        }

        if (listaasig.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay asignaturas registradas.");
            return;
        }
        do {
            String codEst = JOptionPane.showInputDialog("Ingrese código del estudiante:");
            if (codEst == null || codEst.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código no puede estar vacío.");
                return;
            }

            String codAsig = JOptionPane.showInputDialog("Ingrese código de la asignatura:");
            if (codAsig == null || codAsig.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código no puede estar vacío.");
                return;
            }
            String periodo = JOptionPane.showInputDialog("Ingrese el periodo");
            if (periodo == null || periodo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El periodo no puede estar vacío.");
                return;
            }
            double Nota1, Nota2, Nota3;
            try {
                Nota1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota 1"));
                Nota2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota 2"));
                Nota3 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota 3"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Debe ingresar valores numéricos válidos.");
                return;

            }

            Estudiante estudianteEncontrado = null;
            for (Estudiante e : listaest) {
                if (e.getCodigo().equals(codEst)) {
                    estudianteEncontrado = e;
                    break;
                }

            }
            asignatura asignaturaencon = null;
            for (asignatura a : listaasig) {
                if (a.getCodigo().equals(codAsig)) {
                    asignaturaencon = a;
                    break;

                }

            }

            if (estudianteEncontrado == null || asignaturaencon == null) {
                JOptionPane.showMessageDialog(null, "Estudiante o asignatura no encontrados");
                return;
            } else {
                boolean existe = false;

                for (Nota n : listanota) {
                    if (n.getEstudiante().getCodigo().equalsIgnoreCase(codEst)
                            && n.getAsignatura().getCodigo().equalsIgnoreCase(codAsig)
                            && n.getPeriodo().equalsIgnoreCase(periodo)) {
                        existe = true;

                        break;
                    }
                }
                if (existe) {

                    JOptionPane.showMessageDialog(null,
                            "Ya existe una nota registrada para ese estudiante, asignatura y periodo.");

                } else {
                    Nota nueva = new Nota();
                    nueva.setEstudiante(estudianteEncontrado);
                    nueva.setAsignatura(asignaturaencon);
                    nueva.setNota1(Nota1);
                    nueva.setNota2(Nota2);
                    nueva.setNota3(Nota3);
                    nueva.setPeriodo(periodo);
                    nueva.calcularpromedio();

                    listanota.add(nueva);

                    JOptionPane.showMessageDialog(null, "Nota registrada correctamente");
                }

                seleccion = JOptionPane.showConfirmDialog(null,
                        "¿Desea seguir agregando?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);
            }
        } while (seleccion == JOptionPane.YES_OPTION);
    }
    //listarnota

    public void listarNotas() {
        if (listanota.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay notas registradas.");
            return;

        }
        StringBuilder lista = new StringBuilder();

        lista.append("LISTADO DE NOTAS :");

        for (Nota n : listanota) {
            lista.append("\n" + n.toString());
            lista.append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());

    }

    public void buscarNota() {
        if (listanota.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay notas registradas.");
            return;
        } else {
            String codEst = JOptionPane.showInputDialog("Ingrese el código del estudiante:");
            String codAsig = JOptionPane.showInputDialog("Ingrese el código de la asignatura:");
            String periodo = JOptionPane.showInputDialog("Ingrese el periodo:");
            boolean encontrado = false;
            for (Nota n : listanota) {
                if (n.getEstudiante().getCodigo().equalsIgnoreCase(codEst)
                        && n.getAsignatura().getCodigo().equalsIgnoreCase(codAsig)
                        && n.getPeriodo().equalsIgnoreCase(periodo)) {

                    JOptionPane.showMessageDialog(null,
                            "Nota encontrada:\n" + n.toString());

                    encontrado = true;
                    break;
                }

            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null,
                        "Notas  no encontrada");
            }

        }

    }
//actualizarnotas

    public void actualizarNota() {
        if (listanota.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay notas registradas.");
            return;
        }

        String codEst = JOptionPane.showInputDialog(
                "Ingrese el código del estudiante:");

        String codAsig = JOptionPane.showInputDialog(
                "Ingrese el código de la asignatura:");

        String periodo = JOptionPane.showInputDialog(
                "Ingrese el periodo:");

        for (Nota n : listanota) {

            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codEst)
                    && n.getAsignatura().getCodigo().equalsIgnoreCase(codAsig)
                    && n.getPeriodo().equalsIgnoreCase(periodo)) {

                JOptionPane.showMessageDialog(null,
                        "Nota encontrada:\n" + n.toString());

                double n1, n2, n3;

                try {

                    n1 = Double.parseDouble(
                            JOptionPane.showInputDialog("Nueva Nota 1:", n.getNota1()));

                    n2 = Double.parseDouble(
                            JOptionPane.showInputDialog("Nueva Nota 2:", n.getNota2()));

                    n3 = Double.parseDouble(
                            JOptionPane.showInputDialog("Nueva Nota 3:", n.getNota3()));

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debe ingresar valores numéricos válidos.");
                    return;
                }

                n.setNota1(n1);
                n.setNota2(n2);
                n.setNota3(n3);
                n.calcularpromedio();

                JOptionPane.showMessageDialog(null,
                        "Nota actualizada correctamente.\nNuevo promedio: "
                        + n.getPromedio());

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Nota no encontrada.");

    }
//eliminar notas

    public void eliminarNota() {
        if (listanota.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay notas registradas.");
            return;
        }

        String codEst = JOptionPane.showInputDialog(
                "Ingrese el código del estudiante :");

        String codAsig = JOptionPane.showInputDialog(
                "Ingrese el código de la asignatura:");

        String periodo = JOptionPane.showInputDialog(
                "Ingrese el periodo:");
        boolean encontrado = false;
        for (Nota n : listanota) {
            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codEst)
                    && n.getAsignatura().getCodigo().equalsIgnoreCase(codAsig)
                    && n.getPeriodo().equalsIgnoreCase(periodo)) {

                JOptionPane.showMessageDialog(null,
                        "Nota encontrada:\n" + n.toString());

                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea eliminar esta nota?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    listanota.remove(n);
                    JOptionPane.showMessageDialog(null,
                            "Nota eliminada correctamente.");
                }

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null,
                    "Nota no encontrada.");
        }

    }

    
  
    
    
   public void registrarAsignatura() {

    String codigo, nombre, docente, inputCreditos;
    int creditos, seleccion;

    do {
        try {

            do {

                codigo = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura:  ");
                nombre = JOptionPane.showInputDialog("Ingrese el nombre:  ");
                inputCreditos = JOptionPane.showInputDialog("Ingrese los creditos:  ");
                docente = JOptionPane.showInputDialog("Ingrese el docente:  ");

                if (codigo == null || codigo.trim().isEmpty()
                        || nombre == null || nombre.trim().isEmpty()
                        || inputCreditos == null || inputCreditos.trim().isEmpty()
                        || docente == null || docente.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null,
                            "Todos los campos son obligatorios");

                }

            } while (codigo == null || codigo.trim().isEmpty()
                    || nombre == null || nombre.trim().isEmpty()
                    || inputCreditos == null || inputCreditos.trim().isEmpty()
                    || docente == null || docente.trim().isEmpty());

            creditos = Integer.parseInt(inputCreditos);

            if (creditos <= 0 || creditos > 171) {
                JOptionPane.showMessageDialog(null,
                        "Los creditos deben estar entre 1 y 171");
            } else {

                for (asignatura e : listaasig) {
                     if (e.getCodigo().equalsIgnoreCase(codigo)) {
                        JOptionPane.showMessageDialog(null,
                        "Ya existe una asignatura con ese codigo");
                        return;
    }
}

                asignatura nueva = new asignatura(codigo, nombre, creditos, docente);
                listaasig.add(nueva);

                JOptionPane.showMessageDialog(null, "Asignatura agregada");
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null,
                    "Error: Debe ingresar un numero valido en creditos",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

        seleccion = JOptionPane.showConfirmDialog(null,
                "¿DESEA SEGUIR AGREGANDO?",
                "CONFIRMAR",
                JOptionPane.YES_NO_OPTION);

    } while (seleccion == JOptionPane.YES_OPTION);
}

public void listarAsignaturas() {

   if (listaasig.isEmpty()) {  
            JOptionPane.showMessageDialog(null,
                "No hay asignaturas registrados");
        return; 
    }
    StringBuilder texto = new StringBuilder();

        for (asignatura e : listaasig) {
            texto.append("Codigo: ").append(e.getCodigo())
         .append("\nNombre: ").append(e.getNombre())
         .append("\nCreditos: ").append(e.getCreditos())
         .append("\nDocente: ").append(e.getDocente())
         .append("\n--------------------\n");
}

JOptionPane.showMessageDialog(null, texto.toString());
}
public void buscarAsignatura() {

    String codigoBuscar;

    codigoBuscar = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura:");

    for (asignatura e : listaasig) {

        if (e.getCodigo().equalsIgnoreCase(codigoBuscar)) {

            JOptionPane.showMessageDialog(null,
                    "Codigo: " + e.getCodigo() +
                    "\nNombre: " + e.getNombre() +
                    "\nCreditos: " + e.getCreditos() +
                    "\nDocente: " + e.getDocente());

            return;
        }
    }

    JOptionPane.showMessageDialog(null,
            "No existe una asignatura con ese codigo");
}

public void actualizarAsignatura() {

    String codigoActualizar, nuevoNombre, nuevoDocente, inputCreditos;
    int nuevosCreditos, seleccion;

    do {
        try {

            codigoActualizar = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura a actualizar:");

            for (asignatura e : listaasig) {

                if (e.getCodigo().equalsIgnoreCase(codigoActualizar)) {

                    nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                    inputCreditos = JOptionPane.showInputDialog("Ingrese los nuevos creditos:");
                    nuevoDocente = JOptionPane.showInputDialog("Ingrese el nuevo docente:");

                    nuevosCreditos = Integer.parseInt(inputCreditos);

                    if (nuevosCreditos <= 0 || nuevosCreditos > 171) {
                        JOptionPane.showMessageDialog(null,
                                "Los creditos deben estar entre 1 y 171");
                    } else {

                        e.setNombre(nuevoNombre);
                        e.setCreditos(nuevosCreditos);
                        e.setDocente(nuevoDocente);

                        JOptionPane.showMessageDialog(null, "Asignatura actualizada");
                    }

                    seleccion = JOptionPane.showConfirmDialog(null,
                            "¿DESEA SEGUIR ACTUALIZANDO?",
                            "CONFIRMAR",
                            JOptionPane.YES_NO_OPTION);

                    if (seleccion == JOptionPane.YES_OPTION) {
                        actualizarAsignatura();
                    }

                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "No existe una asignatura con ese codigo");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null,
                    "Error: Debe ingresar un numero valido en creditos",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

        seleccion = JOptionPane.showConfirmDialog(null,
                "¿DESEA SEGUIR ACTUALIZANDO?",
                "CONFIRMAR",
                JOptionPane.YES_NO_OPTION);

    } while (seleccion == JOptionPane.YES_OPTION);
}
     public void eliminarAsignatura() {

    String codigoEliminar;
    int seleccion;

    do {

        codigoEliminar = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura a eliminar:");

        for (asignatura e : listaasig) {

            if (e.getCodigo().equalsIgnoreCase(codigoEliminar)) {

                seleccion = JOptionPane.showConfirmDialog(null,
                        "¿Esta seguro que desea eliminar la asignatura?\n"
                        + "Codigo: " + e.getCodigo()
                        + "\nNombre: " + e.getNombre()
                        + "\nCreditos: " + e.getCreditos()
                        + "\nDocente: " + e.getDocente(),
                        "CONFIRMAR",
                        JOptionPane.YES_NO_OPTION);

                if (seleccion == JOptionPane.YES_OPTION) {
                    listaasig.remove(e);
                    JOptionPane.showMessageDialog(null, "Asignatura eliminada");
                }

                seleccion = JOptionPane.showConfirmDialog(null,
                        "¿DESEA SEGUIR ELIMINANDO?",
                        "CONFIRMAR",
                        JOptionPane.YES_NO_OPTION);

                if (seleccion == JOptionPane.YES_OPTION) {
                    eliminarAsignatura();
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "No existe una asignatura con ese codigo");

        seleccion = JOptionPane.showConfirmDialog(null,
                "¿DESEA SEGUIR ELIMINANDO?",
                "CONFIRMAR",
                JOptionPane.YES_NO_OPTION);

    } while (seleccion == JOptionPane.YES_OPTION);
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
        return "----- ASIGNATURA -----\n"
                + "Código: " + codigo + "\n"
                + "Nombre: " + nombre + "\n"
                + "Créditos: " + creditos + "\n"
                + "Docente: " + docente + "\n"
                + "-------------------------";
    }

}

class Nota {

    private Estudiante estudiante;
    private asignatura Asignatura;
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

    public Nota(Estudiante estudiante, asignatura Asignatura, double Nota1, double Nota2, double Nota3, String periodo, double promedio) {
        this.estudiante = estudiante;
        this.Asignatura = Asignatura;
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
        this.periodo = periodo;
        this.promedio = promedio;
    }

    public asignatura getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(asignatura Asignatura) {
        this.Asignatura = Asignatura;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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
        return "----- NOTA -----\n"
                + "Estudiante: " + estudiante + "\n"
                + "Asignatura: " + Asignatura + "\n"
                + "Nota 1: " + Nota1 + "\n"
                + "Nota 2: " + Nota2 + "\n"
                + "Nota 3: " + Nota3 + "\n"
                + "Periodo: " + periodo + "\n"
                + "Promedio: " + promedio + "\n"
                + "--------------------";
    }

}
