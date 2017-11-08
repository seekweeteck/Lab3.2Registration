package my.edu.tarc.lab32registration;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by TAR UC on 11/8/2017.
 */

public class MyDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    OnDateSelectedListener  mCallback;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnDateSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnDateSelectedListener");
        }
    }

    // Container Activity must implement this interface
    public interface OnDateSelectedListener {
        public void onDateSelected(int year, int month, int day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        mCallback.onDateSelected(year,month+1,day);
    }


}
