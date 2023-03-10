package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        getSupportActionBar().hide();

        label1 = (TextView) findViewById(R.id.label1_create);
        input1 = (EditText) findViewById(R.id.input1_create);
        btn1 = (Button) findViewById(R.id.btn1_create);
        btn2 = (Button) findViewById(R.id.btn2_create);

        db = new DataBaseSQL(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto = input1.getText().toString();
                if(texto.equals("")){
                    Toast.makeText(CreateActivity.this, getString(R.string.toast1_create), Toast.LENGTH_SHORT).show();
                }else{
                    db.insertNote(texto);
                    Toast.makeText(CreateActivity.this, getString(R.string.toast2_create), Toast.LENGTH_SHORT).show();
                    pasarPantalla = new Intent(CreateActivity.this, ListActivity.class);
                    pasarPantalla.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(pasarPantalla);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(CreateActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }


}