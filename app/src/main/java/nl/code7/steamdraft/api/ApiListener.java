package nl.code7.steamdraft.api;

import java.util.ArrayList;

import nl.code7.steamdraft.dao.User;

public interface ApiListener {
    void onUserAvailable(User user);
}
