package com.example.appplanet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonReg;
    ProgressBar progreso;
    TextView textView;

    // Declarar FirebaseAuth
    private FirebaseAuth mAuth;




    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.btn_registro);
        progreso = findViewById(R.id.progreso);
        textView = findViewById(R.id.loginNew);

        // Devolver al usuario a la pantalla del login
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        });

        // Acción para el botón de registrarse
        buttonReg.setOnClickListener(view -> {
            // Mostramos barra de progreso
            progreso.setVisibility(View.VISIBLE);

            String email, clave;

            email = String.valueOf(editTextEmail.getText());
            clave = String.valueOf(editTextPassword.getText());

            if(TextUtils.isEmpty(clave)){
                Toast.makeText(Register.this, "Ingresa una clave", Toast.LENGTH_SHORT).show();
            }

            if(TextUtils.isEmpty(clave)){
                Toast.makeText(Register.this, "Ingresa un correo", Toast.LENGTH_SHORT).show();
            }

            // Crear usuario con email y clave ------------------------------------------------------
            mAuth.createUserWithEmailAndPassword(email, clave)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progreso.setVisibility(View.GONE);

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();

                                // Devolver al usuario a la pantalla del login
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Register.this, "Fallo la autenticación.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });
    }
}