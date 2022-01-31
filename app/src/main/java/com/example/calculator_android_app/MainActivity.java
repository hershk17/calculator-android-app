package com.example.calculator_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final Calculator C = new Calculator(this);
    private Boolean advancedModeOn = false;

    private final Integer[] btn_group = {
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply,
            R.id.btn_divide, R.id.btn_clear, R.id.btn_equals, R.id.btn_pow, R.id.btn_mod,
            R.id.btn_max, R.id.btn_min
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i : btn_group) {
            findViewById(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        C.push(((Button) view).getText().toString());
    }

    public void onToggleMode(View view) {
        advancedModeOn = !advancedModeOn;
        ((Button)view).setText(advancedModeOn ? R.string.toggle_simple_mode : R.string.toggle_advanced_mode);
        findViewById(R.id.advancedBtns).setVisibility(advancedModeOn ? View.VISIBLE : View.INVISIBLE);
    }
}