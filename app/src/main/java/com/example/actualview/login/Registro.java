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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private EditText Username,Email,Password;
    private Button ButtonSingIn;

    //variables de los datos a registrar
    private String nombre="";
    private String email="";
    private String password="";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Aquí te muestra los datos para registrarte en la app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_in);

        Username = (EditText)findViewById(R.id.nombre);
        Email = (EditText)findViewById(R.id.email);
        Password = (EditText)findViewById(R.id.password);

        ButtonSingIn = (Button)findViewById(R.id.singIn);

        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        ButtonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = Username.getText().toString();
                email = Email.getText().toString();
                password = Password.getText().toString();

                if(!nombre.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    if(password.length() >= 6){
                        registerUser();
                    }else{
                        Toast.makeText(Registro.this, "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Registro.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                   // map.put("nombre", nombre);
                    map.put("email", email);
                    map.put("password", password);

                    String id=mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(!task2.isSuccessful()){
                                startActivity(new Intent(Registro.this, Login.class));
                            }else{
                                Toast.makeText(Registro.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(Registro.this, "No se pudo registrar este usuario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null){
           // startActivity(new Intent(Registro.this, MainActivity.class));
           // finish();
        }
    }
}