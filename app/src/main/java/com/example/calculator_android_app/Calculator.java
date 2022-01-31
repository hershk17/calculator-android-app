package com.example.calculator_android_app;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator {
    private Activity activity;
    private ArrayList<String> equation = new ArrayList<>();
    private String equationString = "";

    private String calculate() {
        int size = equation.size();

        if (size < 3) {
            return "Invalid Size";
        }

        while (size > 1) {
            if (equation.size() < 3 || !TextUtils.isDigitsOnly(equation.get(2)) || !TextUtils.isDigitsOnly(equation.get(0))) {
                return "Invalid Syntax";
            }

            Integer left = Integer.parseInt(equation.get(0)), right = Integer.parseInt(equation.get(2));
            String op = equation.get(1);

            equation.remove(0);
            equation.remove(0);
            equation.remove(0);

            size = size - 2;

            switch (op) {
                case "+":
                    equation.add(0, String.valueOf(left + right));
                    break;
                case "-":
                    equation.add(0, String.valueOf(left - right));
                    break;
                case "/":
                    equation.add(0, String.valueOf(left / right));
                    break;
                case "*":
                    equation.add(0, String.valueOf(left * right));
                    break;
                case "%":
                    equation.add(0, String.valueOf(left % right));
                    break;
                case "POW":
                    equation.add(0, String.valueOf(Math.round(Math.pow(left, right))));
                    break;
                case "MAX":
                    equation.add(0, String.valueOf(Math.max(left, right)));
                    break;
                case "MIN":
                    equation.add(0, String.valueOf(Math.min(left, right)));
                    break;
                default:
                    return "Invalid Operator";
            }
        }

        return equation.get(0);
    }

    public Calculator(Activity _activity) {
        this.activity = _activity;
    }

    public void push(String value) {
        if (value.equals("C")) {
            equation.clear();
            equationString = "";
        } else if (value.equals("=")) {
            equationString += " = " + calculate();
        } else {
            equation.add(value);
            equationString += " " + value;
        }
        ((TextView)activity.findViewById(R.id.input)).setText(equationString);
    }

}
