package com.example.shapes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        AppCompatButton exist_button = findViewById(R.id.exist_button);

        exist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogName = new AlertDialog.Builder(MainActivity.this);

                dialogName.setTitle("Confirmation");
                dialogName.setMessage("are you sure you wants to leave the app?");
                dialogName.setIcon(R.drawable.warning_img);

                dialogName.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        closeApp();
                    }
                });

                dialogName.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogName.create();
                dialogName.show();

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

    public void closeApp(){
        this.finish();
    }

}