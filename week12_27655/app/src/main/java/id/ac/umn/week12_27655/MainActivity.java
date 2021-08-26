package id.ac.umn.week12_27655;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnA, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.button_a);
        btnB = findViewById(R.id.button_b);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecond = new Intent(MainActivity.this, ActivityPertama.class);
                startActivityForResult(intentSecond, 1);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThird = new Intent(MainActivity.this, ActivityKedua.class);
                startActivityForResult(intentThird, 1);
            }
        });
    }
}