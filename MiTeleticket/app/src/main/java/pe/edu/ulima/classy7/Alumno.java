package pe.edu.ulima.classy7;

import java.io.Serializable;

/**
 * Created by sodm on 07/05/2015.
 */
public class Alumno implements Serializable {
    private int id;
    private String codigo;
    private String nombre;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
