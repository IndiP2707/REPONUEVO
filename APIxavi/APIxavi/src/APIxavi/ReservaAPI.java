package APIxavi;

import java.io.*;
import java.util.ArrayList;

public class ReservaAPI implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        guardarReservas("data/reservas.dat"); // Guardar automáticamente después de agregar
    }

    public ArrayList<Reserva> getReservas() {
        cargarReservas("data/reservas.dat"); // Cargar reservas desde el archivo
        return reservas;
    }

    public void guardarReservas(String archivo) {
        try {
            File directorio = new File("data");
            if (!directorio.exists()) {
                directorio.mkdir(); // Crea el directorio si no existe
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (Reserva reserva : reservas) {
                    String linea = String.format("%s,%d,%s,%d",
                            reserva.getNombreCliente(),
                            reserva.getSala(),
                            reserva.getHorario(),
                            reserva.getNumeroPersonas());
                    bw.write(linea);
                    bw.newLine(); // Añade un salto de línea después de cada reserva
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarReservas(String archivo) {
        reservas.clear(); // Limpia las reservas previas antes de cargar
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreCliente = datos[0];
                int sala = Integer.parseInt(datos[1]);
                String horario = datos[2];
                int numeroPersonas = Integer.parseInt(datos[3]);

                Reserva reserva = new Reserva(nombreCliente, sala, horario, numeroPersonas);
                reservas.add(reserva); // Agrega la reserva cargada
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
        guardarReservas("data/reservas.dat"); // Guardar después de eliminar
    }

    public void modificarReserva(Reserva reservaOriginal, Reserva reservaModificada) {
        int index = reservas.indexOf(reservaOriginal);
        if (index != -1) {
            reservas.set(index, reservaModificada); // Reemplaza la reserva original con la modificada
            guardarReservas("data/reservas.dat"); // Guardar después de modificar
        } else {
            System.out.println("Reserva no encontrada para modificar: " + reservaOriginal);
        }
    }
}