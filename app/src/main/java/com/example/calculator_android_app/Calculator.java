package com.example.calculator_android_app;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    private ArrayList<String> equation = new ArrayList<>();

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

    public Calculator() {
    }

    public void push(String value) {
        if (value.equals("C")) {
            Log.d("Clearing", equation.toString());
            equation.clear();
            Log.d("Result", equation.toString());
        } else if (value.equals("=")) {
            Log.d("Calculating", equation.toString());
            Log.d("Result", calculate());
            equation.clear();
        } else {
            equation.add(value);
        }
    }

}
