package nl.code7.steamdraft;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SteamAuthActivity extends AppCompatActivity {

    private static final String REALM_PARAM = "SteamDraft";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                Uri uri = Uri.parse(url);

                if (uri.getAuthority().equalsIgnoreCase(REALM_PARAM)) {

                    webView.stopLoading();

                    Uri userAccountUrl = Uri.parse(uri.getQueryParameter("openid.identity"));
                    String userId = userAccountUrl.getLastPathSegment();

                    Intent intent = getIntent();
                    intent.putExtra("STEAM_ID", userId);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }

        });

        setContentView(webView);

        String url = "https://steamcommunity.com/openid/login?" +
                "openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.identity=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.mode=checkid_setup&" +
                "openid.ns=http://specs.openid.net/auth/2.0&" +
                "openid.realm=https://" + REALM_PARAM + "&" +
                "openid.return_to=https://" + REALM_PARAM + "/signin/";

        webView.loadUrl(url);

    }
}
