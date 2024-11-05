package APIindira;

import java.io.Serializable;

public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hora; // Ejemplo: "15:00"
    private int sala;    // Número de sala

    public Horario(String hora, int sala) {
        this.hora = hora;
        this.sala = sala;
    }

    // Getters
    public String getHora() { return hora; }
    public int getSala() { return sala; }

    @Override
    public String toString() {
        return "Hora: " + hora + ", Sala: " + sala;
    }}