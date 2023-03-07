package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    private String contenidoItem = "";
    private String[] partes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        label1 = (TextView) findViewById(R.id.label1_list);
        lista1 = (ListView) findViewById(R.id.list1_list);

        db = new DataBaseSQL(this);

        filas = db.getAllNotes();
        adaptador = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, filas);
        lista1.setAdapter(adaptador);

        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contenidoItem = adapterView.getItemAtPosition(i).toString();

                Intent pasarPantalla = new Intent(ListActivity.this, ShowNoteActivity.class);
                pasarPantalla.putExtra("NOTA", contenidoItem);
                finish();
                startActivity(pasarPantalla);
            }
        });

        /*lista1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                contenidoItem = adapterView.getItemAtPosition(i).toString();
                partes = contenidoItem.split(" ");
                System.out.println("-->partes");
                Toast.makeText(ListActivity.this, "He pulsado A", Toast.LENGTH_SHORT).show();

                return true;
            }
        });*/
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
                Intent pasarPantalla2 = new Intent(ListActivity.this, DeleteAllNotesActivity.class);
                finish();
                startActivity(pasarPantalla2);
                //System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}