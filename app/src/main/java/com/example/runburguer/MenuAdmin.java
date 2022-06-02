package com.example.runburguer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuAdmin extends AppCompatActivity {
        ImageButton imb1, imb2, imb3, imb4, imb5;
        Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        imb1 = findViewById(R.id.imageButton1);
        imb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuAdmin.this, AgregarMenu.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A AGREGAR CARTA", Toast.LENGTH_SHORT).show();
            }
        });

        imb2 = findViewById(R.id.imageButton2);
        imb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuAdmin.this, GestionProductos.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A GESTIÓN DE PRODUCTOS", Toast.LENGTH_SHORT).show();
            }
        });

        imb3 = findViewById(R.id.imageButton3);
        imb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuAdmin.this, GestionUsuarios.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A GESTIÓN DE USUARIOS", Toast.LENGTH_SHORT).show();
            }
        });

        imb4 = findViewById(R.id.imageButton4);
        imb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuAdmin.this, Comentarios.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A SECCIÓN DE COMENTARIOS", Toast.LENGTH_SHORT).show();
            }
        });

        imb5 = findViewById(R.id.imageButton5);
        imb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuAdmin.this, GestionVentas.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A SECCIÓN DE VENTAS", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Deseas salir?")
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Item1) {
            Intent j = new Intent(MenuAdmin.this, Item1.class);
            startActivity(j);
        } else if (id == R.id.Item2) {
            Intent j = new Intent(MenuAdmin.this, Item2.class);
            startActivity(j);
        } else if (id == R.id.Item3) {
           finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

