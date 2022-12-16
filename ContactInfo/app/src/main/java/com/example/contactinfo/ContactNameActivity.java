package com.example.contactinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_name);


        EditText name = findViewById(R.id.nameET);
        AppCompatButton nameButton = findViewById(R.id.sendNameButton);

        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ContactNumActivity.class);
                intent.putExtra("contact_name",name.getText().toString());
                startActivity(intent);
            }
        });

    }

}