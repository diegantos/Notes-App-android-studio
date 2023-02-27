package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    protected DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = new DataBaseSQL(this);
        System.out.println("-->Numero de notas:" + db.numberOfNotes());
        db.insertNote("Bajar al perro");
        System.out.println("-->Numero de notas:" + db.numberOfNotes());

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
                Toast.makeText(this, "Estás intentando añadir un elemento", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_opciones_start:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}