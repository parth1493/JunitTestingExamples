package com.test.junittestingexamples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainActivityTest
{
    ClinicCalendar clinicCalendar;

    @BeforeAll
    static void testClassSetup()
    {
        System.out.println("Before all");
    }
    @BeforeEach
    void init()
    {
        System.out.println("Before each");
        clinicCalendar = new ClinicCalendar(LocalDate.of(2019,8,18));
    }
    @Test
    public void
    allowEntryofAnyAppointment()
    {
        System.out.println("Test cases");
        clinicCalendar.addAppointment("Parth","Desai","avery","9/1/1990 2:00 pm");
        List<PatientAppointment> appointments = clinicCalendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        assertEquals("Parth",appointments.get(0).getPatientFirstName());
        assertEquals("Desai",appointments.get(0).getPatientLastName());
        assertEquals(Doctor.avery,appointments.get(0).getDoctor());
        assertSame(Doctor.avery,appointments.get(0).getDoctor());
        assertEquals("9/1/1990 02:00 PM",appointments.get(0).getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
    }

    @Test
    public void
    returnTrueForHasAppointmentsIfThereAreAppointments()
    {
        System.out.println("Test cases");
        clinicCalendar.addAppointment("Parth","Desai","avery","8/18/2019 2:00 pm");
        assertTrue(clinicCalendar.hasAppointment(LocalDate.of(2019,8,18)));
    }

    @Test
    public void
    returnFalseForHasAppointmentsIfThereAreAppointments()
    {
        System.out.println("Test cases");
        assertFalse(clinicCalendar.hasAppointment(LocalDate.of(1990,9,1)));
    }

    @Test
    public void returnCurrentDatsAppointments()
    {
        System.out.println("Test cases");
        clinicCalendar.addAppointment("Parth","Desai","avery","08/18/2019 2:00 pm");
        clinicCalendar.addAppointment("Parth","Desai","avery","08/18/2019 3:00 pm");
        clinicCalendar.addAppointment("Parth","Desai","avery","09/1/2019 3:00 pm");
        assertEquals(2,clinicCalendar.getTodaysAppointment().size());
       // assertIterableEquals(clinicCalendar.getTodaysAppointment(),clinicCalendar.getAppointments());

    }
    @AfterEach
    void testDownEachTest()
    {
        System.out.println("After Test cases");
    }

    @AfterAll
    static void testDownTestCase()
    {
        System.out.println("After All");
    }
}