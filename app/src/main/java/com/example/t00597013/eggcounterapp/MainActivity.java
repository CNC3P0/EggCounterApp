package com.example.t00597013.eggcounterapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    private int egg_count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        final TextView tv = (TextView) findViewById(R.id.counter);

        egg_count = sharedPref.getInt(getString(R.string.saved_egg_count),0);
        tv.setText(String.valueOf(egg_count));
/*
        public void sendMessage(View view) {
            final String EXTRA_MESSAGE = "you have x dozen eggs";
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) findViewById(R.id.textView);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
*/
        final Button plus = (Button) findViewById(R.id.plus_button);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                egg_count +=1;
                tv.setText(String.valueOf(egg_count));
                editor.putInt(getString(R.string.saved_egg_count), egg_count);
                editor.apply();
            }
        });

        final Button minus = (Button) findViewById(R.id.minus_button);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                egg_count -= 1;
                tv.setText(String.valueOf(egg_count));
                editor.putInt(getString(R.string.saved_egg_count), egg_count);
                editor.apply();
            }
        });



    }
}
