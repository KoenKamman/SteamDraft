package nl.code7.steamdraft.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nl.code7.steamdraft.R;

public class MainActivity extends AppCompatActivity {
    static final int STEAMID_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SteamAuthActivity.class);
        //startActivityForResult(intent, STEAMID_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == STEAMID_REQUEST && resultCode == RESULT_OK) {
            Intent i = new Intent(getApplicationContext(), UserSummaryActivity.class);
            i.putExtras(data.getExtras());
            startActivity(i);
        }
    }
}
