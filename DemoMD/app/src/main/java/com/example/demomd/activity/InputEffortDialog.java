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
import android.widget.Toast;

import com.example.demomd.R;
import com.example.demomd.data.EffortRequest;
import com.example.demomd.data.PositionResponse;
import com.example.demomd.presenter.InputEffortPresenter;
import com.example.demomd.presenter.InputEffortPresenterImpl;
import com.example.demomd.view.InputEffortView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class InputEffortDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener, InputEffortView {
    private EditText edtCE, edtBE, edtAE, edtReportDate, edtComment;
    private Spinner spRoleIE;
    private PositionResponse selectedRole;
    private Button btnPickDate, btnInput;
    private int projectMemberId;
    private InputEffortPresenter inputEffortPresenter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        projectMemberId = bundle.getInt("projectMemberId");

        inputEffortPresenter = new InputEffortPresenterImpl(this);
        inputEffortPresenter.getListPositionOfEmployee(projectMemberId);

        //Create Dialog input Effort
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_input_effort, null);

        edtCE       = view.findViewById(R.id.edtCalendarEffort);
        edtBE       = view.findViewById(R.id.edtBuildableEffort);
        edtAE       = view.findViewById(R.id.edtActuralEffort);
        edtComment  = view.findViewById(R.id.edtComment);
        btnInput    = view.findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calendarEffort = edtCE.getText().toString();
                String buildableEffort = edtBE.getText().toString();
                String acturalEffort = edtAE.getText().toString();
                String comment = edtComment.getText().toString();
                String reportDate = parseDateFormat(edtReportDate.getText().toString());
                if (!calendarEffort.isEmpty() & !buildableEffort.isEmpty() & !acturalEffort.isEmpty()) {
                    EffortRequest effortRequest =
                            new EffortRequest(projectMemberId, Float.parseFloat(calendarEffort),
                                    Float.parseFloat(acturalEffort), Float.parseFloat(buildableEffort),
                                    reportDate, selectedRole.getId(), comment);
                    inputEffortPresenter.sendEffortToServer(effortRequest);
                }
            }
        });

        spRoleIE = view.findViewById(R.id.spRoleIE);

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

    private String parseDateFormat(String dayMonthYear) {
        String yearMonthDay = "";
        String[] token = dayMonthYear.split("-");
        yearMonthDay = token[2] + "-" + token[1] + "-" + token[0];
        return yearMonthDay;
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
        String formatDay = dayOfMonth < 10 ? ("0" + dayOfMonth) : (dayOfMonth + "");
        String formatMonth = (month + 1) < 10 ? ("0" + (month + 1)) : ((month + 1) + "");
        String date = formatDay + "-" + formatMonth + "-" + year;
        edtReportDate.setText(date);
    }

    @Override
    public void setListPositionToView(List<PositionResponse> listPosition) {
        //Create Role in project combo box
        List<PositionResponse> roles = new ArrayList<>();
        roles.addAll(listPosition);
        ArrayAdapter<PositionResponse> dataAdaper = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, roles);
        dataAdaper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRoleIE.setAdapter(dataAdaper);

        spRoleIE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRole = (PositionResponse) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void inputEffort(EffortRequest effortRequest) {
        if(effortRequest != null) {
            Toast.makeText(getContext(), "Input effort success", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getContext(), "Error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
