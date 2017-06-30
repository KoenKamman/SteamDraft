package nl.code7.steamdraft.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        if (sharedPref.contains("STEAM_ID")){
            Intent i = new Intent(getApplicationContext(), UserSummaryActivity.class);
            startActivity(i);
        } else {
            Intent intent = new Intent(this, SteamAuthActivity.class);
            startActivityForResult(intent, STEAMID_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == STEAMID_REQUEST && resultCode == RESULT_OK) {
            SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("STEAM_ID", data.getExtras().getString("STEAM_ID"));
            editor.commit();

            Intent i = new Intent(getApplicationContext(), UserSummaryActivity.class);
            startActivity(i);
        }
    }
}
