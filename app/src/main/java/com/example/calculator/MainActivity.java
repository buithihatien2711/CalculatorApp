package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String expression;
    private String operand1;
    private String operand2;
    private String result;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        expression = "";
        operand1 = null;
        operand2 = null;
        operator = null;

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("0");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("1");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("2");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("3");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("4");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("5");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("6");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("7");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("8");
                binding.edtCal.setText(expression);
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression.concat("9");
                binding.edtCal.setText(expression);
            }
        });
        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operand1 == null){
                    operand1 = expression;
                    expression = expression.concat("+");
                    operator = "+";
                }
                else{
                    operand2 = expression;
                    result = calExpression(operand1, operand2, operator);
                    binding.edtCal.setText(result);
                    operand1 = result;
                    operand2 = null;
                    operator = "+";
                }

            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 == null){
                    operand1 = expression;
                    expression = expression.concat("-");
                    operator = "-";
                }
                else{
                    operand2 = expression;
                    result = calExpression(operand1, operand2, operator);
                    binding.edtCal.setText(result);
                    operand1 = result;
                    operand2 = null;
                    operator = "-";
                }
                expression = "";
            }
        });
        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 == null){
                    operand1 = expression;
                    expression = expression.concat("*");
                    operator = "*";
                }
                else{
                    operand2 = expression;
                    result = calExpression(operand1, operand2, operator);
                    binding.edtCal.setText(result);
                    operand1 = result;
                    operand2 = null;
                    operator = "*";
                }

            }
        });
        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 == null){
                    operand1 = expression;
                    expression.concat("/");
                    operator = "/";
                }
                else{
                    operand2 = expression;
                    result = calExpression(operand1, operand2, operator);
                    binding.edtCal.setText(result);
                    operand1 = result;
                    operand2 = null;
                    operator = "/";
                }

            }
        });
        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operand1 == null){
                    operand1 = expression;
                    operator = "";
                }
                else{
                    operand2 = expression;
                    result = calExpression(operand1, operand2, operator);
                    binding.edtCal.setText(result);
                    operand1 = result;
                    operand2 = null;
                    operator = "";
                }

            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = "";
                operand1 = null;
                operand2 = null;
                operator = null;
                binding.edtCal.setText("");
            }
        });
    }

    private String calExpression(String operand1, String operand2, String operator) {
        switch (operator) {
            case "+":
                return Float.toString(Float.parseFloat(operand1) + Float.parseFloat(operand2));
            case "-":
                return Float.toString(Float.parseFloat(operand1) - Float.parseFloat(operand2));
            case "*":
                return Float.toString(Float.parseFloat(operand1) * Float.parseFloat(operand2));
            case "/":
                if (Float.parseFloat(operand1) == 0) return "divisor can't be 0.";
                return Float.toString(Float.parseFloat(operand1) / Float.parseFloat(operand2));
            default:
                return ""; // will never catch up here
        }
    }
}