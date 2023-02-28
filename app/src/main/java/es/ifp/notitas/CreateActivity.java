package es.ifp.notitas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CreateActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText input1;
    protected Button btn1;
    protected Button btn2;
    protected String texto;
    protected DataBaseSQL db;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Objects.requireNonNull(getSupportActionBar()).hide();

        label1 = (TextView) findViewById(R.id.label1_create);
        input1 = (EditText) findViewById(R.id.input1_create);
        btn1 = (Button) findViewById(R.id.btn1_create);
        btn2 = (Button) findViewById(R.id.btn2_create);

        db = new DataBaseSQL(this);

        btn1.setOnClickListener(view -> {
            texto = input1.getText().toString();
            if(texto.equals("")){
                System.out.println("-->Hasta aquí todo bien");
                Toast.makeText(CreateActivity.this, "Debe introducir una nota", Toast.LENGTH_SHORT).show();
            }else{
                System.out.println("-->Hasta aquí todo bien vale");
                db.insertNote(texto);
                Toast.makeText(CreateActivity.this, "Nota insertada", Toast.LENGTH_SHORT).show();
                pasarPantalla = new Intent(CreateActivity.this, ListActivity.class);
                pasarPantalla.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(pasarPantalla);
            }
        });

        btn2.setOnClickListener(view -> {
            pasarPantalla = new Intent(CreateActivity.this, ListActivity.class);
            finish();
            startActivity(pasarPantalla);
        });
    }


}