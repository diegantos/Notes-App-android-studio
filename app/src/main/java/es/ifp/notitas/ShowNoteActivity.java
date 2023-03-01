package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ShowNoteActivity extends AppCompatActivity {

    protected ListView list1;
    protected Button btn1;
    protected Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);
        getSupportActionBar().hide();

        list1 = (ListView) findViewById(R.id.list1_show);
        btn1 = (Button) findViewById(R.id.btn1_show);
        btn2 = (Button) findViewById(R.id.btn2_show);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowNoteActivity.this, "He pulsado en borrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}