package com.example.appplanet;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Animales extends AppCompatActivity {

    // Variables  ------------------------------------------------
    private Button btn_verAnimal;
    private ImageView animalImageView;
    private Spinner sp_especie, sp_raza, sp_grupo,sp_animal;
    private List<Animal> animales = new ArrayList<>();   // Colección de todos los animales
    private MediaPlayer mp;                              // Audio
    private TextView info;


    // Ciclo de vida (onCreate)  ------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animales);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Imágen animales -----
        animalImageView = findViewById(R.id.imageView);

        // Spinner-------
        sp_especie =findViewById(R.id.sp_especie);
        sp_raza =findViewById(R.id.sp_raza);
        sp_grupo =findViewById(R.id.sp_grupo);
        sp_animal =findViewById(R.id.sp_animal);

        // Boton para ver animales  ----
        btn_verAnimal = findViewById(R.id.btn_ver);

        // Descripcion de los animales -------
        info = findViewById(R.id.textView2);

        // Llamada de métodos ----
        cargarDatosAnimales();
        configurarEspecieSpinner();
        configurarAnimalSpinner();
        configurarRazaSpinner();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        if(mp != null){
            mp.release();
            mp = null;
        }
    }






    // Cargar datos animales ------------------------------------------------
    public void cargarDatosAnimales() {
        animales.add(new Animal("Aves", "Pájaro", "Gorrión", "Vertebrado", "ave", R.drawable.gorrion, R.raw.gorrion));

        animales.add(new Animal("Aves", "Cigüeña", "Oriental", "Invertebrado", "Es una especie grande y majestuosa de ave acuática de la " +
                  "familia Ciconiidae. Es nativa de Asia oriental, con una " +
                  "distribución que abarca principalmente China, Rusia, Japón y Corea",
                R.drawable.ciguena, R.raw.ciguena));

        animales.add(new Animal("Aves", "Halcón", "Rapaz", "Invertebrado", "El halcón es un ave rapaz conocida por su velocidad y aguda visión. " +
                "Se encuentra en una gran variedad de hábitats alrededor del mundo, " +
                "incluyendo montañas, bosques y llanuras abiertas. Son depredadores eficientes " +
                "y juegan un papel clave en el equilibrio de los ecosistemas.",
                R.drawable.halcon, R.raw.halcon));

        animales.add(new Animal("Aves", "Colibrí", "Rubí", "Vertebrado", "El colibrí rubí es un ave pequeña y vibrante conocida por " +
                "su habilidad para volar en todas direcciones y su plumaje iridiscente.",
                R.drawable.colibri_rubi, R.raw.colibri));

        animales.add(new Animal("Aves", "Pingüino", "Emperador", "Vertebrado", "El pingüino emperador es un ave no voladora conocida por " +
                "su habilidad para sobrevivir en condiciones extremas en la " +
                "Antártida. Se alimenta principalmente de peces y krill.",
                R.drawable.pinguino_, R.raw.pinguino));

        animales.add(new Animal("Aves", "Águila", "Real", "Vertebrado", "El águila real es un depredador impresionante conocido por " +
                "su gran tamaño y su capacidad para cazar animales de mediano tamaño.",
                R.drawable.aguila_real, R.raw.aguila_real));

        animales.add(new Animal("Aves", "Búho", "Nival", "Vertebrado", "El búho nival, también conocido como lechuza blanca, es una " +
                "especie que habita regiones frías y es fácilmente reconocible por su " +
                "plumaje completamente blanco.",
                R.drawable.buho_nival, R.raw.buho_nival));

        animales.add(new Animal("Aves", "Pelícano", "Común", "Vertebrado", "El pelícano común es un ave acuática conocida por su gran " +
                "bolsa en el pico que utiliza para atrapar peces en el agua.",
                R.drawable.pelicano_comun, R.raw.pelicano_comun));

        animales.add(new Animal("Aves", "Loro", "Arcoíris", "Vertebrado", "El loro arcoíris es una especie tropical conocida por su " +
                "plumaje de colores brillantes y su capacidad para imitar sonidos.",
                R.drawable.loro_arcoiris, R.raw.loro_arcoiris));

        animales.add(new Animal("Aves", "Flamenco", "Rosa", "Vertebrado", "El flamenco rosa es un ave conocida por sus largas patas, " +
                "cuello largo y su plumaje de color rosado debido a su dieta de crustáceos.",
                R.drawable.flamenco_rosa, R.raw.flamenco_rosa));

        animales.add(new Animal("Aves", "Cuervo", "Común", "Vertebrado", "El cuervo común es un ave muy inteligente y adaptable, " +
                "conocida por su capacidad para resolver problemas complejos.",
                R.drawable.cuervo_comun, R.raw.cuervo_comun));

        animales.add(new Animal("Aves", "Canario", "Doméstico", "Vertebrado", "El canario doméstico es un ave pequeña conocida por " +
                "su hermoso canto y su popularidad como ave de compañía.",
                R.drawable.canario, R.raw.canario));

        animales.add(new Animal("Aves", "Pavo", "Real", "Vertebrado", "El pavo real es conocido por sus plumas iridiscentes de la " +
                "cola, que despliega durante sus exhibiciones de cortejo.",
                R.drawable.pavo_real, R.raw.pavo_real));

        animales.add(new Animal("Aves", "Cacatúa", "Galerita", "Vertebrado", "La cacatúa galerita es una especie de ave conocida por " +
                "su cresta distintiva que levanta cuando se siente amenazada o emocionada.",
                R.drawable.cacatua, R.raw.cacatua));

        animales.add(new Animal("Aves", "Águila", "Calva", "Vertebrado", "El águila calva es un símbolo nacional en los Estados Unidos, " +
                "conocida por su cabeza blanca y su capacidad de caza.",
                R.drawable.aguila_calva, R.raw.aguila_calva));

        animales.add(new Animal("Aves", "Cisne", "Negro", "Vertebrado", "El cisne negro es un ave acuática reconocible por su elegante " +
                "plumaje negro y su pico de color rojo brillante.",
                R.drawable.cisne_negro, R.raw.cisne));

        animales.add(new Animal("Aves", "Tucán", "Común", "Vertebrado", "El tucán común es conocido por su gran pico de colores vivos " +
                "y su dieta de frutas y pequeños insectos.",
                R.drawable.tucan, R.raw.tucan));

        animales.add(new Animal("Aves", "Cárabo", "Lapón", "Vertebrado", "El cárabo lapón es una especie de búho grande que vive en " +
                "regiones boscosas del norte de Europa y Asia.",
                R.drawable.carabo_lapon, R.raw.carabo_lapon));








        animales.add(new Animal("Mamíferos", "León", "Katanga", "Vertebrado", "El león es un gran felino conocido como el 'rey de la selva'. " +
                "Es una especie social que vive en manadas, principalmente en las " +
                "praderas y sabanas de África. Su rugido es uno de los sonidos " +
                "más icónicos de la fauna salvaje.",
                R.drawable.leon, R.raw.leon));

        animales.add(new Animal("Mamíferos", "Oso", "Pardo", "Vertebrado", "El oso es un mamífero grande y fuerte, con pelaje grueso. " +
                "Existen diferentes especies distribuidas en bosques, montañas " +
                "y regiones polares. Son omnívoros y tienen un agudo sentido del " +
                "olfato que los ayuda a buscar alimento.",
                R.drawable.oso, R.raw.oso));

        animales.add(new Animal("Mamíferos", "Canguro", "Gris oriental", "Vertebrado", "El canguro es un marsupial nativo de Australia, conocido " +
                "por sus poderosas patas traseras y su capacidad para saltar grandes " +
                "distancias. Las hembras cuidan a sus crías en una bolsa llamada marsupio.",
                R.drawable.canguro, R.raw.canguro));

        animales.add(new Animal("Mamíferos", "Jirafa", "Reticulada", "Vertebrado", "La jirafa reticulada es el mamífero terrestre más alto, " +
                "conocida por su largo cuello y manchas distintivas. Habita " +
                "las sabanas y bosques de África.",
                R.drawable.jirafa, R.raw.jirafa));

        animales.add(new Animal("Mamíferos", "Zebra", "De las llanuras", "Vertebrado", "La zebra de las llanuras es un equino conocido por " +
                "su pelaje blanco y negro a rayas, que le proporciona camuflaje " +
                "en la naturaleza.",
                R.drawable.zebra, R.raw.zebra));

        animales.add(new Animal("Mamíferos", "Tigre", "De Bengala", "Vertebrado", "El tigre de Bengala es un gran felino que habita " +
                "los bosques y praderas de Asia, conocido por sus rayas naranjas " +
                "y negras.",
                R.drawable.tigre, R.raw.rigre));

        animales.add(new Animal("Mamíferos", "Delfín", "Mular", "Vertebrado", "El delfín mular es un mamífero marino inteligente y " +
                "social que habita en océanos de todo el mundo. Es conocido " +
                "por sus habilidades de comunicación y comportamiento juguetón.",
                R.drawable.delfin, R.raw.delfin));

        animales.add(new Animal("Mamíferos", "Ballena", "Azul", "Vertebrado", "La ballena azul es el animal más grande del planeta, " +
                "habita en océanos de todo el mundo y se alimenta principalmente " +
                "de krill.",
                R.drawable.ballena_azul, R.raw.ballena_azul));

        animales.add(new Animal("Mamíferos", "Rinoceronte", "Blanco", "Vertebrado", "El rinoceronte blanco es una especie de gran tamaño " +
                "que habita las praderas africanas, conocido por su piel gruesa y " +
                "su cuerno distintivo.",
                R.drawable.rinoceronte, R.raw.rinoceronte));

        animales.add(new Animal("Mamíferos", "Hipopótamo", "Común", "Vertebrado", "El hipopótamo común es un mamífero semiacuático que " +
                "vive en ríos y lagos de África, conocido por su gran tamaño y " +
                "sus mandíbulas poderosas.",
                R.drawable.hipopotamo, R.raw.hipopotamo));

        animales.add(new Animal("Mamíferos", "Lobo", "Ártico", "Vertebrado", "El lobo ártico es un mamífero carnívoro que vive en " +
                "regiones frías del Ártico, adaptado a climas extremos gracias " +
                "a su grueso pelaje.",
                R.drawable.lobo, R.raw.lobo));

        animales.add(new Animal("Mamíferos", "Zorro", "Rojo", "Vertebrado", "El zorro rojo es un mamífero pequeño y ágil, conocido " +
                "por su pelaje rojizo y su astucia para sobrevivir en diferentes " +
                "hábitats.",
                R.drawable.zorro, R.raw.zorro));

        animales.add(new Animal("Mamíferos", "Coyote", "Común", "Vertebrado", "El coyote es un mamífero carnívoro adaptado a una " +
                "gran variedad de hábitats en América del Norte, conocido por su " +
                "aullido distintivo.",
                R.drawable.coyote, R.raw.coyote));

        animales.add(new Animal("Mamíferos", "Armadillo", "Gigante", "Vertebrado", "El armadillo gigante es un mamífero acorazado que " +
                "habita en América del Sur. Es conocido por su caparazón " +
                "protector y su habilidad para excavar.",
                R.drawable.armadillo, R.raw.armadillo));

        animales.add(new Animal("Mamíferos", "Perezoso", "De tres dedos", "Vertebrado", "El perezoso de tres dedos es un mamífero arbóreo " +
                "que vive en las selvas tropicales de América Central y del Sur, " +
                "conocido por su lentitud y dieta de hojas.",
                R.drawable.perezoso, R.raw.perezoso));

        animales.add(new Animal("Mamíferos", "Murciélago", "Frugívoro", "Vertebrado", "El murciélago frugívoro es un mamífero volador " +
                "que se alimenta principalmente de frutas y desempeña un papel " +
                "clave en la dispersión de semillas.",
                R.drawable.murcielago, R.raw.murcielago));

        animales.add(new Animal("Mamíferos", "Orangután", "De Borneo", "Vertebrado", "El orangután de Borneo es un primate grande que " +
                "vive en los bosques tropicales de Borneo, conocido por su " +
                "inteligencia y comportamiento arbóreo.",
                R.drawable.orangutan, R.raw.orangutan));

        animales.add(new Animal("Mamíferos", "Chimpancé", "Común", "Vertebrado", "El chimpancé común es un primate altamente inteligente " +
                "que habita los bosques de África, conocido por su uso de " +
                "herramientas y su comportamiento social complejo.",
                R.drawable.chimpance, R.raw.chimpance));

        animales.add(new Animal("Mamíferos", "Gorila", "De montaña", "Vertebrado", "El gorila de montaña es el primate más grande, " +
                "habita los bosques montañosos de África y está en peligro " +
                "de extinción.",
                R.drawable.gorila, R.raw.gorila));

        animales.add(new Animal("Mamíferos", "Caballo", "Árabe", "Vertebrado", "El caballo árabe es una de las razas de caballos " +
                "más antiguas y reconocidas, conocida por su resistencia y " +
                "elegancia.",
                R.drawable.caballo, R.raw.caballo));

        animales.add(new Animal("Mamíferos", "Camello", "Bactriano", "Vertebrado", "El camello bactriano es un mamífero adaptado a " +
                "regiones áridas y frías, conocido por sus dos jorobas y su " +
                "resistencia a condiciones extremas.",
                R.drawable.camello, R.raw.camello));








        animales.add(new Animal("Insectos", "Avispa", "Asiática", "Invertebrado", "La avispa es un insecto volador con un cuerpo delgado y " +
                "rayado, conocido por su capacidad de picar en defensa propia. " +
                "Son importantes para el control de plagas y la polinización.",
                R.drawable.avispa, R.raw.avispa));

        animales.add(new Animal("Insectos", "Mariposa", "Peluda", "Invertebrado", "La mariposa es un insecto de colores vibrantes que " +
                "atraviesa una metamorfosis completa durante su ciclo de vida. " +
                "Son importantes polinizadores en los ecosistemas.",
                R.drawable.mariposa, R.raw.mariposa));

        animales.add(new Animal("Insectos", "Grillo", "Podoscirtinae", "Invertebrado", "El grillo es un insecto que emite un característico sonido " +
                "chirriante al frotar sus alas. Habita en campos, jardines y " +
                "otros espacios naturales, especialmente en climas cálidos.",
                R.drawable.grillo, R.raw.grillo));
    }


    // especieSpinner ------------------------------------------------
    public void configurarEspecieSpinner(){
        ArrayList<String>l = new  ArrayList<>(getEspecies());
        ArrayAdapter especieAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,l);
        especieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_especie.setAdapter(especieAdapter);

        sp_especie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedText = adapterView.getItemAtPosition(position).toString();
                actualizarAnimalAdapter(sp_especie);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public ArrayList getEspecies(){
        ArrayList<String> l = new  ArrayList<>();

        for (int i = 0; i < animales.size(); i++) {
            if(l.contains(animales.get(i).getEspecie()) == false){
                l.add(animales.get(i).getEspecie());
            }
        }

        return l;
    }


    // animalSpinner ------------------------------------------------
    public void configurarAnimalSpinner(){
        sp_animal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedText = adapterView.getItemAtPosition(position).toString();
                actualizarRazaAdapter(sp_animal);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void actualizarAnimalAdapter(Spinner spinner){
        ArrayAdapter adapterTemp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getAnimales(spinner));
        adapterTemp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_animal.setAdapter(adapterTemp);
        System.out.println("ello");
        //actualizarRazaAdapter(sp_animal);
    }

    public ArrayList getAnimales(Spinner spinner){
        String especieSeleccionada = getItemSeleccionadoSpinner(spinner);

        ArrayList<String> l = new  ArrayList<>();

        for (int i = 0; i < animales.size(); i++) {
            if(animales.get(i).getEspecie().equals(especieSeleccionada) && !l.contains(animales.get(i).getAnimal())){
                l.add(animales.get(i).getAnimal());
            }
        }

        return l;
    }


    // razaSpinner ------------------------------------------------
    public void configurarRazaSpinner(){
        sp_raza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedText = adapterView.getItemAtPosition(position).toString();
                actualizarGrupoAdapter(sp_raza);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void actualizarRazaAdapter(Spinner spinner){
        ArrayAdapter adapterTemp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getRazas(spinner));
        adapterTemp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_raza.setAdapter(adapterTemp);
        actualizarGrupoAdapter(sp_raza);
    }

    public ArrayList getRazas(Spinner spinner){
        String animalSeleccionado = getItemSeleccionadoSpinner(spinner);

        ArrayList<String> l = new  ArrayList<>();

        for (int i = 0; i < animales.size(); i++) {
            if(animales.get(i).getAnimal().equals(animalSeleccionado)){
                l.add(animales.get(i).getRaza());
            }
        }

        return l;
    }


    // grupoSpinner ------------------------------------------------
    public void actualizarGrupoAdapter(Spinner spinner){
        ArrayAdapter adapterTemp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getGrupos(spinner));
        adapterTemp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_grupo.setAdapter(adapterTemp);
    }

    public ArrayList getGrupos(Spinner spinner){
        String razaSeleccionada = getItemSeleccionadoSpinner(spinner);

        ArrayList<String> l = new  ArrayList<>();

        for (int i = 0; i < animales.size(); i++) {
            if(animales.get(i).getRaza().equals(razaSeleccionada)){
                l.add(animales.get(i).getGrupo());
            }
        }

        return l;
    }


    // Spinners ------------------------------------------------
    String getItemSeleccionadoSpinner(Spinner spinner){
        return new String(spinner.getSelectedItem().toString());
    }


    // Eventos con el boton ------------------------------------------------
    public void onClick(View v){
        String especie = getItemSeleccionadoSpinner(sp_especie);
        String animal = getItemSeleccionadoSpinner(sp_animal);
        String raza = getItemSeleccionadoSpinner(sp_raza);
        String grupo = getItemSeleccionadoSpinner(sp_grupo);

        for (int i = 0; i < animales.size(); i++) {
            String especieActual = animales.get(i).getEspecie();
            String animalActual =  animales.get(i).getAnimal();
            String razaActual =  animales.get(i).getRaza();
            String grupoActual = animales.get(i).getGrupo();
            String infoActual = animales.get(i).getInfo();
            int fotoRedId = animales.get(i).getFotoRedId();
            int sonidoResId = animales.get(i).getSonidoResId();

            if(especieActual.equals(especie) && animalActual.equals(animal) &&
                razaActual.equals(raza)      && grupoActual.equals(grupo)){
                animalImageView.setImageResource(fotoRedId);      // Imágen
                info.setText(infoActual);                         //Descripción

                if(mp != null){  // Reproducción del sonido
                    mp.release();
                }
                mp = MediaPlayer.create(this, sonidoResId);
                mp.start();

                break;
            }
        }
    }
}