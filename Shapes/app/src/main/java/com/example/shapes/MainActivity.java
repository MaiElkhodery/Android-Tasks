package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements DialogFragment.OnNegativeButtonClick, DialogFragment.OnPositiveButtonClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        AppCompatButton exist_button = findViewById(R.id.exist_button);
        exist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = DialogFragment.newInstance("Confirmation",
                        "are you sure you wants to leave the app?",R.drawable.warning_img);
                dialogFragment.show(getSupportFragmentManager(),"dialogFragment");
            }
        });

        AppCompatButton change_button = findViewById(R.id.change_button);
        change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    change_button.setText(null);
                    throw new Exception("show this log message when app crashes");
                }
                catch (Exception e){
                    Log.e("buttonErr",e.getMessage());
                }
            }
        });
    }

    @Override
    public void onClickPositiveButton() {
        this.finish();
    }

    @Override
    public void onClickNegativeButton() {

    }

}