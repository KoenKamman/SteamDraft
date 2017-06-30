package nl.code7.steamdraft.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import nl.code7.steamdraft.dao.User;

/**
 * Created by Koen Kamman on 30-6-2017.
 */

public class UserRequest {

    private final String TAG = UserRequest.class.getName();
    private Context ctx;
    private ApiListener listener;

    public UserRequest(Context context, ApiListener listener) {
        this.listener = listener;
        ctx = context;
    }

    public void getUsers() {
        String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=03F72570107EDDE4CD1FC92CDD38CFAA&steamids=76561197960435530,76561197960435530";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray players = response.getJSONObject("response").getJSONArray("players");

                            for (int i = 0; i < players.length(); i++) {
                                JSONObject curUser = players.getJSONObject(i);
                                User user = new User();

                                if (curUser.has("steamid")) {
                                    user.setSteamID(curUser.getLong("steamid"));
                                }

                                if (curUser.has("personaname")) {
                                    user.setPersonaName(curUser.getString("personaname"));
                                }

                                if (curUser.has("profileurl")) {
                                    user.setProfileUrl(curUser.getString("profileurl"));
                                }

                                if (curUser.has("avatar")) {
                                    user.setAvatar(curUser.getString("avatar"));
                                }

                                if (curUser.has("avatarmedium")) {
                                    user.setAvatarMedium(curUser.getString("avatarmedium"));
                                }

                                if (curUser.has("avatarfull")) {
                                    user.setAvatarFull(curUser.getString("avatarfull"));
                                }

                                if (curUser.has("personastate")) {
                                    user.setPersonaState(curUser.getInt("personastate"));
                                }

                                if (curUser.has("communityvisibilitystate")) {
                                    user.setCommunityVisibilityState(curUser.getInt("communityvisibilitystate"));
                                }

                                if (curUser.has("profilestate")) {
                                    user.setProfileState(curUser.getInt("profilestate"));
                                }

                                if (curUser.has("lastlogoff")) {
                                    user.setLastLogoff(curUser.getLong("lastlogoff"));
                                }

                                if (curUser.has("realname")) {
                                    user.setRealName(curUser.getString("realname"));
                                }

                                if (curUser.has("primaryclanid")) {
                                    user.setPrimaryClanID(curUser.getLong("primaryclanid"));
                                }

                                if (curUser.has("timecreated")) {
                                    user.setTimeCreated(curUser.getLong("timecreated"));
                                }

                                if (curUser.has("gameid")) {
                                    user.setGameID(curUser.getInt("gameid"));
                                }

                                if (curUser.has("gameextrainfo")) {
                                    user.setGameExtraInfo(curUser.getString("gameextrainfo"));
                                }

                                if (curUser.has("loccountrycode")) {
                                    user.setLocCountryCode(curUser.getString("loccountrycode"));
                                }

                                if (curUser.has("locstatecode")) {
                                    user.setLocStateCode(curUser.getString("locstatecode"));
                                }

                                if (curUser.has("loccityid")) {
                                    user.setLocCityID(curUser.getLong("loccityid"));
                                }

                                listener.onUserAvailable(user);

                            }

                        } catch (JSONException e){
                            Log.e(TAG, e.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage());
                    }
                });

        RequestQueueSingleton.getInstance(ctx).addToRequestQueue(jsObjRequest);
    }

}
