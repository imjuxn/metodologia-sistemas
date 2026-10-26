package ar.edu.metodologia;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AgendaTurnos {
    private final Map<LocalDateTime, String> turnos = new HashMap<>();

    public boolean reservar(String paciente, LocalDateTime fechaHora) {
        if (paciente == null || paciente.isBlank()) {
            throw new IllegalArgumentException("El nombre del paciente es obligatorio");
        }
        Objects.requireNonNull(fechaHora, "La fecha y hora son obligatorias");
        return turnos.putIfAbsent(fechaHora, paciente.trim()) == null;
    }

    public boolean cancelar(String paciente, LocalDateTime fechaHora) {
        Objects.requireNonNull(fechaHora, "La fecha y hora son obligatorias");
        return paciente != null && turnos.remove(fechaHora, paciente.trim());
    }

    public boolean estaDisponible(LocalDateTime fechaHora) {
        Objects.requireNonNull(fechaHora, "La fecha y hora son obligatorias");
        return !turnos.containsKey(fechaHora);
    }
}
