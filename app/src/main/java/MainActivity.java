package com.example.calculatorfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    static Button one, two, three, four, five, six, seven, eight, nine, plus, minus, multi, demulti, zero, calculate, reset, dot;

    static TextView addedtext, mainview;
    static double[] added = new double[40];
    int[] calculate_sign = new int[40];
    static int addedroom = 0;
    String add_init;
    String main_init;
    int compute = -1;
    int a;//최종계산할때 연산기호 확인하는 변수
    int change = 0;
    double result = 0;
    int firstt = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.One);
        two = findViewById(R.id.Two);
        four = findViewById(R.id.Four);
        three = findViewById(R.id.Three);
        five = findViewById(R.id.Five);
        six = findViewById(R.id.Six);
        seven = findViewById(R.id.Seven);
        eight = findViewById(R.id.Eihgt);
        nine = findViewById(R.id.Nine);
        addedtext = findViewById(R.id.Result);
        plus = findViewById(R.id.Plus);
        minus = findViewById(R.id.Minus);
        multi = findViewById(R.id.Multiply);
        demulti = findViewById(R.id.Demulti);
        zero = findViewById(R.id.Zero);
        calculate = findViewById(R.id.Calculate);
        reset = findViewById(R.id.Reset);
        dot = findViewById(R.id.Dot);
        mainview = findViewById(R.id.Newadded);
        addedtext.setText("");
        mainview.setText("");
        Arrays.fill(added, 0);
        final Button.OnClickListener first = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "1");
            }
        };
        one.setOnClickListener(first);
        Button.OnClickListener sec = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "2");
            }
        };
        two.setOnClickListener(sec);
        Button.OnClickListener third = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "3");
            }
        };
        three.setOnClickListener(third);
        Button.OnClickListener fourt = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "4");
            }
        };
        four.setOnClickListener(fourt);
        Button.OnClickListener fif = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "5");

            }
        };
        five.setOnClickListener(fif);
        Button.OnClickListener sixt = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "6");
            }
        };
        six.setOnClickListener(sixt);
        Button.OnClickListener seve = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "7");
            }
        };
        seven.setOnClickListener(seve);
        Button.OnClickListener eigh = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "8");
            }
        };
        eight.setOnClickListener(eigh);
        Button.OnClickListener nint = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "9");
            }
        };
        nine.setOnClickListener(nint);
        Button.OnClickListener cal = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "0");

            }
        };
        zero.setOnClickListener(cal);
        Button.OnClickListener dott = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + ".");

            }                                                                    //+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-++-+-+-+-+-+-+-+-+--+-+
        };                                                                       //+-+-+-+-+-+-+-+-+-+-+-+-+-+-+숫자입력+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+
        dot.setOnClickListener(dott);
        Button.OnClickListener plu = new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                                //더하기
                add_init = addedtext.getText().toString();
                main_init = mainview.getText().toString();
                if (main_init.length() > 0) {
                    compute = 2;
                    AddValue();
                    addedtext.setText(add_init + main_init + "+");
                }

            }
        };
        plus.setOnClickListener(plu);
        Button.OnClickListener mint = new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                                   //빼기
                add_init = addedtext.getText().toString();
                main_init = mainview.getText().toString();
                if (main_init.length() > 0) {
                    compute = 3;
                    AddValue();
                    addedtext.setText(add_init + main_init + "-");
                }
            }
        };
        minus.setOnClickListener(mint);
        Button.OnClickListener mlu = new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                               //곱하기
                add_init = addedtext.getText().toString();
                main_init = mainview.getText().toString();
                if (main_init.length() > 0) {
                    compute = 0;
                    AddValue();
                    addedtext.setText(add_init + main_init + "x");
                }

            }
        };
        multi.setOnClickListener(mlu);
        Button.OnClickListener dem = new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                               //나누기
                add_init = addedtext.getText().toString();
                main_init = mainview.getText().toString();
                if (main_init.length() > 0) {
                    compute = 1;
                    AddValue();
                    addedtext.setText(add_init + main_init + "/");
                }
            }
        };
        demulti.setOnClickListener(dem);
        final Button.OnClickListener res = new View.OnClickListener()                      //리셋하기
        {
            @Override
            public void onClick(View view) {
                mainview.setText("");
                addedtext.setText("");
                main_init = "";
                add_init = "";
                addedroom = 0;
                compute = 0;
                firstt = 0;
                result = 0;
                a = 0;
                Arrays.fill(added, 0);
                Arrays.fill(calculate_sign, -1);
            }


        };
        reset.setOnClickListener(res);

        Button.OnClickListener calc = new View.OnClickListener() {               //게산결과
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();

                if (main_init.length() > 0) {
                    Finalset();

                    if (result % 1 == 0) {
                        change = (int) result;
                        mainview.setText(change + "");
                    } else {
                        mainview.setText(result + "");
                    }
                    addedtext.setText("");
                    addedroom = 0;
                    Arrays.fill(added, 0);
                    Arrays.fill(calculate_sign, -1);
                    result = 0;
                    a = 0;
                }
            }
        };
        calculate.setOnClickListener(calc);
    }

    public void AddValue() {
        added[addedroom] = Double.parseDouble(main_init);
        calculate_sign[addedroom] = compute;
        addedroom += 1;
        mainview.setText("");

    }

    public void LetsCalculateonlyplus() {
        if (calculate_sign[a] == 0) {
            result *= added[a + 1];
        } else if (calculate_sign[a] == 1) {
            result /= added[a + 1];
        } else if (calculate_sign[a] == 2) {
            result += added[a + 1];
        } else if (calculate_sign[a] == 3) {
            result -= added[a + 1];
        }
    }

    public void Finalset() {
        added[addedroom] = Double.parseDouble(main_init);

        for (int inthe = 0; inthe < addedroom; inthe++) {
            if (calculate_sign[inthe] == 0) {
                added[inthe] = added[inthe] * added[inthe + 1];
                added[inthe + 1] = 0;
                calculate_sign[inthe] = -1;
            } else if (calculate_sign[inthe] == 1) {
                added[inthe] = added[inthe] / added[inthe + 1];
                added[inthe + 1] = 0;
                calculate_sign[inthe] = -1;
            }
        }
        result = added[0];
        for (a = 0; a < addedroom; a++) {
            LetsCalculateonlyplus();
        }
    }


}