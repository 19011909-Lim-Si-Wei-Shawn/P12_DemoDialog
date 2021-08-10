package sg.edu.rp.c346.id19011909.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Creating Variable,
    TextView tvDemo2, tvDemo3, tvDemoE3, tvDemo4, tvDemo5;
    Button btnDemo1, btnDemo2, btnDemo3, btnDemoE3, btnDemo4, btnDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Variable,
        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnDemoE3 = findViewById(R.id.buttonDemoE3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvDemoE3 = findViewById(R.id.textViewDemoE3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        //Creating Button1 Action,
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating Dialog Builder,
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Setting Dialog Details,
                /*myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android App");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);*/

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //Creating Button2 Action,
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                //Configure the 'Positive' Button,
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have Selected Positive");
                    }
                });

                //Configure the 'Negative' Button,
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have Selected Negative");
                    }
                });

                //Configure the 'Neutral' Button,
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //Creating Button3 Action,
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inflating the Input.xml Layout File,
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //Obtaining the UI Component in Input.xml,
                //Defined as "Final" to be used in onClick() method,
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the Text Inputted,
                        String Message = etInput.getText().toString();

                        //Setting Text,
                        tvDemo3.setText(Message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        //Creating ButtonE3 Action,
        btnDemoE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inflating the sumvalue.xml Layout File,
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.sumvalue, null);

                //Obtaining the UI Component in Input.xml,
                //Defined as "Final" to be used in onClick() method,
                final EditText etInput1 = viewDialog.findViewById(R.id.E3ET1);
                final EditText etInput2 = viewDialog.findViewById(R.id.E3ET2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the Text Inputted,
                        Integer Sum = Integer.parseInt(etInput1.getText().toString()) + Integer.parseInt(etInput2.getText().toString());
                        String Message = String.valueOf(Sum);

                        //Setting Text,
                        tvDemoE3.setText("The Sum is: " + Message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //Creating Button4 Action,
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating Listener to Set Date,
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };

                //Creating DatePicker Dialog,
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();

            }
        });

        //Creating Button5 Action,
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create Listener to Set Time,
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                //Create Time Picker Dialog,
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY); //Current Hour,
                int minute = now.get(Calendar.MINUTE); //Current Minute,
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hourOfDay, minute, true);
                myTimeDialog.show();

            }
        });

    }
}