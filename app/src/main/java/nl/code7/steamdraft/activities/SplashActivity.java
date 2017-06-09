package nl.code7.steamdraft.activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nl.code7.steamdraft.R;

public class SplashActivity extends AppCompatActivity {

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hide actionbar.
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Wait 10 seconds before launching intent.
        timer = new CountDownTimer(10000, 250) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        }.start();
    }
}
