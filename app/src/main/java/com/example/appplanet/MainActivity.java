package com.example.appplanet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    public Button btn_seccionAnimales;
    public Button btn_seccionPlantas;
    public Button btn_logout;
    TextView detallesUsuario;
    FirebaseUser user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        auth = FirebaseAuth.getInstance();
        btn_seccionAnimales = findViewById(R.id.seccionAnimales);
        btn_seccionPlantas = findViewById(R.id.seccionPlantas);
        detallesUsuario =  findViewById(R.id.detalleUsuario);
        btn_logout = findViewById(R.id.logout);
        user = auth.getCurrentUser();

        if(user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else{
            detallesUsuario.setText(user.getEmail());
        }

        btn_logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        });

        btn_seccionAnimales.setOnClickListener(view -> {
            Intent i = new Intent(this, Animales.class);
            startActivity(i);
        });
        btn_seccionPlantas.setOnClickListener(view -> {
            Intent i = new Intent(this, Plantas.class);
            startActivity(i);
        });
    }
}