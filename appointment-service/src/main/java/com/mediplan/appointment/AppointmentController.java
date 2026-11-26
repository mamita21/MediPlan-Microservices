package com.mediplan.appointment;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    // Stockage en mémoire pour l'instant (PostgreSQL viendra plus tard)
    private final Map<Long, Appointment> appointments = new ConcurrentSkipListMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public AppointmentController() {
        // Données d'exemple pour tester tout de suite
        save(new Appointment(null, "Alice Martin", "Dr Dupont", "2026-12-01T09:30"));
        save(new Appointment(null, "Moussa Ba", "Dr Ndiaye", "2026-12-02T14:00"));
    }

    @GetMapping("/")
    public String home() {
        return "appointment-service is running";
    }

    @GetMapping("/appointments")
    public Collection<Appointment> getAll() {
        return appointments.values();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        Appointment appointment = appointments.get(id);
        if (appointment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointment);
    }

    @PostMapping("/appointments")
    public ResponseEntity<Appointment> create(@RequestBody Appointment request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(save(request));
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        if (appointments.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    private Appointment save(Appointment a) {
        Appointment saved = new Appointment(idCounter.incrementAndGet(),
                a.patientName(), a.doctorName(), a.dateTime());
        appointments.put(saved.id(), saved);
        return saved;
    }
}