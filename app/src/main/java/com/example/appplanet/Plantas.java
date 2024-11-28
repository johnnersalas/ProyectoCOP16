package com.example.appplanet;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Plantas extends AppCompatActivity {

    private List<Planta> plantas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantas);

        // Inicializamos la lista
        plantas = new ArrayList<>();

        // Cargamos los datos de las plantas
        cargarDatosPlantas();
    }

    private void cargarDatosPlantas() {
        plantas.add(new Planta("Árboles", "Roble", "Quercus", "Verde",
                "El roble es un árbol robusto de madera dura y longeva, común en climas templados.",
                R.drawable.roble));
        plantas.add(new Planta("Árboles", "Pino", "Pinus", "Verde",
                "El pino es un árbol de coníferas con hojas en forma de aguja, muy utilizado en la industria maderera.",
                R.drawable.pino));
        plantas.add(new Planta("Árboles", "Ciprés", "Cupressus", "Verde oscuro",
                "El ciprés es un árbol de hojas perennes, símbolo de longevidad y resistencia.",
                R.drawable.cipres));
        plantas.add(new Planta("Flores", "Rosa", "Rosaceae", "Rojo",
                "La rosa es una flor ornamental conocida por su fragancia y su amplia variedad de colores.",
                R.drawable.rosa));
        plantas.add(new Planta("Flores", "Tulipán", "Liliaceae", "Amarillo",
                "El tulipán es una flor bulbosa que florece en primavera y es símbolo de elegancia.",
                R.drawable.tulipan));
        plantas.add(new Planta("Flores", "Margarita", "Asteraceae", "Blanco",
                "La margarita es una flor sencilla y delicada, símbolo de pureza y amistad.",
                R.drawable.margarita));
        plantas.add(new Planta("Hierbas", "Albahaca", "Ocimum basilicum", "Verde",
                "La albahaca es una hierba aromática utilizada en la cocina mediterránea.",
                R.drawable.albahaca));
        plantas.add(new Planta("Hierbas", "Menta", "Mentha", "Verde",
                "La menta es una hierba refrescante y aromática conocida por sus usos en gastronomía y medicina.",
                R.drawable.menta));
        plantas.add(new Planta("Hierbas", "Orégano", "Origanum vulgare", "Verde",
                "El orégano es una hierba popular en la cocina italiana y mediterránea.",
                R.drawable.oregano));
        plantas.add(new Planta("Cactus", "Saguaro", "Carnegiea gigantea", "Verde",
                "El saguaro es un cactus característico del desierto de Sonora, famoso por su altura.",
                R.drawable.saguaro));
        plantas.add(new Planta("Cactus", "Aloe Vera", "Aloe barbadensis", "Verde",
                "El aloe vera es una planta suculenta conocida por sus propiedades medicinales.",
                R.drawable.aloe_vera));
        plantas.add(new Planta("Cactus", "Cactus de Navidad", "Schlumbergera", "Rosado",
                "El cactus de Navidad es una planta ornamental que florece en invierno.",
                R.drawable.cactus_navidad));
        plantas.add(new Planta("Frutales", "Manzano", "Malus domestica", "Verde",
                "El manzano es un árbol frutal cultivado por su fruto, la manzana.",
                R.drawable.manzano));
        plantas.add(new Planta("Frutales", "Naranjo", "Citrus sinensis", "Naranja",
                "El naranjo es un árbol cítrico que produce naranjas jugosas y dulces.",
                R.drawable.naranjo));
        plantas.add(new Planta("Frutales", "Limón", "Citrus limon", "Amarillo",
                "El limonero es un árbol pequeño que produce limones ácidos y fragantes.",
                R.drawable.limon));
        plantas.add(new Planta("Arbustos", "Hibisco", "Hibiscus rosa-sinensis", "Rojo",
                "El hibisco es un arbusto tropical que produce flores grandes y llamativas.",
                R.drawable.hibisco));
        plantas.add(new Planta("Arbustos", "Lavanda", "Lavandula", "Violeta",
                "La lavanda es un arbusto aromático conocido por sus usos en la perfumería y medicina.",
                R.drawable.lavanda));
        plantas.add(new Planta("Arbustos", "Buganvilla", "Bougainvillea", "Fucsia",
                "La buganvilla es una planta trepadora que adorna jardines con sus flores brillantes.",
                R.drawable.buganvilla));
        plantas.add(new Planta("Acuáticas", "Loto", "Nelumbo nucifera", "Rosa",
                "El loto es una planta acuática sagrada en varias culturas asiáticas.",
                R.drawable.loto));
        plantas.add(new Planta("Acuáticas", "Nenúfar", "Nymphaea", "Blanco",
                "El nenúfar es una planta acuática con hojas flotantes y flores vistosas.",
                R.drawable.nenufar));
    }
}
