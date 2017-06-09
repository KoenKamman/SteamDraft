package nl.code7.steamdraft.api;

import nl.code7.steamdraft.dao.User;

public interface SteamConnectorListener {
    void onUserAvailable(User user);
}
