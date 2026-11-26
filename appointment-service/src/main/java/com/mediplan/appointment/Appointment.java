package com.mediplan.appointment;

public record Appointment(Long id, String patientName, String doctorName, String dateTime) {
}