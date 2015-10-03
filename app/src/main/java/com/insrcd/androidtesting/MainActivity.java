package com.insrcd.androidtesting;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.insrcd.androidtesting.math.MathParser;


public class MainActivity extends AppCompatActivity {

    public static final String CALC_TEXT_KEY = "androidtesting.calctext";

    private TextView mCalcText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mCalcText = (TextView) findViewById(R.id.txt_calc);

        initNumButtons();

        ((Button) findViewById(R.id.btn_eq)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MathParser parser = new MathParser(mCalcText.getText().toString());

                mCalcText.setText(String.valueOf(parser.parse()));
            }
        });


    }

    private void initNumButtons(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                TextView textField = (TextView) findViewById(R.id.txt_calc);

                if (btn.getText().equals("Clear")) {
                    textField.setText("");
                }
                else {
                    appendToCalculatorText(btn.getText().toString() + " ");
                }
            }
        };

        ((Button) findViewById(R.id.num0)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num1)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num2)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num3)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num4)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num5)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num6)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num7)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num8)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num9)).setOnClickListener(listener);
        ((Button) findViewById(R.id.num0)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btn_plus)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btn_div)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btn_minus)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btn_mult)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btn_clear)).setOnClickListener(listener);

    }

    public void appendToCalculatorText(String text){
       mCalcText.setText( mCalcText.getText() + text );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(CALC_TEXT_KEY, mCalcText.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mCalcText.setText(savedInstanceState.getString(CALC_TEXT_KEY));

        super.onRestoreInstanceState(savedInstanceState);
    }
}
