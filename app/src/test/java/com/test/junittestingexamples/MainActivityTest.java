package com.test.junittestingexamples;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainActivityTest
{
    @Test
    public void allowEntryofAnyAppointment()
    {
        ClinicCalendar clinicCalendar = new ClinicCalendar();
        clinicCalendar.addAppointment("Parth","Desai","avery","9/1/1990 2:00 pm");
        List<PatientAppointment> appointments = clinicCalendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        assertEquals("Parth",appointments.get(0).getPatientFirstName());
        assertEquals("Desai",appointments.get(0).getPatientLastName());
        assertEquals(Doctor.avery,appointments.get(0).getDoctor());
        assertEquals("9/1/1990 02:00 PM",appointments.get(0).getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
    }
}