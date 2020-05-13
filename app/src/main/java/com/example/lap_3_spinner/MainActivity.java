package com.example.lap_3_spinner;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InicializarControles();
    }

    private void InicializarControles()
    {
        usuario = findViewById(R.id.txtUsuario);
        contrasena = findViewById(R.id.txtContrasena);
    }

    public void Registrar1(View view)
    {
        try{
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);
            }
        catch (Exception e)
            {
                Toast.makeText (this, "Error al intentar volver" + e.getMessage(),Toast.LENGTH_SHORT).show();
            }

    }


    public void Login (View view){
        SharedPreferences user = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String usuE = usuario.getText().toString();
        String contra =contrasena.getText().toString();

        String user2 = user.getString("txtNombre","usuario1");
        String contra2 = user.getString("txtContrasena","1234");

        if (user2.equals(usuE)) {
            if (contra2.equals(contra))
            {
                Intent i = new Intent(MainActivity.this, ResultadoActivity.class);
                i.putExtra("usuario", usuario.getText().toString() );
                startActivity(i);
            }else {
                Toast.makeText(this,"Contrasena Incorrecta",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this,"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }

}

