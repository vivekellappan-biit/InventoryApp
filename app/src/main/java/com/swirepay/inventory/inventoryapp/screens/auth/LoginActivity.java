package com.swirepay.inventory.inventoryapp.screens.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.swirepay.inventory.inventoryapp.R;
import com.swirepay.inventory.inventoryapp.screens.home.HomeActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText mUsernameTextInputEditText;
    private TextInputEditText mPasswordTextInputEditText;
    private Button mLoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inflateXMLView();
    }

    private void inflateXMLView(){
        mUsernameTextInputEditText = findViewById(R.id.txt_usermame);
        mPasswordTextInputEditText = findViewById(R.id.txt_password);
        mLoginButton = findViewById(R.id.btn_login);


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.requireNonNull(mUsernameTextInputEditText.getText()).toString().isEmpty() && Objects.requireNonNull(mPasswordTextInputEditText.getText()).toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    if(Objects.requireNonNull(mUsernameTextInputEditText.getText()).toString().equals("admin") && Objects.requireNonNull(mPasswordTextInputEditText.getText()).toString().equals("admin")){
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Username and Password not valid", Toast.LENGTH_SHORT).show();
                    }
                    
                }


            }
        });
    }
}