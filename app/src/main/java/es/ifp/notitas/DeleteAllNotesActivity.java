package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteAllNotesActivity extends AppCompatActivity {

    protected Button btn1;
    protected Button btn2;
    private Intent pasarPantalla;
    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);
        getSupportActionBar().hide();

        btn1 = (Button) findViewById(R.id.btn1_delete);
        btn2 = (Button) findViewById(R.id.btn2_delete);
        db = new DataBaseSQL(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteAllNotes();
                pasarPantalla = new Intent(DeleteAllNotesActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);
                Toast.makeText(DeleteAllNotesActivity.this, "Se han eliminado todas las notas correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(DeleteAllNotesActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}