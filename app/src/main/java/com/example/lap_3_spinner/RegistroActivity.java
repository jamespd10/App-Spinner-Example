/*Corina Ruiz
* Nancy Díaz
* Jahir Calderon*/
package com.example.lap_3_spinner;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtContrasena;
    EditText txtCorreo;
    EditText txtEdad;
    RadioGroup Genero;
    String  nom, correo, edad,contra ,escuela, sexo;

    Button btRegistrar;
    Spinner spnOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.InicializarControles();
        this.LoadSpinners();
    }

    private void InicializarControles() {
        try {
            txtNombre = findViewById(R.id.txtNombre);
            txtCorreo = findViewById(R.id.txtCorreo);
            txtContrasena = findViewById(R.id.txtContrasena);
            txtEdad = findViewById(R.id.txtEdad);
            Genero = findViewById(R.id.RgGenero);
            btRegistrar = findViewById(R.id.btRegistrar);
            spnOpciones =findViewById(R.id.spnOpciones);

        nom = txtNombre.getText().toString();
        contra = txtContrasena.getText().toString();
        correo = txtCorreo.getText().toString();
        edad = txtEdad.getText().toString();

        //SELECCION DEL OBJETO SELECCIONADO DE LA LISTA DE ESCUELAS
        escuela = spnOpciones.getSelectedItem().toString();
        //SELECCION DEL BOTON SELECCIONADO DE EL GRUPO DE RADIOBUTTOM
        sexo = ((RadioButton)findViewById(Genero.getCheckedRadioButtonId() )).getText().toString();
        }
        catch (Exception e)
        {
            Toast.makeText (this, "Error:" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }

//METODO QUE CARGA EL LISTADO DE COLEGIOS EN EL SPINNER
    private void LoadSpinners(){

        List<String> operaciones = new ArrayList<String>();
        operaciones.add("Seleccionar Escuela");
        operaciones.add("IJA");
        operaciones.add("IBCM");
        operaciones.add("CBP");
        operaciones.add("CBDCV");
        operaciones.add("CNSB");

        ArrayAdapter<String> adapterList = new ArrayAdapter<String>
                (this, R.layout.support_simple_spinner_dropdown_item, operaciones);

        spnOpciones.setAdapter(adapterList);
    }


    public void Registrar(View view){
        nom = txtNombre.getText().toString();
        contra = txtContrasena.getText().toString();
        correo = txtCorreo.getText().toString();
        edad = txtEdad.getText().toString();

        //SELECCION DEL OBJETO SELECCIONADO DE LA LISTA DE ESCUELAS
        escuela = spnOpciones.getSelectedItem().toString();
        //SELECCION DEL BOTON SELECCIONADO DE EL GRUPO DE RADIOBUTTOM
        sexo = ((RadioButton)findViewById(Genero.getCheckedRadioButtonId() )).getText().toString();

        Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
        SharedPreferences user = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putString("txtNombre", nom);
        edit.putString("txtContrasena", contra);
        edit.putString("txtCorreo", correo);
        edit.putString("txtEdad", edad);
        edit.putString("spnOpciones", escuela);
        edit.putString("RgGenero", sexo);
        edit.apply();
        RegistroActivity.this.startActivity(intent);
    }

}

