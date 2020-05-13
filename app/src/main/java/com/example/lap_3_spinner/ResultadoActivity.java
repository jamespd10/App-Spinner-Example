package com.example.lap_3_spinner;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;



public class ResultadoActivity extends AppCompatActivity {
    //Declaraciones
    String Usuario;
    String Clave;
    String Email;
    String Edads;
    String Escuela;
    String sexo;

    TextView Nombre;
    TextView Contrasena;
    TextView Correo;
    TextView Edad;
    TextView sch;
    TextView sex;
    Button btRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Nombre = findViewById(R.id.txtusuario);
        Contrasena = findViewById(R.id.txtContrasena);
        Correo = findViewById(R.id.txtCorreo);
        Edad = findViewById(R.id.txtEdad);
        sch = findViewById(R.id.spnOpciones);
        sex = findViewById(R.id.RgGenero);
        btRegresar = findViewById(R.id.btRegresar);

        SharedPreferences prefs = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

            Usuario = prefs.getString("txtNombre", "No hay");
            Clave = prefs.getString("txtContrasena", "No hay");
            Email = prefs.getString("txtCorreo", "No hay");
            Edads = prefs.getString("txtEdad", "No hay");
            Escuela = prefs.getString("spnOpciones", "No hay");
            sexo = prefs.getString("RgGenero", "No hay");
            
            // SE CONCATENA EN UNA VARIABLE STRING PORQUE MANDABA ERROR AL CONCATENAR
            String Impre1 = ("Usuario: "+ Usuario);
            Nombre.setText(Impre1);

            String Impre2 = ("Correo: "+ Email);
            Correo.setText(Impre2);

            String Impre3 = ("Edad: "+Edads);
            Edad.setText(Impre3);

            String Impre4 = ("Escuela: "+ Escuela);
            sch.setText(Impre4);

            String Impre5 = ("Genero: "+ sexo);
            sex.setText(Impre5);



    }

            public void Regresar (View view) {
                try
                {
                    Intent intent = new Intent (ResultadoActivity.this, RegistroActivity.class);
                    ResultadoActivity.this.startActivity(intent);
                }
                catch (Exception e)
                {
                    Toast.makeText (this, "Error al intentar volver" + e.getMessage(),Toast.LENGTH_SHORT).show(); }
            }
}