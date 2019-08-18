package com.test.junittestingexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private final String TAG = MainActivity.class.getCanonicalName();
    private EditText lastName,firstName,dateTime,doctorName;
    private Button submit;
    private ListView listView;
    private ArrayAdapter aAdapter;
    private ArrayList<String> patients = new ArrayList<>();
    public static ClinicCalendar clinicCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clinicCalendar = new ClinicCalendar(LocalDate.now());
        lastName = findViewById(R.id.lastName);
        firstName = findViewById(R.id.firstName);
        dateTime = findViewById(R.id.dateTime);
        doctorName = findViewById(R.id.doctorName);
        submit = findViewById(R.id.submit);
        listView = findViewById(R.id.listview);
        aAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, patients);
        listView.setAdapter(aAdapter);
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                clinicCalendar.addAppointment(firstName.getText().toString(),lastName.getText().toString(),doctorName.getText().toString(),dateTime.getText().toString());
                Log.i(TAG, "Date saved");
                for(PatientAppointment patientAppointment : clinicCalendar.getAppointments())
                {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
                    String dateTime = dateTimeFormatter.format(patientAppointment.getAppointmentDateTime());
                    String patient = patientAppointment.getPatientFirstName()+"\n"
                                    +patientAppointment.getPatientLastName()+"\n"
                                    +dateTime+"\n"
                                    +patientAppointment.getDoctor().getName();
                    patients.add(patient);

                }
            }
        });

    }
}
