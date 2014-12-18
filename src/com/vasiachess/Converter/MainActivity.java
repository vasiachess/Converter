package com.vasiachess.Converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */

    private EditText etDistance;
    private Button btnConvert;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etDistance = (EditText) findViewById(R.id.etDistance);
        btnConvert = (Button) findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConvert:
                onClickBtnConvert();
                break;
        }
    }

    private void onClickBtnConvert() {

        RadioButton KmButton = (RadioButton) findViewById(R.id.radioKm);
        RadioButton MileButton = (RadioButton) findViewById(R.id.radioMile);

        if (etDistance.getText().length() == 0) {
            Toast.makeText(this, "Enter distance!", Toast.LENGTH_LONG).show();
            return;
        }
        float inputValue = Float.parseFloat(etDistance.getText().toString());
        if (KmButton.isChecked()) {
            etDistance.setText(String.valueOf(convertMileToKm(inputValue)));
        } else {
            etDistance.setText(String
                    .valueOf(convertKmToMile(inputValue)));
        }

        if (KmButton.isChecked()) {
            MileButton.setChecked(false);
            KmButton.setChecked(true);
        } else {
            MileButton.setChecked(true);
            KmButton.setChecked(false);
        }
    }

    // Convert to km
    private float convertMileToKm(float mile) {
        return (float) (mile * 1.609344);
    }

    // Convert to miles
    private float convertKmToMile(float km) {
        return (float) (km / 1.609344);
    }
}


