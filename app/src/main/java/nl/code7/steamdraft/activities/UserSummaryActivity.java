package nl.code7.steamdraft.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import nl.code7.steamdraft.BuildConfig;
import nl.code7.steamdraft.api.UserRequest;
import nl.code7.steamdraft.dao.User;
import nl.code7.steamdraft.R;
import nl.code7.steamdraft.api.ApiListener;

public class UserSummaryActivity extends AppCompatActivity implements ApiListener {

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
        UserRequest req = new UserRequest(getApplicationContext(), this);
        req.getUsers();
    }

    @Override
    public void onUserAvailable(User user) {
        Log.i(TAG, user.toString());
    }
}
