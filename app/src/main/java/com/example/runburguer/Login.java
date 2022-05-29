package com.example.runburguer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    EditText editusuario, editpass;
    String perfil1 ="1";
    String perfil2 ="2";
    RequestQueue requestQueue;
    private ProgressBar progreso;
    private Button boton;
    private Boolean cargando = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editusuario=(EditText)findViewById(R.id.Correo);
        editpass=(EditText)findViewById(R.id.Contraseña);
        relacion();
        click();
        progreso.setVisibility(View.GONE);
    }



    public void registrarse (View view){

        Intent j = new Intent(Login.this, AgregarCliente.class);
        startActivity(j);

    }

    public void iniciarsesion (View view){
        loginUsuario("http://"+URL.IP+"/"+URL.sitio+"/validarsesion.php?usuario="+editusuario.getText().toString()+ "&contrasena="+editpass.getText().toString());
    }

    public void loginUsuario(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, response -> {
            JSONObject jsonObject;
            for (int i = 0; i < response.length(); i++) {
                try {
                    jsonObject = (JSONObject) response.getJSONObject(i);
                    if(editusuario.getText().toString().equals(jsonObject.getString("usuario")) &&
                            editpass.getText().toString().equals(jsonObject.getString("contrasena"))){
                    }
                    if (perfil1.equals(jsonObject.getString("id_perfil"))) {
                        Intent j = new Intent(Login.this, MenuPrincipal.class);
                        j.putExtra("id", jsonObject.getString("id_usuario"));
                        j.putExtra("nombre", jsonObject.getString("nombre"));
                        j.putExtra("apellido", jsonObject.getString("apellido"));
                        j.putExtra("correo", jsonObject.getString("correo"));
                        j.putExtra("telefono", jsonObject.getString("telefono"));
                        startActivity(j);
                    }
                    else if(perfil2.equals(jsonObject.getString("id_perfil"))){
                        Intent j = new Intent(Login.this, MenuAdmin.class);
                        j.putExtra("id", jsonObject.getString("id_usuario"));
                        j.putExtra("nombre", jsonObject.getString("nombre"));
                        j.putExtra("apellido", jsonObject.getString("apellido"));
                        j.putExtra("correo", jsonObject.getString("correo"));
                        j.putExtra("telefono", jsonObject.getString("telefono"));
                        startActivity(j);
                    }

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, error -> Toast.makeText(getApplicationContext(), "DATOS INCORRECTOS, INTENTE DE NUEVO",
                Toast.LENGTH_SHORT).show()
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit?")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent (Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void relacion (){
        progreso = findViewById(R.id.cargalogin);
        boton = findViewById(R.id.Iniciando);
    }

    private void click (){
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarsesion(view);
                if (!cargando){
                    progreso.setVisibility(View.VISIBLE);
                }else{
                    progreso.setVisibility(View.GONE);
                }
                cargando = !cargando;
            }
        });
    }

}
