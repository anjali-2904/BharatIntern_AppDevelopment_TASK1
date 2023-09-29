package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView result;
    String oldNumber="";
    String op="+";
    boolean isNewOp=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.res);
    }
    public void numberEvent(View view){
        if(isNewOp)
            result.setText("");
        isNewOp=false;
        String number=result.getText().toString();
        int viewId = view.getId(); // Get the ID of the clicked button

        if (viewId == R.id.one) {
            number += "1";
        } else if (viewId == R.id.two) {
            number += "2";
        } else if (viewId == R.id.three) {
            number += "3";
        } else if (viewId == R.id.four) {
            number += "4";
        } else if (viewId == R.id.five) {
            number += "5";
        } else if (viewId == R.id.six) {
            number += "6";
        } else if (viewId == R.id.seven) {
            number += "7";
        } else if (viewId == R.id.eight) {
            number += "8";
        } else if (viewId == R.id.nine) {
            number += "9";
        } else if (viewId == R.id.zero) {
            number += "0";
        } else if (viewId == R.id.dot) {
            number += ".";
        } else if (viewId == R.id.plusMinus) {
            number = "-" + number;
        }
        result.setText(number);
    }
    public  void operatorEvent(View view){
        isNewOp=true;
        oldNumber=result.getText().toString();
        int viewId = view.getId(); // Get the ID of the clicked button
        if(viewId== R.id.add)
            op="+";
        else if( viewId==R.id.min)
            op="-";
        else if(viewId==R.id.mul)
            op="*";
        else if(viewId==R.id.div)
            op="/";
    }
    public void percentEvent(View view){
        double no=Double.parseDouble(result.getText().toString())/100;
        result.setText(no+"");
        isNewOp=true;
    }
    public void equalEvent(View view) {
        String newNUmber=result.getText().toString();
        double res=0.0;
        switch(op){
            case "+":res=Double.parseDouble(oldNumber)+Double.parseDouble(newNUmber);break;
            case "-":res=Double.parseDouble(oldNumber)-Double.parseDouble(newNUmber);break;
            case "*":res=Double.parseDouble(oldNumber)*Double.parseDouble(newNUmber);break;
            case "/":res=Double.parseDouble(oldNumber)/Double.parseDouble(newNUmber);break;
        }
        result.setText(res+"");
    }

    public void acEvent(View view) {
        result.setText("0");
        isNewOp=true;
    }

    public void cEvent(View view) {
        String r=result.getText().toString();
        result.setText(r.substring(0,r.length()-1)+"");
        isNewOp=true;
    }
}