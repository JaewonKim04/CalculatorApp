package com.example.calculatorfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



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
        Button one = findViewById(R.id.One);
        Button two = findViewById(R.id.Two);
        Button four = findViewById(R.id.Four);
        Button three = findViewById(R.id.Three);
        Button five = findViewById(R.id.Five);
        Button six = findViewById(R.id.Six);
        Button seven = findViewById(R.id.Seven);
        Button eight = findViewById(R.id.Eihgt);
        Button nine = findViewById(R.id.Nine);
        addedtext = findViewById(R.id.Result);
        Button plus = findViewById(R.id.Plus);
        Button minus = findViewById(R.id.Minus);
        Button multi = findViewById(R.id.Multiply);
        Button demulti = findViewById(R.id.Demulti);
        Button zero = findViewById(R.id.Zero);
        Button calculate = findViewById(R.id.Calculate);
        Button reset = findViewById(R.id.Reset);
        Button dot = findViewById(R.id.Dot);
        mainview = findViewById(R.id.Newadded);
        addedtext.setText("");
        mainview.setText("");
        Arrays.fill(added, 0);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init=mainview.getText().toString();
                mainview.setText(main_init+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + "0");

            }
        });                                                                 //+-+-+-+-+-+-+-+-+-+-+-+-+-+-+숫자입력+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_init = mainview.getText().toString();
                mainview.setText(main_init + ".");

            }                                                                    //+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-++-+-+-+-+-+-+-+-+--+-+
        });
        plus.setOnClickListener(new View.OnClickListener() {
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
        });
        minus.setOnClickListener(new View.OnClickListener() {
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
        });
        multi.setOnClickListener(new View.OnClickListener() {
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
        });
        demulti.setOnClickListener(new View.OnClickListener() {
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
        });
        reset.setOnClickListener(new View.OnClickListener()                      //리셋하기
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


        });
        calculate.setOnClickListener(new View.OnClickListener() {               //게산결과
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
        });
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