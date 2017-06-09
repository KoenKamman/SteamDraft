package nl.code7.steamdraft.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import nl.code7.steamdraft.BuildConfig;
import nl.code7.steamdraft.dao.User;
import nl.code7.steamdraft.R;
import nl.code7.steamdraft.api.SteamApiConnector;
import nl.code7.steamdraft.api.SteamConnectorListener;

public class UserSummaryActivity extends AppCompatActivity implements SteamConnectorListener {

    private static final String API_KEY = BuildConfig.API_KEY;
    private static final String TAG = UserSummaryActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_summary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String steamId = getIntent().getExtras().getString("STEAM_ID");
        getUser(steamId);
    }

    public void getUser(String id){
        SteamApiConnector connector = new SteamApiConnector(this);
        String[] urls = new String[] {"http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" + API_KEY + "&steamids=" + id};
        connector.execute(urls);
    }

    @Override
    public void onUserAvailable(User user) {
        Log.i(TAG, user.toString());
    }
}