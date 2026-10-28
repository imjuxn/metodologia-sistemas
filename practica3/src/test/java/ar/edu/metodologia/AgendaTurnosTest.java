package ar.edu.metodologia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class AgendaTurnosTest {
    private static final LocalDateTime FECHA_HORA = LocalDateTime.of(2030, 1, 15, 10, 0);

    @Test
    void reservaUnHorarioLibre() {
        AgendaTurnos agenda = new AgendaTurnos();

        assertTrue(agenda.reservar("Ana", FECHA_HORA));
        assertFalse(agenda.estaDisponible(FECHA_HORA));
    }

    @Test
    void noPermiteDosReservasEnElMismoHorario() {
        AgendaTurnos agenda = new AgendaTurnos();
        agenda.reservar("Ana", FECHA_HORA);

        assertFalse(agenda.reservar("Luis", FECHA_HORA));
        assertTrue(agenda.cancelar("Ana", FECHA_HORA));
    }

    @Test
    void soloElPacientePuedeCancelarSuTurno() {
        AgendaTurnos agenda = new AgendaTurnos();
        agenda.reservar("Ana", FECHA_HORA);

        assertFalse(agenda.cancelar("Luis", FECHA_HORA));
        assertFalse(agenda.estaDisponible(FECHA_HORA));
        assertTrue(agenda.cancelar("Ana", FECHA_HORA));
        assertTrue(agenda.estaDisponible(FECHA_HORA));
    }

    @Test
    void rechazaUnNombreVacio() {
        AgendaTurnos agenda = new AgendaTurnos();

        assertThrows(IllegalArgumentException.class, () -> agenda.reservar("  ", FECHA_HORA));
    }

    @Test
    void rechazaPacienteNulo() {
        AgendaTurnos agenda = new AgendaTurnos();

        assertThrows(IllegalArgumentException.class, () -> agenda.reservar(null, FECHA_HORA));
    }

    @Test
    void cancelarConPacienteNuloNoEliminaTurno() {
        AgendaTurnos agenda = new AgendaTurnos();
        agenda.reservar("Ana", FECHA_HORA);

        assertFalse(agenda.cancelar(null, FECHA_HORA));
        assertFalse(agenda.estaDisponible(FECHA_HORA));
    }

    @Test
    void rechazaFechaNula() {
        AgendaTurnos agenda = new AgendaTurnos();

        assertThrows(NullPointerException.class, () -> agenda.reservar("Ana", null));
        assertThrows(NullPointerException.class, () -> agenda.cancelar("Ana", null));
        assertThrows(NullPointerException.class, () -> agenda.estaDisponible(null));
    }
}
