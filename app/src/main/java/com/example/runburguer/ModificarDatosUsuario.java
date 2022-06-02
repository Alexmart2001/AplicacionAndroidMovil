package com.example.runburguer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ModificarDatosUsuario extends AppCompatActivity {

    private StringRequest stringRequest;
    private RequestQueue requestQueue;
    EditText nombre, apellido, correo, telefono, contraseña, usuarioss;
    TextView muestra;
    String nombres, apellidos, idd, correos, telefonos, con, uss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos_usuario);
        muestra =(TextView) findViewById(R.id.nusu2);
        idd = getIntent().getExtras().getString("id_usuario");
        nombres = getIntent().getExtras().getString("nombre");
        apellidos = getIntent().getExtras().getString("apellido");
        correos = getIntent().getExtras().getString("correo");
        telefonos = getIntent().getExtras().getString("telefono");
       uss = getIntent().getExtras().getString("usuario");
        con = getIntent().getExtras().getString("contrasena");

        muestra.setText(""+nombres+" "+apellidos);


        nombre= (EditText) findViewById(R.id.editTextTextNombre);
        apellido= (EditText) findViewById(R.id.editTextTextApellido);
        correo= (EditText) findViewById(R.id.editTextTextCorreo);
        telefono= (EditText) findViewById(R.id.editTextTextTelefono);
        contraseña= (EditText) findViewById(R.id.editTextTextcontraseña);
        usuarioss = (EditText) findViewById(R.id.editTextTextTelefono2);

        nombre.setText(nombres);
        apellido.setText(apellidos);
        correo.setText(correos);
        telefono.setText(telefonos);
        contraseña.setText(con);
        usuarioss.setText(uss);

    }

    public void modificar (View view){
        ejecutarDatos("http://"+URL.IP+"/"+URL.sitio+"/"+"modificarcliente.php?id_usuario="+ idd + "");
    }
    public void ejecutarDatos(String URL) {
        stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACIÓN ÉXITOSA", Toast.LENGTH_SHORT).show();
                limpiarfor();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("id_usuario", idd);
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellido", apellido.getText().toString());
                parametros.put("correo", correo.getText().toString());
                parametros.put("telefono", telefono.getText().toString());
                parametros.put("contrasena", contraseña.getText().toString());
                parametros.put("usuario", usuarioss.getText().toString());
                return parametros;
            }
        };
        //Describe como envíar los datos a la base de datos
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Toast.makeText(getApplicationContext(), "Usuario modificado", Toast.LENGTH_SHORT).show();
    }

    private void limpiarfor(){
        nombre.setText("");
        apellido.setText("");
        correo.setText("");
        telefono.setText("");
        contraseña.setText("");
        usuarioss.setText("");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Deseas salir?")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
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


}