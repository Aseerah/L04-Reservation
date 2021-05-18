package sg.edu.rp.c346.id20009530.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // creating variable
    EditText name;
    EditText number;
    EditText groupSize;
    RadioButton smoking;
    RadioButton noSmoking;
    RadioGroup area;
    DatePicker datePicker;
    TimePicker timePicker;
    Button reset;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameLine);
        number = findViewById(R.id.numberLine);
        groupSize = findViewById(R.id.groupSizeLine);
        smoking = findViewById(R.id.smokingArea);
        noSmoking = findViewById(R.id.nonSmokingArea);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        reset = findViewById(R.id.reset);
        confirm = findViewById(R.id.confirm);

        datePicker.updateDate(2021, 6, 1); // default date
        timePicker.setCurrentMinute(30); // default time
        timePicker.setCurrentHour(19); // default time

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting the input of the user and storing in a variable
                String getName = name.getText().toString();
                String getNumber = number.getText().toString();
                String getGroupSize = groupSize.getText().toString();
                String getDate = (datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear()); // add 1 for month to make it normal
                String getTime = (timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());
                String area;
                String output;

                if (getName.isEmpty()) {
                    output = "Please enter your name";
                } else if (getNumber.isEmpty()) {
                    output = "Please enter your number";
                } else if (getGroupSize.isEmpty()) {
                    output = "Please enter Number of total people";
                } else {
                    output = String.format("Hi %s,\n Your number: %s \n Number of people: %s \n Date chosen: %s \n Time chosen: %s\n", getName, getNumber, getGroupSize, getDate, getTime);
                    if (smoking.isChecked()) {
                        output += "Area chosen: Smoking Area";
                    } else {
                        output += "Area chosen: Non Smoking Area";
                    }
                }
                Toast.makeText(MainActivity.this, output, Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePicker.updateDate(2021, 6, 1); // default date
                timePicker.setCurrentMinute(30); // default time
                timePicker.setCurrentHour(19); // default time
                smoking.setChecked(false);
                noSmoking.setChecked(false);
                name.setText(" ");
                number.setText(" ");
                groupSize.setText(" ");
            }
        });


    }
}