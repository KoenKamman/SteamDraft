package nl.code7.steamdraft.api;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import nl.code7.steamdraft.dao.User;

public class SteamApiConnector extends AsyncTask<String, Void, String> {

    private SteamConnectorListener listener;
    private static final String TAG = SteamApiConnector.class.getName();

    public SteamApiConnector(SteamConnectorListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... urls) {

        BufferedReader reader = null;
        String response = "";

        try {
            URL url = new URL(urls[0]);
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while( (line = reader.readLine()) != null ) {
                response += line;
            }

        } catch(IOException e){
            Log.e(TAG, "exception", e);
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, "exception", e);
                }
            }
        }

        return response;
    }

    @Override
    protected void onPostExecute(String response){
        User user;

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray users = jsonObject.getJSONObject("response").getJSONArray("players");

            for (int i = 0; i < users.length(); i++){
                JSONObject curUser = users.getJSONObject(i);
                user = new User();

                if (curUser.has("steamid")){
                    user.setSteamID(curUser.getLong("steamid"));
                }

                if (curUser.has("personaname")){
                    user.setPersonaName(curUser.getString("personaname"));
                }

                if (curUser.has("profileurl")){
                    user.setProfileUrl(curUser.getString("profileurl"));
                }

                if (curUser.has("avatar")){
                    user.setAvatar(curUser.getString("avatar"));
                }

                if (curUser.has("avatarmedium")){
                    user.setAvatarMedium(curUser.getString("avatarmedium"));
                }

                if (curUser.has("avatarfull")){
                    user.setAvatarFull(curUser.getString("avatarfull"));
                }

                if (curUser.has("personastate")){
                    user.setPersonaState(curUser.getInt("personastate"));
                }

                if (curUser.has("communityvisibilitystate")){
                    user.setCommunityVisibilityState(curUser.getInt("communityvisibilitystate"));
                }

                if (curUser.has("profilestate")){
                    user.setProfileState(curUser.getInt("profilestate"));
                }

                if (curUser.has("lastlogoff")){
                    user.setLastLogoff(curUser.getLong("lastlogoff"));
                }

                if (curUser.has("realname")){
                    user.setRealName(curUser.getString("realname"));
                }

                if (curUser.has("primaryclanid")){
                    user.setPrimaryClanID(curUser.getLong("primaryclanid"));
                }

                if (curUser.has("timecreated")){
                    user.setTimeCreated(curUser.getLong("timecreated"));
                }

                if (curUser.has("gameid")){
                    user.setGameID(curUser.getInt("gameid"));
                }

                if (curUser.has("gameextrainfo")){
                    user.setGameExtraInfo(curUser.getString("gameextrainfo"));
                }

                if (curUser.has("loccountrycode")){
                    user.setLocCountryCode(curUser.getString("loccountrycode"));
                }

                if (curUser.has("locstatecode")){
                    user.setLocStateCode(curUser.getString("locstatecode"));
                }

                if (curUser.has("loccityid")){
                    user.setLocCityID(curUser.getLong("loccityid"));
                }

                listener.onUserAvailable(user);
            }

        } catch (JSONException e){
            Log.e(TAG, "exception", e);
        }

    }

}
