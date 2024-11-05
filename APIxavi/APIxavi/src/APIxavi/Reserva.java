package APIxavi;

import java.util.Objects;

public class Reserva {
    private String nombreCliente;
    private int sala;
    private String horario;
    private int numeroPersonas;

    public Reserva(String nombreCliente, int sala, String horario, int numeroPersonas) {
        this.nombreCliente = nombreCliente;
        this.sala = sala;
        this.horario = horario;
        this.numeroPersonas = numeroPersonas;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    @Override
    public String toString() {
        return nombreCliente + " - Sala: " + sala + " - Horario: " + horario + " - Personas: " + numeroPersonas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Reserva)) return false;
        Reserva other = (Reserva) obj;
        return sala == other.sala &&
               numeroPersonas == other.numeroPersonas &&
               nombreCliente.equals(other.nombreCliente) &&
               horario.equals(other.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCliente, sala, horario, numeroPersonas);
    }
}