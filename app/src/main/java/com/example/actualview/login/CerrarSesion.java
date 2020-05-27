package com.example.actualview.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actualview.R;
import com.google.firebase.auth.FirebaseAuth;


public class CerrarSesion extends AppCompatActivity {
    private Button CerrarSesion;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Aqui es para cerrar sesion
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

        mAuth=FirebaseAuth.getInstance();
        CerrarSesion=(Button) findViewById(R.id.singOut);

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(com.example.actualview.login.CerrarSesion.this, Login.class));
                finish();
            }
        });
    }
}