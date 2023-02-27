package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    protected TextView label1;
    protected ImageView img1;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label1 = (TextView) findViewById(R.id.label1_start);
        img1 = (ImageView) findViewById(R.id.img1_start);

        TimerTask myTimerTask = new TimerTask() {
            @Override
            public void run() {
                pasarPantalla = new Intent(StartActivity.this, ListActivity.this);
                finish();
                startActivity(pasarPantalla);
            }
        };
        Timer timer = new Timer();
        timer.schedule(myTimerTask, 2000);

    }
}