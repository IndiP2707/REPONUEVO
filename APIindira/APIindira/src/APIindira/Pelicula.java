package APIindira;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String genero;
    private int duracion; // en minutos
    private String descripcion;
    private List<Horario> horarios; // Lista de horarios para la película

    public Pelicula(String nombre, String genero, int duracion, String descripcion) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.horarios = new ArrayList<>();
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }
    public String getDescripcion() { return descripcion; }
    public List<Horario> getHorarios() { return horarios; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setHorarios(List<Horario> horarios) { this.horarios = horarios; }

    // Agregar horario
    public void agregarHorario(Horario horario) {
        horarios.add(horario);
    }

    // Eliminar horario
    public void eliminarHorario(Horario horario) {
        horarios.remove(horario);
    }

    @Override
    public String toString() {
        return nombre + " (" + genero + ", " + duracion + " mins)";
    }
}