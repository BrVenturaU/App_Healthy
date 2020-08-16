package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ConfigActivity extends AppCompatActivity implements  View.OnClickListener {
    private EditText etNombre;
    private Button btnGuardar;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        etNombre = findViewById(R.id.etNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        layout = findViewById(R.id.clConfig);

        SharedPreferences myPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE);

        String nombreUsuario = myPreferences.getString("nombrePersona","");
        etNombre.setText(nombreUsuario);

        btnGuardar.setOnClickListener(this);
    }

    private String crearNombreUsuario(String nombre){
        try {
            String[] partesNombre = nombre.split(" ");
            String nombreUsuario = "";
            for(String parteNombre : partesNombre){
                nombreUsuario += parteNombre.substring(0,1);
            }
            return  nombreUsuario;
        }catch (Exception ex) {
            return "";
        }

    }

    @Override
    public void onClick(View view) {
        int idComponentView = view.getId();
        switch (idComponentView){
            case R.id.btnGuardar:{
                String nombre = crearNombreUsuario(etNombre.getText().toString());
                if(nombre.isEmpty()){
                    Snackbar snackbar = Snackbar.make(layout, R.string.snbConfiguracionError, Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(), R.color.colorError));
                    snackbar.show();
                }else{
                    SharedPreferences myPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE);

                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putString("nombreUsuario", nombre);
                    myEditor.putString("nombrePersona", etNombre.getText().toString());
                    myEditor.commit();

                    Snackbar snackbar = Snackbar.make(layout, R.string.snbConfiguracionExito, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                    snackbar.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ConfigActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }, 1000);
                }
            }
        }
    }
}