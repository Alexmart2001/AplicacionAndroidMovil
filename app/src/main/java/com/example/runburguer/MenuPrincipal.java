package com.example.runburguer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {

    ImageButton carta;
    ImageButton pedidos;
    ImageButton reservaciones;
    ImageButton descuentos;
    ImageButton estados;
    ImageButton quejas;
    ImageButton info;
    Button modifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    carta = findViewById(R.id.imageButton);
    carta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = getIntent().getExtras().getString("nombre");
            String apellido = getIntent().getExtras().getString("apellido");
            Intent j = new Intent(MenuPrincipal.this, carta.class);
            j.putExtra("nombre", nombre);
            j.putExtra("apellido", apellido);
            startActivity(j);
            Toast.makeText(getApplicationContext(),"PASA A MENU DISPONIBLE", Toast.LENGTH_SHORT).show();
        }
    });

    pedidos = findViewById(R.id.imageButton2);
    pedidos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = getIntent().getExtras().getString("nombre");
            String apellido = getIntent().getExtras().getString("apellido");
            Intent j = new Intent(MenuPrincipal.this, Pedidos.class);
            j.putExtra("nombre", nombre);
            j.putExtra("apellido", apellido);
            startActivity(j);
            Toast.makeText(getApplicationContext(),"PASA A SECCION PEDIDOS", Toast.LENGTH_SHORT).show();

        }
    });

    reservaciones = findViewById(R.id.imageButton3);
    reservaciones.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = getIntent().getExtras().getString("nombre");
            String apellido = getIntent().getExtras().getString("apellido");
            Intent j = new Intent(MenuPrincipal.this, Reservas.class);
            j.putExtra("nombre", nombre);
            j.putExtra("apellido", apellido);
            startActivity(j);
            Toast.makeText(getApplicationContext(),"PASA A SECCIÓN RESERVAS", Toast.LENGTH_SHORT).show();
        }
    });

    descuentos = findViewById(R.id.imageButton4);
    descuentos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = getIntent().getExtras().getString("nombre");
            String apellido = getIntent().getExtras().getString("apellido");
            Intent j = new Intent(MenuPrincipal.this, Descuentos.class);
            j.putExtra("nombre", nombre);
            j.putExtra("apellido", apellido);
            startActivity(j);
            Toast.makeText(getApplicationContext(),"PASA A DESCUENTOS", Toast.LENGTH_SHORT).show();

        }
    });
    estados = findViewById(R.id.imageButton7);
    estados.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = getIntent().getExtras().getString("nombre");
            String apellido = getIntent().getExtras().getString("apellido");
            Intent j = new Intent(MenuPrincipal.this, Seguimiento.class);
            j.putExtra("nombre", nombre);
            j.putExtra("apellido", apellido);
            startActivity(j);
            Toast.makeText(getApplicationContext(),"PASA A SEGUIMIENTO PEDIDO", Toast.LENGTH_SHORT).show();

        }
    });

        quejas = findViewById(R.id.imageButton6);
        quejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuPrincipal.this, VerComentarios.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A COMENTARIOS DE USUARIOS", Toast.LENGTH_SHORT).show();

            }
        });

        info = findViewById(R.id.imageButton5c);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                Intent j = new Intent(MenuPrincipal.this, descripcion.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PASA A INFORMACIÓN SOBRE LA APP", Toast.LENGTH_SHORT).show();
            }
        });

        modifica = findViewById(R.id.button5);
        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = getIntent().getExtras().getString("nombre");
                String apellido = getIntent().getExtras().getString("apellido");
                String correo = getIntent().getExtras().getString("correo");
                String tel = getIntent().getExtras().getString("telefono");
                String id_user = getIntent().getExtras().getString("id");
                Intent j = new Intent(MenuPrincipal.this, ModificarDatosUsuario.class);
                j.putExtra("nombre", nombre);
                j.putExtra("apellido", apellido);
                j.putExtra("id_usuario", id_user);
                j.putExtra("correo", correo);
                j.putExtra("telefono", tel);
                startActivity(j);
                Toast.makeText(getApplicationContext(),"PERMITE MODIFICAR USUARIOS", Toast.LENGTH_SHORT).show();
            }
        });
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
}