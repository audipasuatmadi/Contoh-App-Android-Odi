package com.example.roomlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {


    private EditText mInputUsername;
    private EditText mInputPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        mInputUsername = findViewById(R.id.input_username);
        mInputPin = findViewById(R.id.input_pin);
        final Button mAddButton = findViewById(R.id.button_add);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mInputUsername.getText()) || TextUtils.isEmpty(mInputPin.getText().toString())) {
                    Toast.makeText(AddDataActivity.this, "Make sure all input fields is not empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent replyIntent = new Intent();
                    String username = mInputUsername.getText().toString();
                    String pin = mInputPin.getText().toString();

                    Bundle extras = new Bundle();
                    extras.putString("username", username);
                    extras.putString("pin", pin);

                    replyIntent.putExtras(extras);
                    setResult(RESULT_OK, replyIntent);
                    finish();
                }
            }
        });

    }
}
