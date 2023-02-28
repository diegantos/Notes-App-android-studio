package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    protected TextView label1;
    protected ListView lista1;
    protected DataBaseSQL db;

    private ArrayList<String> filas = new ArrayList<String>();
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        label1 = (TextView) findViewById(R.id.label1_list);
        lista1 = (ListView) findViewById(R.id.list1_list);

        db = new DataBaseSQL(this);

        db.insertNote("Bajar al perro");
        db.insertNote("Hacer la colada");


        filas = db.getAllNotes();
        adaptador = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, filas);
        lista1.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_crear_start:
                Intent pasarPantalla = new Intent(ListActivity.this, CreateActivity.class);
                finish();
                startActivity(pasarPantalla);
                return true;
            case R.id.item_opciones_start:
                Intent pasarPantalla = new Intent(ListActivity.this, DeleteNoteActivity.class);
                finish();
                startActivity(pasarPantalla);
                //System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}