package nl.code7.steamdraft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    static final int STEAMID_REQUEST = 1;
    private static final String API_KEY = BuildConfig.API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SteamAuthActivity.class);
        //startActivityForResult(intent, STEAMID_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == STEAMID_REQUEST) {

            if (resultCode == RESULT_OK) {
                String steamId = data.getExtras().getString("STEAM_ID");
                Log.i("STEAMAUTH", "STEAM_ID = " + steamId);
            }
        }
    }
}
