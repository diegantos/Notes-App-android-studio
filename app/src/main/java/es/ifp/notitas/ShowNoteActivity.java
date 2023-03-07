package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowNoteActivity extends AppCompatActivity {
    protected TextView label1;
    protected Button btn1;
    protected Button btn2;
    private Intent pasarPantalla;
    private Bundle extras;
    private String paquete1;
    protected DataBaseSQL db;
    private int id = 0;
    private String contenidoCaja1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);
        getSupportActionBar().hide();

        label1 = (TextView) findViewById(R.id.label1_show);
        btn1 = (Button) findViewById(R.id.btn1_show);
        btn2 = (Button) findViewById(R.id.btn2_show);

        db = new DataBaseSQL(this);

        extras = getIntent().getExtras();
        if(extras != null){
            paquete1 = extras.getString("NOTA");
            label1.setText(paquete1);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(ShowNoteActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*label1.getId(contenidoCaja1);
                id = Integer.parseInt(contenidoCaja1);
                System.out.println("--> Imprimo supuesto id: " + id);
                System.out.println("--> Imprimo contenidoCaja: " + contenidoCaja1);*/

                String texto = label1.getText().toString();
                db.deleteNote(texto);

                Toast.makeText(ShowNoteActivity.this, getString(R.string.toast1_show), Toast.LENGTH_SHORT).show();
                pasarPantalla = new Intent(ShowNoteActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}