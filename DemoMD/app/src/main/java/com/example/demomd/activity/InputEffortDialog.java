package com.example.demomd.activity;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.demomd.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class InputEffortDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {
    private EditText edtCE, edtBE, edtAE, edtReportDate;
    private Spinner spRoleIE;
    private String selectSpinner;
    private Button btnPickDate;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Create Dialog input Effort
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_input_effort, null);
        builder.setView(view)
                .setTitle("Input Effort")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String calendarEffort = edtCE.getText().toString();
                        String buildableEffort = edtBE.getText().toString();
                        String acturalEffort = edtAE.getText().toString();

                        if (!calendarEffort.isEmpty() & !buildableEffort.isEmpty() & !acturalEffort.isEmpty()) {
                            System.out.println("CE " + calendarEffort);
                            System.out.println("BE " + buildableEffort);
                            System.out.println("AE " + acturalEffort);
                        }


                    }
                });
        edtCE = view.findViewById(R.id.edtCalendarEffort);
        edtBE = view.findViewById(R.id.edtBuildableEffort);
        edtAE = view.findViewById(R.id.edtActuralEffort);

        //Create Spinner
        spRoleIE = view.findViewById(R.id.spRoleIE);
        List<String> roles = new ArrayList<>();
        roles.add("Developer");
        roles.add("Project Manager");
        roles.add("Busniess Manner");
        ArrayAdapter<String> dataAdaper = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, roles);
        dataAdaper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRoleIE.setAdapter(dataAdaper);

        spRoleIE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectSpinner = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Pick Date
        edtReportDate = view.findViewById(R.id.edtReportDate);
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        edtReportDate.setText(sdf.format(currentDate));

        btnPickDate = view.findViewById(R.id.btnPickDate);
        btnPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });


        return builder.create();
    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "-" + (month + 1) + "-" + year;
        edtReportDate.setText(date);

    }
}
