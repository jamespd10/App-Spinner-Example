package com.example.lap_3_spinner;

import android.content.Intent;
import android.os.Bundle;
/*import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;*/
import android.support.v7.app.AppCompatActivity;
/*import android.support.v7.widget.Toolbar;
import android.view.View;*/
import android.widget.TextView;

//import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    TextView txtUsuario;
    String nombreUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent i = getIntent();

        this.InicializarControles();
        this.ObtenerValoresIntetn(i);

        txtUsuario.setText("Bienvenido " + nombreUsuario);
    }

    private void InicializarControles(){

        txtUsuario = (TextView)findViewById(R.id.txtUsuario);
    }

    private void ObtenerValoresIntetn(Intent entranteIntent)
    {
        nombreUsuario = entranteIntent.getStringExtra("usuario");
    }

}