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

public class Login extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonLogin;
    ProgressBar progreso;
    TextView textView;

    // Declarar FirebaseAuth
    private FirebaseAuth mAuth;




    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Si el usuario ya inicio sesión, lo llevara a la pantalla principal del usuario
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
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btn_login);
        progreso = findViewById(R.id.progreso);
        textView = findViewById(R.id.registerNew);

        // Devolver al usuario a la pantalla de registro
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
            finish();
        });

        // Acción para el botón de login
        buttonLogin.setOnClickListener(view -> {
            // Mostramos barra de progreso
            progreso.setVisibility(View.VISIBLE);

            String email, clave;

            email = String.valueOf(editTextEmail.getText());
            clave = String.valueOf(editTextPassword.getText());

            if(TextUtils.isEmpty(email)){
                Toast.makeText(Login.this, "Ingresa un correo", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(clave)){
                Toast.makeText(Login.this, "Ingresa una clave", Toast.LENGTH_SHORT).show();
                return;
            }

            // Iniciar sesión con Firebase Authentication
            mAuth.signInWithEmailAndPassword(email, clave)
                    .addOnCompleteListener(task -> {
                        progreso.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Login.this, "Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            //intent.putExtra("Usuario", correo);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Error: Credenciales inválidas: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}