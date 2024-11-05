package APIindira;

import java.io.*;
import java.util.*;

public class Cartelera {
    private List<Pelicula> peliculas;

    public Cartelera() {
        peliculas = new ArrayList<>();
        cargarPeliculasDesdeArchivo("pelis.dat");
        if (peliculas.isEmpty()) {
            agregarPeliculaConHorarios("Batman", "Acción", 155, "Un superhéroe lucha contra el crimen.",
                new Horario("15:00", 1), new Horario("18:00", 1));
            agregarPeliculaConHorarios("Toy Story", "Animación", 81, "Los juguetes cobran vida.",
                new Horario("14:00", 2), new Horario("16:30", 2));
            agregarPeliculaConHorarios("Blancanieves", "Cuento", 83, "Una princesa y siete enanitos.",
                new Horario("10:00", 3), new Horario("12:30", 3));
            agregarPeliculaConHorarios("Titanes del Pacífico", "Ciencia Ficción", 131, "Guerra entre humanos y monstruos.",
                new Horario("20:00", 1), new Horario("22:30", 1));
            agregarPeliculaConHorarios("King Kong", "Aventura", 100, "Un gorila gigante en Nueva York.",
                new Horario("17:00", 2), new Horario("19:30", 2));
        }
    }

    public void agregarPeliculaConHorarios(String nombre, String genero, int duracion, String descripcion, Horario h1, Horario h2) {
        Pelicula pelicula = new Pelicula(nombre, genero, duracion, descripcion);
        pelicula.agregarHorario(h1);
        pelicula.agregarHorario(h2);
        peliculas.add(pelicula);
        guardarPeliculasEnArchivo("pelis.dat");
    }

    public void eliminarPelicula(String nombre) {
        peliculas.removeIf(pelicula -> pelicula.getNombre().equalsIgnoreCase(nombre));
        guardarPeliculasEnArchivo("pelis.dat");
    }

    public void modificarPelicula(String nombre, Pelicula nuevaPelicula) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                peliculas.set(i, nuevaPelicula);
                break;
            }
        }
        guardarPeliculasEnArchivo("pelis.dat");
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @SuppressWarnings("unchecked")
    private void cargarPeliculasDesdeArchivo(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            peliculas = (List<Pelicula>) ois.readObject();
        } catch (FileNotFoundException e) {
            // El archivo no existe, no hay problema
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarPeliculasEnArchivo(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(peliculas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}