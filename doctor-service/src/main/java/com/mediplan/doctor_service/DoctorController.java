
package com.mediplan.doctor_service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DoctorController {

    private final List<Doctor> doctors = new ArrayList<>(List.of(
        new Doctor(1L, "Dr Diop", "Cardiologie"),
        new Doctor(2L, "Dr Ndiaye", "Dermatologie"),
        new Doctor(3L, "Dr Fall", "Pediatrie")
    ));

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctors;
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }
}
