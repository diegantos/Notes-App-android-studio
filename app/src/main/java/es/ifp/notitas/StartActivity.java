package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
        getSupportActionBar().hide();

        label1 = (TextView) findViewById(R.id.label1_start);
        img1 = (ImageView) findViewById(R.id.img1_start);

        TimerTask myTimerTask = new TimerTask() {
            @Override
            public void run() {
                pasarPantalla = new Intent(StartActivity.this, CreateActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        };
        Timer timer = new Timer();
        timer.schedule(myTimerTask, 2000);

    }
}