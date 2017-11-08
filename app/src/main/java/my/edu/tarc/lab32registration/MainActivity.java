package my.edu.tarc.lab32registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyDateFragment.OnDateSelectedListener{
    private Button buttonDOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDOB = (Button)findViewById(R.id.buttonDOB);
    }

    public void showDatePickerDialog(View v) {
        MyDateFragment newFragment = new MyDateFragment();
        newFragment.show(getFragmentManager(), "datePicker");
        //or newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSelected(int year, int month, int day) {
        buttonDOB.setText(day + "-"+ month + "-" + year);
    }
}
