package pe.edu.ulima.classy7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sodm on 07/05/2015.
 */
public class GestorAlumnos {

    public static GestorAlumnos gestor = null;

    private List<Alumno> lAlumnos;

    public static GestorAlumnos getInstance() {
        if (gestor == null) {
            gestor = new GestorAlumnos();
        }

        return gestor;
    }

    private GestorAlumnos() {
    }

    public boolean registrar(Alumno alumno) {
        if (lAlumnos == null) {
            lAlumnos = new ArrayList<Alumno>();
        }

        try {
            Integer.parseInt(alumno.getCodigo());
        } catch (Exception e) {
            return false;
        }
        lAlumnos.add(alumno);
        return true;
    }

    public Alumno login(String codigo, String password) {
        Alumno alumnoEncontrado = null;

        for (Alumno alumno : lAlumnos) {
            if (alumno.getCodigo().equals(codigo) && alumno.getPassword().equals(password)) {
                alumnoEncontrado = alumno;
                break;
            }
        }

        return alumnoEncontrado;

    }
}