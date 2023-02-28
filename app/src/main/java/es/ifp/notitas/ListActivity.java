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

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    protected TextView label1;
    protected ListView lista1;
    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        label1 = (TextView) findViewById(R.id.label1_list);
        lista1 = (ListView) findViewById(R.id.list1_list);

        db = new DataBaseSQL(this);

        ArrayList<String> filas = db.getAllNotes();
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, filas);
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
        if (item.getItemId() == R.id.item_crear_start) {
            finish();
            startActivity(new Intent(ListActivity.this, CreateActivity.class));
            return true;
        }
        if (item.getItemId() == R.id.item_opciones_start) {
            finish();
            startActivity(new Intent(ListActivity.this, DeleteAllNotesActivity.class));
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }
}