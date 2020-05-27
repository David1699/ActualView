package com.example.actualview.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.actualview.R;
import com.example.actualview.activities.SeriesActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText Email,Password;
    private Button ButtonLogin, ButtonSingIn;

    private String email="";
    private String password="";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Aquí te muestra los datos para iniciar sesion y entrar en la app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Email = (EditText)findViewById(R.id.email);
        Password = (EditText)findViewById(R.id.password);

        ButtonLogin = (Button)findViewById(R.id.login);
        ButtonSingIn = (Button)findViewById(R.id.singIn);

        mAuth=FirebaseAuth.getInstance();

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=Email.getText().toString();
                password=Password.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(Login.this, "Debe completar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

        ButtonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registro.class));
            }
        });
    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Login.this, SeriesActivity.class);

                    intent.putExtra("email", email);

                    startActivity(intent);
                    //finish();
                }else{
                    Toast.makeText(Login.this, "No se pudo iniciar sesion. Compruebe sus datos.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null){
           // startActivity(new Intent(Login.this, MainActivity.class));
           // finish();
        }
    }
}